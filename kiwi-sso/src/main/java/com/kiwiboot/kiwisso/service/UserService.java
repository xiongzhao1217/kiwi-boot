package com.kiwiboot.kiwisso.service;

import com.kiwiboot.kiwisso.model.User;
import com.kiwiframework.easycoding.base.BaseService;
/**
 * Created on 2018/11/04.
 * @author xiongzhao.
 */
public interface UserService extends BaseService<User> {

    /**
     * 登录
     * @param loginUser
     * @return
     */
    String doLogin(User loginUser);

    /**
     * 注册
     * @param registerUser
     * @return
     */
    User register(User registerUser);
}