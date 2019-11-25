package com.example.sqlere;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Visu extends AppCompatActivity {
    TextView id,nome,escola,disciplina;
    ArrayList<Professor> PROF2;
    RecyclerView recy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visu);
         recy=(RecyclerView) findViewById(R.id.rv);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        RecyclerView.LayoutManager rvLiLayoutManager =layoutManager;
        recy.setLayoutManager(rvLiLayoutManager);
        ProfessorDAO crud = new ProfessorDAO(getApplicationContext());

        Cursor dao =crud.carregaDados();
        PROF2 =new ArrayList<>();
        while (dao.moveToNext())
        {

            String id =dao.getString(dao.getColumnIndex(ConexaoUtil.ID));
            String nome =dao.getString(dao.getColumnIndex(ConexaoUtil.NOME));
            String escola =dao.getString(dao.getColumnIndex(ConexaoUtil.ESCOLA));
            String disciplina =dao.getString(dao.getColumnIndex(ConexaoUtil.DISCIPLINA));
            Professor  ron =new Professor(Integer.parseInt(id),nome,escola,disciplina);
            PROF2.add(ron);
        }
        ProfessorAdapter adapter = new ProfessorAdapter(this,PROF2);
        recy.setAdapter(adapter);


    }
}
