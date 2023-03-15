package br.com.contmatic.empresa;

import br.com.contmatic.contato.Contato;
import br.com.contmatic.endereco.Endereco;
import br.com.contmatic.utils.UtilsCnpj;

import java.util.List;
import java.util.Objects;

import static br.com.contmatic.utils.Utils.*;
import static br.com.contmatic.utils.Utils.validarCaracterEspecial;
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

    public void setNome(String nome) {
        validarStringTamanhoMinimo(nome, 3, "nome", "Fornecedor");
        validarStringTamanhoMaximo(nome, 30, "nome", "Fornecedor");
        validarNumerosString(nome, "Nome", "Fornecedor");
        validarObjetoNulo(nome, "Nome", "Fornecedor");
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        validarObjetoNulo(produtos.get(0),  "produtos", "Fornecedor");
        this.produtos = produtos;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        validaCnpj(cnpj, "CNPJ", "Fornecedor");
        this.cnpj = cnpj;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        validarObjetoNulo(contatos.get(0),  "contatos", "Fornecedor");
        this.contatos = contatos;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        validarObjetoNulo(enderecos.get(0), "enderecos", "Fornecedor");
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
