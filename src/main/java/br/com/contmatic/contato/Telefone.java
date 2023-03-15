package br.com.contmatic.contato;

import java.util.Objects;

import static br.com.contmatic.utils.Utils.*;

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
        validarObjetoNulo(ddd, "DDD", "Telefone");
        validarCaracterString(String.valueOf(ddd), "DDD", "Telefone");
        this.ddd = ddd;
    }

    public Integer getDdi() {
        return ddi;
    }

    public void setDdi(Integer ddi) {
        validarStringTamanhoMaximo(String.valueOf(ddi), 3, "DDI", "Telefone");
        validarObjetoNulo(ddi, "DDI", "Telefone");
        validarCaracterString(String.valueOf(ddi), "DDI", "Telefone");
        this.ddi = ddi;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        validarObjetoNulo(numero, "Numero", "Telefone");
        validarStringTamanhoMinimo(numero, 8, "Numero", "Telefone");
        validarStringTamanhoMaximo(numero, 10, "Numero", "Telefone");
        validarCaracterString(numero, "Numero", "Telefone");
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
