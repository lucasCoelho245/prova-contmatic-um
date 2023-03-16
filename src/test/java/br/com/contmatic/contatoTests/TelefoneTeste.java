package br.com.contmatic.contatoTests;

import br.com.contmatic.contato.Telefone;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static br.com.contmatic.contato.DDDType.DDD11;
import static br.com.contmatic.contato.DDDType.DDD12;
import static org.junit.Assert.*;

public class TelefoneTeste {
    private Telefone telefone;
    private List<Telefone> telefoneErrado = new ArrayList<>();
    private List<Telefone> telefoneCompleto = new ArrayList<>();
    private List<Telefone> telefonePadrao = new ArrayList<>();

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Iniciamos os testes na classe Cargo");
    }

    @Before
    public void setBeforeProduto() {
        telefone = new Telefone();
        telefoneErrado.add(new Telefone(DDD12, 55555, "43433443"));
        telefoneCompleto.add(new Telefone(DDD11, 555, "941584007"));

    }

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
