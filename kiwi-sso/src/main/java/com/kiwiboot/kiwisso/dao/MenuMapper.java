package com.kiwiboot.kiwisso.dao;

import com.kiwiboot.kiwisso.model.Menu;
import com.kiwiboot.kiwisso.model.vo.MenuVO;
import com.kiwiframework.easycoding.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 根据角色id查询角色拥有的菜单
     * @param roleId
     * @return
     */
    List<MenuVO> findByRole(@Param("appsId") Long appsId, @Param("roleId") Long roleId);

    /**
     * 查询某用户的某应用的菜单权限
     * @param query
     * @return
     */
    List<Menu> findByUser(MenuVO query);
}