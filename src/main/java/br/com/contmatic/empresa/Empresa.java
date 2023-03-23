package br.com.contmatic.empresa;


import br.com.contmatic.contato.Contato;
import br.com.contmatic.endereco.Endereco;

import java.util.List;
import java.util.Objects;

import static br.com.contmatic.utils.ConstantsUtils.*;
import static br.com.contmatic.utils.ValidadoresUtils.*;
import static br.com.contmatic.utils.CnpjUtils.validaCnpj;

public class Empresa {
    private String nome;

    private String cnpj;

    private String razaoSocial;

    private Boolean ativa;

    private List<Endereco> enderecos;

    private List<Funcionario> funcionarios;

    private List<Contato> contatos;


    public Empresa() {
    }

    public Empresa(String cnpj) {
        this.cnpj = cnpj;
    }

    public Empresa(String cnpj, String razaoSocial, List<Endereco> endereco, List<Funcionario> funcionarios, List<Contato> contatos) {
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.enderecos = endereco;
        this.funcionarios = funcionarios;
        this.contatos = contatos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validarObjetoNulo(nome, nomeEmpresa, NOME_CLASSE_EMPRESA);
        validarStringVazio(nome, nomeEmpresa, NOME_CLASSE_EMPRESA);
        validarStringTamanhoMaximo(nome, 60, nomeEmpresa, NOME_CLASSE_EMPRESA);
        validarStringTamanhoMinimo(nome, 2, nomeEmpresa, NOME_CLASSE_EMPRESA);
        this.nome = nome;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void setAtiva(Boolean ativa) {
        validarObjetoNulo(ativa, empresaAtiva, NOME_CLASSE_EMPRESA);
        validarObjetoNulo(ativa, empresaAtiva, NOME_CLASSE_EMPRESA);
        this.ativa = ativa;
    }

    public List<Contato> getContatos() {
        return contatos;
    }


    public void setContatos(List<Contato> contatos) {
        validarListVazia(contatos, contatoEmpresa, NOME_CLASSE_EMPRESA);
        validarObjetoNulo(contatos, contatoEmpresa, NOME_CLASSE_EMPRESA);
        this.contatos = contatos;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        String cnpjEmpresa = "CNPJ";
        validaCnpj(cnpj, cnpjEmpresa, NOME_CLASSE_EMPRESA);
        this.cnpj = cnpj;
    }


    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        String empresaRazaoSocial = "razao social";
        validarObjetoNulo(razaoSocial, empresaRazaoSocial, NOME_CLASSE_EMPRESA);
        validarStringVazio(razaoSocial, empresaRazaoSocial, NOME_CLASSE_EMPRESA);
        validarStringTamanhoMinimo(razaoSocial, 10, empresaRazaoSocial, NOME_CLASSE_EMPRESA);
        validarStringTamanhoMaximo(razaoSocial, 60, empresaRazaoSocial, NOME_CLASSE_EMPRESA);
        validarNumerosString(razaoSocial, empresaRazaoSocial, NOME_CLASSE_EMPRESA);
        this.razaoSocial = razaoSocial;
    }


    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        validarObjetoNulo(enderecos, empresaEndereco, NOME_CLASSE_EMPRESA);
        validarListVazia(enderecos, empresaEndereco, NOME_CLASSE_EMPRESA);
        this.enderecos = enderecos;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        validarObjetoNulo(funcionarios, EMPRESA_FUNCIONARIO, NOME_CLASSE_EMPRESA);
        validarListVazia(funcionarios, EMPRESA_FUNCIONARIO, NOME_CLASSE_EMPRESA);
        this.funcionarios = funcionarios;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Empresa)) return false;
        Empresa empresa = (Empresa) o;
        return getCnpj().equals(empresa.getCnpj());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCnpj());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Empresa {cnpj= ");
        builder.append(cnpj);
        builder.append(", razaoSocial= ");
        builder.append(razaoSocial);
        builder.append(", enderecos= ");
        builder.append(enderecos);
        builder.append(", funcionarios= ");
        builder.append(funcionarios);
        builder.append(", contatos= ");
        builder.append(contatos);
        return builder.toString();
    }

}
