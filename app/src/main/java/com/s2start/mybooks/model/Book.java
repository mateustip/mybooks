package com.s2start.mybooks.model;

import java.io.Serializable;
import java.util.List;

public class Book  implements Serializable {
    private Integer id;
    private String imagem;
    private String imagem_pequena;
    private String link;
    private String nome;
    private String nota;
    private Integer numero_paginas;
    private List<ComentariosL> comentario;
    private Double preco;
    private Integer ano_edicao;
    private String editora;

    public Book( List<ComentariosL> comentario,Integer id, String imagem, String imagem_pequena, String link, String nome, String nota, Integer numero_paginas, Double preco, Integer ano_edicao,String editora) {
        this.id = id;
        this.imagem = imagem;
        this.imagem_pequena = imagem_pequena;
        this.link = link;
        this.nome = nome;
        this.nota = nota;
        this.numero_paginas = numero_paginas;
        this.preco = preco;
        this.ano_edicao = ano_edicao;
        this.editora = editora;
        this.comentario = comentario;
    }

    public List<ComentariosL> getComentario() {
        return comentario;
    }

    public void setComentario(List<ComentariosL> comentario) {
        this.comentario = comentario;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
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

    public String getImagem_pequena() {
        return imagem_pequena;
    }

    public void setImagem_pequena(String imagem_pequena) {
        this.imagem_pequena = imagem_pequena;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Integer getNumero_paginas() {
        return numero_paginas;
    }

    public void setNumero_paginas(Integer numero_paginas) {
        this.numero_paginas = numero_paginas;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getAno_edicao() {
        return ano_edicao;
    }

    public void setAno_edicao(Integer ano_edicao) {
        this.ano_edicao = ano_edicao;
    }
}
