package com.kiwiboot.kiwisso.service.impl;

import com.kiwiboot.kiwisso.dao.UserMapper;
import com.kiwiboot.kiwisso.model.User;
import com.kiwiboot.kiwisso.service.UserService;
import com.kiwiboot.kiwisso.utils.JwtUtils;
import com.kiwiframework.core.enums.ResultCode;
import com.kiwiframework.core.exception.AppException;
import com.kiwiframework.core.utils.Checker;
import com.kiwiframework.core.utils.CodeGenerateor;
import com.kiwiframework.core.utils.encryption.MD5Helper;
import com.kiwiframework.easycoding.base.AbstractService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.Date;

/**
 * Created on 2018/11/04.
 * @author xiongzhao.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 默认头像
     */
    @Value("${default.avatar.url}")
    private String defaultAvatarUrl;

    @Override
    public String doLogin(User loginUser) {
        User user = selectBy("email", loginUser.getEmail());
        if (user == null) {
            throw new AppException(ResultCode.FAIL, "账号或密码错误");
        }
        // 校验密码
        if (!user.getPasswd().equals(MD5Helper.getMD5Str(loginUser.getPasswd() + user.getPasswdSalt()))) {
            throw new AppException(ResultCode.FAIL, "账号或密码错误");
        }
        // 创建jwt
        return JwtUtils.createJWT(user);
    }

    @Override
    public User register(User registerUser) {
        String nickName = registerUser.getEmail();
        if (StringUtils.isNotEmpty(registerUser.getEmail())) {
            nickName = nickName.substring(0, nickName.indexOf("@"));
        } else {
            nickName = registerUser.getTelephone();
        }
        registerUser.setNickName(nickName);
        registerUser.setPasswdSalt(CodeGenerateor.uuid());
        registerUser.setPasswd(MD5Helper.getMD5Str(registerUser.getPasswd() + registerUser.getPasswdSalt()));
        if (StringUtils.isEmpty(registerUser.getAvatarUrl())) {
            registerUser.setAvatarUrl(defaultAvatarUrl);
        }
        Date now = new Date();
        registerUser.setCreateTime(now);
        registerUser.setUpdateTime(now);
        insertSelective(registerUser);
        return registerUser;
    }
}
