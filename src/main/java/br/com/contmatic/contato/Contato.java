package br.com.contmatic.contato;

import java.util.List;
import java.util.Objects;

import static br.com.contmatic.utils.Utils.*;

public class Contato {
    private String email;
    private List<Telefone> telefones;
    private String contatoEmpresa = "contato";
    private String emailEmpresa = "email";
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
        validarObjetoNulo(email, emailEmpresa, contatoEmpresa);
        validarStringVazio(email, emailEmpresa, contatoEmpresa);
        validarEmail(email, emailEmpresa, contatoEmpresa);
        validarStringTamanhoMaximo(email, 60, emailEmpresa, contatoEmpresa);
        validarStringTamanhoMinimo(email, 6, emailEmpresa, contatoEmpresa);
        this.email = email;
    }

    public List<Telefone> getTelefones() {

        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        validarObjetoNulo(telefones.get(0), "telefones", contatoEmpresa);
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
