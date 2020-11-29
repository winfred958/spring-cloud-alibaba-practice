package com.winfred.auth.service.imp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.RSAKeyProvider;
import com.winfred.auth.entity.request.LoginInfo;
import com.winfred.auth.entity.response.ResponseUserInfo;
import com.winfred.auth.entity.response.TokenResponse;
import com.winfred.auth.service.AuthToken;
import com.winfred.common.global.constant.JWTConstant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Service
public class AuthTokenImpl implements AuthToken {

    @Value(value = "${spring.application.name}")
    private String APPLICATION_NAME;

    @Value(value = "${default.redirect.url:xxxxxx}")
    private String DEFAULT_REDIRECT_URL;

    /**
     * 1. 查询DB或调用user-service, 获取用户信息&角色
     * 2. 设置 authentication 标识位
     */
    @Override
    public ResponseUserInfo authentication(LoginInfo loginInfo) {

        return null;
    }

    @Override
    public TokenResponse getAuthorizationToken(LoginInfo loginInfo) {
        TokenResponse tokenResponse;
        ResponseUserInfo authenticationUser = authentication(loginInfo);
        tokenResponse = new TokenResponse();
        if (null == authenticationUser || !authenticationUser.getAuthenticated()) {
            // 没有通过认证
            tokenResponse.setRedirectUrl(DEFAULT_REDIRECT_URL);
            return tokenResponse;
        }

        JWTCreator.Builder jwtBuilder = JWT.create();
        jwtBuilder
                .withIssuer(APPLICATION_NAME)// 颁发者
                .withIssuedAt(getIssuedTime())
                .withNotBefore(getNotBeforeTime())
                .withExpiresAt(getExpireTime(1))
        ;

        // 增加业务数据
        jwtBuilder.withClaim(JWTConstant.USER_ID.getName(), authenticationUser.getUserId());
        jwtBuilder.withClaim(JWTConstant.NICKNAME.getName(), authenticationUser.getNickname());
        jwtBuilder.withClaim(JWTConstant.ROLES.getName(), JSON.toJSONString(authenticationUser.getRoles(), SerializerFeature.SortField));
        jwtBuilder.withClaim(JWTConstant.AUTHENTICATED.getName(), authenticationUser.getAuthenticated());

        String token = jwtBuilder.sign(Algorithm.RSA256(gerRSAKeyProvider()));

        tokenResponse.setToken(token);
        tokenResponse.setRedirectUrl(loginInfo.getRedirectUrl());

        return tokenResponse;
    }

    @Override
    public TokenResponse refreshToken(TokenResponse tokenResponse) {
        return null;
    }

    @Override
    public Boolean verifyToken(String token) {

        return null;
    }


    private RSAKeyProvider gerRSAKeyProvider() {
        RSAKeyProvider rsaKeyProvider = new RSAKeyProvider() {
            @Override
            public RSAPublicKey getPublicKeyById(String keyId) {
                return null;
            }

            @Override
            public RSAPrivateKey getPrivateKey() {
                return null;
            }

            @Override
            public String getPrivateKeyId() {
                return null;
            }
        };
        return rsaKeyProvider;
    }
}
