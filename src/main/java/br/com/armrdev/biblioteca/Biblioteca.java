/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package br.com.armrdev.biblioteca;

import br.com.armrdev.biblioteca.service.Servicos;

/**
 *
 * @author aurem
 */
public class Biblioteca {

    public static void main(String[] args) {
        Servicos listaDeLivros = new Servicos();
        // Adicionando um livro para ter o que listar
        listaDeLivros.adicionarLivro("O Hobbit", "J.R.R. Tolkien", "1937", 10);
        listaDeLivros.adicionarLivro("O Senhor dos Anéis", "J.R.R. Tolkien", "1954", 5);
        listaDeLivros.adicionarLivro("1984", "George Orwell", "1949", 12);
        listaDeLivros.adicionarLivro("Dom Casmurro", "Machado de Assis", "1899", 3);
        listaDeLivros.adicionarLivro("Clean Code", "Robert C. Martin", "2008", 20);
        listaDeLivros.adicionarLivro("Java: Como Programar", "Deitel & Deitel", "2017", 8);
        listaDeLivros.listarLivros();
    }
}
