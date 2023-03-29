package br.com.contmatic.utils;

import br.com.contmatic.auditoria.Auditoria;

import static java.time.LocalDateTime.now;

public class AuditoriaUtils {

    public static void setAuditoriaCriacao(Auditoria auditoria) {
            auditoria.setIpCriacao("192.168.0.1");
            auditoria.setLoginCriacao("lucasLocalHost");
            auditoria.setDataCriacao(now());
    }
    public static void setAuditoriaAlteracao(Auditoria auditoria) {
            auditoria.setIpAlteracao("192.168.0.1");
            auditoria.setDataAlteracao(now());
            auditoria.setLoginAlteracao("lucasLocalHost");
    }
}
