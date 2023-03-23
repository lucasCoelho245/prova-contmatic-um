package br.com.contmatic.contato;

import java.util.Objects;

import static br.com.contmatic.utils.ConstantsUtils.*;
import static br.com.contmatic.utils.ValidadoresUtils.*;

public class Telefone {
    private DDDType ddd;
    private Integer ddi;
    private String numero;

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
        validarObjetoNulo(ddd, NOME_DDD_TELEFONE, NOME_CLASSE_TELEFONE);
        this.ddd = ddd;
    }

    public Integer getDdi() {
        return ddi;
    }

    public void setDdi(String ddi) {
        validarObjetoNulo(ddi, NOME_DDI_TELEFONE, NOME_CLASSE_TELEFONE);
        validarStringTamanhoMaximo(ddi, 3, NOME_DDI_TELEFONE, NOME_CLASSE_TELEFONE);
        validarCaracterString(ddi, NOME_DDI_TELEFONE, NOME_CLASSE_TELEFONE);
        this.ddi = Integer.valueOf(ddi);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        validarObjetoNulo(numero, NUMERO_TELEFONE, NOME_CLASSE_TELEFONE);
        validarStringVazio(numero, NUMERO_TELEFONE, NOME_CLASSE_TELEFONE);
        validarCaracterString(numero, NUMERO_TELEFONE, NOME_CLASSE_TELEFONE);
        validarStringTamanhoMinimo(numero, 8, NUMERO_TELEFONE, NOME_CLASSE_TELEFONE);
        validarStringTamanhoMaximo(numero, 10, NUMERO_TELEFONE, NOME_CLASSE_TELEFONE);
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
