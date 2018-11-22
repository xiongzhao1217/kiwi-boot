package com.kiwiboot.kiwisso.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "a_access")
public class Access {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 父id,如果没有父id填写0
     */
    private Long pid;

    /**
     * 应用id
     */
    @Column(name = "apps_id")
    private Long appsId;

    /**
     * 名称
     */
    private String name;

    /**
     * 菜单url,按钮不需要填写url
     */
    private String url;

    /**
     * 类型, 1: 菜单, 2: 按钮
     */
    private Integer type;

    /**
     * 排序值,越小越靠前
     */
    @Column(name = "order_id")
    private Integer orderId;

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
     * 获取父id,如果没有父id填写0
     *
     * @return pid - 父id,如果没有父id填写0
     */
    public Long getPid() {
        return pid;
    }

    /**
     * 设置父id,如果没有父id填写0
     *
     * @param pid 父id,如果没有父id填写0
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
     * 获取应用id
     *
     * @return apps_id - 应用id
     */
    public Long getAppsId() {
        return appsId;
    }

    /**
     * 设置应用id
     *
     * @param appsId 应用id
     */
    public void setAppsId(Long appsId) {
        this.appsId = appsId;
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取菜单url,按钮不需要填写url
     *
     * @return url - 菜单url,按钮不需要填写url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置菜单url,按钮不需要填写url
     *
     * @param url 菜单url,按钮不需要填写url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取类型, 1: 菜单, 2: 按钮
     *
     * @return type - 类型, 1: 菜单, 2: 按钮
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类型, 1: 菜单, 2: 按钮
     *
     * @param type 类型, 1: 菜单, 2: 按钮
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取排序值,越小越靠前
     *
     * @return order_id - 排序值,越小越靠前
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * 设置排序值,越小越靠前
     *
     * @param orderId 排序值,越小越靠前
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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