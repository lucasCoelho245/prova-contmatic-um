package br.com.contmatic.endereco;

import br.com.contmatic.auditoria.Auditoria;

import java.util.Objects;

import static br.com.contmatic.utils.AuditoriaUtils.setAuditoriaAlteracao;
import static br.com.contmatic.utils.AuditoriaUtils.setAuditoriaCriacao;
import static br.com.contmatic.utils.ConstantsUtils.*;
import static br.com.contmatic.utils.ValidadoresUtils.*;

public class Endereco extends Auditoria {
    private String logradouro;
    private Integer numero;
    private String bairro;
    private String cidade;
    private UFType uf;
    private String complemento;
    private String cep;

    public Endereco() {
    }

    public Endereco(String logradouro, Integer numero, String bairro, String cidade, UFType uf, String complemento, String cep) {
        setLogradouro(logradouro);
        setNumero(numero);
        setBairro(bairro);
        setCidade(cidade);
        setUf(uf);
        setComplemento(complemento);
        setCep(cep);
        setAuditoriaCriacao(this);
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        validarObjetoNulo(logradouro, ENDERECO_LOGRADOURO, NOME_CLASSE_ENDERECO);
        validarStringVazio(logradouro, ENDERECO_LOGRADOURO, NOME_CLASSE_ENDERECO);
        validarStringTamanhoMinimo(logradouro, 3, ENDERECO_LOGRADOURO, NOME_CLASSE_ENDERECO);
        validarNumerosString(logradouro, ENDERECO_LOGRADOURO, NOME_CLASSE_ENDERECO);
        validarStringTamanhoMaximo(String.valueOf(numero), 20, ENDERECO_LOGRADOURO, NOME_CLASSE_ENDERECO);
        setAuditoriaAlteracao(this);
        this.logradouro = logradouro;
    }

    public UFType getUf() {
        return uf;
    }

    public void setUf(UFType uf) {
        setAuditoriaAlteracao(this);
        this.uf = uf;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        validarObjetoNulo(numero, ENDERECO_NUMERO, NOME_CLASSE_ENDERECO);
        setAuditoriaAlteracao(this);
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        validarObjetoNulo(bairro, ENDERECO_BAIRRO, NOME_CLASSE_ENDERECO);
        validarStringVazio(bairro, ENDERECO_BAIRRO, NOME_CLASSE_ENDERECO);
        validarStringTamanhoMinimo(bairro, 3, ENDERECO_BAIRRO, NOME_CLASSE_ENDERECO);
        validarNumerosString(bairro, ENDERECO_BAIRRO, NOME_CLASSE_ENDERECO);
        validarStringTamanhoMaximo(bairro, 20, ENDERECO_BAIRRO, NOME_CLASSE_ENDERECO);
        setAuditoriaAlteracao(this);
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        validarObjetoNulo(cidade, ENDERECO_CIDADE, NOME_CLASSE_ENDERECO);
        validarStringVazio(cidade, ENDERECO_CIDADE, NOME_CLASSE_ENDERECO);
        validarStringTamanhoMinimo(cidade, 3, ENDERECO_CIDADE, NOME_CLASSE_ENDERECO);
        validarNumerosString(cidade, ENDERECO_CIDADE, NOME_CLASSE_ENDERECO);
        validarStringTamanhoMaximo(cidade, 20, ENDERECO_CIDADE, NOME_CLASSE_ENDERECO);
        setAuditoriaAlteracao(this);
        this.cidade = cidade;
    }


    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        validarObjetoNulo(complemento, ENDERECO_COMPLEMENTO, NOME_CLASSE_ENDERECO);
        validarStringVazio(complemento, ENDERECO_COMPLEMENTO, NOME_CLASSE_ENDERECO);
        validarStringTamanhoMinimo(complemento, 3, ENDERECO_COMPLEMENTO, NOME_CLASSE_ENDERECO);
        validarStringTamanhoMaximo(complemento, 20, ENDERECO_COMPLEMENTO, NOME_CLASSE_ENDERECO);
        setAuditoriaAlteracao(this);
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        validarPatternCep(cep, ENDERECO_CEP, NOME_CLASSE_ENDERECO);
        this.cep = cep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Endereco)) return false;
        Endereco endereco = (Endereco) o;
        return getCep().equals(endereco.getCep());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCep());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Endereco {logradouro= ");
        builder.append(logradouro);
        builder.append(", numero= ");
        builder.append(numero);
        builder.append(", bairro= ");
        builder.append(bairro);
        builder.append(", cidade= ");
        builder.append(cidade);
        builder.append(", uf= ");
        builder.append(uf);
        builder.append(", complemento= ");
        builder.append(complemento);
        builder.append(", cep= ");
        builder.append(cep);
        builder.append("}");
        return builder.toString();
    }
}
