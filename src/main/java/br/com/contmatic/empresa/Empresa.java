package br.com.contmatic.empresa;


import br.com.contmatic.contato.Contato;
import br.com.contmatic.endereco.Endereco;

import java.util.List;
import java.util.Objects;

import static br.com.contmatic.utils.Utils.*;
import static br.com.contmatic.utils.UtilsCnpj.validaCnpj;

public class Empresa {
    private String nome;

    private String cnpj;

    private String razaoSocial;

    private Boolean ativa;

    private List<Endereco> enderecos;

    private List<Funcionario> funcionarios;

    private List<Contato> contatos;

    private final String nomeClasse = "empresa";
    private final String nomeEmpresa = "nome empresa";
    private final String empresaAtiva = "empresa Ativa";
    private final String contatoEmpresa = "contatos";
    private final String empresaRazaoSocial = "razao social";
    private final String empresaEndereco = "endereco";
    private final String empresaFuncionario = "funcionario";
    private final String cnpjEmpresa = "CNPJ";


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
        validarObjetoNulo(nome, nomeEmpresa, nomeClasse);
        validarStringVazio(nome, nomeEmpresa, nomeClasse);
        validarStringTamanhoMaximo(nome, 60, nomeEmpresa, nomeClasse);
        validarStringTamanhoMinimo(nome, 2, nomeEmpresa, nomeClasse);
        this.nome = nome;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void setAtiva(Boolean ativa) {
        validarObjetoNulo(ativa, empresaAtiva, nomeClasse);
        validarObjetoNulo(ativa, empresaAtiva, nomeClasse);
        this.ativa = ativa;
    }

    public List<Contato> getContatos() {
        return contatos;
    }


    public void setContatos(List<Contato> contatos) {
        validarObjetoNulo(contatos.get(0), contatoEmpresa, nomeClasse);
        this.contatos = contatos;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        validaCnpj(cnpj, cnpjEmpresa, nomeClasse);
        this.cnpj = cnpj;
    }


    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        validarObjetoNulo(razaoSocial, empresaRazaoSocial, nomeClasse);
        validarStringVazio(razaoSocial, empresaRazaoSocial, nomeClasse);
        validarStringTamanhoMinimo(razaoSocial, 10, empresaRazaoSocial, nomeClasse);
        validarStringTamanhoMaximo(razaoSocial, 60, empresaRazaoSocial, nomeClasse);
        validarNumerosString(razaoSocial, empresaRazaoSocial, nomeClasse);
        this.razaoSocial = razaoSocial;
    }


    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        validarObjetoNulo(enderecos.get(0), empresaEndereco, nomeClasse);
        this.enderecos = enderecos;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        validarObjetoNulo(funcionarios.get(0), empresaFuncionario, nomeClasse);
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
