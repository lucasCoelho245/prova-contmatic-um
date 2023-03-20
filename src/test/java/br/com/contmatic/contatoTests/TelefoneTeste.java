package br.com.contmatic.contatoTests;

import br.com.contmatic.contato.Telefone;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static br.com.contmatic.contato.DDDType.DDD11;
import static br.com.contmatic.contato.DDDType.DDD12;
import static br.com.contmatic.contatoTests.constants.telefone.TelefoneConstansts.*;
import static org.junit.Assert.*;

public class TelefoneTeste {
    private Telefone telefone;
    private List<Telefone> telefoneErrado = new ArrayList<>();
    private List<Telefone> telefoneCompleto = new ArrayList<>();
    private List<Telefone> telefonePadrao = new ArrayList<>();

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Iniciamos os testes na classe Telefone");
    }

    @Before
    public void setBeforeProduto() {
        telefone = new Telefone();
        telefoneErrado.add(new Telefone(DDD12, 55555, "43433443"));
        telefoneCompleto.add(new Telefone(DDD11, 555, "941584007"));

    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void deve_aceitar_DDD_correto() {
        telefone.setDdd(DDD11);
        assertEquals(telefone.getDdd(), DDD11);
    }

    @Test
    public void deve_aceitar_numero_correto() {
        telefone.setNumero("941584007");
        assertEquals(telefone.getNumero(), "941584007");
    }

    @Test
    public void deve_aceitar_ddi_correto() {
        Integer ddi = 55;
        telefone.setDdi(55);
        assertEquals(telefone.getDdi(), ddi);
    }
    @Test
    public void testContatoEqualsAndHashCode() {

        telefonePadrao.add(new Telefone(DDD11, 555, "941584007"));

        assertEquals(telefoneCompleto.hashCode(), telefonePadrao.hashCode());
        assertNotEquals(telefoneCompleto.hashCode(), telefoneErrado.hashCode());

        assertTrue(telefoneCompleto.equals(telefoneCompleto));
        assertFalse(telefoneErrado.equals(telefoneCompleto));
    }

    @Test
    public void testContatoToString() {
        String expectedString = "[Telefone {DDD= DDD11, DDDI= 555, numero= 941584007]";
        assertEquals(expectedString, telefoneCompleto.toString());
    }


    @Test
    public void nao_deve_aceitar_ddi_nulo() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(MSG_DDI_NULO);
        telefone.setDdi(null);
    }

    @Test
    public void nao_deve_aceitar_ddi_maior_que_3() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(MSG_DDI_MAIOR_DE_3_CARACTERES);
        telefone.setDdi(44444444);
    }

    @Test
    public void nao_deve_aceitar_numero_nulo() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(MSG_TELEFONE_VAZIO);
        telefone.setNumero("");
    }

    @Test
    public void nao_deve_aceitar_numero_maior_que_10() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(MSG_TELEFONE_MAIOR_DE_10_CARACTERES);
        telefone.setNumero("3487457845784578958756786");
    }

    @Test
    public void nao_deve_aceitar_numero_menor_que_8() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(MSG_TELEFONE_MENOR_DE_8_CARACTERES);
        telefone.setNumero("444");
    }

    @Test
    public void nao_deve_aceitar_numero_com_caracteres() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(MSG_TELEFONE_COM_LETRAS);
        telefone.setNumero("4fsdfgf");
    }


}
