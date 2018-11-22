package com.kiwiboot.kiwisso.controller;
import com.kiwiframework.easycoding.api.ApiResult;
import com.kiwiframework.easycoding.api.ResultGenerator;
import com.kiwiboot.kiwisso.model.Access;
import com.kiwiboot.kiwisso.service.AccessService;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import java.util.Date;
import java.util.List;
/**
 * AccessController created on 2018/11/22.
 * @author xiongzhao.
 */
@Controller
@RequestMapping("//access")
public class AccessController {
    @Resource
    private AccessService accessService;

    @PostMapping(value = "/add")
    @ResponseBody
    public ApiResult add(Access access) {
        access.setCreateTime(new Date());
        if (access.getType() == 2) {
            access.setUrl(null);
        }
        accessService.insertSelective(access);
        return ResultGenerator.genSuccessResult(access);
    }

    @PostMapping(value = "/delete")
    @ResponseBody
    public ApiResult delete(@RequestParam Integer id) {
        accessService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping(value = "/update")
    @ResponseBody
    public ApiResult update(Access access) {
        accessService.updateSelective(access);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping(value = "/detail")
    @ResponseBody
    public ApiResult detail(@RequestParam Integer id) {
        Access access = accessService.selectById(id);
        return ResultGenerator.genSuccessResult(access);
    }

    @GetMapping(value = "/list")
    @ResponseBody
    public ApiResult list(Access query) {
        Condition condition = new Condition(Access.class);
        condition.and().andEqualTo(query);
        condition.orderBy("orderId").asc();
        List<Access> list = accessService.findByCondition(condition);
        return ResultGenerator.genSuccessResult(list);
    }
}
