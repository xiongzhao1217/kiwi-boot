package com.kiwiboot.kiwisso.service.impl;

import com.kiwiboot.kiwisso.dao.RoleMapper;
import com.kiwiboot.kiwisso.model.Role;
import com.kiwiboot.kiwisso.model.RoleAccessRela;
import com.kiwiboot.kiwisso.model.RoleMenuRela;
import com.kiwiboot.kiwisso.model.RoleUserRela;
import com.kiwiboot.kiwisso.service.RoleAccessRelaService;
import com.kiwiboot.kiwisso.service.RoleMenuRelaService;
import com.kiwiboot.kiwisso.service.RoleService;
import com.kiwiboot.kiwisso.service.RoleUserRelaService;
import com.kiwiframework.easycoding.base.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
/**
 * Created on 2018/11/21.
 * @author xiongzhao.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl extends AbstractService<Role> implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    @Resource
    private RoleUserRelaService roleUserRelaService;

    @Resource
    private RoleMenuRelaService roleMenuRelaService;

    @Resource
    private RoleAccessRelaService roleAccessRelaService;

    @Override
    public void deleteRole(Long id) {
        // 删除角色关联的用户
        roleUserRelaService.delete(RoleUserRela.builder().roleId(id).build());
        // 删除角色关联的菜单
        roleMenuRelaService.delete(RoleMenuRela.builder().roleId(id).build());
        // 删除角色关联的权限资源
        roleAccessRelaService.delete(RoleAccessRela.builder().roleId(id).build());
        // 删除角色
        this.deleteById(id);
    }
}
