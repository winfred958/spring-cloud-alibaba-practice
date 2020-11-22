package com.winfred.core.entity.base;


public class BaseResponse<T> {
  private Integer code;
  private String message;

  private T data;

  public BaseResponse() {
    this.code = EnumResponseType.SUCCESS.getCode();
    this.message = EnumResponseType.SUCCESS.getMessage();
  }

  public BaseResponse(T data) {
    this.code = EnumResponseType.SUCCESS.getCode();
    this.message = EnumResponseType.SUCCESS.getMessage();
    this.data = data;
  }

  public static <T> BaseResponse<T> success(T data) {
    BaseResponse<T> response = new BaseResponse<>();
    response.setData(data);
    return response;
  }

  public static <T> BaseResponse<T> send(EnumResponseType type) {
    BaseResponse<T> response = new BaseResponse<>();
    response.setCode(type.getCode());
    response.setMessage(type.getMessage());
    return response;
  }

  public static <T> BaseResponse<T> send(EnumResponseType type, T data) {
    BaseResponse<T> response = new BaseResponse<>();
    response.setCode(type.getCode());
    response.setMessage(type.getMessage());
    response.setData(data);
    return response;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return this.data;
  }

  /**
   * 常规返回, 非分页
   *
   * @param data
   */
  public void setData(T data) {
    this.data = data;
  }


}
