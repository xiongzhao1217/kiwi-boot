package com.kiwiboot.kiwisso.model;

import com.kiwiboot.kiwisso.constant.ValidatedGroup;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@Table(name = "kiwi_user")
public class User {

    @Tolerate
    public User(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 密码盐,MD5(MD5(明文密码)+盐)=password
     */
    @Column(name = "passwd_salt")
    private String passwdSalt;

    /**
     * 连续登陆失败次数，超过这个值需要输入验证码登陆
     */
    @Column(name = "login_fail_counts")
    private Integer loginFailCounts;

    private Integer sex;

    /**
     * 密码,公式: MD5(MD5(明文密码)+盐)
     */
    @NotEmpty(message = "密码不能为空", groups = ValidatedGroup.User.class)
    @Length(min = 32, max = 32, message = "密码必须是md5加密后的32位字符串", groups = ValidatedGroup.User.class)
    private String passwd;

    /**
     * 手机号
     */
    private String telephone;

    @NotEmpty(message = "email不能为空", groups = ValidatedGroup.User.class)
    @Email(message = "邮箱格式不正确", groups = ValidatedGroup.User.class)
    private String email;

    /**
     * 头像地址
     */
    @Column(name = "avatar_url")
    private String avatarUrl;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;
}