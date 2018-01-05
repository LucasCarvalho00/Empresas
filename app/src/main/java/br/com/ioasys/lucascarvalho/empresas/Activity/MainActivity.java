package br.com.ioasys.lucascarvalho.empresas.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.ioasys.lucascarvalho.empresas.Models.Service;
import br.com.ioasys.lucascarvalho.empresas.Models.User;
import br.com.ioasys.lucascarvalho.empresas.Models.UserResponse;
import br.com.ioasys.lucascarvalho.empresas.R;
import br.com.ioasys.lucascarvalho.empresas.Utils.PreencheDados;
import br.com.ioasys.lucascarvalho.empresas.Utils.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button btnEntrar;
    EditText edtEmail, edtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        referenciaComponentes();
        acaoComponentes();
    }

    private void referenciaComponentes(){
        btnEntrar = findViewById(R.id.btnMainEntrar);
        edtEmail = findViewById(R.id.edtMainEmail);
        edtSenha = findViewById(R.id.edtMainSenha);

    }

    private void acaoComponentes(){
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Verifica se os campos estão vazios.
                if(Utils.validaCampoVazio(edtEmail, getString(R.string.msgemailvazio)) == true
                        || (Utils.validaCampoVazio(edtSenha, getString(R.string.msgsenhavazia)) == true)) {

                    //User usuario = new User(edtEmail.getText().toString(), edtSenha.getText().toString());
                    //autenticarUsuario(usuario);

                    Intent i = new Intent(MainActivity.this, HomeActivity.class);
                    PreencheDados.setDadosObjetos();
                    startActivity(i);
                    finish();
                }
            }
        });
    }

    public void autenticarUsuario(User user) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Service.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Service servico = retrofit.create(Service.class);

        Call<UserResponse> call = servico.login(user);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {

                if (response.isSuccessful()) {
                    SharedPreferences sharedPreferences = getSharedPreferences(Service.TOKEN_SHARED, 0);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putString("access-token", response.headers().get("access-token"));
                    editor.putString("client", response.headers().get("client"));
                    editor.putString("uid", response.headers().get("uid"));
                    editor.commit();

                    Intent i = new Intent(MainActivity.this, HomeActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                } else {
                    Log.d("Erro", response.toString());
                    Toast.makeText(MainActivity.this, getString(R.string.msgusuario), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, getString(R.string.msgconexao), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
