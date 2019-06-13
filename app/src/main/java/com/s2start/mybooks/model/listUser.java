package com.s2start.mybooks.model;

import java.io.Serializable;

public class listUser implements Serializable {
    private User user;

    public listUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
