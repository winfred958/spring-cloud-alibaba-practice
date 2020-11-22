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
  DEFAULT_ERROR(-1, "error", "unknown error"),

  /**
   * 权限错误
   */
  PERMISSION_ERROR(4001, "error", "permission error"),
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
