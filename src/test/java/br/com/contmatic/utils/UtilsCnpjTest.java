package br.com.contmatic.utils;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UtilsCnpjTest {
    private UtilsCnpj cnpj;
    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Iniciamos os testes na classe CnpjUtils");
    }

    @Before
    public void setBeforeProduto() {
        cnpj = new UtilsCnpj();
    }

    @Test
    public void deve_aceitar_cnpj_correto() {
        cnpj.validaCnpj("26631884000176", "Cnpj", "UtilsCnpj");
    }
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_com_caracteres_iguais() {
        cnpj.validaCnpj("00000000000000", "Cnpj", "UtilsCnpj");
    }
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_invalido() {
        cnpj.validaCnpj("74756244765647", "Cnpj", "UtilsCnpj");
    }
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_com_mais_de_14_caracteres() {
        cnpj.validaCnpj("7475624476564722232", "Cnpj", "UtilsCnpj");
    }
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_com_menos_de_14_caracteres() {
        cnpj.validaCnpj("5454", "Cnpj", "UtilsCnpj");
    }
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_nulo() {
        cnpj.validaCnpj(" ", "Cnpj", "UtilsCnpj");
    }
}
