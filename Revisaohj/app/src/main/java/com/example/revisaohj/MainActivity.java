package com.example.revisaohj;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_STRING=1;
    Button botaoCadastro;
    Button botaoEditar;
    TextView tv;
    Button botaoVisualizar;
    static ArrayList<Pessoa>pessoas;
    Pessoa pessoaCadastro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       /* if(pessoas!= null){
            Intent result = getIntent();

            Pessoa pessoa = result.getExtras().getParcelable("pessoa");
            pessoas.add(pessoa);

       }else {
                if(getIntent() != null){
            Intent result = getIntent();
            Pessoa pessoa = result.getExtras().getParcelable("pessoa");
            pessoas = new ArrayList<>();
            pessoas.add(pessoa);
            }
        }
*/
        if(pessoas != null){

        }else{
            pessoas = new ArrayList<>();
        }
        Intent result =getIntent();

        botaoCadastro = (Button) findViewById(R.id.btmCadastro);
        botaoEditar =(Button) findViewById(R.id.btneditar);
        botaoVisualizar =(Button) findViewById(R.id.btnVisualizar);
        tv = (TextView) findViewById(R.id.TVRONALDO);
        botaoCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Cadastro.class);
                i.putExtra(Cadastro.EXTRA_ALUNO, pessoaCadastro);
                startActivityForResult(i,REQUEST_STRING);
            }
        });
        botaoVisualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Visualizar.class);

                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("pessoas", pessoas);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        botaoEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),EditarPessoa.class);

                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("pessoas", pessoas);
                i.putExtras(bundle);
                startActivity(i);
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == REQUEST_STRING){

            pessoaCadastro= data.getParcelableExtra(Cadastro.EXTRA_RESULTADO);
            pessoas.add(pessoaCadastro);
            tv.setText(pessoaCadastro.nome);


        }
    }


}
