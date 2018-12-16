package com.kiwiboot.kiwisso.dao;

import com.kiwiboot.kiwisso.model.Access;
import com.kiwiboot.kiwisso.model.vo.AccessVO;
import com.kiwiframework.easycoding.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccessMapper extends BaseMapper<Access> {

    /**
     * 根据角色id查询角色拥有的权限资源
     * @param roleId
     * @return
     */
    List<AccessVO> findByRole(@Param("appsId") Long appsId, @Param("roleId") Long roleId);

    /**
     * 根据应用主键查询应用所有的角色拥有的权限
     * @param appsId
     * @return
     */
    List<AccessVO> findAllRoleAccess(Long appsId);
}