package br.com.contmatic.utils;

import org.junit.Test;

public class UtilsCpfTest {
    private UtilsCpf cpf;
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_se_nulo() {
        cpf.validarCpf(" ", "cpf", "utilsCpf");
    }
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_se_caracter_repetido() {
        cpf.validarCpf("44444444444", "cpf", "utilsCpf");
    }
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_se_invalido() {
        cpf.validarCpf("88844477458", "cpf", "utilsCpf");
    }
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_menos_de_11_caracteres() {
        cpf.validarCpf("545", "cpf", "utilsCpf");
    }
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_mais_de_11_caracteres() {
        cpf.validarCpf("502793028356", "cpf", "utilsCpf");
    }
}
