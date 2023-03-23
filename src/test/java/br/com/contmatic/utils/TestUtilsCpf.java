package br.com.contmatic.utils;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static br.com.contmatic.utils.CpfUtils.validarCpf;
import static br.com.contmatic.utils.constants.TestCpf.*;
import static org.junit.rules.ExpectedException.none;

public class TestUtilsCpf {
    @Rule
    public ExpectedException exceptionRule = none();

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Iniciamos os testes na classe CpfUtils");
    }

    @Test
    public void nao_deve_aceitar_cpf_se_vazio() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(MSG_CPF_VAZIO);
        validarCpf(" ", "cpf", "utilsCpf");
    }

    @Test
    public void nao_deve_aceitar_cpf_se_caracter_repetido() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(MSG_CPF_REPETIDO);
        validarCpf("44444444444", "cpf", "utilsCpf");
    }

    @Test
    public void nao_deve_aceitar_cpf_se_invalido() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(MSG_CPF_INVALIDO);
        validarCpf("88844477458", "cpf", "utilsCpf");
    }

}
