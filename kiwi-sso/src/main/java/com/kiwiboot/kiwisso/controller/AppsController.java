package com.kiwiboot.kiwisso.controller;
import com.kiwiboot.kiwisso.model.User;
import com.kiwiframework.core.utils.Checker;
import com.kiwiframework.easycoding.api.ApiResult;
import com.kiwiframework.easycoding.api.ResultGenerator;
import com.kiwiboot.kiwisso.model.Apps;
import com.kiwiboot.kiwisso.service.AppsService;
import com.kiwiframework.easycoding.PageBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 * AppsController created on 2018/11/11.
 * @author xiongzhao.
 */
@Controller
@RequestMapping("/apps")
public class AppsController {
    @Resource
    private AppsService appsService;

    @PostMapping(value = "/add")
    @ResponseBody
    public ApiResult add(@Validated Apps apps) {
        appsService.save(apps, User.builder().build());
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping(value = "/delete")
    @ResponseBody
    public ApiResult delete(@RequestParam Integer id) {
        appsService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping(value = "/update")
    @ResponseBody
    public ApiResult update(Apps apps) {
        Checker.notNull(apps.getId(), "应用ID不能为空");
        appsService.updateSelective(apps);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping(value = "/detail")
    @ResponseBody
    public ApiResult detail(@RequestParam Integer id) {
        Apps apps = appsService.selectById(id);
        return ResultGenerator.genSuccessResult(apps);
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public ApiResult list(PageBean pageBean, Apps query) {
        PageHelper.startPage(pageBean).setOrderBy(pageBean.getOrderBy());
        List<Apps> list = appsService.find(query);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
