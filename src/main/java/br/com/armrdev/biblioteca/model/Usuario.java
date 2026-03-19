/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.armrdev.biblioteca.model;

/**
 *
 * @author aurem
 */
public class Usuario {

    private String nome;
    private String email;
    private String escola;

    public Usuario(String nome, String email, String escola) {
        this.nome = nome;
        this.email = email;
        this.escola = escola;
        
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setEscola(String escola) {
        this.escola = escola;
    }

    public String getEscola() {
        return escola;
    }
    
    
}
