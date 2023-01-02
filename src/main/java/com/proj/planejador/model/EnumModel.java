package com.proj.planejador.model;

public class EnumModel {
    private String id;
    private String nome;

    public EnumModel(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public EnumModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
