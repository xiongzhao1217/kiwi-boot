package com.kiwiboot.kiwisso.controller;
import com.kiwiframework.easycoding.api.ApiResult;
import com.kiwiframework.easycoding.api.ResultGenerator;
import com.kiwiboot.kiwisso.model.Menu;
import com.kiwiboot.kiwisso.service.MenuService;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import java.util.Date;
import java.util.List;
/**
 * MenuController created on 2018/11/25.
 * @author xiongzhao.
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    @Resource
    private MenuService menuService;

    @PostMapping(value = "/add")
    @ResponseBody
    public ApiResult add(Menu menu) {
        menu.setCreateTime(new Date());
        if (menu.getType() == 2) {
            menu.setUrl(null);
        }
        // 排序值越小越靠前,新增默认排在最后
        menu.setOrderId(9999);
        menuService.insertSelective(menu);
        return ResultGenerator.genSuccessResult(menu);
    }

    @PostMapping(value = "/delete")
    @ResponseBody
    public ApiResult delete(@RequestParam Integer id) {
        menuService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping(value = "/update")
    @ResponseBody
    public ApiResult update(Menu menu) {
        menu.setUpdateTime(new Date());
        menuService.updateSelective(menu);
        return ResultGenerator.genSuccessResult(menu);
    }

    @GetMapping(value = "/detail")
    @ResponseBody
    public ApiResult detail(@RequestParam Integer id) {
        Menu menu = menuService.selectById(id);
        return ResultGenerator.genSuccessResult(menu);
    }

    @GetMapping(value = "/list")
    @ResponseBody
    public ApiResult list(Menu query) {
        Condition condition = new Condition(Menu.class);
        condition.and().andEqualTo(query);
        condition.orderBy("orderId").asc();
        List<Menu> list = menuService.findByCondition(condition);
        return ResultGenerator.genSuccessResult(list);
    }
}
