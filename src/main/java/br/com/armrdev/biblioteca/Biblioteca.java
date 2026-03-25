/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package br.com.armrdev.biblioteca;

import br.com.armrdev.biblioteca.model.Usuario;
import br.com.armrdev.biblioteca.service.Servicos;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author aurem
 */
public class Biblioteca {

    private final static String version = "0.0.1";
    //input para captura de dados
    private final Scanner input = new Scanner(System.in);
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
        //pre-carregamento para testes
        System.out.println("|===================================================|");        //pre-carregando os livros
        System.out.println("Pre-carregar Livros de teste? se sim digite algo pra continuar ou enter para pular.");
        System.out.println("|===================================================|");

        String precarga = biblioteca.input.nextLine();

        if (!precarga.isBlank()) {
            preloadLivros(biblioteca.servicos);
        }

        while (!biblioteca.encerrar) {

            //Imprimindo o menus.
            imprimirMenu(biblioteca.countErrorOption);

            try {

                //esperando opção do input do usuario
                int opcao = Integer.parseInt(biblioteca.input.nextLine());

                switch (opcao) {
                    case 1:
                        //Nome
                        System.out.println("Digite o nome do livro:");
                        String nomeLivro = biblioteca.input.nextLine();
                        //Autor
                        System.out.println("Digite o autor do livro:");
                        String autorLivro = biblioteca.input.nextLine();
                        //Ano de lançamento
                        System.out.println("Digite o ano do livro:");
                        String anoLivro = biblioteca.input.nextLine();
                        System.out.println("Digite a quantia disponível:");
                        int estoqueLivro = biblioteca.input.nextInt();
                        //Adicionando a lista
                        biblioteca.servicos.adicionarLivro(nomeLivro, autorLivro, anoLivro, estoqueLivro);

                        break;
                    case 2:

                        //Listando todos os Livros.
                        biblioteca.servicos.listarLivros();

                        break;

                    case 3:
                        System.out.println("Digite o id do livro:");
                        int idLivro;
                        while (true) {
                            try {
                                idLivro = biblioteca.input.nextInt();
                                biblioteca.servicos.removerLivro(idLivro);
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Digite um id com formato válido!");
                            }
                        }
                        //limpando scanner
                        biblioteca.input.nextLine();
                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:

                        break;
                    case 7:
                        int tipoDeUsuario;
                        int idadeUsuario;
                        String turmaUsuario = "";
                        String emailUsuario = "";
                        String nomeUsuario = "";
                        String escolaUsuario = "";

                        while (true) {
                            try {
                                System.out.println("O usuário é um professor ou aluno?");
                                System.out.println("Digite [1] para adicionar novo [Professor]");
                                System.out.println("Digite [2] para adicionar novo [Aluno]");
                                tipoDeUsuario = biblioteca.input.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Opção inválida!");
                            }
                        }

                        while (true) {
                            //limpando
                            biblioteca.input.nextLine();

                            System.out.println("Digite o nome:");
                            nomeUsuario = biblioteca.input.nextLine();

                            if (nomeUsuario.isBlank()) {
                                System.out.println("O nome não pode ser vazio!");
                            } else {
                                break;
                            }
                        }

                        while (true) {

                            System.out.println("Digite o email:");
                            emailUsuario = biblioteca.input.nextLine();

                            if (emailUsuario.isBlank()) {
                                System.out.println("O email não pode ser vazio!");
                            } else if (emailUsuario.contains("@")) {
                                break;
                            } else {
                                System.out.println("O email deve ser válido!");
                            }
                        }

                        while (true) {

                            System.out.println("Digite a escola que o professor leciona:");
                            escolaUsuario = biblioteca.input.nextLine();
                            if (escolaUsuario.isBlank()) {
                                System.out.println("A escola não pode ser vazia!");
                            } else {
                                break;
                            }
                        }
// Decidindo qual tipo deve ser criado aluno/professor

                        switch (tipoDeUsuario) {
                            case 1:

                                while (true) {

                                    System.out.println("Digite a turma do professor:");
                                    turmaUsuario = biblioteca.input.nextLine();

                                    if (turmaUsuario.isBlank()) {
                                        System.out.println("A turma não pode ser vazia!");
                                    } else {
                                        Usuario novoProfessor = biblioteca.servicos.addProfessor(nomeUsuario, emailUsuario, escolaUsuario, turmaUsuario);
                                        System.out.println(novoProfessor);
                                        break;
                                    }
                                }
                                break;
                            case 2:


                                while (true) {

                                    while (true) {
                                        try {

                                            System.out.println("Digite a idade do aluno:");
                                            idadeUsuario = biblioteca.input.nextInt();
                                            break;
                                        } catch (InputMismatchException e) {
                                            System.out.println("A idade deve ser um número!");
                                        }
                                    }

                                    if (idadeUsuario <= 10) {
                                        System.out.println("|===================================================|");
                                        System.out.println("O Aluno tem idade suficiente para o sistema de emprestimos!");
                                        System.out.println("|===================================================|");
                                        break;
                                    } else {
                                        Usuario novoAluno = biblioteca.servicos.addAluno(nomeUsuario, emailUsuario, escolaUsuario, idadeUsuario);
                                        System.out.println(novoAluno);

                                        break;
                                    }
                                }
                                break;
                        }

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
