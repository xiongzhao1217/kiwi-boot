package com.kiwiboot.kiwisso.service.impl;

import com.kiwiboot.kiwisso.dao.RoleMenuRelaMapper;
import com.kiwiboot.kiwisso.model.RoleMenuRela;
import com.kiwiboot.kiwisso.service.RoleMenuRelaService;
import com.kiwiframework.easycoding.base.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
/**
 * Created on 2018/11/25.
 * @author xiongzhao.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleMenuRelaServiceImpl extends AbstractService<RoleMenuRela> implements RoleMenuRelaService {
    @Resource
    private RoleMenuRelaMapper roleMenuRelaMapper;

}
