package com.kiwiboot.kiwisso.service.impl;

import com.kiwiboot.kiwisso.dao.UserMapper;
import com.kiwiboot.kiwisso.model.User;
import com.kiwiboot.kiwisso.service.UserService;
import com.kiwiframework.easycoding.base.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
/**
 * Created on 2018/11/01.
 * @author xiongzhao.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;

}
