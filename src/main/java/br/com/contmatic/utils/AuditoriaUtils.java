package br.com.contmatic.utils;

import br.com.contmatic.auditoria.Auditoria;
import br.com.contmatic.empresa.Empresa;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import static java.net.InetAddress.getLocalHost;
import static java.time.LocalDateTime.now;

public class AuditoriaUtils {
    public static void setAuditoriaCriacao(Auditoria auditoria){
        try {
            auditoria.setIpCriacao(getLocalHost().getHostAddress());
            auditoria.setLoginCriacao(getLocalHost().getHostName());
            auditoria.setDataCriacao(now());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
