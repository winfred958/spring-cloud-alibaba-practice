package com.winfred.auth.service.imp;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.RSAKeyProvider;
import com.winfred.auth.entity.UserInfo;
import com.winfred.auth.entity.response.TokenResponse;
import com.winfred.auth.service.AuthToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Calendar;

@Service
public class AuthTokenImpl implements AuthToken {

    @Value(value = "${spring.application.name}")
    private String application_name;

    @Override
    public UserInfo authentication(UserInfo userInfo) {
        /**
         * 1. 查询DB或调用user-service, 获取用户信息
         */
        return null;
    }

    @Override
    public TokenResponse getAuthorizationToken(UserInfo userInfo) {
        UserInfo authenticationUser = authentication(userInfo);
        if (null == authenticationUser || !authenticationUser.getAuthentication()) {
            // 没有通过认证
            return null;
        }
        String userId = userInfo.getUserId();

        JWTCreator.Builder jwtBuilder = JWT.create();
        jwtBuilder
                .withIssuer(application_name)// 颁发者
                .withIssuedAt(Calendar.getInstance().getTime())
                .withNotBefore(Calendar.getInstance().getTime())
        ;

        String token = jwtBuilder.sign(Algorithm.RSA256(gerRSAKeyProvider()));


        return new TokenResponse(token, "");
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
