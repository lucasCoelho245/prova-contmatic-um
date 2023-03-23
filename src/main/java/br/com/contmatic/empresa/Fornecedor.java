package br.com.contmatic.empresa;

import br.com.contmatic.contato.Contato;
import br.com.contmatic.endereco.Endereco;

import java.util.List;
import java.util.Objects;

import static br.com.contmatic.utils.UtilsConstantes.*;
import static br.com.contmatic.utils.ValidadoresUtils.*;
import static br.com.contmatic.utils.UtilsCnpj.validaCnpj;

public class Fornecedor {
    private String cnpj;
    private String nome;
    private List<Produto> produtos;
    private List<Contato> contatos;
    private List<Endereco> enderecos;

    public String getNome() {
        return nome;
    }



    public Fornecedor() {
    }

    public Fornecedor(String cnpj, String nome, List<Produto> produtos, List<Contato> contatos, List<Endereco> enderecos) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.produtos = produtos;
        this.contatos = contatos;
        this.enderecos = enderecos;
    }

    public void setNome(String nome) {
        validarObjetoNulo(nome, FORNECEDOR_EMPRESA, NOME_CLASSE_FORNECEDOR);
        validarStringVazio(nome, FORNECEDOR_EMPRESA, NOME_CLASSE_FORNECEDOR);
        validarStringTamanhoMinimo(nome, 3, FORNECEDOR_EMPRESA, NOME_CLASSE_FORNECEDOR);
        validarStringTamanhoMaximo(nome, 30, FORNECEDOR_EMPRESA, NOME_CLASSE_FORNECEDOR);
        validarNumerosString(nome, FORNECEDOR_EMPRESA, NOME_CLASSE_FORNECEDOR);
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        validarObjetoNulo(produtos.get(0), FORNECEDOR_PRODUTO, NOME_CLASSE_FORNECEDOR);
        this.produtos = produtos;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        validaCnpj(cnpj, FORNECEDOR_CNPJ, NOME_CLASSE_FORNECEDOR);
        this.cnpj = cnpj;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        validarObjetoNulo(contatos.get(0), FORNECEDOR_CONTATO, NOME_CLASSE_FORNECEDOR);
        this.contatos = contatos;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        validarObjetoNulo(enderecos.get(0), FORNECEDOR_ENDERECO, NOME_CLASSE_FORNECEDOR);
        this.enderecos = enderecos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fornecedor)) return false;
        Fornecedor that = (Fornecedor) o;
        return getCnpj().equals(that.getCnpj());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCnpj());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Fornecedor {nome= ");
        builder.append(nome);
        builder.append(", produtos= ");
        builder.append(produtos);
        builder.append(", cnpj= ");
        builder.append(cnpj);
        builder.append(", contatos= ");
        builder.append(contatos);
        builder.append(", enderecos= ");
        builder.append(enderecos);
        builder.append("}");
        return builder.toString();
    }
}
