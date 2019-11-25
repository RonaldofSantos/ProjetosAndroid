package com.example.sqlere;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {
    private SQLiteDatabase db;
    private ConexaoUtil conexao;

    public ProfessorDAO(Context context){
        conexao = new ConexaoUtil(context);
    }

    public String insereDado(Professor professor){
        ContentValues valores;
        long resultado;

        db = conexao.getWritableDatabase();
        valores = new ContentValues();
        valores.put(ConexaoUtil.NOME, professor.getNome());
        valores.put(ConexaoUtil.ESCOLA, professor.getEscola());
        valores.put(ConexaoUtil.DISCIPLINA, professor.getDisciplina());
        // nullcolumnhack identificar coluna que aceite nulo
        resultado = db.insert(ConexaoUtil.TABELA, null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";

    }

    public Cursor carregaDados(){
        Cursor cursor;
        String[] campos =  {conexao.ID,conexao.NOME,conexao.ESCOLA,conexao.DISCIPLINA};
        db = conexao.getReadableDatabase();
        cursor = db.query(conexao.TABELA, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadoById(int id){
        Cursor cursor;
        String[] campos =  {conexao.ID,conexao.NOME,conexao.DISCIPLINA, conexao.ESCOLA};
        String where = ConexaoUtil.ID + "=" + id;
        db = conexao.getReadableDatabase();
        cursor = db.query(ConexaoUtil.TABELA,campos,where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public void alteraRegistro(Professor professor){
        ContentValues valores;
        String where;

        db = conexao.getWritableDatabase();

        where = ConexaoUtil.ID + "=" + professor.getId();

        valores = new ContentValues();
        valores.put(ConexaoUtil.NOME, professor.getNome());
        valores.put(ConexaoUtil.ESCOLA, professor.getEscola());
        valores.put(ConexaoUtil.DISCIPLINA, professor.getDisciplina());

        db.update(ConexaoUtil.TABELA,valores,where,null);
        db.close();
    }

    public void deletaRegistro(Professor professor){
        String where = ConexaoUtil.ID + "=" + professor.getId();
        db = conexao.getReadableDatabase();
        db.delete(ConexaoUtil.TABELA,where,null);
        db.close();
    }


    public static List<Professor> listarAnuncios(Context context){
        ConexaoUtil dbOpenHelper = new ConexaoUtil(context);
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();

        Cursor cursor;
        String TABELA = "banco.db";
        String[] campos =  {"_id", "nome", "escola", "disciplina"};

        cursor = db.query(TABELA, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
            List<Professor> professors = new ArrayList<>();
            while (!cursor.isAfterLast()){

                int ID = Integer.parseInt(cursor.getString(0));
                String nome = cursor.getString(1);
                String disciplina = cursor.getString(2);
                String escola = cursor.getString(3);
                Professor professor = new Professor(ID, nome,escola,disciplina);
                professors.add(professor);

                cursor.moveToNext();
            }
            if (!cursor.isClosed()) {
                cursor.close();
            }
            return professors;
        }
        return null;
    }
}

