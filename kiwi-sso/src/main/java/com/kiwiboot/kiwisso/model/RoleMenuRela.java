package com.kiwiboot.kiwisso.model;

import com.kiwiframework.easycoding.base.BaseModel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.util.Date;
import javax.persistence.*;

@Builder
@Data
@Table(name = "a_role_menu_rela")
public class RoleMenuRela extends BaseModel{

    @Tolerate
    public RoleMenuRela(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "menu_id")
    private Long menuId;

//    @Column(name = "create_time")
//    private Date createTime;
//
//    @Column(name = "update_time")
//    private Date updateTime;
}