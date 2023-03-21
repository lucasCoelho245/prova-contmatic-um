package br.com.contmatic.empresa;

import java.util.List;
import java.util.Objects;

import static br.com.contmatic.utils.ConstantesUtils.*;
import static br.com.contmatic.utils.ValidadoresUtils.*;
import static br.com.contmatic.utils.UtilsCpf.validarCpf;

public class Cliente {
    private String cpf;

    private String nome;

    private List<Produto> produtos;

    public String getNome() {
        return nome;
    }


    public Cliente() {
    }

    public Cliente(String cpf, String nome, List<Produto> produtos) {
        this.cpf = cpf;
        this.nome = nome;
        this.produtos = produtos;
    }

    public void setNome(String nome) {
        validarObjetoNulo(nome, NOME_CLIENTE, NOME_CLASSE_CLIENTE);
        validarStringVazio(nome, NOME_CLIENTE, NOME_CLASSE_CLIENTE);
        validarStringTamanhoMinimo(nome, 3, NOME_CLIENTE, NOME_CLASSE_CLIENTE);
        validarStringTamanhoMaximo(nome, 60, NOME_CLIENTE, NOME_CLASSE_CLIENTE);
        validarNumerosString(nome, NOME_CLIENTE, NOME_CLASSE_CLIENTE);
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        validarCpf(cpf, CPF_CLIENTE, NOME_CLASSE_CLIENTE);
        this.cpf = cpf;
    }

    public void setProdutos(List<Produto> produtos) {
        validarStringTamanhoMinimo(produtos.toString(), 60, PRODUTO_CLIENTE, NOME_CLASSE_CLIENTE);
        validarStringTamanhoMaximo(produtos.toString(), 180, PRODUTO_CLIENTE, NOME_CLASSE_CLIENTE);
        validarObjetoNulo(produtos, PRODUTO_CLIENTE, NOME_CLASSE_CLIENTE);
        this.produtos = produtos;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return getNome().equals(cliente.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Cliente {nome= ");
        builder.append(nome);
        builder.append(", produtos= ");
        builder.append(produtos);
        builder.append("}");
        return builder.toString();
    }
}
