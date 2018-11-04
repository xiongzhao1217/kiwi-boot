package com.kiwiboot.kiwisso.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.util.Date;
import javax.persistence.*;

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
    private String passwd;

    private String telephone;

    private String email;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;
}