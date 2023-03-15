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

    public Endereco(Integer numero, String cep, String nomeLogradouro) {
        this.numero = numero;
        this.cep = cep;
        this.logradouro = nomeLogradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        validarStringTamanhoMinimo(logradouro, 3, "logradouro", "Endereco");
        validarNumerosString(logradouro, "logradouro", "Endereco");
        validarObjetoNulo(logradouro, "logradouro", "Endereco");
        validarStringTamanhoMaximo(String.valueOf(numero), 20, "logradouro", "Endereco");
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
        validarObjetoNulo(numero.toString(), "numero", "Endereco");
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        validarStringTamanhoMinimo(bairro, 3, "Bairro", "Endereco");
        validarNumerosString(bairro, "Bairro", "Endereco");
        validarObjetoNulo(bairro, "Bairro", "Endereco");
        validarStringTamanhoMaximo(bairro, 20, "Bairro", "Endereco");
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        validarStringTamanhoMinimo(cidade, 3, "cidade", "Endereco");
        validarNumerosString(cidade, "cidade", "Endereco");
        validarObjetoNulo(cidade, "cidade", "Endereco");
        validarStringTamanhoMaximo(cidade, 20, "cidade", "Endereco");
        this.cidade = cidade;
    }


    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        validarStringTamanhoMinimo(complemento, 3, "complemento", "Endereco");
        validarNumerosString(complemento, "complemento", "Endereco");
        validarObjetoNulo(complemento, "complemento", "Endereco");
        validarStringTamanhoMaximo(complemento, 20, "complemento", "Endereco");
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        validarCep(cep, "cep", "Endereco");
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
