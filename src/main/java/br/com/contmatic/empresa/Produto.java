package br.com.contmatic.empresa;

import br.com.contmatic.auditoria.Auditoria;

import java.math.BigDecimal;
import java.util.Objects;

import static br.com.contmatic.utils.AuditoriaUtils.setAuditoriaAlteracao;
import static br.com.contmatic.utils.AuditoriaUtils.setAuditoriaCriacao;
import static br.com.contmatic.utils.ConstantsUtils.*;
import static br.com.contmatic.utils.ValidadoresUtils.*;

public class Produto extends Auditoria {
    private String id;
    private String nome;
    private BigDecimal quantidade;
    private BigDecimal valor;

    public Produto() {
    }

    public Produto(String nome, String id, BigDecimal quantidade, BigDecimal valor) {
        this.nome = nome;
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
        setAuditoriaCriacao(this);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validarObjetoNulo(nome, PRODUTO_NOME, NOME_CLASSE_PRODUTO);
        validarStringVazio(nome, PRODUTO_NOME, NOME_CLASSE_PRODUTO);
        validarStringTamanhoMinimo(nome, 3, PRODUTO_NOME, NOME_CLASSE_PRODUTO);
        validarNumerosString(nome, PRODUTO_NOME, NOME_CLASSE_PRODUTO);
        validarStringTamanhoMaximo(nome, 60, PRODUTO_NOME, NOME_CLASSE_PRODUTO);
        setAuditoriaAlteracao(this);
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        validarObjetoNulo(id, PRODUTO_ID, NOME_CLASSE_PRODUTO);
        validarStringVazio(id, PRODUTO_ID, NOME_CLASSE_PRODUTO);
        validarStringTamanhoMinimo(id, 2, PRODUTO_ID, NOME_CLASSE_PRODUTO);
        setAuditoriaAlteracao(this);
        this.id = id;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        validarStringTamanhoMinimo(String.valueOf(quantidade), 1, PRODUTO_QUANTIDADE, NOME_CLASSE_PRODUTO);
        setAuditoriaAlteracao(this);
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        validarStringTamanhoMinimo(String.valueOf(valor), 3, PRODUTO_VALOR, NOME_CLASSE_PRODUTO);
        setAuditoriaAlteracao(this);
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
