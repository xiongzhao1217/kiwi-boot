package com.kiwiboot.kiwisso.service;

import com.kiwiboot.kiwisso.model.User;
import com.kiwiboot.kiwisso.model.vo.SsoUser;
import com.kiwiframework.easycoding.base.BaseService;

import java.util.List;

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

    /**
     * 管理员创建用户
     * @param user
     * @return
     */
    User adminAddUser(User user);

    /**
     * 根据角色查询用户
     * @param query
     * @return
     */
    List<SsoUser> findByRole(SsoUser query);
}