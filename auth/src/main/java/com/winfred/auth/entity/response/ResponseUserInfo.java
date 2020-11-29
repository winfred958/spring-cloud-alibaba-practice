package com.winfred.auth.entity.response;

import lombok.Data;

import java.util.List;

/**
 * 返回前端
 * token 中携带的 user -> role
 */
@Data
public class ResponseUserInfo {
    private String userId;
    private String nickname;
    /**
     * 角色列表
     */
    private List<String> roles;
    /**
     * 是否认证成功
     */
    private Boolean authenticated;
}
