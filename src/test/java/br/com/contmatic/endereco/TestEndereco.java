package br.com.contmatic.endereco;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static br.com.contmatic.empresa.constants.endereco.enderecoConstants.*;
import static br.com.contmatic.endereco.UFType.MA;
import static org.junit.Assert.*;
import static org.junit.rules.ExpectedException.*;

public class TestEndereco {
    private Endereco endereco;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Iniciamos os testes na classe fornecedor");
    }

    @Before
    public void setBeforeEndereco() {
        endereco = new Endereco();
    }

    @Rule
    public ExpectedException exceptionRule = none();

    @Test
    public void deve_aceitar_logradouro_correto() {
        endereco.setLogradouro("avenida brasil");
        assertEquals("avenida brasil", endereco.getLogradouro());
    }

    @Test
    public void deve_aceitar_uf_correto() {
        endereco.setUf(MA);
        assertEquals(MA, endereco.getUf());
    }

    @Test
    public void deve_aceitar_numero_correto() {
        Integer numero = 23;
        endereco.setNumero(numero);
        assertEquals(endereco.getNumero(), numero);
    }

    @Test
    public void deve_aceitar_cep_correto() {
        endereco.setCep("01235-000");
        assertEquals("01235-000", endereco.getCep());
    }

    @Test
    public void deve_aceitar_bairro_correto() {
        endereco.setBairro("barata ribeiro");
        assertEquals("barata ribeiro", endereco.getBairro());

    }

    @Test
    public void deve_aceitar_cidade_correto() {
        endereco.setCidade("são paulo");
        assertEquals("são paulo", endereco.getCidade());
    }

    @Test
    public void deve_aceitar_complemento_correto() {
        endereco.setComplemento("apto61");
        assertEquals("apto61", endereco.getComplemento());
    }

    @Test
    public void testEnderecoHashCodeTrue() {
        assertEquals(enderecoCompleto.hashCode(), enderecoPadrao.hashCode());
    }
    @Test
    public void testEnderecoHashCodeFalse() {
        assertNotEquals(enderecoCompleto.hashCode(), enderecoErrado.hashCode());
    }
    @Test
    public void testEnderecoEqualsTrue() {
        assertEquals(enderecoCompleto.hashCode(), enderecoPadrao.hashCode());
    }
    @Test
    public void testEnderecoEqualsFalse() {
        assertNotEquals(enderecoErrado, enderecoCompleto);
    }

    @Test
    public void testEnderecoToString() {
        String expectedString = "Endereco {logradouro= cambuci, numero= 22, bairro= barata Ribeiro, cidade= 01235000, uf= MA, complemento= apto 61, cep= 01233300}";
        assertEquals(expectedString, enderecoCompleto.toString());
    }

    @Test
    public void nao_deve_aceitar_numero_nulo() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(NUMERO_NULO);
        endereco.setNumero(null);
    }

    @Test
    public void nao_deve_aceitar_bairro_com_menos_de_3_caracteres() {
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage(BAIRRO_CURTO);
        endereco.setBairro("ww");
    }

    @Test
    public void nao_deve_aceitar_bairro_com_mais_de_20_caracteres() {
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage(BAIRRO_LONGO);
        endereco.setBairro("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
    }

    @Test
    public void nao_deve_aceitar_bairro_com_numeros() {
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage(BAIRRO_COM_NUMEROS);
        endereco.setBairro("74145");
    }

    @Test
    public void nao_deve_aceitar_bairro_vazio() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(BAIRRO_VAZIO);
        endereco.setBairro("");
    }
    @Test
    public void nao_deve_aceitar_bairro_nulo() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(BAIRRO_NULO);
        endereco.setBairro(null);
    }

    @Test
    public void nao_deve_aceitar_cidade_com_menos_de_3_caracteres() {
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage(CIDADE_CURTA);
        endereco.setCidade("ww");
    }

    @Test
    public void nao_deve_aceitar_cidade_com_mais_de_20_caracteres() {
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage(CIDADE_LONGA);
        endereco.setCidade("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
    }

    @Test
    public void nao_deve_aceitar_cidade_com_numeros() {
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage(CIDADE_COM_NUMEROS);
        endereco.setCidade("74145");
    }

    @Test
    public void nao_deve_aceitar_cidade_nulo() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CIDADE_VAZIA);
        endereco.setCidade("");
    }

    @Test
    public void nao_deve_aceitar_complemento_com_menos_de_3_caracteres() {
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage(COMPLEMENTO_CURTO);
        endereco.setComplemento("ww");
    }

    @Test
    public void nao_deve_aceitar_complemento_com_mais_de_20_caracteres() {
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage(COMPLEMENTO_LONGO);
        endereco.setComplemento("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
    }

    @Test
    public void nao_deve_aceitar_complemento_vazio() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(COMPLEMENTO_VAZIO);
        endereco.setComplemento("");
    }
    @Test
    public void nao_deve_aceitar_complemento_nulo() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(COMPLEMENTO_NULO);
        endereco.setComplemento(null);
    }

    @Test
    public void nao_deve_aceitar_cep_invalido() {
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage(CEP_INVALIDO);
        endereco.setCep("054515");
    }
}
