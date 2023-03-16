package br.com.contmatic.endereco;

import java.util.Objects;

import static br.com.contmatic.utils.Utils.*;

public class Endereco {
    private String logradouro;

    private Integer numero;

    private String bairro;

    private String cidade;

    private UFType uf;

    private String complemento;

    private String cep;

    public Endereco() {

    }
    private String nomeClasse = "endereco";
    private String enderecoLogradouro = "logradouro";
    private String enderecoNumero = "numero";
    private String enderecoBairro = "bairro";
    private String enderecoCidade = "cidade";
    private String enderecoComplemento = "complemento";
    private String enderecoCep = "cep";


    public Endereco(String logradouro, Integer numero, String bairro, String cidade, UFType uf, String complemento, String cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.complemento = complemento;
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        validarStringTamanhoMinimo(logradouro, 3, enderecoLogradouro, nomeClasse);
        validarNumerosString(logradouro, enderecoLogradouro, nomeClasse);
        validarObjetoNulo(logradouro, enderecoLogradouro, nomeClasse);
        validarStringTamanhoMaximo(String.valueOf(numero), 20, enderecoLogradouro, nomeClasse);
        this.logradouro = logradouro;
    }

    public UFType getUf() {
        return uf;
    }

    public void setUf(UFType uf) {
        this.uf = uf;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        validarObjetoNulo(numero.toString(), enderecoNumero, nomeClasse);
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        validarStringTamanhoMinimo(bairro, 3, enderecoBairro, nomeClasse);
        validarNumerosString(bairro, enderecoBairro, nomeClasse);
        validarObjetoNulo(bairro, enderecoBairro, nomeClasse);
        validarStringTamanhoMaximo(bairro, 20, enderecoBairro, nomeClasse);
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        validarStringTamanhoMinimo(cidade, 3, enderecoCidade, nomeClasse);
        validarNumerosString(cidade, enderecoCidade, nomeClasse);
        validarObjetoNulo(cidade, enderecoCidade, nomeClasse);
        validarStringTamanhoMaximo(cidade, 20, enderecoCidade, nomeClasse);
        this.cidade = cidade;
    }


    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        validarStringTamanhoMinimo(complemento, 3, enderecoComplemento, nomeClasse);
        validarNumerosString(complemento, enderecoComplemento, nomeClasse);
        validarObjetoNulo(complemento, enderecoComplemento, nomeClasse);
        validarStringTamanhoMaximo(complemento, 20, enderecoComplemento, nomeClasse);
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        validarCep(cep, enderecoCep, nomeClasse);
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
