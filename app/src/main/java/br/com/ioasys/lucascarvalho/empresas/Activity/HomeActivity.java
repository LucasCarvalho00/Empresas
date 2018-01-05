package br.com.ioasys.lucascarvalho.empresas.Activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.Locale;

import br.com.ioasys.lucascarvalho.empresas.Adapters.ListEmpresaAdapter;
import br.com.ioasys.lucascarvalho.empresas.R;
import br.com.ioasys.lucascarvalho.empresas.Utils.PreencheDados;

public class HomeActivity extends AppCompatActivity {

    private TextView txvDescricao;
    private ListView lstEmpresa;
    private ListEmpresaAdapter empresaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        carregaCustomActionBar();

        txvDescricao = findViewById(R.id.txvHomeDescricao);
        lstEmpresa = findViewById(R.id.lstHomeEmpresas);
    }

    private void carregaCustomActionBar(){
        LayoutInflater inflater = (LayoutInflater) getSupportActionBar().getThemedContext()
                .getSystemService(LAYOUT_INFLATER_SERVICE);

        final View customActionBarView = inflater.inflate(
                R.layout.action_bar_home, null);

        /*As funções abaixo são utilizadas para carregar o custom action bar*/
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setIcon(R.drawable.ic_search);
        actionBar.setCustomView(customActionBarView);
        actionBar.setDisplayShowCustomEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        final SearchView searchView = (SearchView)item.getActionView();
        searchView.setQueryHint(getString(R.string.pesquisar));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if(!s.isEmpty()){
                    String text = searchView.getQuery().toString().toLowerCase(Locale.getDefault());
                    empresaAdapter.filtro(text);

                    lstEmpresa.setVisibility(View.VISIBLE);
                } else
                {
                    lstEmpresa.setVisibility(View.GONE);
                }
                return false;
            }
        });

        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txvDescricao.setVisibility(View.GONE);
                preencheLista();
            }
        });

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                txvDescricao.setVisibility(View.VISIBLE);
                lstEmpresa.setVisibility(View.GONE);
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }

    public void preencheLista(){
        lstEmpresa.setVisibility(View.GONE);
        empresaAdapter = new ListEmpresaAdapter(this, R.layout.list_empresa, PreencheDados.arrayEmpresa);
        lstEmpresa.setAdapter(empresaAdapter);
    }
}
