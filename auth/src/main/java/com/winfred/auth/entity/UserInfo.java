package com.winfred.auth.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserInfo {

    private String userId;

    @NotEmpty(message = "用户名不能为空")
    private String userName;

    @NotEmpty(message = "密码不能为空")
    private String password;

    private String securityCode;
    /**
     * 是否认证成功
     */
    private Boolean authenticated;
}
