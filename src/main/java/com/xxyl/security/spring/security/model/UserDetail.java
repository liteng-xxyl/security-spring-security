package com.xxyl.security.spring.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

/**
 * 当前登录用户信息
 *
 * @author xxyl
 * @version 2020/2/7 10:39
 */
@Data
@AllArgsConstructor
public class UserDetail {

    public static final String SESSION_USER_KEY = "_user";

    private String id;
    private String username;
    private String password;
    private String fullName;
    private String mobile;

    /**
     * 用户权限
     */
    private Set<String> authorities;

}
