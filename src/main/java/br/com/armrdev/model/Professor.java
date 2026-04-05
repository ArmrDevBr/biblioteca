package br.com.armrdev.model;

public class Professor extends Usuario {
    private String disciplina;

    public Professor(String nome, String email, Integer idade, String escola, String turno, String disciplina) {
        super(nome, email, idade, escola, turno);
        this.disciplina = disciplina;
        this.setRole(Role.PROFESSOR);
    }
    public String getDisciplina() {
        return disciplina;
    }
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public String toString() {
        return  super.toString() + "\nDisciplina: " + this.disciplina + "\n("+this.getRole()+")";
    }
}

