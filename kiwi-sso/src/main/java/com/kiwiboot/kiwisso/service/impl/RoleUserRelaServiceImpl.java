package com.kiwiboot.kiwisso.service.impl;

import com.kiwiboot.kiwisso.dao.RoleUserRelaMapper;
import com.kiwiboot.kiwisso.model.RoleUserRela;
import com.kiwiboot.kiwisso.service.RoleUserRelaService;
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
public class RoleUserRelaServiceImpl extends AbstractService<RoleUserRela> implements RoleUserRelaService {
    @Resource
    private RoleUserRelaMapper roleUserRelaMapper;

}
