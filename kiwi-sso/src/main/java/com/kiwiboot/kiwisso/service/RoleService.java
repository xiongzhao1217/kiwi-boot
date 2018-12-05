package com.kiwiboot.kiwisso.service;

import com.kiwiboot.kiwisso.model.Role;
import com.kiwiframework.easycoding.base.BaseService;
/**
 * Created on 2018/11/21.
 * @author xiongzhao.
 */
public interface RoleService extends BaseService<Role> {

    /**
     * 删除角色
     * @param id
     */
    void deleteRole(Long id);
}