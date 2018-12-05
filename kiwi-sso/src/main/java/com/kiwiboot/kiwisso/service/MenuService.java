package com.kiwiboot.kiwisso.service;

import com.kiwiboot.kiwisso.model.Menu;
import com.kiwiboot.kiwisso.model.vo.MenuVO;
import com.kiwiframework.easycoding.base.BaseService;

import java.util.List;

/**
 * Created on 2018/11/25.
 * @author xiongzhao.
 */
public interface MenuService extends BaseService<Menu> {

    /**
     * 根据角色id查询角色拥有的菜单
     * @param roleId
     * @return
     */
    List<MenuVO> findByRole(Long appsId, Long roleId);

    /**
     * 查询某用户的某应用的菜单权限
     * @param userId
     * @param appsId
     * @return
     */
    List<Menu> findByUser(Long userId, Long appsId);
}