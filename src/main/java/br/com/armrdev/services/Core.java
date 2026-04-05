package br.com.armrdev.services;

import br.com.armrdev.model.*;
import br.com.armrdev.services.Validador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Core {
    //String usará o email com id do usuario
    Map<String, Usuario> usuariosCadastrados = new HashMap<String, Usuario>();
    //Int armazenaram um ID para o livro
    Map<Integer, Livro> livrosCadastrados = new HashMap<Integer, Livro>();

    //valida as entradas
    Validador validador = new Validador();

    Integer idLivro = 0;

    public void criarUsuario(Role role) {
        String nome = validador.validacaoString("Digite o nome do usuario:");
        String email = validador.emailValidator("Digite o email do usuario:");
        if (usuariosCadastrados.containsKey(email)) {
            System.out.println("|======================   !   ======================|");
            System.out.println("O email não pode ser cadastrado!");
            return;
        }
        Integer idade = validador.validacaoIntMaxAndMin(10, 100, "Digite a idade:");
        String escolar = validador.validacaoString("Digite a escolar do usuario:");
        String turno = validador.validacaoString("Digite o turno do usuario:");
        Usuario newUsuario = null;
        if (role == Role.ALUNO) {
            String turma = validador.validacaoString("Digite a turma:");
            newUsuario = new Aluno(nome, email, idade, escolar, turno, turma);
        } else {
            String disciplina = validador.validacaoString("Digite a disciplina:");
            newUsuario = new Professor(nome, email, idade, escolar, disciplina, turno);
        }
        usuariosCadastrados.put(email, newUsuario);

    }

    public void criarLivro() {

        String titulo = validador.validacaoString("Digite o titulo do livro:");
        Integer anoLancamento = validador.validacaoIntMaxAndMin(1600, 9999, "Digite a ano de lançamento:");
        String autor = validador.validacaoString("Digite o autor do livro:");
        Integer quantidade = validador.validacaoIntMaxAndMin(1, 9999, "Digite a quantidade:");

        Livro newLivro = new Livro(titulo, autor, quantidade, anoLancamento, idLivro);

        livrosCadastrados.put(idLivro, newLivro);
        idLivro++;

        System.out.println("|======================   #   ======================|");
        System.out.println("Livro criado com sucesso!");

    }

    public void criarEmprestimo(String email, Integer idLivroEmprestimo) {
        Usuario usuario = usuariosCadastrados.get(email);
        Livro livro = livrosCadastrados.get(idLivroEmprestimo);

        if (usuario == null) {
            System.out.println("|======================   !   ======================|");
            System.out.println("Usuario nao cadastrado!");
            return;
        }

        if (livro == null) {
            System.out.println("|======================   !   ======================|");
            System.out.println("Livro nao cadastrado!");
            return;
        }

        for (Integer id : usuario.getLivrosObtidos()) {
            if (id.equals(idLivroEmprestimo)) {
                System.out.println("|======================   !   ======================|");
                System.out.println("O usuário já possui o livro do emprestimo!");
                return;
            }
        }
        if (livro.getQuantidade() > 0) {
            usuario.getLivrosObtidos().add(idLivroEmprestimo);
            livro.setQuantidade(livro.getQuantidade() - 1);

            System.out.println("|======================   +   ======================|");
            System.out.println("Emprestimo criado com sucesso!");
            System.out.println("|====================== Livro ======================|");
            System.out.println(livro);
        } else {
            System.out.println("|======================   !   ======================|");
            System.out.println("O livro não possui quantidade em estoque!");
        }

    }

    public void devolverEmprestimo(String email, Integer idLivroEmprestimo) {
        Usuario usuario = usuariosCadastrados.get(email);
        Livro livro = livrosCadastrados.get(idLivroEmprestimo);

        if (usuario == null) {
            System.out.println("Usuario nao cadastrado!");
            return;
        }

        if (livro == null) {
            System.out.println("Livro nao cadastrado!");
            return;
        }

        for (Integer id : usuario.getLivrosObtidos()) {
            if (!id.equals(idLivroEmprestimo)) {
                System.out.println("O usuário não possui o livro do emprestimo!");
                return;
            }
        }
        usuario.getLivrosObtidos().remove(idLivroEmprestimo);
        livro.setQuantidade(livro.getQuantidade() + 1);

        System.out.println("|======================   -   ======================|");
        System.out.println("O livro foi devolvido com sucesso!");
        System.out.println("|====================== Livro ======================|");
        System.out.println(livro);

    }

    public void listarLivros() {
        if (!livrosCadastrados.isEmpty()) {

            for (Map.Entry<Integer, Livro> livros : livrosCadastrados.entrySet()) {
                System.out.println("|====================== Livro ======================|");
                System.out.println(livros.getValue());
            }
        } else {
            System.out.println("Nenhum livro cadastrado!");
        }
    }

    public void listarUsuarios() {
        if (!usuariosCadastrados.isEmpty()) {
            for (Map.Entry<String, Usuario> usuarios : usuariosCadastrados.entrySet()) {
                System.out.println("|====================== Ficha ======================|");
                System.out.println(usuarios.getValue());
            }
        } else {
            System.out.println("Nenhum usuario cadastrado!");
        }
    }

    public void buscarLivros(String busca) {
        for (Map.Entry<Integer, Livro> livros : livrosCadastrados.entrySet()) {

            if (livros.getValue().getTitulo().toLowerCase().contains(busca.toLowerCase())) {
                System.out.println("|====================== Livro ======================|");
                System.out.println(livros.getValue());
            }
        }
    }

    public void removerUsuario(String email) {
        if (usuariosCadastrados.containsKey(email)) {
            usuariosCadastrados.remove(email);
            System.out.println("Usuario removido com sucesso!");
        } else {
            System.out.println("Usuário não encontrado!");
        }
    }

    public void removerLivro(Integer idLivroEmprestimo) {
        if (livrosCadastrados.containsKey(idLivroEmprestimo)) {
            livrosCadastrados.remove(idLivroEmprestimo);
            System.out.println("Livro removido com sucesso!");
        } else {
            System.out.println("Livro nao encontrado!");
        }
    }


    public void mockupDados() {
        Usuario usuario = new Aluno("Auremir", "auremir1994@gmail.com", 32, "Estácio", "Manhã", "A");
        usuariosCadastrados.put("teste@gmail.com", usuario);

        Livro livro = new Livro("Harry potter e a pedra do nunca mais", "Rita", 200, 2000, idLivro);
        livrosCadastrados.put(idLivro, livro);
        idLivro++;
    }
}
