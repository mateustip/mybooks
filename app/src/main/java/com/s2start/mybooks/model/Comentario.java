package com.s2start.mybooks.model;

public class Comentario {
    private Integer nota;
    private String comentario;
    private Integer l_id;

    public Comentario(Integer nota, String comentario, Integer l_id) {
        this.nota = nota;
        this.comentario = comentario;
        this.l_id = l_id;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getL_id() {
        return l_id;
    }

    public void setL_id(Integer l_id) {
        this.l_id = l_id;
    }
}
