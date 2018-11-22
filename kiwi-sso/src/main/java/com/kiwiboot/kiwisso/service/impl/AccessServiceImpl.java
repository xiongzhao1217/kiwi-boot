package com.kiwiboot.kiwisso.service.impl;

import com.kiwiboot.kiwisso.dao.AccessMapper;
import com.kiwiboot.kiwisso.model.Access;
import com.kiwiboot.kiwisso.service.AccessService;
import com.kiwiframework.easycoding.base.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
/**
 * Created on 2018/11/22.
 * @author xiongzhao.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AccessServiceImpl extends AbstractService<Access> implements AccessService {
    @Resource
    private AccessMapper accessMapper;

}
