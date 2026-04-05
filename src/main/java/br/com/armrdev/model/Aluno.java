package br.com.armrdev.model;

import br.com.armrdev.model.Role;

public class Aluno extends Usuario {
    private String turma = null;

    public Aluno(String nome, String email, Integer idade, String escola, String turno, String turma) {
        super(nome, email, idade, escola, turno);
        this.turma = turma;
        this.setRole(Role.ALUNO);
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTurma: " + this.turma + "\n("+this.getRole()+")";
    }
}
