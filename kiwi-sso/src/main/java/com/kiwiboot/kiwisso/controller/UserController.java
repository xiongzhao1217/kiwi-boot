package com.kiwiboot.kiwisso.controller;
import com.kiwiboot.kiwisso.constant.ValidatedGroup;
import com.kiwiframework.core.enums.ResultCode;
import com.kiwiframework.core.exception.AppException;
import com.kiwiframework.easycoding.api.ApiResult;
import com.kiwiframework.easycoding.api.ResultGenerator;
import com.kiwiboot.kiwisso.model.User;
import com.kiwiboot.kiwisso.service.UserService;
import com.kiwiframework.easycoding.PageBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
/**
 * UserController created on 2018/11/04.
 * @author xiongzhao.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ApiResult add(User user) {
        userService.insertSelective(user);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ApiResult delete(@RequestParam Integer id) {
        userService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ApiResult update(User user) {
        userService.updateSelective(user);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    @ResponseBody
    public ApiResult detail(@RequestParam Integer id) {
        User user = userService.selectById(id);
        return ResultGenerator.genSuccessResult(user);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ApiResult list(PageBean pageBean, User query) {
        PageHelper.startPage(pageBean).setOrderBy(pageBean.getOrderBy());
        List<User> list = userService.find(query);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 登录
     * @param loginUser
     * @param response
     * @return
     */
    @RequestMapping(value = "/dologin")
    @ResponseBody
    public ApiResult<String> dologin(@Validated(ValidatedGroup.User.class) User loginUser, HttpServletResponse response) {
        String token = userService.doLogin(loginUser);
        // 写入token到cookie
        Cookie cookie = new Cookie("token", token);
        cookie.setMaxAge(24 * 3600);
        cookie.setPath("/");
        response.addCookie(cookie);
        return ResultGenerator.genSuccessResult(token);
    }

    /**
     * 用户注册
     * @param registerUser
     * @return
     */
    @PostMapping(value = "/register")
    @ResponseBody
    public ApiResult<User> register(@Validated(ValidatedGroup.User.class) User registerUser) {
        try {
            userService.register(registerUser);
        } catch (DuplicateKeyException dupExp) {
            throw new AppException(ResultCode.FAIL, "手机号或邮箱已经被使用,请更换其他账号");
        }
        return ResultGenerator.genSuccessResult();
    }
}
