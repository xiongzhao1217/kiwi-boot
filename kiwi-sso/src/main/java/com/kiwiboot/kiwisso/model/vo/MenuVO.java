package com.kiwiboot.kiwisso.model.vo;

import com.kiwiboot.kiwisso.model.Menu;
import lombok.Data;

/**
 * @author xiongzhao1 by 2018-11-25 20:23
 */
@Data
public class MenuVO extends Menu{
    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 用户id
     */
    private Long userId;
}
