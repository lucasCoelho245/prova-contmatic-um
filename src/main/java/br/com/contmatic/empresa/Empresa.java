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
        validarObjetoNulo(nome, "nome da empresa", "Empresa");
        validarStringTamanhoMaximo(nome, 60, "nome da empresa", "Empresa");
        validarStringTamanhoMinimo(nome, 2, "nome da empresa", "Empresa");
        this.nome = nome;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void setAtiva(Boolean ativa) {
        validarObjetoNulo(ativa, "Empresa Ativa?", "Empresa");
        this.ativa = ativa;
    }

    public List<Contato> getContatos() {
        return contatos;
    }


    public void setContatos(List<Contato> contatos) {
        validarObjetoNulo(contatos.get(0), "contatos", "Empresa");
        this.contatos = contatos;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        validaCnpj(cnpj, "CNPJ", "Empresa");
        this.cnpj = cnpj;
    }


    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        validarStringTamanhoMinimo(razaoSocial, 10, "razaoSocial", "Empresa");
        validarStringTamanhoMaximo(razaoSocial, 60, "razaoSocial", "Empresa");
        validarNumerosString(razaoSocial, "razaoSocial", "Empresa");
        validarCaracterEspecial(razaoSocial, "razaoSocial", "Empresa");
        validarObjetoNulo(razaoSocial, "razaoSocial", "Empresa");
        this.razaoSocial = razaoSocial;
    }


    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        validarObjetoNulo(enderecos.get(0), "enderecos", "Empresa");
        this.enderecos = enderecos;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        validarObjetoNulo(funcionarios.get(0), "funcionarios", "Empresa");
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
