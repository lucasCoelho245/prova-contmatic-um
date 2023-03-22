package br.com.contmatic.utils;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static br.com.contmatic.utils.constants.TestCnpj.*;
import static org.junit.rules.ExpectedException.none;

public class TestUtilsCnpj {
    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Iniciamos os testes na classe CnpjUtils");
    }

    @Rule
    public ExpectedException exceptionRule = none();
    @Test
    public void deve_aceitar_cnpj_correto() {
        UtilsCnpj.validaCnpj("26631884000176", "Cnpj", "UtilsCnpj");
    }
    @Test
    public void nao_deve_aceitar_cnpj_com_caracteres_iguais() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(MSG_REPETIDO);
        UtilsCnpj.validaCnpj("00000000000000", "Cnpj", "UtilsCnpj");
    }

    @Test
    public void nao_deve_aceitar_cnpj_invalido() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(MSG_CNPJ_INVALIDO);
        UtilsCnpj.validaCnpj("74756244765647", "Cnpj", "UtilsCnpj");
    }
    @Test
    public void nao_deve_aceitar_cnpj_com_fora_de_formatacao() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(MSG_CNPJ_INVALIDO_FORMATACAO);
        UtilsCnpj.validaCnpj("5454", "Cnpj", "UtilsCnpj");
    }
    @Test
    public void nao_deve_aceitar_cnpj_vazio() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(MSG_CNPJ_VAZIO);
        UtilsCnpj.validaCnpj(" ", "Cnpj", "UtilsCnpj");
    }
}
