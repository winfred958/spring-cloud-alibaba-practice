package com.winfred.common.global.constant;

public enum AuthConstant {
    /**
     * dev
     */
    TOKEN_NAME("___token", "token名称"),

    ;

    private String name;
    private String describe;

    AuthConstant(String name, String describe) {
        this.name = name;
        this.describe = describe;
    }

    public String getName() {
        return name;
    }

    public String getDescribe() {
        return describe;
    }
}
