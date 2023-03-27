package br.com.contmatic.utils;

import br.com.contmatic.auditoria.Auditoria;

import java.net.UnknownHostException;

import static java.net.InetAddress.getLocalHost;
import static java.time.LocalDateTime.now;

public class AuditoriaUtils {
    public static void setAuditoriaCriacao(Auditoria auditoria) {
        try {
            auditoria.setIpCriacao(getLocalHost().getHostAddress());
            auditoria.setLoginCriacao(getLocalHost().getHostName());
            auditoria.setDataCriacao(now());
        } catch (UnknownHostException erro) {
            throw new RuntimeException(erro);
        }
    }
    public static void setAuditoriaAlteracao(Auditoria auditoria) {
        try {
            auditoria.setIpAlteracao(getLocalHost().getHostAddress());
            auditoria.setDataAlteracao(now());
            auditoria.setLoginAlteracao(getLocalHost().getHostName());
        } catch (UnknownHostException erro) {
            throw new RuntimeException(erro);
        }
    }
}
