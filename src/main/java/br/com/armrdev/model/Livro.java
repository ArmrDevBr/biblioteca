package br.com.armrdev.model;

import java.time.LocalDate;

public class Livro {
    private String titulo;
    private Integer anoLancamento;
    private String autor;
    private Integer quantidade;
    private Integer id;

    public Livro(String titulo, String autor, Integer quantidade, Integer anoLancamento, Integer id) {
        this.titulo = titulo;
        this.autor = autor;
        this.quantidade = quantidade;
        this.anoLancamento = anoLancamento;
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return " Livro ID: " + id +
                "\n Titulo: " + titulo +
                "\n Ano de Lancamento: " + anoLancamento +
                "\n Autor:" + autor  +
                "\n Quantidade: " + quantidade;
    }
}
