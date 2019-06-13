package com.s2start.mybooks.model;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private String email;
    private Integer id;
    private String nome;
    private Integer tipo;

    public User(String email, Integer id, String nome, Integer tipo) {
        this.email = email;
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
}

