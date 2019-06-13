package com.s2start.mybooks;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.s2start.mybooks.app.MyBooksApplication;
import com.s2start.mybooks.model.ArrayWish;
import com.s2start.mybooks.model.User;
import com.s2start.mybooks.model.books;
import com.s2start.mybooks.model.imagemBase64;
import com.s2start.mybooks.model.listUser;
import com.s2start.mybooks.services.ServiceUser;
import com.s2start.mybooks.ui.BookActivity;
import com.s2start.mybooks.ui.adapters.AdapterWishlist;

import java.io.ByteArrayOutputStream;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.list)
    ListView list;




    List<books> livros;

     @BindView(R.id.pesquisalb)
    EditText pesquisalb;

     @BindView(R.id.titulo)
    TextView titulo;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    String base64;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);



        SharedPreferences sharedPreferences =  getApplicationContext().getSharedPreferences("usuario", Context.MODE_PRIVATE);

        //chamando o gson
        Gson gson = new Gson();

        //colocando o gson em uma string
        String json =  sharedPreferences.getString("usuario", null);

        //colocando o usuario do gson em um objeto
        User user = gson.fromJson(json, User.class);
        this.user = user;
        getBiblioteca();
    }

    public void getBiblioteca(){
        //getBiblioteca
        ServiceUser s = MyBooksApplication.getInstance().getServiceUser();

        Call<ArrayWish> call =  s.getBiblioteca(this.user.getId());
        call.enqueue(new Callback<ArrayWish>() {
            @Override
            public void onResponse(Call<ArrayWish> call, Response<ArrayWish> response) {
                if(response.code() == 400){
                    restart();
                }else if(response.code() == 200) {
                    titulo.setText("Biblioteca");

                    livros =  response.body().getLivros();
                    AdapterWishlist adapter = new AdapterWishlist(MainActivity.this, response.body().getLivros());
                    list.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<ArrayWish> call, Throwable t) {

            }
        });

    }
    public void restart(){
        titulo.setText("WishList");

        ServiceUser s = MyBooksApplication.getInstance().getServiceUser();

        Call<ArrayWish> call =  s.wishlist(this.user.getId());
        call.enqueue(new Callback<ArrayWish>() {
            @Override
            public void onResponse(Call<ArrayWish> call, Response<ArrayWish> response) {

                if(response.code() == 400){
                    getBiblioteca();
                }else if(response.code() == 200) {
                    livros =  response.body().getLivros();
                    AdapterWishlist adapter = new AdapterWishlist(MainActivity.this, response.body().getLivros());
                    list.setAdapter(adapter);

                }
            }
            @Override
            public void onFailure(Call<ArrayWish> call, Throwable t) {
            }
        });
    }
    @OnItemClick(R.id.list)
    public void listaClick(int p) {
        restart();

        books teste = livros.get(p);
        Log.i("#########", "listaClick: "+teste.getNome());
        Intent i = new Intent(this, BookActivity.class);
        i.putExtra("id",livros.get(p).getId());
        startActivity(i);

    }

    @OnClick(R.id.pesquisar)
    public void pesquisar(){
        String pq =  pesquisalb.getText().toString();
        ServiceUser s = MyBooksApplication.getInstance().getServiceUser();
        Call<ArrayWish> call =  s.pesquisaLivro(pq);
        call.enqueue(new Callback<ArrayWish>() {
            @Override
            public void onResponse(Call<ArrayWish> call, Response<ArrayWish> response) {
                if(response.code() == 400){
                    restart();
                }else if(response.code() == 200) {
                    livros = response.body().getLivros();
                    AdapterWishlist adapter = new AdapterWishlist(MainActivity.this, response.body().getLivros());
                    list.setAdapter(adapter);
                    titulo.setText("Pesquisa: " + pesquisalb.getText().toString());
                }
            }

            @Override
            public void onFailure(Call<ArrayWish> call, Throwable t) {
                Log.d("error ","" + t.getMessage());

            }
        });


    }
    @OnClick(R.id.camera)
    public void camera(){

        dispatchTakePictureIntent();



    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream .toByteArray();

            String encoded = Base64.encodeToString(byteArray, Base64.DEFAULT);
           this.base64 = encoded;

            imagemBase64 im = new imagemBase64(this.base64);
            ServiceUser s = MyBooksApplication.getInstance().getServiceUser();
            Call<ArrayWish> call =  s.getImagem64(im);

            call.enqueue(new Callback<ArrayWish>() {
                @Override
                public void onResponse(Call<ArrayWish> call, Response<ArrayWish> response) {
                    if(response.code() == 400){
                        restart();
                    }else if(response.code() == 200) {
                        livros = response.body().getLivros();
                        AdapterWishlist adapter = new AdapterWishlist(MainActivity.this, response.body().getLivros());
                        list.setAdapter(adapter);
                    }
                }

                @Override
                public void onFailure(Call<ArrayWish> call, Throwable t) {
                    Log.d("error ","" + t.getMessage());
                }
            });
        }
    }

    @OnClick(R.id.bibliteca)
    public void bbiblioteca(){
        getBiblioteca();
    }
    @OnClick(R.id.recarregar)
    public void recarregar(){
        restart();
    }
    @OnClick(R.id.recomendado)
    public void recomendado(){

    }

    @OnClick(R.id.sair)
    public void sair(){

        Intent i = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(i);
        finish();
        overridePendingTransition(0,0);

    }

}
