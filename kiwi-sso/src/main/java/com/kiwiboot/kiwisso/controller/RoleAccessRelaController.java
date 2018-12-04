package com.kiwiboot.kiwisso.controller;
import com.kiwiframework.easycoding.api.ApiResult;
import com.kiwiframework.easycoding.api.ResultGenerator;
import com.kiwiboot.kiwisso.model.RoleAccessRela;
import com.kiwiboot.kiwisso.service.RoleAccessRelaService;
import com.kiwiframework.easycoding.PageBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 * RoleAccessRelaController created on 2018/12/04.
 * @author xiongzhao.
 */
@Controller
@RequestMapping("/roleAccessRela")
public class RoleAccessRelaController {
    @Resource
    private RoleAccessRelaService roleAccessRelaService;

    @PostMapping(value = "/add")
    @ResponseBody
    public ApiResult add(RoleAccessRela roleAccessRela) {
        roleAccessRelaService.insertSelective(roleAccessRela);
        return ResultGenerator.success();
    }

    @PostMapping(value = "/delete")
    @ResponseBody
    public ApiResult delete(@RequestParam Integer id) {
        roleAccessRelaService.deleteById(id);
        return ResultGenerator.success();
    }

    @PostMapping(value = "/update")
    @ResponseBody
    public ApiResult update(RoleAccessRela roleAccessRela) {
        roleAccessRelaService.updateSelective(roleAccessRela);
        return ResultGenerator.success();
    }

    @GetMapping(value = "/detail")
    @ResponseBody
    public ApiResult detail(@RequestParam Integer id) {
        RoleAccessRela roleAccessRela = roleAccessRelaService.selectById(id);
        return ResultGenerator.success(roleAccessRela);
    }

    @GetMapping(value = "/list")
    @ResponseBody
    public ApiResult list(PageBean pageBean, RoleAccessRela query) {
        PageHelper.startPage(pageBean).setOrderBy(pageBean.getOrderBy());
        List<RoleAccessRela> list = roleAccessRelaService.find(query);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.success(pageInfo);
    }
}
