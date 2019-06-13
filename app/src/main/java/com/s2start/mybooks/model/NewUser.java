package com.s2start.mybooks.model;

import java.io.Serializable;

public class NewUser implements Serializable {
    private String usuario;
    private String senha;
    private String email;
    private String nome;

    public NewUser(String usuario, String senha, String email, String nome) {
        this.usuario = usuario;
        this.senha = senha;
        this.email = email;
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
