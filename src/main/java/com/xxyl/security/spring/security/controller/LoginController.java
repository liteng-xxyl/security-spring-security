package com.xxyl.security.spring.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xxyl
 * @version 2020/2/7 14:11
 */
@RestController
public class LoginController {

    /**
     * 登录成功
     * @return
     */
    @PostMapping(value = "/login-success", produces = {"text/plain;charset=UTF-8"})
    public String loginSuccess() {
        return "登录成功";
    }

    /**
     * 访问资源1
     * @return
     */
    @GetMapping(value = "/resource/r1", produces = {"text/plain;charset=UTF-8"})
    public String r1() {
        return "访问资源1";
    }

    /**
     * 访问资源2
     * @return
     */
    @GetMapping(value = "/resource/r2", produces = {"text/plain;charset=UTF-8"})
    public String r2() {
        return "访问资源2";
    }

}
