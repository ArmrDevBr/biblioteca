package br.com.armrdev.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome = null;
    private String email = null;
    private Integer idade = null;
    private String escola = null;
    private String turno = null;
    private Role role = null;

    private List<Integer> livrosObtidos = new ArrayList();


    Usuario(String nome, String email, Integer idade, String escola, String turno
    ) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.escola = escola;
        this.turno = turno;

    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdade() {
        return this.idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getEscola() {
        return this.escola;
    }

    public void setEscola(String escola) {
        this.escola = escola;
    }

    public String getTurno() {
        return this.turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public List<Integer> getLivrosObtidos() {
        return livrosObtidos;
    }

    public void setLivrosObtidos(List<Integer> livrosObtidos) {
        this.livrosObtidos = livrosObtidos;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + "\nEmail: " + this.email + "\nIdade: " + this.idade + "\nEscola: " + this.escola + "\nTurno: " + this.turno;
    }
}
