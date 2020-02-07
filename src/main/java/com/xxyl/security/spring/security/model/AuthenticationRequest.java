package com.xxyl.security.spring.security.model;

import lombok.Data;

/**
 * 认证请求
 *
 * @author xxyl
 * @version 2020/2/7 10:41
 */
@Data
public class AuthenticationRequest {

    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

}
