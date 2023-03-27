package br.com.contmatic.utils;

import br.com.contmatic.auditoria.Auditoria;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static br.com.contmatic.utils.AuditoriaUtils.setAuditoriaCriacao;
import static org.junit.Assert.assertEquals;
import static org.junit.rules.ExpectedException.none;

public class TestAuditoriaUtils extends Auditoria{
    @Rule
    public ExpectedException exceptionRule = none();

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Iniciamos os testes na classe CnpjUtils");
    }

//    @Test()
//    public void testSetAuditoriaCriacao() {
//        Auditoria auditoria = new Auditoria();
//        InetAddress inetAddress = null;
//        try {
//            inetAddress = InetAddress.getLocalHost();
//        } catch (UnknownHostException e) {
//            // Ignorar exceção
//        }
//        // Simular exceção lançando um RuntimeException
//        if (inetAddress == null) {
//            throw new RuntimeException("Falha ao obter endereço de IP");
//        }
//        // Chamar o método com o objeto InetAddress obtido
//        AuditoriaUtils.setAuditoriaCriacao(auditoria);
//        // O teste falhará se a exceção RuntimeException não for lançada
//    }

    @Test
    public void deve_aceitar_login_valido() throws UnknownHostException {
        Auditoria auditoria = new Auditoria();
        InetAddress localHost = InetAddress.getLocalHost();
        setAuditoriaCriacao(auditoria);
        assertEquals(auditoria.getLoginCriacao(), localHost.getHostName());
    }
    @Test
    public void nao_deve_aceitar_login_invalido() throws UnknownHostException {
        exceptionRule.expect(UnknownHostException.class);
        Auditoria auditoria = new Auditoria();
        InetAddress localHost = InetAddress.getByName("teste");
        setAuditoriaCriacao(auditoria);
        assertEquals(auditoria.getLoginCriacao(), localHost);
    }

}
