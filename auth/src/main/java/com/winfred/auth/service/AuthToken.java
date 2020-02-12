package com.winfred.auth.service;

import com.winfred.auth.entity.UserInfo;
import com.winfred.auth.entity.response.TokenResponse;

/**
 * 主要功能:
 * 1. 颁发Token: 根据 user 信息, 生成Token
 * 2. 判断Token是否合法
 */
public interface AuthToken {

    /**
     * authentication(认证):
     * 身份验证: 证明请求者身份, 需要提供密码, 验证码, 或生物识别码
     *
     * @param userInfo
     * @return
     */
    UserInfo authentication(UserInfo userInfo);

    /**
     * authorization(授权):
     * 为了获得授权, 经过认证后获得token, 这个token就是authorization授权.
     * <p>
     * client 端, token 需要放在header请求中
     *
     * @param userInfo
     * @return
     */
    TokenResponse getAuthorizationToken(UserInfo userInfo);

    /**
     * refresh token
     *
     * @param tokenResponse
     * @return
     */
    TokenResponse refreshToken(TokenResponse tokenResponse);

    /**
     * verifier token
     *
     * @param token
     * @return
     */
    Boolean verifyToken(String token);


}
