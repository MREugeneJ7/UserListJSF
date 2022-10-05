package com.eugene.userlist.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.eugene.userlist.domain.User;
import com.eugene.userlist.service.UserService;

@RequestScope
@Component(value = "userSaveController")
public class UserSaveJSFController {
    @Autowired
    private UserService service;

    private User user = new User();

    public String save() {
        service.save(user);
        user = new User();
        return "/user-list.xhtml?faces-redirect=true";
    }

    public User getUser() {
        return user;
    }
}