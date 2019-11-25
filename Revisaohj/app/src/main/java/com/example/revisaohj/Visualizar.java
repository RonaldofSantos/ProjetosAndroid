package com.example.revisaohj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Visualizar extends AppCompatActivity {
    TextView txtnome;
    TextView txtemail;
    TextView txtcpf;
    TextView txtidade;
    AutoCompleteTextView actv;
    Button btnpesquisar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);
        Intent result = getIntent();
        List<Pessoa> pessoas1 = new ArrayList<>();
        List<String> nomedealunos = new ArrayList<>();
        final Bundle[] extras = {getIntent().getExtras()};
        final ArrayList<Pessoa> ListaRecebida = extras[0].getParcelableArrayList("pessoas");
        //pessoas1 = result.getExtras().getParcelable("pessoas");

        //salvado
        txtnome = (TextView) findViewById(R.id.TXTnome1);
        txtemail = (TextView) findViewById(R.id.TXTemail1);
        txtcpf = (TextView) findViewById(R.id.TXTcpf1);
        txtidade = (TextView) findViewById(R.id.TXTidade1);
        actv = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        btnpesquisar= (Button) findViewById(R.id.BTNpesquisar);
        //recebendo

        //Pessoa pessoa = result.getExtras().getParcelable("pessoa");

      //  List<String> nomedealunos = new ArrayList<>();
/*
        for ( int i =0; i <= pessoas1.size();i++){
            nomedealunos.add(pessoas1.get(i).nome);
        }
        PesquisarAdapter adapter = new PesquisarAdapter(this,
                android.R.layout.simple_dropdown_item_1line, nomedealunos);


        actv.setAdapter(adapter);*/

        for (Pessoa aluno: ListaRecebida) {
            nomedealunos.add(aluno.cpf);
        }
        PesquisarAdapter adapter = new PesquisarAdapter(this, android.R.layout.simple_dropdown_item_1line, nomedealunos);
        actv.setAdapter(adapter);

        btnpesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String whoSelected = actv.getText().toString();
                for (Pessoa aluno: ListaRecebida) {
                    if(whoSelected.equals(aluno.cpf)){
                        Pessoa Editar = new Pessoa();
                        Editar = aluno;
                        txtnome.setText(aluno.nome);
                        txtcpf.setText(aluno.cpf);
                        txtidade.setText(aluno.idade);
                        txtemail.setText(aluno.email);
                    }
                }
            }
        });

    }
}
