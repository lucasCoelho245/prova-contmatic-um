package br.com.contmatic.auditoria;

import java.time.LocalDateTime;
import java.util.Objects;

import static br.com.contmatic.utils.ConstantsUtils.*;
import static br.com.contmatic.utils.ValidaDate.isValidLocalDateTime;
import static br.com.contmatic.utils.ValidadoresUtils.*;

public class Auditoria {

    private String loginCriacao;
    private String loginAlteracao;
    private String ipCriacao;
    private String ipAlteracao;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAlteracao;
    private LocalDateTime dataLogin;
    private LocalDateTime dataLogout;

    public Auditoria() {
    }

    public Auditoria(String loginCriacao, String ipCriacao, LocalDateTime dataCriacao, LocalDateTime dataLogout, LocalDateTime dataLogin) {
        setLoginCriacao(loginCriacao);
        setIpCriacao(ipCriacao);
        setDataCriacao(dataCriacao);
        setDataLogin(dataLogin);
        setDataLogout(dataLogout);
    }

    public Auditoria(String loginAlteracao, LocalDateTime dataLogout, String ipAlteracao, LocalDateTime dataLogin, LocalDateTime dataAlteracao) {
        setLoginAlteracao(loginAlteracao);
        setDataLogin(dataLogin);
        setIpAlteracao(ipAlteracao);
        setDataLogout(dataLogout);
        setDataAlteracao(dataAlteracao);
    }

    public String getLoginCriacao() {
        return loginCriacao;
    }

    public void setLoginCriacao(String loginCriacao) {
        validarObjetoNulo(loginCriacao, LOGIN_DA_CRIACAO, NOME_CLASSE_AUDITORIA);
        validarStringVazio(loginCriacao, LOGIN_DA_CRIACAO, NOME_CLASSE_AUDITORIA);
        validarCaracterEspecial(loginCriacao, LOGIN_DA_CRIACAO, NOME_CLASSE_AUDITORIA);
        validarStringTamanhoMaximo(loginCriacao, 25, LOGIN_DA_CRIACAO, NOME_CLASSE_AUDITORIA);
        validarStringTamanhoMinimo(loginCriacao, 2, LOGIN_DA_CRIACAO, NOME_CLASSE_AUDITORIA);
        this.loginCriacao = loginCriacao;
    }

    public String getLoginAlteracao() {
        return loginAlteracao;
    }

    public void setLoginAlteracao(String loginAlteracao) {
        validarObjetoNulo(loginAlteracao, LOGIN_DA_ALTERACAO, NOME_CLASSE_AUDITORIA);
        validarStringVazio(loginAlteracao, LOGIN_DA_ALTERACAO, NOME_CLASSE_AUDITORIA);
        validarStringTamanhoMaximo(loginAlteracao, 25, LOGIN_DA_ALTERACAO, NOME_CLASSE_AUDITORIA);
        validarStringTamanhoMinimo(loginAlteracao, 2, LOGIN_DA_ALTERACAO, NOME_CLASSE_AUDITORIA);
        validarCaracterEspecial(loginAlteracao, LOGIN_DA_ALTERACAO, NOME_CLASSE_AUDITORIA);
        this.loginAlteracao = loginAlteracao;
    }

    public String getIpCriacao() {
        return ipCriacao;
    }

    public void setIpCriacao(String ipCriacao) {
        validarObjetoNulo(ipCriacao, IP_DA_CRIACAO, NOME_CLASSE_AUDITORIA);
        validarStringVazio(ipCriacao, IP_DA_CRIACAO, NOME_CLASSE_AUDITORIA);
        validarPatternIp(ipCriacao, IP_DA_CRIACAO, NOME_CLASSE_AUDITORIA);
        validarStringTamanhoMinimo(ipCriacao, 6, IP_DA_CRIACAO, NOME_CLASSE_AUDITORIA);
        validarStringTamanhoMaximo(ipCriacao, 15, IP_DA_CRIACAO, NOME_CLASSE_AUDITORIA);
        this.ipCriacao = ipCriacao;
    }

    public String getIpAlteracao() {
        return ipAlteracao;
    }

    public void setIpAlteracao(String ipAlteracao) {
        validarObjetoNulo(ipAlteracao, IP_DA_ALTERACAO, NOME_CLASSE_AUDITORIA);
        validarStringVazio(ipAlteracao, IP_DA_ALTERACAO, NOME_CLASSE_AUDITORIA);
        validarPatternIp(ipAlteracao, IP_DA_ALTERACAO, NOME_CLASSE_AUDITORIA);
        validarStringTamanhoMinimo(ipAlteracao, 6, IP_DA_ALTERACAO, NOME_CLASSE_AUDITORIA);
        validarStringTamanhoMaximo(ipAlteracao, 15, IP_DA_ALTERACAO, NOME_CLASSE_AUDITORIA);
        this.ipAlteracao = ipAlteracao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        isValidLocalDateTime(dataCriacao, DATA_CRIACAO_AUDITORIA, NOME_CLASSE_AUDITORIA);
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        isValidLocalDateTime(dataAlteracao, DATA_ALTERACAO_AUDITORIA, NOME_CLASSE_AUDITORIA);
        this.dataAlteracao = dataAlteracao;
    }

    public LocalDateTime getDataLogin() {
        return dataLogin;
    }

    public void setDataLogin(LocalDateTime dataLogin) {
        isValidLocalDateTime(dataLogin, DATA_LOGIN_AUDITORIA, NOME_CLASSE_AUDITORIA);
        this.dataLogin = dataLogin;
    }

    public LocalDateTime getDataLogout() {
        return dataLogout;
    }

    public void setDataLogout(LocalDateTime dataLogout) {
        isValidLocalDateTime(dataLogout, DATA_LOGOUT_AUDITORIA, NOME_CLASSE_AUDITORIA);
        this.dataLogout = dataLogout;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auditoria auditoria = (Auditoria) o;
        return ipCriacao.equals(auditoria.ipCriacao) && loginCriacao.equals(auditoria.loginCriacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ipCriacao, LOGIN_DA_CRIACAO);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Auditoria {dataCriacao= ");
        builder.append(dataCriacao);
        builder.append(", dataAlteracao= ");
        builder.append(dataAlteracao);
        builder.append(", loginCriacao= ");
        builder.append(loginCriacao);
        builder.append(", loginAlteracao= ");
        builder.append(loginAlteracao);
        builder.append(", ipCriacao= ");
        builder.append(ipCriacao);
        builder.append(", dataLogin= ");
        builder.append(dataLogin);
        builder.append(", dataLogout= ");
        builder.append(dataLogout);
        builder.append("}");
        return builder.toString();
    }
}
