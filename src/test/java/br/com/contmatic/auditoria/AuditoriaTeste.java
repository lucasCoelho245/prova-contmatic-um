package br.com.contmatic.auditoria;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDateTime;

import static br.com.contmatic.auditoria.constants.auditoria.AuditoriaConstants.*;
import static org.junit.Assert.*;

public class AuditoriaTeste {
    private Auditoria auditoria;
    private LocalDateTime exemploData = LocalDateTime.of(2022, 1, 1, 12, 30);
    private Auditoria auditoriaTeste = new Auditoria("teste@login", "2552552551");
    private Auditoria auditoriaTesteCompleto = new Auditoria("teste@login", "teste@login", "2552552550", exemploData, exemploData, exemploData, exemploData, "auditoriaTeste", "auditoriaTeste", "auditoriaTeste", "2552552550");
    private Auditoria auditoriaTesteIgual = new Auditoria("teste@login", "2552552551");
    private Auditoria auditoriaerrado = new Auditoria("teste2@login", "33223");

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Iniciamos os testes na classe Auditoria");
    }

    @Before
    public void setBeforeauditoria() {
        auditoria = new Auditoria();
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void deve_aceitar_login_alteracao_correto() {
        auditoria.setLoginAlteracao("testelog");
        assertEquals(auditoria.getLoginAlteracao(), "testelog");
    }

    @Test
    public void deve_aceitar_login_criacao_correto() {
        auditoria.setLoginCriacao("testelog");
        assertEquals(auditoria.getLoginCriacao(), "testelog");
    }

    @Test
    public void deve_aceitar_ip_criacao_correto() {
        auditoria.setIpCriacao("255.255.255.10");
        assertEquals(auditoria.getIpCriacao(), "255.255.255.10");
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
    public void testAuditoriaEqualsAndHashCode() {
        assertEquals(auditoriaTeste.hashCode(), auditoriaTesteIgual.hashCode());
        assertNotEquals(auditoriaTeste.hashCode(), auditoriaerrado.hashCode());

        assertTrue(auditoriaTeste.equals(auditoriaTesteIgual));
        assertFalse(auditoriaerrado.equals(auditoriaTesteIgual));
    }

    @Test
    public void testAuditoriaToString() {
        String expectedString = "Auditoria {dataCriacao= 2022-01-01T12:30, dataAlteracao= 2022-01-01T12:30, loginCriacao= teste@login, loginAlteracao= teste@login, ipCriacao= 2552552550, dataLogin= 2022-01-01T12:30, dataLogout= 2022-01-01T12:30}";
        assertEquals(expectedString, auditoriaTesteCompleto.toString());
    }


    @Test
    public void nao_deve_aceitar_login_maior_que_25() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(LOG_CRIACAO);


        auditoria.setLoginCriacao("4288r342342342487qrRETRTRIUHIHIHJIHRIHGRSIHGRSIHGIHJIHGFSIHJOIHJOIHDGFSHFGHJDFFHJFJHJF");
        auditoria.setLoginAlteracao("4288r342342342487qrRETRTRIUHIHIHJIHRIHGRSIHGRSIHGIHJIHGFSIHJOIHJOIHDGFSHFGHJDFFHJFJHJF");
    }

    @Test
    public void nao_deve_aceitar_login_menor_que_2() {
        exceptionRule.expect(IllegalArgumentException.class);
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
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(LOG_ALTERACAO_CARACTER_ESPECIAL);
        auditoria.setLoginCriacao("sded&%");
        auditoria.setLoginAlteracao("sdvkjbsd&%");
    }

    @Test
    public void nao_deve_aceitar_data_alteracao_invalida() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(LOG_ALTERACAO_CARACTER_ESPECIAL);
        LocalDateTime dataAlteracao = LocalDateTime.of(2024, 1, 1, 12, 30);
        auditoria.setDataAlteracao(dataAlteracao);
    }

    @Test
    public void nao_deve_aceitar_data_criacao_invalida() {
        LocalDateTime dataCriacao = LocalDateTime.of(2024, 1, 1, 12, 30);
        auditoria.setDataCriacao(dataCriacao);
    }

    @Test
    public void nao_deve_aceitar_data_logout_invalida() {
        LocalDateTime dataLogout = LocalDateTime.of(2024, 1, 1, 12, 30);
        auditoria.setDataLogout(dataLogout);
    }

    @Test
    public void nao_deve_aceitar_data_login_invalida() {
        LocalDateTime dataLogin = LocalDateTime.of(2024, 1, 1, 12, 30);
        auditoria.setDataLogin(dataLogin);
    }

    @Test
    public void nao_deve_aceitar_ip_criacao_menor_que_6() {
        exceptionRule.expectMessage(IP_CRIACAO_MENOR_QUE_6_CARACTERES);
        exceptionRule.expect(IllegalArgumentException.class);
        auditoria.setIpCriacao("25992");
    }

    @Test
    public void nao_deve_aceitar_ip_criacao_invalido() {
        exceptionRule.expectMessage(IP_CRIACAO_MAIO_QUE_15_CARACTERES);
        exceptionRule.expect(IllegalArgumentException.class);
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
        exceptionRule.expectMessage(IP_CRIACAO_NAO_PODE_TER_CARACTERES);
        exceptionRule.expect(IllegalArgumentException.class);
        auditoria.setIpCriacao("65ssfwfew992");
    }



}
