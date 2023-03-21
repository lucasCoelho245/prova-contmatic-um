package br.com.contmatic.contato;

import java.util.Objects;

import static br.com.contmatic.utils.Utils.*;

public class Telefone {
    private DDDType ddd;
    private Integer ddi;
    private String numero;
    private String nomeClasse = "telefone";
    private String numeroTelefone = "numero";

    public Telefone() {
    }

    public Telefone(DDDType ddd, Integer ddi, String numero) {
        this.ddd = ddd;
        this.ddi = ddi;
        this.numero = numero;
    }

    public DDDType getDdd() {
        return ddd;
    }

    public void setDdd(DDDType ddd) {
        validarObjetoNulo(ddd, "DDD", nomeClasse);
        this.ddd = ddd;
    }

    public Integer getDdi() {
        return ddi;
    }

    public void setDdi(String ddi) {
        validarObjetoNulo(ddi, "DDI", nomeClasse);
        validarStringTamanhoMaximo(ddi, 3, "DDI", nomeClasse);
        validarCaracterString(ddi, "DDI", nomeClasse);
        this.ddi = Integer.valueOf(ddi);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        validarObjetoNulo(numero, numeroTelefone, nomeClasse);
        validarStringVazio(numero, numeroTelefone, nomeClasse);
        validarStringSomenteNumeros(numero, numeroTelefone, nomeClasse);
        validarStringTamanhoMinimo(numero, 8, numeroTelefone, nomeClasse);
        validarStringTamanhoMaximo(numero, 10, numeroTelefone, nomeClasse);
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Telefone)) return false;
        Telefone telefone = (Telefone) o;
        return getDdd() == telefone.getDdd() && getNumero().equals(telefone.getNumero());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDdd(), getNumero());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Telefone {DDD= ");
        builder.append(ddd);
        builder.append(", DDDI= ");
        builder.append(ddi);
        builder.append(", numero= ");
        builder.append(numero);
        return builder.toString();
    }
}
