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

    public void setNome(String nome) {
        validarStringTamanhoMinimo(nome, 3, "nome", "Cliente");
        validarStringTamanhoMaximo(nome, 60, "nome", "Cliente");
        validarNumerosString(nome, "Nome", "Cliente");
        validarObjetoNulo(nome, "Nome", "Cliente");
        this.nome = nome;
    }
    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setCpf(String cpf) {
        validarCpf(cpf, "cpf", "Cliente");
        this.cpf = cpf;
    }

    public void setProdutos(List<Produto> produtos) {
        validarStringTamanhoMinimo(produtos.toString(), 60, "Produtos", "Cliente");
        validarStringTamanhoMaximo(produtos.toString(), 100, "Produtos", "Cliente");
        validarObjetoNulo(produtos, "Produtos", "Cliente");
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
