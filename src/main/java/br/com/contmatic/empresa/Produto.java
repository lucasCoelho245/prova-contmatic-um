package br.com.contmatic.empresa;

import java.math.BigDecimal;
import java.util.Objects;

import static br.com.contmatic.utils.Utils.*;

public class Produto {
    private String id;
    private String nome;
    private BigDecimal quantidade;
    private BigDecimal valor;
    private String nomeClasse = "produto";
    private String produtoNome = "nome";
    private String produtoId = "id";
    private String produtoQuantidade = "quantidade";
    private String produtoValor = "valor";

    public Produto() {
    }

    public Produto(String nome, String id, BigDecimal quantidade, BigDecimal valor) {
        this.nome = nome;
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validarObjetoNulo(nome, produtoNome, nomeClasse);
        validarStringVazio(nome, produtoNome, nomeClasse);
        validarStringTamanhoMinimo(nome, 3, produtoNome, nomeClasse);
        validarNumerosString(nome, produtoNome, nomeClasse);
        validarStringTamanhoMaximo(nome, 60, produtoNome, nomeClasse);
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        validarStringTamanhoMinimo(id, 2, produtoId, nomeClasse);
        validarObjetoNulo(id, produtoId, nomeClasse);
        this.id = id;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        validarStringTamanhoMinimo(String.valueOf(quantidade), 1, produtoQuantidade, nomeClasse);
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        validarStringTamanhoMinimo(String.valueOf(valor), 3, produtoValor, nomeClasse);
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;
        Produto produto = (Produto) o;
        return id.equals(produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Produto {nome= ");
        builder.append(nome);
        builder.append(", Id= ");
        builder.append(id);
        builder.append(", quantidade= ");
        builder.append(quantidade);
        builder.append(", valor= ");
        builder.append(valor);
        builder.append("}");
        return builder.toString();
    }

}
