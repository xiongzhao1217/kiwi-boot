package com.kiwiboot.kiwisso.service.impl;

import com.kiwiboot.kiwisso.dao.RoleMapper;
import com.kiwiboot.kiwisso.model.Role;
import com.kiwiboot.kiwisso.service.RoleService;
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

}
