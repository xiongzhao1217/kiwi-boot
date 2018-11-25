package com.kiwiboot.kiwisso.model.vo;

import com.kiwiboot.kiwisso.model.User;
import lombok.Data;

/**
 * @author xiongzhao1 by 2018-11-25 10:31
 */
@Data
public class UserVO extends User {

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 角色用户关系ID
     */
    private Long roleUserRelaId;
}
