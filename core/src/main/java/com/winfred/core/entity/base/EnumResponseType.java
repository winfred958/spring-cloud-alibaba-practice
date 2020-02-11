package com.winfred.core.entity.base;

/**
 * @author kevin
 */

public enum EnumResponseType {

    /**
     * 返回ok
     */
    SUCCESS(0, "ok", "success"),
    /**
     * 默认返回
     */
    DEFAULT_ERROR(999, "error", "defalut error"),

    /**
     *
     */
    REFRESH_LOCAL_CACHE_ERROR(5001, "refresh local cache error", "刷新本地缓存失败, 销量top"),
    /**
     *
     */
    REFRESH_ALS_CACHE_ERROR(5002, "refresh als cache error", "刷新als redis 缓存失败"),
    /**
     *
     */
    REFRESH_ALS_CACHE_OK(0, "refresh als cache success", "刷新als redis 缓存成功"),
    ;

    EnumResponseType(Integer code, String message, String describe) {
        this.code = code;
        this.message = message;
        this.describe = describe;
    }

    private Integer code;
    private String message;
    private String describe;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDescribe() {
        return describe;
    }
}
