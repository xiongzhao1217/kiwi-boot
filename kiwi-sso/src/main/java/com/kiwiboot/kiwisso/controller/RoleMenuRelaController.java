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

    @GetMapping(value = "/roleMenuList")
    @ResponseBody
    public ApiResult roleMenuList(Long appsId, Long roleId) {
        return ResultGenerator.success(menuService.findByRole(appsId, roleId));
    }
}
