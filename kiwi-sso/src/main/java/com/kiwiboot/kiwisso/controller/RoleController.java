package com.kiwiboot.kiwisso.controller;
import com.kiwiframework.easycoding.api.ApiResult;
import com.kiwiframework.easycoding.api.ResultGenerator;
import com.kiwiboot.kiwisso.model.Role;
import com.kiwiboot.kiwisso.service.RoleService;
import com.kiwiframework.easycoding.PageBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
/**
 * RoleController created on 2018/11/21.
 * @author xiongzhao.
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Resource
    private RoleService roleService;

    @PostMapping(value = "/add")
    @ResponseBody
    public ApiResult add(Role role) {
        role.setCreateTime(new Date());
        roleService.insertSelective(role);
        return ResultGenerator.success();
    }

    @PostMapping(value = "/delete")
    @ResponseBody
    public ApiResult delete(@RequestParam Long id) {

        roleService.deleteRole(id);
        return ResultGenerator.success();
    }

    @PostMapping(value = "/update")
    @ResponseBody
    public ApiResult update(Role role) {
        role.setUpdateTime(new Date());
        roleService.update(role);
        return ResultGenerator.success();
    }

    @GetMapping(value = "/detail")
    @ResponseBody
    public ApiResult detail(@RequestParam Integer id) {
        Role role = roleService.selectById(id);
        return ResultGenerator.success(role);
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public ApiResult list(PageBean pageBean, Role query) {
        PageHelper.startPage(pageBean).setOrderBy(pageBean.getOrderBy());
        List<Role> list = roleService.find(query);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.success(pageInfo);
    }
}
