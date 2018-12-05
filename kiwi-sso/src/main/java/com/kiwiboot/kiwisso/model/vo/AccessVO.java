package com.kiwiboot.kiwisso.model.vo;

import com.kiwiboot.kiwisso.model.Access;
import com.kiwiframework.easycoding.base.BaseModel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.*;

@Data
public class AccessVO extends Access{

    /**
     * 角色ID
     */
    private Long roleId;
}