package com.s2start.mybooks.model;

import java.io.Serializable;

public class mss  implements Serializable {

    private String message;

    public mss(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
