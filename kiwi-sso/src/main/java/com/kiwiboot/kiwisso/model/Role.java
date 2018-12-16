package com.kiwiboot.kiwisso.model;

import com.kiwiframework.easycoding.base.BaseModel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;
import javax.persistence.*;

@Data
@Builder
@Table(name = "a_role")
public class Role extends BaseModel{

    @Tolerate
    public Role(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 所属应用id
     */
    @Column(name = "apps_id")
    private Long appsId;

    /**
     * 角色名称
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * 角色描述
     */
    @Column(name = "role_desc")
    private String roleDesc;
}