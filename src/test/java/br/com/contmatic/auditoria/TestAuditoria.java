package br.com.contmatic.auditoria;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDateTime;

import static br.com.contmatic.auditoria.constants.auditoria.AuditoriaConstants.*;
import static org.junit.Assert.*;
import static org.junit.rules.ExpectedException.*;

public class TestAuditoria {
    private Auditoria auditoria;

    @Rule
    public ExpectedException exceptionRule = none();

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Iniciamos os testes na classe Auditoria");
    }

    @Before
    public void setBeforeauditoria() {
        auditoria = new Auditoria();
    }

    @Test
    public void deve_aceitar_login_alteracao_correto() {
        auditoria.setLoginAlteracao("testelog");
        assertEquals("testelog", auditoria.getLoginAlteracao());
    }

    @Test
    public void deve_aceitar_login_criacao_correto() {
        auditoria.setLoginCriacao("testelog");
        assertEquals("testelog", auditoria.getLoginCriacao());
    }

    @Test
    public void deve_aceitar_ip_criacao_correto() {
        auditoria.setIpCriacao("255.255.255.10");
        assertEquals("255.255.255.10", auditoria.getIpCriacao());
    }
    @Test
    public void deve_aceitar_ip_alteracao_correto() {
        auditoria.setIpAlteracao("255.255.255.10");
        assertEquals("255.255.255.10", auditoria.getIpAlteracao());
    }

    @Test
    public void deve_aceitar_data_alteracao_correta() {
        auditoria.setDataAlteracao(exemploData);
        assertEquals(auditoria.getDataAlteracao(), LocalDateTime.of(2022, 1, 1, 12, 30));
    }

    @Test
    public void deve_aceitar_data_criacao_correta() {
        auditoria.setDataCriacao(exemploData);
        assertEquals(auditoria.getDataCriacao(), LocalDateTime.of(2022, 1, 1, 12, 30));
    }

    @Test
    public void deve_aceitar_data_logout_correta() {
        LocalDateTime datalogout = LocalDateTime.of(2022, 1, 1, 12, 30);
        auditoria.setDataLogout(datalogout);
        assertEquals(auditoria.getDataLogout(), LocalDateTime.of(2022, 1, 1, 12, 30));
    }

    @Test
    public void deve_aceitar_data_login_correta() {
        LocalDateTime datalogin = LocalDateTime.of(2022, 1, 1, 12, 30);
        auditoria.setDataLogin(datalogin);
        assertEquals(auditoria.getDataLogin(), LocalDateTime.of(2022, 1, 1, 12, 30));
    }

    @Test
    public void testAuditoriaHashCodeTrue() {
        assertEquals(auditoriaTeste.hashCode(), auditoriaTesteIgual.hashCode());
    }
    @Test
    public void testAuditoriaHashCodeFalse() {
        assertNotEquals(auditoriaTeste.hashCode(), auditoriaerrado.hashCode());
    }
    @Test
    public void testAuditoriaEqualsTrue() {
        assertEquals(auditoriaTeste, auditoriaTesteIgual);
    }
    @Test
    public void testAuditoriaEqualsFalse() {
        assertNotEquals(auditoriaerrado, auditoriaTesteIgual);
    }

    @Test
    public void testAuditoriaToString() {
        String expectedString = "Auditoria {dataCriacao= null, dataAlteracao= 2022-01-01T12:30, loginCriacao= null, loginAlteracao= testelogin, ipCriacao= null, dataLogin= 2022-01-01T12:30, dataLogout= 2022-01-01T12:30}";
        assertEquals(expectedString, auditoriaTesteCompleto.toString());
    }


    @Test
    public void nao_deve_aceitar_login_maior_que_25() {
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage(LOG_CRIACAO);
        auditoria.setLoginCriacao("4288r342342342487qrRETRTRIUHIHIHJIHRIHGRSIHGRSIHGIHJIHGFSIHJOIHJOIHDGFSHFGHJDFFHJFJHJF");
        auditoria.setLoginAlteracao("4288r342342342487qrRETRTRIUHIHIHJIHRIHGRSIHGRSIHGIHJIHGFSIHJOIHJOIHDGFSHFGHJDFFHJFJHJF");
    }

    @Test
    public void nao_deve_aceitar_login_menor_que_2() {
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage(LOG_ALTERACAO);
        auditoria.setLoginCriacao("1");
        auditoria.setLoginAlteracao("1");
    }

    @Test
    public void nao_deve_aceitar_login_nulo() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(LOG_ALTERACAO_NULL);
        auditoria.setLoginCriacao(null);
        auditoria.setLoginAlteracao(null);
    }
    @Test
    public void nao_deve_aceitar_login_vazio() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(LOG_ALTERACAO_VAZIO);
        auditoria.setLoginCriacao("");
        auditoria.setLoginAlteracao("");
    }

    @Test
    public void nao_deve_aceitar_login_caracter_especial() {
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage(LOG_LOGIN_CARACTER_ESPECIAL);
        auditoria.setLoginCriacao("sded&%");
        auditoria.setLoginAlteracao("sdvkjbsd&%");
    }

    @Test
    public void nao_deve_aceitar_data_alteracao_invalida() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(LOG_ALTERACAO_INVALIDA);
        LocalDateTime dataAlteracao = LocalDateTime.of(2024, 12, 30, 22, 12);
        auditoria.setDataAlteracao(dataAlteracao);
    }

    @Test
    public void nao_deve_aceitar_data_criacao_invalida() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(LOG_CRIACAO_INVALIDA);
        LocalDateTime dataCriacao = LocalDateTime.of(2023, 12, 30, 22, 12);
        auditoria.setDataCriacao(dataCriacao);
    }

    @Test
    public void nao_deve_aceitar_data_logout_invalida() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(LOG_LOGOUT_INVALIDA);
        LocalDateTime dataLogout = LocalDateTime.of(2023, 3, 30, 22, 12);
        auditoria.setDataLogout(dataLogout);
    }

    @Test
    public void nao_deve_aceitar_data_login_invalida() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(LOG_LOGIN_INVALIDA);
        LocalDateTime dataLogin = LocalDateTime.of(2024, 1, 1, 12, 30);
        auditoria.setDataLogin(dataLogin);
    }

    @Test
    public void nao_deve_aceitar_ip_criacao_invalido() {
        exceptionRule.expectMessage(IP_CRIACAO_INVALIDO);
        exceptionRule.expect(IllegalStateException.class);
        auditoria.setIpCriacao("257765677656565722232992");
    }

    @Test
    public void nao_deve_aceitar_ip_criacao_nulo() {
        exceptionRule.expectMessage(IP_CRIACAO_NULO);
        exceptionRule.expect(IllegalArgumentException.class);
        auditoria.setIpCriacao(null);
    }
    @Test
    public void nao_deve_aceitar_ip_criacao_vazio() {
        exceptionRule.expectMessage(IP_CRIACAO_VAZIO);
        exceptionRule.expect(IllegalArgumentException.class);
        auditoria.setIpCriacao("");
    }

    @Test
    public void nao_deve_aceitar_ip_criacao_com_caracteres() {
        exceptionRule.expectMessage(IP_CRIACAO_INVALIDO);
        exceptionRule.expect(IllegalStateException.class);
        auditoria.setIpCriacao("65ssfwfew992");
    }
    @Test
    public void nao_deve_aceitar_ip_alteracao_invalido() {
        exceptionRule.expectMessage(IP_ALTERACAO_INVALIDO);
        exceptionRule.expect(IllegalStateException.class);
        auditoria.setIpAlteracao("257765677656565722232992");
    }

    @Test
    public void nao_deve_aceitar_ip_alteracao_nulo() {
        exceptionRule.expectMessage(IP_ALTERACAO_NULO);
        exceptionRule.expect(IllegalArgumentException.class);
        auditoria.setIpAlteracao(null);
    }
    @Test
    public void nao_deve_aceitar_ip_alteracao_vazio() {
        exceptionRule.expectMessage(IP_ALTERACAO_VAZIO);
        exceptionRule.expect(IllegalArgumentException.class);
        auditoria.setIpAlteracao("");
    }

    @Test
    public void nao_deve_aceitar_ip_alteracao_com_caracteres() {
        exceptionRule.expectMessage(IP_ALTERACAO_INVALIDO);
        exceptionRule.expect(IllegalStateException.class);
        auditoria.setIpAlteracao("65ssfwfew992");
    }



}
