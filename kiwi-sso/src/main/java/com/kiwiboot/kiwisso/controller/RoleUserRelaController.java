package com.kiwiboot.kiwisso.controller;
import com.kiwiboot.kiwisso.model.vo.UserVO;
import com.kiwiboot.kiwisso.service.UserService;
import com.kiwiframework.core.utils.Checker;
import com.kiwiframework.easycoding.api.ApiResult;
import com.kiwiframework.easycoding.api.ResultGenerator;
import com.kiwiboot.kiwisso.model.RoleUserRela;
import com.kiwiboot.kiwisso.service.RoleUserRelaService;
import com.kiwiframework.easycoding.PageBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 * RoleUserRelaController created on 2018/11/25.
 * @author xiongzhao.
 */
@Controller
@RequestMapping("/roleUserRela")
public class RoleUserRelaController {
    @Resource
    private RoleUserRelaService roleUserRelaService;

    @Resource
    private UserService userService;

    @PostMapping(value = "/add")
    @ResponseBody
    public ApiResult add(RoleUserRela roleUserRela) {
        roleUserRelaService.insertSelective(roleUserRela);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping(value = "/delete")
    @ResponseBody
    public ApiResult delete(@RequestParam Integer id) {
        roleUserRelaService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping(value = "/update")
    @ResponseBody
    public ApiResult update(RoleUserRela roleUserRela) {
        roleUserRelaService.updateSelective(roleUserRela);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping(value = "/detail")
    @ResponseBody
    public ApiResult detail(@RequestParam Integer id) {
        RoleUserRela roleUserRela = roleUserRelaService.selectById(id);
        return ResultGenerator.genSuccessResult(roleUserRela);
    }

    @PostMapping(value = "/list")
    @ResponseBody
    public ApiResult list(PageBean pageBean, UserVO query) {
        Checker.notNull(query.getRoleId(), "角色id不能为空");
        PageInfo pageInfo = PageHelper.startPage(pageBean)
                .setOrderBy(pageBean.getOrderBy())
                .doSelectPageInfo(() -> userService.findByRole(query));
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
