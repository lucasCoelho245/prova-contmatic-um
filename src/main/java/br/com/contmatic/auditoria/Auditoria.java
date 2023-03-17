package br.com.contmatic.auditoria;

import java.time.LocalDateTime;
import java.util.Objects;

import static br.com.contmatic.utils.Utils.*;

public class Auditoria {

    private String loginCriacao;

    private String loginAlteracao;

    private String ipCriacao;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAlteracao;

    private LocalDateTime dataLogin;

    private LocalDateTime dataLogout;

    private String nomeClasseauditoria = "auditoria";
    private String loginDaCriacao = "login criacao";
    private String loginDaAlteracao = "login alteracao";
    private String ipDaCriacao = "ipcriacao";

    public Auditoria() {
    }

    public Auditoria(String loginCriacao, String loginAlteracao, String ipCriacao, LocalDateTime dataCriacao, LocalDateTime dataAlteracao, LocalDateTime dataLogin, LocalDateTime dataLogout, String nomeClasseauditoria, String loginDaCriacao, String loginDaAlteracao, String ipDaCriacao) {
        this.loginCriacao = loginCriacao;
        this.loginAlteracao = loginAlteracao;
        this.ipCriacao = ipCriacao;
        this.dataCriacao = dataCriacao;
        this.dataAlteracao = dataAlteracao;
        this.dataLogin = dataLogin;
        this.dataLogout = dataLogout;
        this.nomeClasseauditoria = nomeClasseauditoria;
        this.loginDaCriacao = loginDaCriacao;
        this.loginDaAlteracao = loginDaAlteracao;
        this.ipDaCriacao = ipDaCriacao;
    }

    public Auditoria(String loginCriacao, String ipCriacao) {
        this.loginCriacao = loginCriacao;
        this.ipCriacao = ipCriacao;
    }

    public String getLoginCriacao() {
        return loginCriacao;
    }

    public void setLoginCriacao(String loginCriacao) {
        validarObjetoNulo(loginCriacao, loginDaCriacao, nomeClasseauditoria);
        validarStringVazio(loginCriacao, loginDaCriacao, nomeClasseauditoria);
        validarCaracterEspecial(loginCriacao, loginDaCriacao, nomeClasseauditoria);
        validarStringTamanhoMaximo(loginCriacao, 25, loginDaCriacao, nomeClasseauditoria);
        validarStringTamanhoMinimo(loginCriacao, 2, loginDaCriacao, nomeClasseauditoria);
        this.loginCriacao = loginCriacao;
    }

    public String getLoginAlteracao() {
        return loginAlteracao;
    }

    public void setLoginAlteracao(String loginAlteracao) {
        validarObjetoNulo(loginAlteracao, loginDaAlteracao, nomeClasseauditoria);
        validarStringVazio(loginAlteracao, loginDaAlteracao, nomeClasseauditoria);
        validarStringTamanhoMaximo(loginAlteracao, 25, loginDaAlteracao, nomeClasseauditoria);
        validarStringTamanhoMinimo(loginAlteracao, 2, loginDaAlteracao, nomeClasseauditoria);
        validarCaracterEspecial(loginAlteracao, loginDaAlteracao, nomeClasseauditoria);
        this.loginAlteracao = loginAlteracao;
    }

    public String getIpCriacao() {
        return ipCriacao;
    }

    public void setIpCriacao(String ipCriacao) {
        validarObjetoNulo(ipCriacao, ipDaCriacao, nomeClasseauditoria);
        validarStringVazio(ipCriacao, ipDaCriacao, nomeClasseauditoria);
        validarStringTamanhoMinimo(ipCriacao, 6, ipDaCriacao, nomeClasseauditoria);
        validarStringTamanhoMaximo(ipCriacao, 12, ipDaCriacao, nomeClasseauditoria);
        validarCaracterString(ipCriacao, ipDaCriacao, nomeClasseauditoria);
        validarIp(ipCriacao, ipDaCriacao, nomeClasseauditoria);
        this.ipCriacao = ipCriacao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        validarDate(dataCriacao, "data criação", nomeClasseauditoria);
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        validarDate(dataAlteracao, "data alteracao", nomeClasseauditoria);
        this.dataAlteracao = dataAlteracao;
    }

    public LocalDateTime getDataLogin() {
        return dataLogin;
    }

    public void setDataLogin(LocalDateTime dataLogin) {
        validarDate(dataLogin, "data login", nomeClasseauditoria);
        this.dataLogin = dataLogin;
    }

    public LocalDateTime getDataLogout() {
        return dataLogout;
    }

    public void setDataLogout(LocalDateTime dataLogout) {
        validarDate(dataLogout, "data logout", nomeClasseauditoria);
        this.dataLogout = dataLogout;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auditoria auditoria = (Auditoria) o;
        return ipCriacao.equals(auditoria.ipCriacao) && loginDaCriacao.equals(auditoria.loginDaCriacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ipCriacao, loginDaCriacao);
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
