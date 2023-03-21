package br.com.contmatic.utils;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestUtilsCnpj {
    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Iniciamos os testes na classe CnpjUtils");
    }
    @Test
    public void deve_aceitar_cnpj_correto() {
        UtilsCnpj.validaCnpj("26631884000176", "Cnpj", "UtilsCnpj");
    }
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_com_caracteres_iguais() {
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
