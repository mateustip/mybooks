package com.s2start.mybooks.services;


import com.s2start.mybooks.model.ArrayWish;
import com.s2start.mybooks.model.Book;
import com.s2start.mybooks.model.Comentario;
import com.s2start.mybooks.model.NewUser;
import com.s2start.mybooks.model.wishlistadd;
import com.s2start.mybooks.model.imagemBase64;
import com.s2start.mybooks.model.listUser;
import com.s2start.mybooks.model.UserLogin;
import com.s2start.mybooks.model.mss;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ServiceUser {
    @POST("login")
    Call<listUser> login(@Body UserLogin l);
    @GET("wishlist/{id}")
    Call<ArrayWish> wishlist(@Path("id") int id);
    @GET("livro/{id}")
    Call<Book> getLivro(@Path("id") int id);
    @POST("registro")
    Call<mss> registrar(@Body NewUser u);

    @GET("procura/{name}")
    Call<ArrayWish> pesquisaLivro(@Path("name") String name);
    ///procura/imagem


    @POST("procura/imagem")
    Call<ArrayWish> getImagem64(@Body imagemBase64 im);

    @POST("biblioteca/{id}")
    Call<ArrayWish> setComentario(@Path("id") int id,@Body Comentario comentario);

    @POST("wishlist/{id}")
    Call<mss> addWishList(@Path("id") int id,@Body wishlistadd c);

    @GET("biblioteca/{id}")
    Call<ArrayWish> getBiblioteca(@Path("id") int id);
}
