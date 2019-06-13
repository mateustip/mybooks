package com.s2start.mybooks;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.EditText;

import com.google.gson.Gson;
import com.s2start.mybooks.app.MyBooksApplication;
import com.s2start.mybooks.model.User;
import com.s2start.mybooks.model.UserLogin;
import com.s2start.mybooks.model.listUser;
import com.s2start.mybooks.services.ServiceUser;
import com.s2start.mybooks.ui.CadastroActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.usuario)
    EditText usuario;
    @BindView(R.id.senha)
    EditText senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.logar)
    public void logar(){
        UserLogin l = new UserLogin(usuario.getText().toString(),senha.getText().toString());

        ServiceUser s = MyBooksApplication.getInstance().getServiceUser();
        Call<listUser> call = s.login(l);

        call.enqueue(new Callback<listUser>() {
            @Override
            public void onResponse(Call<listUser> call, Response<listUser> response) {

                if(response.code() == 200){

                    Gson gson = new Gson();
                    String userString = gson.toJson(response.body().getUser());
                    SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("usuario", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("usuario", userString);
                    editor.apply();

                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();

                }else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setMessage("Email ou senha invalido");
                    builder.setTitle("Alert !");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Concluir",null);

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            }

            @Override
            public void onFailure(Call<listUser> call, Throwable t) {
                    Log.d("ERROR","" + t.getMessage());
            }
        });
    }
    @OnClick(R.id.cadastro)
    public void cadastro(){
        Intent i = new Intent(LoginActivity.this, CadastroActivity.class);
        startActivity(i);
    }

}
