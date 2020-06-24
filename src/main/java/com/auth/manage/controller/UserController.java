package com.auth.manage.controller;

import com.auth.manage.entity.User;
import com.auth.manage.service.UserService;
import com.auth.starter.annotation.Auth;
import com.auth.starter.annotation.NotAuth;
import com.auth.starter.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Auth//该类下的方法都要认证
public class UserController {

    @Resource
    private UserService userService;

    @NotAuth//该方法不需要认证
    @PostMapping("/login")
    public Object login(@RequestBody User user) throws Exception {
        return userService.login(user);
    }

    @GetMapping("/add")
    @RequiresPermissions("add")
    public Object add() throws Exception {
        return "add";
    }

    @GetMapping("/get")
    @RequiresPermissions("select")
    public Object select() throws Exception {
        return "get";
    }

    @GetMapping("/del")
    @RequiresPermissions("del")
    public Object del() throws Exception {
        return "del";
    }

    @GetMapping("/other")
    public Object other() throws Exception {
        return "other";
    }
}
