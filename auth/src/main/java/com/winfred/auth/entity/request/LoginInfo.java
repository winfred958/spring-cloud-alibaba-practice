package com.winfred.auth.entity.request;

import lombok.Data;


@Data
public class LoginInfo {

    private String userId;

    private String password;

    private String securityCode;
    /**
     * 是否认证成功
     */
    private Boolean authenticated;

    private String redirectUrl;
}
