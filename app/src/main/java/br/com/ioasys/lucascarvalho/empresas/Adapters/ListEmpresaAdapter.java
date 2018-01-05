package br.com.ioasys.lucascarvalho.empresas.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.com.ioasys.lucascarvalho.empresas.Activity.EmpresaActivity;
import br.com.ioasys.lucascarvalho.empresas.Models.Enterprise;
import br.com.ioasys.lucascarvalho.empresas.Models.EnterpriseSearchResponse;
import br.com.ioasys.lucascarvalho.empresas.Models.Service;
import br.com.ioasys.lucascarvalho.empresas.R;
import br.com.ioasys.lucascarvalho.empresas.Utils.PreencheDados;

/**
 * Created by Desenvolvimento on 04/01/2018.
 */

public class ListEmpresaAdapter extends ArrayAdapter<Enterprise> {

    private AppCompatActivity activity;
    //Itens de exibição / filtrados
    private List<Enterprise> resultadoList;
    private ArrayList<Enterprise> arraylist;


    public ListEmpresaAdapter(AppCompatActivity context, int resource, ArrayList<Enterprise> objects) {
        super(context, resource, objects);
        this.activity = context;
        this.resultadoList = objects;
        this.arraylist = new ArrayList<>();
        resultadoList = PreencheDados.arrayEmpresa;
        arraylist.addAll(resultadoList);

    }

    @Override
    public Enterprise getItem(int position) {
        return resultadoList.get(position);
    }


    @Override
    public int getCount() {

        return resultadoList.size();
    }

    @Override
    public long getItemId(int arg0) {
        return resultadoList.get(arg0).getId();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        final LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_empresa, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.empresa.setText(getItem(position).getEnterpriseName());
        holder.ramo.setText(getItem(position).getEnterpriseType().getEnterprise_type_name());
        holder.pais.setText(getItem(position).getCountry());
        int tamanho = getItem(position).getEnterpriseName().length();
        String textoEmpresa = getItem(position).getEnterpriseName();
        holder.textoEmpresa.setText(String.valueOf(textoEmpresa.charAt(0)).toUpperCase() + String.valueOf(textoEmpresa.charAt(tamanho - 1)));


        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), EmpresaActivity.class);
                intent.putExtra("ID", String.valueOf(getItem(position).getId()));
                intent.putExtra("Empresa", String.valueOf(getItem(position).getEnterpriseName()));
                intent.putExtra("Descricao", String.valueOf(getItem(position).getDescription()));

                activity.startActivity(intent);
            }
        });

        return convertView;
    }

    public void filtro(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        resultadoList.clear();
        if (charText.length() == 0) {
            resultadoList.addAll(arraylist);
        }
        else
        {
            for (Enterprise ent : arraylist)
            {
                if (ent.getEnterpriseName().toLowerCase(Locale.getDefault()).contains(charText))
                {
                    resultadoList.add(ent);
                }
            }
        }
        notifyDataSetChanged();
    }

    private static class ViewHolder {
        private TextView empresa;
        private TextView ramo;
        private TextView pais;
        private TextView textoEmpresa;
        private ImageView fotoEmpresa;

        public ViewHolder(View view) {
            empresa = (TextView) view.findViewById(R.id.txvListEmpEmpresa);
            ramo = (TextView) view.findViewById(R.id.txvListEmpRamo);
            pais = (TextView) view.findViewById(R.id.txvListEmpPais);
            textoEmpresa = (TextView) view.findViewById(R.id.txvListEmpTexto);
            fotoEmpresa = (ImageView) view.findViewById(R.id.imgListEmpEmpresas);

        }
    }
}
