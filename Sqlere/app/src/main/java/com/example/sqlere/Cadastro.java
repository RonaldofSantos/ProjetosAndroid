package com.example.sqlere;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cadastro extends AppCompatActivity {
    EditText etnome,etescola,etdisciplina;
    Button  BTN,voltar;
    Professor prof;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        etnome =(EditText) findViewById(R.id.ETnome);
        etescola =(EditText) findViewById(R.id.ETescola);
        etdisciplina =(EditText) findViewById(R.id.ETdisciplina);
        BTN = (Button) findViewById(R.id.BTNcadconfirm);
        voltar = (Button) findViewById(R.id.VoltarCA2);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(a);
                finish();
            }
        });
        BTN.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View view) {
                ProfessorDAO crud = new ProfessorDAO(getBaseContext());
                String nomeString = etnome.getText().toString();
                String escolaString = etescola.getText().toString();
                String disciplinaString = etdisciplina.getText().toString();
                String resultado;
                prof = new Professor(1,nomeString,disciplinaString,escolaString);
                resultado = crud.insereDado(prof);
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                }
        });

    }
}
