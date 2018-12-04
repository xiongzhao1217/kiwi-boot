package com.kiwiboot.kiwisso.model;

import com.kiwiframework.easycoding.base.BaseModel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.util.Date;
import javax.persistence.*;

@Data
@Builder
@Table(name = "a_access")
public class Access extends BaseModel{

    @Tolerate
    public Access() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 父id
     */
    private Long pid;

    /**
     * 权限名称
     */
    private String name;

    private String code;

    private String url;

    /**
     * 应用id
     */
    @Column(name = "apps_id")
    private Long appsId;
}