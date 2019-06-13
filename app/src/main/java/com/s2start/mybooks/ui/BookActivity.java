package com.s2start.mybooks.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.s2start.mybooks.MainActivity;
import com.s2start.mybooks.R;
import com.s2start.mybooks.app.MyBooksApplication;
import com.s2start.mybooks.model.ArrayWish;
import com.s2start.mybooks.model.Book;
import com.s2start.mybooks.model.Comentario;
import com.s2start.mybooks.model.User;
import com.s2start.mybooks.model.listUser;
import com.s2start.mybooks.model.mss;
import com.s2start.mybooks.model.wishlistadd;
import com.s2start.mybooks.services.ServiceUser;
import com.s2start.mybooks.ui.adapters.AdapterComentario;
import com.s2start.mybooks.ui.adapters.AdapterWishlist;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookActivity extends AppCompatActivity {
    @BindView(R.id.name)
    TextView name;

    @BindView(R.id.editora)
    TextView editora;

    @BindView(R.id.image)
    ImageView image;

    @BindView(R.id.star1)
    ImageButton star1;
    @BindView(R.id.star2)
    ImageButton star2;
    @BindView(R.id.star3)
    ImageButton star3;
    @BindView(R.id.star4)
    ImageButton star4;
    @BindView(R.id.star5)
    ImageButton star5;

    @BindView(R.id.descricao)
    EditText descricao;

    @BindView(R.id.listcomentarios)
    ListView list;

    Integer NumberStar = 1;
    Integer id;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        ButterKnife.bind(this);

        SharedPreferences sharedPreferences =  getApplicationContext().getSharedPreferences("usuario", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json =  sharedPreferences.getString("usuario", null);
        User user = gson.fromJson(json, User.class);
        this.user = user;


        retry();

    }

    public void retry(){
        Integer p = (Integer) getIntent().getSerializableExtra("id");
        Log.d("id livro ","" + p);
        id = p;
        ServiceUser s = MyBooksApplication.getInstance().getServiceUser();

        Call<Book> call =  s.getLivro(p);
        call.enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {
                name.setText("Nome: "+ response.body().getNome());
                editora.setText("Editora: "+ response.body().getEditora());
                Picasso.get().load(response.body().getImagem_pequena()).into(image);



                AdapterComentario adapter = new AdapterComentario(BookActivity.this,response.body().getComentario());
                list.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {
                Log.d("erro matheus", t.getMessage());
            }
        });
    }


    @OnClick(R.id.star1)
    public void star1s(ImageButton button) {
        button.setImageResource(R.drawable.star_ativa);
        star2.setImageResource(R.drawable.star_inativa);
        star3.setImageResource(R.drawable.star_inativa);
        star4.setImageResource(R.drawable.star_inativa);
        star5.setImageResource(R.drawable.star_inativa);
        NumberStar = 1;
    }
    @OnClick(R.id.star2)
    public void star2s(ImageButton button) {
        button.setImageResource(R.drawable.star_ativa);
        star1.setImageResource(R.drawable.star_ativa);
        star3.setImageResource(R.drawable.star_inativa);
        star4.setImageResource(R.drawable.star_inativa);
        star5.setImageResource(R.drawable.star_inativa);
        NumberStar = 2;
    }
    @OnClick(R.id.star3)
    public void star3s(ImageButton button) {
        button.setImageResource(R.drawable.star_ativa);
        star1.setImageResource(R.drawable.star_ativa);
        star2.setImageResource(R.drawable.star_ativa);
        star4.setImageResource(R.drawable.star_inativa);
        star5.setImageResource(R.drawable.star_inativa);
        NumberStar = 3;

    }
    @OnClick(R.id.star4)
    public void star4s(ImageButton button) {
        button.setImageResource(R.drawable.star_ativa);
        star2.setImageResource(R.drawable.star_ativa);
        star3.setImageResource(R.drawable.star_ativa);
        star1.setImageResource(R.drawable.star_ativa);

        star5.setImageResource(R.drawable.star_inativa);
        NumberStar = 4;

    }
    @OnClick(R.id.star5)
    public void star5s(ImageButton button) {
        button.setImageResource(R.drawable.star_ativa);
        star2.setImageResource(R.drawable.star_ativa);
        star3.setImageResource(R.drawable.star_ativa);
        star1.setImageResource(R.drawable.star_ativa);
        star4.setImageResource(R.drawable.star_ativa);
        NumberStar = 5;
    }

    @OnClick(R.id.enviar)
    public void enviar(){
        Comentario c = new Comentario(NumberStar,descricao.getText().toString(),id);
        ServiceUser s = MyBooksApplication.getInstance().getServiceUser();

        Call<ArrayWish> call =  s.setComentario(user.getId(),c);
        call.enqueue(new Callback<ArrayWish>() {
            @Override
            public void onResponse(Call<ArrayWish> call, Response<ArrayWish> response) {
                retry();
            }

            @Override
            public void onFailure(Call<ArrayWish> call, Throwable t) {

            }
        });

    }

    @OnClick(R.id.adicionarwishlist)
    public void adicionarwishlist(){
        wishlistadd a = new wishlistadd(id);
        ServiceUser s = MyBooksApplication.getInstance().getServiceUser();

        Call<mss> call =  s.addWishList(user.getId(),a);
        call.enqueue(new Callback<mss>() {
            @Override
            public void onResponse(Call<mss> call, Response<mss> response) {
                if(response.message().equals("Insert Done")){
                    retry();
                }
            }

            @Override
            public void onFailure(Call<mss> call, Throwable t) {

            }
        });
        //addWishList
    }

}
