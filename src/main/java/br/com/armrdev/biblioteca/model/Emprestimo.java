/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.armrdev.biblioteca.model;

import java.util.ArrayList;

/**
 *
 * @author Auremir
 */
public class Emprestimo {
    private Usuario usuario;
    private ArrayList<Livros> livros;
    
    public Emprestimo(Usuario usuario){
        this.usuario = usuario;
    }
    
    public void addLivro(Livros livro){
        this.livros.add(livro);
    }
    
    public void removeLivro(Livros livro){
        this.livros.remove(livro);
    }
}
