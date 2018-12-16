package com.kiwiboot.kiwisso.controller;
import com.kiwiframework.easycoding.api.ApiResult;
import com.kiwiframework.easycoding.api.ResultGenerator;
import com.kiwiboot.kiwisso.model.Access;
import com.kiwiboot.kiwisso.service.AccessService;
import com.kiwiframework.easycoding.PageBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;
/**
 * AccessController created on 2018/12/04.
 * @author xiongzhao.
 */
@RestController
@RequestMapping("/access")
public class AccessController {
    @Resource
    private AccessService accessService;

    @PostMapping(value = "/add")
    public ApiResult add(Access access) {
        accessService.insertSelective(access);
        return ResultGenerator.success(access);
    }

    @PostMapping(value = "/delete")
    public ApiResult delete(@RequestParam Integer id) {
        accessService.deleteById(id);
        return ResultGenerator.success();
    }

    @PostMapping(value = "/update")
    public ApiResult update(Access access) {
        accessService.update(access);
        return ResultGenerator.success(access);
    }

    @GetMapping(value = "/list")
    public ApiResult list(Access query) {
        Condition condition = new Condition(Access.class);
        condition.and().andEqualTo(query);
        List<Access> list = accessService.findByCondition(condition);
        return ResultGenerator.success(list);
    }
}
