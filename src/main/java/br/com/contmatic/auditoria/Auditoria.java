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

    public String getLoginCriacao() {
        return loginCriacao;
    }

    public void setLoginCriacao(String loginCriacao) {
        validarStringTamanhoMaximo(loginCriacao, 25, "loginCriação", "Auditoria");
        validarStringTamanhoMinimo(loginCriacao, 2, "loginCriação", "Auditoria");
        validarObjetoNulo(loginCriacao, "loginCriação", "Auditoria");
        validarCaracterEspecial(loginCriacao, "loginCriação", "Auditoria");
        this.loginCriacao = loginCriacao;
    }

    public String getLoginAlteracao() {
        return loginAlteracao;
    }

    public void setLoginAlteracao(String loginAlteracao) {
        validarStringTamanhoMaximo(loginAlteracao, 25, "loginAlteração", "Auditoria");
        validarStringTamanhoMinimo(loginAlteracao, 2, "loginAlteração", "Auditoria");
        validarObjetoNulo(loginAlteracao, "loginAlteração", "Auditoria");
        validarCaracterEspecial(loginAlteracao, "loginAlteração", "Auditoria");
        this.loginAlteracao = loginAlteracao;
    }

    public String getIpCriacao() {
        return ipCriacao;
    }

    public void setIpCriacao(String ipCriacao) {
        validarStringTamanhoMinimo(ipCriacao, 6, "ipcriação", "Auditoria");
        validarStringTamanhoMaximo(ipCriacao, 12, "ipcriação", "Auditoria");
        validarObjetoNulo(ipCriacao, "ipcriação", "Auditoria");
        validarCaracterString(ipCriacao, "ipcriação", "Auditoria");
        validarIp(ipCriacao, "ipcriação", "Auditoria");
        this.ipCriacao = ipCriacao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        validarDate(dataCriacao, "data criação", "auditoria");
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        validarDate(dataAlteracao, "data alteracao", "auditoria");
        this.dataAlteracao = dataAlteracao;
    }

    public LocalDateTime getDataLogin() {
        return dataLogin;
    }

    public void setDataLogin(LocalDateTime dataLogin) {
        validarDate(dataLogin, "data login", "auditoria");
        this.dataLogin = dataLogin;
    }

    public LocalDateTime getDataLogout() {
        return dataLogout;
    }

    public void setDataLogout(LocalDateTime dataLogout) {
        validarDate(dataLogout, "data logout", "auditoria");
        this.dataLogout = dataLogout;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Auditoria)) return false;
        Auditoria auditoria = (Auditoria) o;
        return getLoginCriacao().equals(auditoria.getLoginCriacao()) && ipCriacao.equals(auditoria.ipCriacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLoginCriacao(), ipCriacao);
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
