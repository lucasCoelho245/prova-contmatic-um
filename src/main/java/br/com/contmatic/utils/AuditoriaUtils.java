package br.com.contmatic.utils;

import br.com.contmatic.auditoria.Auditoria;

import java.net.UnknownHostException;

import static br.com.contmatic.utils.ValidadoresConstants.AUDITORIA_EXCEPTION;
import static java.net.InetAddress.getLocalHost;
import static java.time.LocalDateTime.now;

public class AuditoriaUtils {

    public static void setAuditoriaCriacao(Auditoria auditoria) {
            auditoria.setIpCriacao("19216801");
            auditoria.setLoginCriacao("lucasLocalHost");
            auditoria.setDataCriacao(now());

    }
    public static void setAuditoriaAlteracao(Auditoria auditoria) {
            auditoria.setIpAlteracao("19216801");
            auditoria.setDataAlteracao(now());
            auditoria.setLoginAlteracao("lucasLocalHost");
    }
}
