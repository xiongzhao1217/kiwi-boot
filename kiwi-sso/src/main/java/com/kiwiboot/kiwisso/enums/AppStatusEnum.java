package com.kiwiboot.kiwisso.enums;

/**
 * 应用状态枚举
 * @author xiongzhao
 */
public enum AppStatusEnum {

    INVALID(0, "无效"),
    VALID(1, "有效");

    private final Integer code;

    private final String desc;

    AppStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public AppStatusEnum get (Integer code) {
        if (code == null) return null;
        for (AppStatusEnum appStatusEnum: AppStatusEnum.values()) {
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
