package br.com.contmatic.auditoria;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

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
        auditoria.setIpCriacao("2552992");
        assertEquals(auditoria.getIpCriacao(), "2552992");
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


    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_login_maior_que_25() {
        auditoria.setLoginCriacao("4288r342342342487qrRETRTRIUHIHIHJIHRIHGRSIHGRSIHGIHJIHGFSIHJOIHJOIHDGFSHFGHJDFFHJFJHJF");
        auditoria.setLoginAlteracao("4288r342342342487qrRETRTRIUHIHIHJIHRIHGRSIHGRSIHGIHJIHGFSIHJOIHJOIHDGFSHFGHJDFFHJFJHJF");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_login_menor_que_2() {
        auditoria.setLoginCriacao("1");
        auditoria.setLoginAlteracao("1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_login_nulo() {
        auditoria.setLoginCriacao(null);
        auditoria.setLoginAlteracao(null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_login_vazio() {
        auditoria.setLoginCriacao("");
        auditoria.setLoginAlteracao("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_login_caracter_especial() {
        auditoria.setLoginCriacao("sded&%");
        auditoria.setLoginAlteracao("sdvkjbsd&%");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_data_alteracao_invalida() {
        LocalDateTime dataAlteracao = LocalDateTime.of(2024, 1, 1, 12, 30);
        auditoria.setDataAlteracao(dataAlteracao);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_data_criacao_invalida() {
        LocalDateTime dataCriacao = LocalDateTime.of(2024, 1, 1, 12, 30);
        auditoria.setDataCriacao(dataCriacao);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_data_logout_invalida() {
        LocalDateTime dataLogout = LocalDateTime.of(2024, 1, 1, 12, 30);
        auditoria.setDataLogout(dataLogout);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_data_login_invalida() {
        LocalDateTime dataLogin = LocalDateTime.of(2024, 1, 1, 12, 30);
        auditoria.setDataLogin(dataLogin);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_ip_criacao_menor_que_6() {
        auditoria.setIpCriacao("25992");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_ip_criacao_invalido() {
        auditoria.setIpCriacao("257765677656565722232992");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_ip_criacao_nulo() {
        auditoria.setIpCriacao(" ");
    }
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_ip_criacao_vazio() {
        auditoria.setIpCriacao("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_ip_criacao_com_caracteres() {
        auditoria.setIpCriacao("65ssfwfew992");
    }



}
