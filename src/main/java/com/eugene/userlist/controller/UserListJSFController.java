package com.eugene.userlist.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.eugene.userlist.domain.Filter;
import com.eugene.userlist.domain.User;
import com.eugene.userlist.service.UserService;

@SessionScope
@Component (value = "userList")
public class UserListJSFController {
    @Autowired
    private UserService service;

    private List<User> users;
    private Filter filter;

    @PostConstruct
    public void loadData() {
        filter = new Filter();
        users = service.getUserList( filter.getDateFrom(), filter.getDateTo(), filter.getEmail());
    }
    
    public List<User> getUsers() {
        users = service.getUserList( filter.getDateFrom(), filter.getDateTo(), filter.getEmail());
        return users;
    }
    
    public void remove(User user) {
        service.delete(user);
        users = service.getUserList( filter.getDateFrom(), filter.getDateTo(), filter.getEmail());
    }

	public Filter getFilter() {
		return filter;
	}
   
}