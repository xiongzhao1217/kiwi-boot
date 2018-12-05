package com.kiwiboot.kiwisso.model;

import com.kiwiframework.easycoding.base.BaseModel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.util.Date;
import javax.persistence.*;

@Data
@Builder
@Table(name = "a_role_access_rela")
public class RoleAccessRela extends BaseModel{

    @Tolerate
    public RoleAccessRela() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "access_id")
    private Long accessId;
}