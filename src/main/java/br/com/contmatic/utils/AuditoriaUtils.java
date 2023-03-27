package br.com.contmatic.utils;

import br.com.contmatic.auditoria.Auditoria;

import java.net.UnknownHostException;

import static br.com.contmatic.utils.ValidadoresConstants.AUDITORIA_EXCEPTION;
import static java.net.InetAddress.getLocalHost;
import static java.time.LocalDateTime.now;

public class AuditoriaUtils {

    public static void setAuditoriaCriacao(Auditoria auditoria) {
        try {
            auditoria.setIpCriacao(getLocalHost().getHostAddress());
            auditoria.setLoginCriacao(getLocalHost().getHostName());
            auditoria.setDataCriacao(now());
        } catch (UnknownHostException erro) {
            //@TODO ver com o silvano sobre o runtime
            throw new RuntimeException(AUDITORIA_EXCEPTION.concat(erro.toString()));
        }
    }
    public static void setAuditoriaAlteracao(Auditoria auditoria) {
        try {
            auditoria.setIpAlteracao(getLocalHost().getHostAddress());
            auditoria.setDataAlteracao(now());
            auditoria.setLoginAlteracao(getLocalHost().getHostName());
        } catch (UnknownHostException erro) {
            //@TODO ver com o silvano sobre o runtime
            throw new RuntimeException(AUDITORIA_EXCEPTION.concat(erro.toString()));
        }
    }
}
