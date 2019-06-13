package com.s2start.mybooks.model;

import java.io.Serializable;
import java.util.List;


public class ArrayWish  implements Serializable {
    private List<books> livros;

    public ArrayWish(List<books> livros) {
        this.livros = livros;
    }

    public List<books> getLivros() {
        return livros;
    }

    public void setLivros(List<books> livros) {
        this.livros = livros;
    }
}
