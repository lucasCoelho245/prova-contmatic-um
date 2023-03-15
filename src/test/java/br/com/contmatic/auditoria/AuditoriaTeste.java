package br.com.contmatic.auditoria;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDateTime;


public class AuditoriaTeste {
    private Auditoria auditoria;
    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Iniciamos os testes na classe Auditoria");
    }

    @Before
    public void setBeforeauditoria(){
        auditoria = new Auditoria();
    }

    @Test
    public void deve_aceitar_login_alteracao_correto() {
        auditoria.setLoginAlteracao("teste.log");
    }

    @Test
    public void deve_aceitar_login_criacao_correto() {
        auditoria.setLoginCriacao("teste.log");
    }

    @Test
    public void deve_aceitar_ip_criacao_correto() {
        auditoria.setIpCriacao("2552992");
    }
    @Test
    public void deve_aceitar_data_alteracao_correta() {
        LocalDateTime dataAlteracao = LocalDateTime.of(2022, 1, 1, 12, 30);
        auditoria.setDataAlteracao(dataAlteracao);
    }
    @Test
    public void deve_aceitar_data_criacao_correta() {
        LocalDateTime dataCriacao = LocalDateTime.of(2022, 1, 1, 12, 30);
        auditoria.setDataAlteracao(dataCriacao);
    }
    @Test
    public void deve_aceitar_data_logout_correta() {
        LocalDateTime datalogout = LocalDateTime.of(2022, 1, 1, 12, 30);
        auditoria.setDataLogout(datalogout);
    }
    @Test
    public void deve_aceitar_data_login_correta() {
        LocalDateTime datalogin = LocalDateTime.of(2022, 1, 1, 12, 30);
        auditoria.setDataLogin(datalogin);
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
        auditoria.setLoginCriacao(" ");
        auditoria.setLoginAlteracao(" ");
    }
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_login_caracter_especial() {
        auditoria.setLoginCriacao("%%");
        auditoria.setLoginAlteracao("%%");
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
        auditoria.setIpCriacao("257765677656565722232992");
    }
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_ip_criacao_com_caracteres() {
        auditoria.setIpCriacao("65ssfwfew992");
    }



}
