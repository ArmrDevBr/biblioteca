package br.com.armrdev;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import br.com.armrdev.model.Role;
import br.com.armrdev.services.Core;
import br.com.armrdev.services.Validador;

public class Biblioteca {

    private static final String version = "1.0.0";


    static void main(String[] args) throws UnsupportedEncodingException {
        //corrige acentuação e caracteres especiais
        System.setOut(new PrintStream(System.out, true, "UTF-8"));

        //inicializando o app
        Biblioteca biblioteca = new Biblioteca();
        Validador validador = new Validador();
        Core servicos = new Core();
        Integer input = null;
        //Encerra o loop quando e definido para verdadeiro/true
        Boolean encerrarApp = false;

        //servicos.mockupDados();

        while (!encerrarApp) {
            try {
                imprimirMenu();
                input = validador.validacaoIntMaxAndMin(1, 10, "Digite um número entre 1 e 10:");

                switch (input) {
                    case 1:
                        servicos.criarLivro();
                        break;
                    case 2:
                        servicos.listarLivros();
                        break;
                    case 3:
                        String busca = validador.validacaoString("Pesquisar por: ");
                        servicos.buscarLivros(busca);
                        break;
                    case 4:
                        System.out.println("|---------------------------------------------------|");
                        System.out.println("Emprestar Livros");
                        System.out.println("|---------------------------------------------------|");
                        String emailEmprestimo = validador.validacaoString("E-mail do usuario: ");
                        Integer idEmprestimo = validador.validacaoInt("Id do Livro: ");
                        servicos.criarEmprestimo(emailEmprestimo, idEmprestimo);
                        break;
                    case 5:
                        System.out.println("|---------------------------------------------------|");
                        System.out.println("Devolver Livros");
                        System.out.println("|---------------------------------------------------|");
                        String emailDelvolver = validador.validacaoString("E-mail do usuario: ");
                        Integer idDevolver = validador.validacaoInt("Id do Livro: ");
                        servicos.devolverEmprestimo(emailDelvolver, idDevolver);
                        break;
                    case 6:
                        System.out.println("|---------------------------------------------------|");
                        System.out.println("Remover Livros");
                        System.out.println("|---------------------------------------------------|");
                        Integer idLivroRemover = validador.validacaoInt("Id do Livro: ");
                        servicos.removerLivro(idLivroRemover);
                        break;
                    case 7:
                        Integer opcaoCadastro;
                        while (true) {

                            System.out.println("|---------------------------------------------------|");
                            System.out.println("Cadastro de Usuário");
                            opcaoCadastro = validador.validacaoIntMaxAndMin(1, 2, "Digite 1 para Aluno ou 2 para Professor:");

                            if (opcaoCadastro == 1) {
                                servicos.criarUsuario(Role.ALUNO);
                                break;
                            }
                            if (opcaoCadastro == 2) {
                                servicos.criarUsuario(Role.PROFESSOR);
                                break;
                            }
                        }
                        break;

                    case 8:
                        servicos.listarUsuarios();
                        break;
                    case 9:
                        String emailASerEncerrado = validador.emailValidator("Informe o email a ser encerrado");
                        servicos.removerUsuario(emailASerEncerrado);
                        break;
                    case 10:
                        encerrarApp = true;
                        break;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static void imprimirMenu() {
        System.out.println("|===================================================|");
        System.out.println("        Sistema de emprestimo de livros V." + version);
        System.out.println("|===================================================|");
        System.out.println("(Digite o número correspodente a ação desejada:)");
        System.out.println("[1]  Adicionar Livro.");
        System.out.println("[2]  Listar Livros.");
        System.out.println("[3]  Buscar Livro.");
        System.out.println("[4]  Emprestar Livro.");
        System.out.println("[5]  Devolver Livro.");
        System.out.println("[6]  Remover Livro.");
        System.out.println("[7]  Adicionar Usuário.");
        System.out.println("[8]  Listar Usuários.");
        System.out.println("[9]  Remover Usuário.");
        System.out.println("[10] Encerrar.");
        System.out.println("|===================================================|");
    }
}
