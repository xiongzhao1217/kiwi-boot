package com.kiwiboot.kiwisso.service;

import com.kiwiboot.kiwisso.model.Access;
import com.kiwiboot.kiwisso.model.vo.AccessVO;
import com.kiwiframework.easycoding.base.BaseService;

import java.util.List;

/**
 * Created on 2018/12/04.
 * @author xiongzhao.
 */
public interface AccessService extends BaseService<Access> {

    /**
     * 根据角色id查询角色拥有的权限资源
     * @param roleId
     * @return
     */
    List<AccessVO> findByRole(Long appsId, Long roleId);

    /**
     * 根据应用主键查询应用所有的角色拥有的权限
     * @param appsId
     * @return
     */
    List<AccessVO> findAllRoleAccess(Long appsId);
}