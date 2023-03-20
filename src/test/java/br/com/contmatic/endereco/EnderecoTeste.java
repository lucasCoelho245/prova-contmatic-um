package br.com.contmatic.endereco;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static br.com.contmatic.empresa.constants.endereco.enderecoConstants.*;
import static br.com.contmatic.endereco.UFType.MA;
import static org.junit.Assert.*;

public class EnderecoTeste {
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
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void deve_aceitar_logradouro_correto() {
        endereco.setLogradouro("avenida brasil");
        assertEquals(endereco.getLogradouro(), "avenida brasil");
    }

    @Test
    public void deve_aceitar_uf_correto() {
        endereco.setUf(MA);
        assertEquals(endereco.getUf(), MA);
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
        assertEquals(endereco.getCep(), "01235-000");
    }

    @Test
    public void deve_aceitar_bairro_correto() {
        endereco.setBairro("barata ribeiro");
        assertEquals(endereco.getBairro(), "barata ribeiro");

    }

    @Test
    public void deve_aceitar_cidade_correto() {
        endereco.setCidade("são paulo");
        assertEquals(endereco.getCidade(), "são paulo");
    }

    @Test
    public void deve_aceitar_complemento_correto() {
        endereco.setComplemento("apto61");
        assertEquals(endereco.getComplemento(), "apto61");
    }

    @Test
    public void testEnderecoEqualsAndHashCode() {
        Endereco enderecoPadrao = new Endereco("cambuci", 22, "barata Ribeiro", "01235000", MA, "apto 61", "01233300");
        assertEquals(enderecoCompleto.hashCode(), enderecoPadrao.hashCode());
        assertNotEquals(enderecoCompleto.hashCode(), enderecoErrado.hashCode());

        assertTrue(enderecoCompleto.equals(enderecoPadrao));
        assertFalse(enderecoErrado.equals(enderecoCompleto));
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
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(BAIRRO_CURTO);
        endereco.setBairro("ww");
    }

    @Test
    public void nao_deve_aceitar_bairro_com_mais_de_20_caracteres() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(BAIRRO_LONGO);
        endereco.setBairro("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
    }

    @Test
    public void nao_deve_aceitar_bairro_com_numeros() {
        exceptionRule.expect(IllegalArgumentException.class);
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
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CIDADE_CURTA);
        endereco.setCidade("ww");
    }

    @Test
    public void nao_deve_aceitar_cidade_com_mais_de_20_caracteres() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CIDADE_CURTA);
        endereco.setCidade("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
    }

    @Test
    public void nao_deve_aceitar_cidade_com_numeros() {
        exceptionRule.expect(IllegalArgumentException.class);
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
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(COMPLEMENTO_CURTO);
        endereco.setComplemento("ww");
    }

    @Test
    public void nao_deve_aceitar_complemento_com_mais_de_20_caracteres() {
        exceptionRule.expect(IllegalArgumentException.class);
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
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CEP_INVALIDO);
        endereco.setCep("054515");
    }
}
