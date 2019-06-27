package com.hanburger92.model;

import com.sun.istack.internal.NotNull;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Size;

@Component
public class User {

    // 规定了用户名不为空且长度之于5到20
    @NotNull
    @Size(min = 5, max = 20)
    private String username;

    @NotNull
    @Size(min = 5, max = 20)
    private String password;

    public User(){}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
