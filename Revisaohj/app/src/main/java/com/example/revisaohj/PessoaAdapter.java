package com.example.revisaohj;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PessoaAdapter extends BaseAdapter {
    Context ctx;
    List<Pessoa> listpessoas2;

    public PessoaAdapter(Context ctx, List<Pessoa> pessoas) {
        this.ctx = ctx;
        this.listpessoas2 = pessoas;
    }

    @Override
    public int getCount() {return listpessoas2.size(); }

    @Override
    public Object getItem(int position) {
        return listpessoas2.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parebt) {
        // passos 1
        Pessoa pessoa = listpessoas2.get(position);
        //passo2
        ViewHolder holder = null;
        if (convertView == null){
            Log.d("NGVL","View Nova => position: "+ position);
            convertView = LayoutInflater.from(ctx).inflate(R.layout.item, null);
            holder= new ViewHolder();

            holder.txtNome = (TextView) convertView.findViewById(R.id.txtNome);
            holder.txtidade =(TextView) convertView.findViewById(R.id.txtIdade);
            holder.txtCpf =(TextView) convertView.findViewById(R.id.txtCpf);
            holder.txtCpf =(TextView) convertView.findViewById(R.id.txtEmail);

            convertView.setTag(holder);

        }else {
            Log.d("NGVL","View existente => position: "+ position);
            holder = (ViewHolder)convertView.getTag();
        }
        //passo 3
        Resources res = ctx.getResources();


        holder.txtNome.setText(pessoa.nome);
        holder.txtEmail.setText(pessoa.email);
        holder.txtCpf.setText(pessoa.cpf);
        holder.txtidade.setText(pessoa.idade);

        return convertView;

    }
    static class ViewHolder
    {

        TextView txtNome, txtidade, txtCpf,txtEmail;
    }
}
