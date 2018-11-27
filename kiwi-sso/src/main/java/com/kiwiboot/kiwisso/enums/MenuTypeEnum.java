package com.kiwiboot.kiwisso.enums;

/**
 * 菜单类型枚举
 * @author xiongzhao
 */
public enum MenuTypeEnum {

    MENU(1, "菜单"),
    BUTTON(1, "按钮");

    private final Integer code;

    private final String desc;

    MenuTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public MenuTypeEnum get (Integer code) {
        if (code == null) return null;
        for (MenuTypeEnum appStatusEnum: MenuTypeEnum.values()) {
            if (appStatusEnum.code().equals(code)) {
                return appStatusEnum;
            }
        }
        return null;
    }

    public Integer code() {
        return code;
    }

    public String desc() {
        return desc;
    }
}
