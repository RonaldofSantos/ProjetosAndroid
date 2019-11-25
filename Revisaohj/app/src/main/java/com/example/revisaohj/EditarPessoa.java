package com.example.revisaohj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class EditarPessoa extends AppCompatActivity {
    List<String> pessoas ;
    PessoaAdapter adapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_pessoa);
       /* Intent result = getIntent();
        pessoas = result.getExtras().getParcelable("Listadepessoa");
        adapter = new PessoaAdapter(this,pessoas);*/
        listView = (ListView) findViewById(R.id.list);
        listView.setEmptyView(findViewById(android.R.id.empty));
        pessoas = new ArrayList<>();
        final Bundle[] extrast = {getIntent().getExtras()};
        final ArrayList<Pessoa> ListaRecebidav = extrast[0].getParcelableArrayList("pessoas");

        for (Pessoa aluno: ListaRecebidav) {
            pessoas.add(aluno.nome);
        }
        ArrayAdapter ar = new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,pessoas);

        listView.setAdapter(ar);
    }
}
