package com.winfred.auth.entity.response;

import lombok.Data;

@Data
public class TokenResponse {
    private String token;
    private String refreshToken;
}
