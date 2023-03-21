package br.com.contmatic.contato;

import java.util.List;
import java.util.Objects;

import static br.com.contmatic.utils.Utils.*;

public class Contato {
    private String email;
    private List<Telefone> telefones;
    private static final String CONTATO_EMPRESA = "contato";

    public Contato() {
    }

    public Contato(String email, List<Telefone> telefones) {
        this.email = email;
        this.telefones = telefones;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String emailEmpresa = "email";
        validarObjetoNulo(email, emailEmpresa, CONTATO_EMPRESA);
        validarStringVazio(email, emailEmpresa, CONTATO_EMPRESA);
        validarEmail(email, emailEmpresa, CONTATO_EMPRESA);
        validarStringTamanhoMaximo(email, 60, emailEmpresa, CONTATO_EMPRESA);
        validarStringTamanhoMinimo(email, 12, emailEmpresa, CONTATO_EMPRESA);
        this.email = email;
    }

    public List<Telefone> getTelefones() {

        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        validarObjetoNulo(telefones.get(0), "telefones", CONTATO_EMPRESA);
        this.telefones = telefones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contato)) return false;
        Contato contato = (Contato) o;
        return email.equals(contato.email) && telefones.equals(contato.telefones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, telefones);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Contato {email= ");
        builder.append(email);
        builder.append(", telefones= ");
        builder.append(telefones);
        builder.append("}");
        return builder.toString();
    }
}
