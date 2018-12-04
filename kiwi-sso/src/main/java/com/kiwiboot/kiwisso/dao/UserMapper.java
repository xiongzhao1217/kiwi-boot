package com.kiwiboot.kiwisso.dao;

import com.kiwiboot.kiwisso.model.User;
import com.kiwiboot.kiwisso.model.vo.SsoUser;
import com.kiwiframework.easycoding.base.BaseMapper;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据角色查询用户
     * @param query
     * @return
     */
    List<SsoUser> findByRole(SsoUser query);
}