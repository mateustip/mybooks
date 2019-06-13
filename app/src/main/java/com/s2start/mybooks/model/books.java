package com.s2start.mybooks.model;

import java.io.Serializable;

public class books implements Serializable {

    private Integer id;
    private String imagem;
    private String nome;

    public books(Integer id, String imagem, String nome) {
        this.id = id;
        this.imagem = imagem;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
