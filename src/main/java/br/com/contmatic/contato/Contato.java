package br.com.contmatic.contato;

import br.com.contmatic.auditoria.Auditoria;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import static br.com.contmatic.utils.AuditoriaUtils.setAuditoriaAlteracao;
import static br.com.contmatic.utils.ConstantsUtils.*;
import static br.com.contmatic.utils.ValidadoresUtils.*;

public class Contato extends Auditoria {
    private String email;
    private List<Telefone> telefones;

    private Auditoria auditoria;

    public Contato() {
    }

    public Contato(String email, List<Telefone> telefones, String loginCriacao, String loginAlteracao, String ipCriacao, String ipAlteracao, LocalDateTime dataCriacao, LocalDateTime dataAlteracao ,LocalDateTime dataLogin, LocalDateTime dataLogout, Auditoria auditoria) {
        this.email = email;
        this.telefones = telefones;
        this.auditoria = new Auditoria(loginCriacao, loginAlteracao, ipCriacao, ipAlteracao, dataCriacao, dataAlteracao, dataLogin, dataLogout);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        validarObjetoNulo(email, emailEmpresa, CONTATO_EMPRESA);
        validarStringVazio(email, emailEmpresa, CONTATO_EMPRESA);
        validarPatternEmail(email, emailEmpresa, CONTATO_EMPRESA);
        validarStringTamanhoMaximo(email, 60, emailEmpresa, CONTATO_EMPRESA);
        validarStringTamanhoMinimo(email, 12, emailEmpresa, CONTATO_EMPRESA);
        setAuditoriaAlteracao(this);
        this.email = email;
    }

    public List<Telefone> getTelefones() {

        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        validarObjetoNulo(telefones, telefoneEmpresa, CONTATO_EMPRESA);
        validarListVazia(telefones, telefoneEmpresa, CONTATO_EMPRESA);
        setAuditoriaAlteracao(this);
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
