/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.armrdev.biblioteca.service;

import br.com.armrdev.biblioteca.model.*;

import java.util.ArrayList;

/**
 *
 * @author aurem
 */
public class Servicos {

    private ArrayList<Livros> estoque = new ArrayList<>();
    private ArrayList<Emprestimo> emprestados = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public Servicos() {

    }

    public void adicionarLivro(String nome, String autor, String anoDeLancamento, int estoque) {

        try {

            Livros addLivro = new Livros(nome, autor, anoDeLancamento, estoque);
            this.estoque.add(addLivro);
            System.out.println("O Livro: " + nome + " foi adicionado com sucesso a coleção!");

        } catch (Exception e) {

            System.out.println("Erro ao adicionar livro a coleção!");

        }
    }

    public Usuario addAluno(String nome, String email, String escola, int idade) {
        Usuario novoAluno = new Aluno(nome, email, idade, escola);
        usuarios.add(novoAluno);
        System.out.println("Aluno adicionado com sucesso!");
        return novoAluno;
    }

    public Usuario addProfessor(String nome, String email, String escola, String turno) {
        Usuario novoProfessor = new Professor(nome, email, escola, turno);
        usuarios.add(novoProfessor);
        System.out.println("Professor adicionado com sucesso!");
        return novoProfessor;
    }

    public ArrayList<Livros> getEstoque() {
        return estoque;
    }

    public void listarLivros() {
        int index = 0;
        for (Livros esteLivro : estoque) {
            System.out.println("------------------------------------------------------");
            System.out.println("Id:" + index + " :" + esteLivro);
            index++;
        }
    }

    public void emprestarLivro(Usuario usuario, Livros livro) {

        if (emprestados.contains(usuario)) {

        }

        Emprestimo item = new Emprestimo(usuario);
        item.addLivro(livro);

    }

    public void removerLivro(int id) {
        Livros livroAremover = null;
        int index = 0;
        for (Livros livro : estoque) {
            if (index == id) {
                livroAremover = livro;
                System.out.println("Livro encontrado:" + livroAremover);
                break;
            }
            index++;
        }
        if (livroAremover != null) {

            estoque.remove(livroAremover);
            System.out.println("Livro removido com sucesso!");
        } else {
            System.out.println("Não foi encontrado o livro com esse id!");
        }
    }

}
