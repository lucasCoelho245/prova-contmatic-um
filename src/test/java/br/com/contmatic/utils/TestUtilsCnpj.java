package br.com.contmatic.utils;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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
        exceptionRule.expectMessage(MSG_TELEFONE_NULO);
        UtilsCnpj.validaCnpj("00000000000000", "Cnpj", "UtilsCnpj");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_invalido() {
        UtilsCnpj.validaCnpj("74756244765647", "Cnpj", "UtilsCnpj");
    }
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_com_mais_de_14_caracteres() {
        UtilsCnpj.validaCnpj("7475624476564722232", "Cnpj", "UtilsCnpj");
    }
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_com_menos_de_14_caracteres() {
        UtilsCnpj.validaCnpj("5454", "Cnpj", "UtilsCnpj");
    }
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_nulo() {
        UtilsCnpj.validaCnpj(" ", "Cnpj", "UtilsCnpj");
    }
}
