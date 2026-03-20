/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package br.com.armrdev.biblioteca;

import br.com.armrdev.biblioteca.service.Servicos;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 *
 * @author aurem
 */
public class Biblioteca {

    private static String version = "0.0.1";
    //input para captura de dados
    private Scanner input = new Scanner(System.in);
    private boolean encerrar = false;
    //intânciando serviços
    private Servicos servicos = new Servicos();
    //nescessita de ajuda
    private int countErrorOption = 0;

    public static void main(String[] args) throws UnsupportedEncodingException {
        //corrige acentuação e caracteres especiais
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        //Iniciando 
        Biblioteca biblioteca = new Biblioteca();
        //pre-carregando os livros
        preloadLivros(biblioteca.servicos);

        while (!biblioteca.encerrar) {

            //Imprimindo o menus.
            imprimirMenu(biblioteca.countErrorOption);

            try {

                //esperando opção do input do usuario
                int opcao = Integer.parseInt(biblioteca.input.nextLine());

                switch (opcao) {
                    case 1:
                        biblioteca.servicos.adicionarLivro(version, version, version, opcao);
                        break;
                    case 2:

                        //Listando todos os Livros.
                        biblioteca.servicos.listarLivros();

                        break;

                    case 3:

                        break;

                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:

                        break;
                    case 7:

                        break;
                    case 8:

                        break;
                    case 9:
                        biblioteca.encerrar = true;
                        break;
                    case 0:
                        if (biblioteca.countErrorOption >= 3) {
                            biblioteca.exibirGuiaRapido();
                        } else {
                            biblioteca.countErrorOption++;
                            System.out.println("Opção inválida!!");
                        }
                        break;
                    default:
                        System.out.println("Opção inválida!!");
                        biblioteca.countErrorOption++;
                }
            } catch (NumberFormatException e) {
                biblioteca.countErrorOption++;
                System.out.println("Opção inválida!!");
            } catch (Exception e) {
                System.out.println("Erro:" + e.getMessage());
            }

        }

    }

    public static void preloadLivros(Servicos listaDeLivros) {
        listaDeLivros.adicionarLivro("O Hobbit", "J.R.R. Tolkien", "1937", 10);
        listaDeLivros.adicionarLivro("O Senhor dos Anéis", "J.R.R. Tolkien", "1954", 5);
        listaDeLivros.adicionarLivro("1984", "George Orwell", "1949", 12);
        listaDeLivros.adicionarLivro("Dom Casmurro", "Machado de Assis", "1899", 3);
        listaDeLivros.adicionarLivro("Clean Code", "Robert C. Martin", "2008", 20);
        listaDeLivros.adicionarLivro("Java: Como Programar", "Deitel & Deitel", "2017", 8);
    }

    public static void imprimirMenu(int help) {
        System.out.println("|===================================================|");
        System.out.println("        Sistema de emprestimo de livros V." + version);
        System.out.println("|===================================================|");
        System.out.println("(Digite o número correspodente a ação desejada:)");
        System.out.println("|---------------------------------------------------|");
        System.out.println("[1] Adicionar Livro.");
        System.out.println("[2] Listar Livros.");
        System.out.println("[3] Remover Livro.");
        System.out.println("[4] Emprestar Livro.");
        System.out.println("[5] Devolver Livro.");
        System.out.println("[6] Buscar Livro.");
        System.out.println("[7] Adicionar Usuário.");
        System.out.println("[8] Remover Usuário.");
        System.out.println("[9] Encerrar.");
        if (help >= 3) {
            System.out.println("[0] Ajuda.");
        }
        System.out.println("|===================================================|");
    }

    public static void exibirGuiaRapido() {
        System.out.println("------------------ GUIA DE AJUDA RÁPIDA ------------");
        System.out.println("1. Use apenas números de 1 a 9 para navegar nas funções.");
        System.out.println("2. Para encerrar o programa com segurança, use a opção [9].");
        System.out.println("----------------------------------------------------");
    }
}
