package com.kiwiboot.kiwisso.controller;
import com.kiwiboot.kiwisso.service.MenuService;
import com.kiwiframework.easycoding.api.ApiResult;
import com.kiwiframework.easycoding.api.ResultGenerator;
import com.kiwiboot.kiwisso.model.RoleMenuRela;
import com.kiwiboot.kiwisso.service.RoleMenuRelaService;
import com.kiwiframework.easycoding.PageBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 * RoleMenuRelaController created on 2018/11/25.
 * @author xiongzhao.
 */
@Controller
@RequestMapping("/roleMenuRela")
public class RoleMenuRelaController {
    @Resource
    private RoleMenuRelaService roleMenuRelaService;

    @Resource
    private MenuService menuService;

    @PostMapping(value = "/batchAdd")
    @ResponseBody
    public ApiResult batchAdd(Long roleId, @RequestBody List<RoleMenuRela> roleMenuRelaList) {
        roleMenuRelaService.delete(RoleMenuRela.builder().roleId(roleId).build());
        if (CollectionUtils.isNotEmpty(roleMenuRelaList)) {
            roleMenuRelaService.insertBatch(roleMenuRelaList);
        }
        return ResultGenerator.success();
    }

    @PostMapping(value = "/delete")
    @ResponseBody
    public ApiResult delete(@RequestParam Integer id) {
        roleMenuRelaService.deleteById(id);
        return ResultGenerator.success();
    }

    @PostMapping(value = "/update")
    @ResponseBody
    public ApiResult update(RoleMenuRela roleMenuRela) {
        roleMenuRelaService.updateSelective(roleMenuRela);
        return ResultGenerator.success();
    }

    @GetMapping(value = "/detail")
    @ResponseBody
    public ApiResult detail(@RequestParam Integer id) {
        RoleMenuRela roleMenuRela = roleMenuRelaService.selectById(id);
        return ResultGenerator.success(roleMenuRela);
    }

    @GetMapping(value = "/list")
    @ResponseBody
    public ApiResult list(PageBean pageBean, RoleMenuRela query) {
        PageHelper.startPage(pageBean).setOrderBy(pageBean.getOrderBy());
        List<RoleMenuRela> list = roleMenuRelaService.find(query);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.success(pageInfo);
    }

    @GetMapping(value = "/roleMenuList")
    @ResponseBody
    public ApiResult roleMenuList(Long appsId, Long roleId) {
        return ResultGenerator.success(menuService.findByRole(appsId, roleId));
    }
}
