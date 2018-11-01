package com.kiwiboot.kiwisso.controller;
import com.kiwiframework.easycoding.api.Result;
import com.kiwiframework.easycoding.api.ResultGenerator;
import com.kiwiboot.kiwisso.model.User;
import com.kiwiboot.kiwisso.service.UserService;
import com.kiwiframework.easycoding.PageBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
/**
 * UserController created on 2018/11/01.
 * @author xiongzhao.
 */
@Controller
@RequestMapping("//user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Result add(User user) {
        userService.insertSelective(user);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@RequestParam Integer id) {
        userService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(User user) {
        userService.updateSelective(user);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    @ResponseBody
    public Result detail(@RequestParam Integer id) {
        User user = userService.selectById(id);
        return ResultGenerator.genSuccessResult(user);
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public Result list(PageBean pageBean, User query) {
        PageHelper.startPage(pageBean).setOrderBy(pageBean.getOrderBy());
        List<User> list = userService.find(query);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
