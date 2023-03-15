package br.com.contmatic.empresa;

import java.math.BigDecimal;
import java.util.Objects;

import static br.com.contmatic.utils.Utils.*;

public class Produto {
    private String Id;
    private String nome;
    private BigDecimal quantidade;
    private BigDecimal valor;

    public Produto() {
    }

    public Produto(String nome, String id, BigDecimal quantidade, BigDecimal valor) {
        this.nome = nome;
        Id = id;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validarStringTamanhoMinimo(nome, 3, "nome", "Produto");
        validarNumerosString(nome, "Nome", "Produto");
        validarObjetoNulo(nome, "Nome", "Produto");
        validarStringTamanhoMaximo(nome, 60, "nome", "Produto");
        this.nome = nome;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        validarStringTamanhoMinimo(id, 2, "Id", "Produto");
        validarObjetoNulo(id, "Id", "Produto");
        Id = id;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        validarStringTamanhoMinimo(String.valueOf(quantidade), 1, "Quantidade", "Produto");
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        validarStringTamanhoMinimo(String.valueOf(valor), 3, "Valor", "Produto");
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;
        Produto produto = (Produto) o;
        return Id.equals(produto.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Produto {nome= ");
        builder.append(nome);
        builder.append(", Id= ");
        builder.append(Id);
        builder.append(", quantidade= ");
        builder.append(quantidade);
        builder.append(", valor= ");
        builder.append(valor);
        builder.append("}");
        return builder.toString();
    }

}
