package com.winfred.auth.api;

import com.winfred.auth.entity.request.LoginInfo;
import com.winfred.auth.entity.response.TokenResponse;
import com.winfred.common.entity.base.BaseResponse;

public interface BaseAuth {

    BaseResponse<TokenResponse> userLogin(LoginInfo loginInfo);
}
