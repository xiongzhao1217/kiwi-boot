package com.kiwiboot.kiwisso.model;

import com.kiwiframework.easycoding.base.BaseModel;
import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "a_role_access_rela")
public class RoleAccessRela extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "access_id")
    private Long accessId;

//    @Column(name = "create_time")
//    private Date createTime;
//
//    @Column(name = "update_time")
//    private Date updateTime;
}