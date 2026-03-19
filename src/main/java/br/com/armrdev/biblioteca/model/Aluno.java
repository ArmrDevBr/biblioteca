/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.armrdev.biblioteca.model;

/**
 *
 * @author aurem
 */
public class Aluno extends Usuario {

    private int idade;

    public Aluno(String nome, String email, int idade, String escola) {
        super(nome, email,escola);
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    
}
