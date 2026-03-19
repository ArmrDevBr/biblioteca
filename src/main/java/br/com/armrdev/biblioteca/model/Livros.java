/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.armrdev.biblioteca.model;

/**
 *
 * @author aurem
 */
public class Livros {
    private String nome;
    private String autor;
    private String anoDeLancamento;
    private int estoque;
    private int emprestimos;

    public Livros(String nome, String autor, String anoDeLancamento, int estoque, int emprestimos) {
        this.nome = nome;
        this.autor = autor;
        this.anoDeLancamento = anoDeLancamento;
        this.estoque = estoque;
        this.emprestimos = emprestimos;
    }

    @Override
    public String toString() {
        
        return  "Livro: " + this.nome + " Autor: " + this.autor +" Ano de lançamento: " + this.anoDeLancamento +" Disponível: " + (this.estoque - this.emprestimos);
    }
    
    
    
    
}
