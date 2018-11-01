package com.kiwiboot.kiwisso.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "kiwi_user")
public class User {
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

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取昵称
     *
     * @return nick_name - 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置昵称
     *
     * @param nickName 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取密码盐,MD5(MD5(明文密码)+盐)=password
     *
     * @return passwd_salt - 密码盐,MD5(MD5(明文密码)+盐)=password
     */
    public String getPasswdSalt() {
        return passwdSalt;
    }

    /**
     * 设置密码盐,MD5(MD5(明文密码)+盐)=password
     *
     * @param passwdSalt 密码盐,MD5(MD5(明文密码)+盐)=password
     */
    public void setPasswdSalt(String passwdSalt) {
        this.passwdSalt = passwdSalt;
    }

    /**
     * 获取连续登陆失败次数，超过这个值需要输入验证码登陆
     *
     * @return login_fail_counts - 连续登陆失败次数，超过这个值需要输入验证码登陆
     */
    public Integer getLoginFailCounts() {
        return loginFailCounts;
    }

    /**
     * 设置连续登陆失败次数，超过这个值需要输入验证码登陆
     *
     * @param loginFailCounts 连续登陆失败次数，超过这个值需要输入验证码登陆
     */
    public void setLoginFailCounts(Integer loginFailCounts) {
        this.loginFailCounts = loginFailCounts;
    }

    /**
     * @return sex
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取密码,公式: MD5(MD5(明文密码)+盐)
     *
     * @return passwd - 密码,公式: MD5(MD5(明文密码)+盐)
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * 设置密码,公式: MD5(MD5(明文密码)+盐)
     *
     * @param passwd 密码,公式: MD5(MD5(明文密码)+盐)
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    /**
     * @return telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}