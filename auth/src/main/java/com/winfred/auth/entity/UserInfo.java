package com.winfred.auth.entity;

import lombok.Data;


@Data
public class UserInfo {

    private String userId;

    private String userName;

    private String password;

    private String securityCode;
    /**
     * 是否认证成功
     */
    private Boolean authenticated;
}
