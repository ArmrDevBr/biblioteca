/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.armrdev.biblioteca.service;

import br.com.armrdev.biblioteca.model.Livros;
import java.util.ArrayList;


/**
 *
 * @author aurem
 */
public class Servicos {

    private ArrayList<Livros> minhaBiblioteca = new ArrayList();
    private ArrayList<Livros> emprestados = new ArrayList();

    public Servicos() {
        
    }
    
    public String adicionarLivro(String nome, String autor, String anoDeLancamento, int estoque) {

        try {

            Livros addLivro = new Livros(nome, autor, anoDeLancamento, estoque);
            this.minhaBiblioteca.add(addLivro);
            return "O Livro " + nome + " foi adicionado com sucesso a coleção!";

        } catch (Exception e) {

            return "Erro ao adicionar livro a coleção!";

        }
    }
    
    public void listarLivros(){
        for(Livros esteLivro: minhaBiblioteca){
            System.out.println("===================================================");
            System.out.println(esteLivro);
        }
    }
    
    

}
