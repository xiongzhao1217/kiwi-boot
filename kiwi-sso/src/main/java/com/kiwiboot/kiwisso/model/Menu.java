package com.kiwiboot.kiwisso.model;

import com.kiwiframework.easycoding.base.BaseModel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.util.Date;
import javax.persistence.*;

@Data
@Builder
@Table(name = "a_menu")
public class Menu extends BaseModel{

    @Tolerate
    public Menu() {}

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

    @Column(name = "menu_icon")
    private String menuIcon;

    /**
     * 类型, 1: 菜单, 2: 按钮
     */
    private Integer type;

    /**
     * 排序值,越小越靠前
     */
    @Column(name = "order_id")
    private Integer orderId;

//    @Column(name = "create_time")
//    private Date createTime;
//
//    @Column(name = "update_time")
//    private Date updateTime;
}