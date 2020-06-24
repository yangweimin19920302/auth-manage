package com.auth.manage.service;

import com.auth.manage.entity.User;
import com.auth.manage.util.CustomException;
import com.auth.starter.Subject;
import com.auth.starter.model.SecurityUser;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService {

    public User login(User user) throws Exception {
        if (!user.getLoginName().equals("ywm") || !user.getPassword().equals("123")) {
            throw new CustomException(700, "用户名或密码不正确");
        }
        SecurityUser securityUser = new SecurityUser();
        securityUser.setLoginName(user.getLoginName());
        securityUser.setPermissionList(Arrays.asList("add", "select"));
        String token = Subject.login(securityUser);
        user.setToken(token);
        return user;
    }
}
