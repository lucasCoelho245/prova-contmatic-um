package br.com.contmatic.utils;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static br.com.contmatic.utils.constants.TestCpf.*;
import static org.junit.rules.ExpectedException.none;

public class TestUtilsCpf {
    private UtilsCpf cpf;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Iniciamos os testes na classe CpfUtils");
    }

    @Rule
    public ExpectedException exceptionRule = none();

    @Test
    public void deve_aceitar_cnpj_correto() {
        UtilsCpf.validarCpf("50279302835", "Cpf", "UtilsCpf");
    }

    @Test
    public void nao_deve_aceitar_cpf_se_vazio() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(MSG_CPF_VAZIO);
        UtilsCpf.validarCpf(" ", "cpf", "utilsCpf");
    }

    @Test
    public void nao_deve_aceitar_cpf_se_caracter_repetido() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(MSG_CPF_REPETIDO);
        UtilsCpf.validarCpf("44444444444", "cpf", "utilsCpf");
    }

    @Test
    public void nao_deve_aceitar_cpf_se_invalido() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(MSG_CPF_INVALIDO);
        UtilsCpf.validarCpf("88844477458", "cpf", "utilsCpf");
    }

}
