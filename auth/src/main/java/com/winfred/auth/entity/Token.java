package com.winfred.auth.entity;

import lombok.Data;

@Data
public class Token {
    private String userId;
    /**
     * 颁发时间戳
     */
    private Long issued;
    /**
     * 过期时间戳
     */
    private Long expire;



}
