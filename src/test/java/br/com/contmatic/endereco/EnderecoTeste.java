package br.com.contmatic.endereco;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static br.com.contmatic.endereco.UFType.AP;
import static org.junit.Assert.*;

import static br.com.contmatic.endereco.UFType.MA;

public class EnderecoTeste {

    private Endereco endereco;

    private Endereco enderecoCompleto = new Endereco("cambuci", 22, "barata Ribeiro" ,"01235000", MA ,"apto 61", "01233300");;
    private Endereco enderecoErrado = new Endereco("cambu", 232, "barata" ,"01231000", AP ,"apto", "01235300");;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Iniciamos os testes na classe fornecedor");
    }

    @Before
    public void setBeforeEndereco() {
        endereco = new Endereco();
    }

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
        endereco.setCep("01235000");
        assertEquals(endereco.getCep(), "01235000");
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
    public void testEnderecoEqualsAndHashCode() {
        Endereco enderecoPadrao = new Endereco("cambuci", 22, "barata Ribeiro" ,"01235000", MA ,"apto 61", "01233300");
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
    @Test(expected = NullPointerException.class)
    public void nao_deve_aceitar_numero_nulo() {
        endereco.setNumero(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_bairro_com_menos_de_3_caracteres() {
        endereco.setBairro("ww");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_bairro_com_mais_de_20_caracteres() {
        endereco.setBairro("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_bairro_com_numeros() {
        endereco.setBairro("74145");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_bairro_nulo() {
        endereco.setBairro("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cidade_com_menos_de_3_caracteres() {
        endereco.setCidade("ww");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cidade_com_mais_de_20_caracteres() {
        endereco.setCidade("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cidade_com_numeros() {
        endereco.setCidade("74145");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cidade_nulo() {
        endereco.setCidade("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_complemento_com_menos_de_3_caracteres() {
        endereco.setComplemento("ww");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_complemento_com_mais_de_20_caracteres() {
        endereco.setComplemento("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_complemento_com_numeros() {
        endereco.setComplemento("74145");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_complemento_nulo() {
        endereco.setComplemento("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cep_invalido() {
        endereco.setComplemento("054515");
    }
}
