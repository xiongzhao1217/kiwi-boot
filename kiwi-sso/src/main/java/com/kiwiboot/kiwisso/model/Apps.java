package com.kiwiboot.kiwisso.model;

import com.kiwiframework.easycoding.base.BaseModel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Builder
@Data
@Table(name = "sso_apps")
public class Apps extends BaseModel{

    @Tolerate
    public Apps(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 应用id
     */
    @Column(name = "app_id")
    private String appId;

    /**
     * 应用名称
     */
    @NotBlank(message = "应用名称不能为空")
    @Column(name = "app_name")
    private String appName;

    /**
     * 应用英文名称,建议单词间用中划线隔开,不可重复
     */
    @NotBlank(message = "应用英文名称不能为空")
    @Column(name = "app_name_en")
    private String appNameEn;

    /**
     * 应用密匙
     */
    @Column(name = "app_secret")
    private String appSecret;

    /**
     * 应用描述
     */
    @Column(name = "app_desc")
    private String appDesc;

    /**
     * 应用状态,1:有效,2:无效
     */
    private Integer status;

    /**
     * 应用负责任手机号
     */
    @Column(name = "app_support_telephone")
    private String appSupportTelephone;

    private Long creator;

    private Long updator;

//    @Column(name = "create_time")
//    private Date createTime;
//
//    @Column(name = "update_time")
//    private Date updateTime;
}