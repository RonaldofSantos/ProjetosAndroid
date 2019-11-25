package com.example.sqlere;

public class Professor {

    int id ;
    private String nome;
    private String escola;
    private String disciplina;

    public Professor(int id, String nome, String escola, String disciplina) {
        this.id = id;
        this.nome = nome;
        this.escola = escola;
        this.disciplina = disciplina;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEscola() {
        return escola;
    }

    public void setEscola(String escola) {
        this.escola = escola;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
}
