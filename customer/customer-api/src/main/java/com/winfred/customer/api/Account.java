package com.winfred.customer.api;

import com.winfred.core.entity.base.BaseResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 *
 */
@RequestMapping(value = "/v1/account")
public interface Account {

    // FIXME: 接口定义, 待完善

    /**
     * 创建新账户
     *
     * @param object
     * @return
     */
    @RequestMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    BaseResponse<Object> createAccount(@RequestBody Object object);

    /**
     * 获取或创建(不存在)的账户
     *
     * @param object
     * @return
     */
    @RequestMapping(value = "/get-or-create", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    BaseResponse<Object> getOrCreateAccount(@RequestBody Object object);

    /**
     * 根据userId获取账户信息, 内部使用, 需要权限
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/get/{user_id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    BaseResponse<Object> getById(@PathVariable(name = "user_id") String userId);

    /**
     * 变更密码
     *
     * @param object
     * @return
     */
    @RequestMapping(value = "/update/password", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    BaseResponse<Object> updatePassword(
            @RequestHeader(name = "Authentication") String token,
            @RequestBody Object object
    );

    /**
     * login
     * 认证, (登陆校验)
     * 验证用户名密码
     *
     * @return
     */
    @RequestMapping(value = "/authentication", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    BaseResponse<Object> authentication(@RequestBody Object object);

    /**
     * 请求密码重置
     * 通过邮件或短信间接操作
     *
     * @param object
     * @return
     */
    @RequestMapping(value = "/reset", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    BaseResponse<Object> requestPasswordReset(@RequestBody Object object);

    /**
     * 同步账户至其他系统
     *
     * @param object
     * @return
     */
    @RequestMapping(value = "/sync", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    BaseResponse<Object> syncUser(@RequestBody Object object);
}
