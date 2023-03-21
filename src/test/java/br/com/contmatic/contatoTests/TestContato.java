package br.com.contmatic.contatoTests;

import br.com.contmatic.contato.Contato;
import br.com.contmatic.contato.Telefone;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static br.com.contmatic.contato.DDDType.DDD11;
import static br.com.contmatic.contatoTests.constants.contato.ContatoConstants.*;
import static org.junit.Assert.*;
import static org.junit.rules.ExpectedException.*;

public class TestContato {
    private Contato contato;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Iniciamos os testes na classe Contato");
    }

    @Before
    public void setBeforeProduto() {
        contato = new Contato();
    }

    @Rule
    public ExpectedException exceptionRule = none();

    @Test
    public void deve_aceitar_email_correto() {
        contato.setEmail("johndoe@example.com");
        assertEquals("johndoe@example.com", contato.getEmail());

    }
    @Test
    public void testContatoHashCodeTrue() {
        assertEquals(contato.hashCode(), contato.hashCode());
    }
    @Test
    public void testContatoHashCodeFalse() {
        assertNotEquals(contato.hashCode(), contatoErrado.hashCode());
    }
    @Test
    public void testContatoEqualsTrue() {
        assertEquals(contato, contato);
    }
    @Test
    public void testContatoEqualsFalse() {
        assertNotEquals(contatoErrado, contato);
    }

    @Test
    public void testContatoToString() {
        telefones.add(new Telefone(DDD11, 555, "941584007"));
        String expectedString = "Contato {email= test@gmail.com, telefones= [Telefone {DDD= DDD11, DDDI= 555, numero= 941584007]}";
        assertEquals(expectedString, contatoCompleto.toString());
    }
    @Test
    public void deve_aceitar_telefone_correto() {
        List<Telefone> telefones = new ArrayList<>();
        telefones.add(new Telefone(DDD11, 5255 ,"1234"));
        contato.setTelefones(telefones);
        assertEquals(contato.getTelefones(), telefones);
    }

    @Test
    public void nao_deve_aceitar_email_vazio() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(MSG_EMAIL_VAZIO);
        contato.setEmail("");
    }
    @Test
    public void nao_deve_aceitar_email_nulo() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(MSG_EMAIL_NULO);
        contato.setEmail(null);
    }

    @Test
    public void nao_deve_aceitar_email_maior_que_60() {
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage(MSG_EMAIL_MAIOR_QUE_60);
        contato.setEmail("444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444@gmail.com");
    }

    @Test
    public void nao_deve_aceitar_email_menor_que_6() {
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage(MSG_EMAIL_MENOR_QUE_12);
        contato.setEmail("5@gmail.com");
    }

    @Test
    public void nao_deve_aceitar_email_invalido() {
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage(MSG_EMAIL_INVALIDO);
        contato.setEmail("55232sdsdffsdfdsdffdsd656567s");
    }

    @Test
    public void nao_deve_aceitar_telefone_nulo() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(MSG_TELEFONE_NULO);
        List<Telefone> telefones = new ArrayList<>();
        telefones.add(null);
        contato.setTelefones(telefones);
    }
}
