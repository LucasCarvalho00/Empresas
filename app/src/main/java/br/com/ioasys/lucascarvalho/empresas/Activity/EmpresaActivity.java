package br.com.ioasys.lucascarvalho.empresas.Activity;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import br.com.ioasys.lucascarvalho.empresas.R;

public class EmpresaActivity extends AppCompatActivity {

    TextView txvDescricao, txvEmpresa;
    String Descricao, Empresa, ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa);

        referenciaComponentes();
        recuperandoDados();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(Empresa);

        int i = Empresa.length();
        txvEmpresa.setText(String.valueOf(Empresa.charAt(0)).toUpperCase() + String.valueOf(Empresa.charAt(i - 1)));
        txvDescricao.setText(Descricao);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void referenciaComponentes(){
        txvDescricao = findViewById(R.id.txvEmpTexto);
        txvEmpresa = findViewById(R.id.txvEmpTextoImagem);
    }

    public void recuperandoDados(){
        Intent intent = getIntent();
        Bundle dados = intent.getExtras();
        ID = dados.getString("ID");
        Descricao = dados.getString("Descricao");
        Empresa = dados.getString("Empresa");
    }
}
