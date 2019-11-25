package com.example.sqlere;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button BTNcadastro,BTNvisu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BTNcadastro = (Button) findViewById(R.id.btcadastro);
        BTNvisu = (Button) findViewById(R.id.btvisu);
        BTNcadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent (getApplicationContext(),Cadastro.class);
                startActivity(j);
            }
        });

        BTNvisu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Visu.class);
                startActivity(i);
            }
        });

    }
}
