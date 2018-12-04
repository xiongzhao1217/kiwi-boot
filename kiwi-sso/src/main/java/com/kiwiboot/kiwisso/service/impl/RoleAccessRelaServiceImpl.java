package com.kiwiboot.kiwisso.service.impl;

import com.kiwiboot.kiwisso.dao.RoleAccessRelaMapper;
import com.kiwiboot.kiwisso.model.RoleAccessRela;
import com.kiwiboot.kiwisso.service.RoleAccessRelaService;
import com.kiwiframework.easycoding.base.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
/**
 * Created on 2018/12/04.
 * @author xiongzhao.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleAccessRelaServiceImpl extends AbstractService<RoleAccessRela> implements RoleAccessRelaService {
    @Resource
    private RoleAccessRelaMapper roleAccessRelaMapper;

}
