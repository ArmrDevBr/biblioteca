/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.armrdev.biblioteca.service;

import br.com.armrdev.biblioteca.model.Emprestimo;
import br.com.armrdev.biblioteca.model.Livros;
import br.com.armrdev.biblioteca.model.Usuario;
import java.util.ArrayList;

/**
 *
 * @author aurem
 */
public class Servicos {

    private ArrayList<Livros> estoque = new ArrayList();
    private ArrayList<Emprestimo> emprestados = new ArrayList();

    public Servicos() {

    }

    public String adicionarLivro(String nome, String autor, String anoDeLancamento, int estoque) {

        try {

            Livros addLivro = new Livros(nome, autor, anoDeLancamento, estoque);
            this.estoque.add(addLivro);
            return "O Livro " + nome + " foi adicionado com sucesso a coleção!";

        } catch (Exception e) {

            return "Erro ao adicionar livro a coleção!";

        }
    }

    public void listarLivros() {
        for (Livros esteLivro : estoque) {
            System.out.println("===================================================");
            System.out.println(esteLivro);
        }
    }

    public void emprestarLivro(Usuario usuario, Livros livro) {

        if (emprestados.contains(usuario)) {
            
        }

        Emprestimo item = new Emprestimo(usuario);
        item.addLivro(livro);

    }

}
