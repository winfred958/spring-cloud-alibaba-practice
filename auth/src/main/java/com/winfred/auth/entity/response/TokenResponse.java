package com.winfred.auth.entity.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TokenResponse {
  private String token;
  private String refreshToken;
}
