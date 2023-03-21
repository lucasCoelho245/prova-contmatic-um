package br.com.contmatic.empresa;

import java.util.List;
import java.util.Objects;

import static br.com.contmatic.utils.Utils.*;
import static br.com.contmatic.utils.UtilsCpf.validarCpf;

public class Cliente {
    private String cpf;

    private String nome;

    private List<Produto> produtos;

    public String getNome() {
        return nome;
    }

    private String nomeClasse = "cliente";

    private String nomeCliente = "nome";

    private String produtoCliente = "produto";
    private String cpfCLiente = "cpf";

    public Cliente() {
    }

    public Cliente(String cpf, String nome, List<Produto> produtos) {
        this.cpf = cpf;
        this.nome = nome;
        this.produtos = produtos;
    }

    public void setNome(String nome) {
        validarObjetoNulo(nome, nomeCliente, nomeClasse);
        validarStringVazio(nome, nomeCliente, nomeClasse);
        validarStringTamanhoMinimo(nome, 3, nomeCliente, nomeClasse);
        validarStringTamanhoMaximo(nome, 60, nomeCliente, nomeClasse);
        validarNumerosString(nome, nomeCliente, nomeClasse);
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        validarCpf(cpf, cpfCLiente, nomeClasse);
        this.cpf = cpf;
    }

    public void setProdutos(List<Produto> produtos) {
        validarStringTamanhoMinimo(produtos.toString(), 60, produtoCliente, nomeClasse);
        validarStringTamanhoMaximo(produtos.toString(), 180, produtoCliente, nomeClasse);
        validarObjetoNulo(produtos, produtoCliente, nomeClasse);
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
