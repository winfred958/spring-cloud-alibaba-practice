package com.winfred.auth.api;

import com.winfred.auth.entity.response.TokenResponse;
import com.winfred.core.entity.base.BaseResponse;

public interface BaseAuth {

    BaseResponse<TokenResponse> userLogin();
}
