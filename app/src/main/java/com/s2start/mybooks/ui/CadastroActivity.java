package com.s2start.mybooks.ui;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.EditText;

import com.s2start.mybooks.LoginActivity;
import com.s2start.mybooks.R;
import com.s2start.mybooks.app.MyBooksApplication;
import com.s2start.mybooks.model.Book;
import com.s2start.mybooks.model.NewUser;
import com.s2start.mybooks.model.mss;
import com.s2start.mybooks.services.ServiceUser;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroActivity extends AppCompatActivity {

    @BindView(R.id.usuario)
    EditText usuario;
    @BindView(R.id.senha)
    EditText senha;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.nome)
    EditText nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        ButterKnife.bind(this);

    }
    @OnClick(R.id.cadastrar)
    public void cadastro(){
        NewUser nu = new NewUser(usuario.getText().toString(),senha.getText().toString(),email.getText().toString(),nome.getText().toString());
        ServiceUser s = MyBooksApplication.getInstance().getServiceUser();

        Call<mss> call =  s.registrar(nu);
        call.enqueue(new Callback<mss>() {
            @Override
            public void onResponse(Call<mss> call, Response<mss> response) {
                if(response.code() == 200){
                    AlertDialog.Builder builder = new AlertDialog.Builder(CadastroActivity.this);
                    builder.setMessage("Cadastro realizado com sucesso!");
                    builder.setTitle("Sucesso !");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Concluir",null);

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                }else{

                    AlertDialog.Builder builder = new AlertDialog.Builder(CadastroActivity.this);
                    builder.setMessage("Nao foi possivel fazer o cadastro");
                    builder.setTitle("Alert !");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Concluir",null);

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            }

            @Override
            public void onFailure(Call<mss> call, Throwable t) {

            }
        });

    }
    @OnClick(R.id.login)
    public void login(){
        onBackPressed();
    }
}
