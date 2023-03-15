package br.com.contmatic.contatoTests;

import br.com.contmatic.contato.Telefone;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static br.com.contmatic.contato.DDDType.DDD11;

public class TelefoneTeste {
    private Telefone telefone;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Iniciamos os testes na classe Cargo");
    }

    @Before
    public void setBeforeProduto() {
        telefone = new Telefone();
    }

    @Test
    public void deve_aceitar_DDD_correto() {
        telefone.setDdd(DDD11);
    }

    @Test
    public void deve_aceitar_numero_correto() {
        telefone.setNumero("941584007");
    }

    @Test
    public void deve_aceitar_ddi_correto() {
        telefone.setDdi(55);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_ddi_nulo() {
        telefone.setDdi(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_ddi_maior_que_3() {
        telefone.setDdi(44444444);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numero_nulo() {
        telefone.setNumero("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numero_maior_que_10() {
        telefone.setNumero("3487457845784578958756786");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numero_menor_que_8() {
        telefone.setNumero("444");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numero_com_caracteres() {
        telefone.setNumero("444dfsdfgf");
    }


}
