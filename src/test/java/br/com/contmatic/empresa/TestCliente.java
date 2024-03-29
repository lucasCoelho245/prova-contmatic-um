package br.com.contmatic.empresa;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static br.com.contmatic.empresa.constants.cliente.ClienteConstants.*;
import static org.junit.Assert.*;
import static org.junit.rules.ExpectedException.*;


public class TestCliente {
    private Cliente cliente;

    @Rule
    public ExpectedException exceptionRule = none();

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Iniciamos os testes na classe cliente");
        produtos.add(new Produto("produtoA", "110", quantidade, valor));
        clienteErrado = new Cliente("12640907816", "julio", produtos);
        clienteCompleto = new Cliente("50279302835", "João", produtos);
        clientePadrao = new Cliente("50279302835", "João", produtos);
    }

    @Before
    public void setBeforeCliente() {
        cliente = new Cliente();
    }

    @Test
    public void deve_aceitar_nome_correto() {
        cliente.setNome("lucas");
        assertEquals("lucas", cliente.getNome());
    }

    @Test
    public void deve_aceitar_cpf_correto() {
        cliente.setCpf("50279302835");
        assertEquals("50279302835", cliente.getCpf());
    }

    @Test
    public void deve_aceitar_produto_correto() {
        cliente.setProdutos(produtos);
        assertEquals(produtos, cliente.getProdutos());
    }

    @Test
    public void testClienteHashCodeTrue() {
        assertEquals(clienteCompleto.hashCode(), clientePadrao.hashCode());
    }
    @Test
    public void testClienteHashCodeFalse() {
        assertNotEquals(clienteCompleto.hashCode(), clienteErrado.hashCode());
    }
    @Test
    public void testClienteEqualsTrue() {
        assertEquals(clienteCompleto, clientePadrao);
    }
    @Test
    public void testClienteEqualsFalse() {
        assertNotEquals(clienteErrado, clienteCompleto);
    }

    @Test
    public void testClienteToString() {
        String expectedString = "Cliente {nome= João, produtos= [Produto {nome= produtoA, Id= 110, quantidade= 100, valor= 100}]}";
        assertEquals(expectedString, clienteCompleto.toString());
    }

    @Test
    public void nao_deve_aceitar_nome_menor_que_3() {
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage(TAMANHO_DE_CLIENTE_ESTA_ABAIXO_DE_2_CARACTERES);
        cliente.setNome("sh");
    }

    @Test
    public void nao_deve_aceitar_nome_maior_que_60() {
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage(TAMANHO_DE_CLIENTE_ESTA_ACIMA_DE_60_CARACTERES);
        cliente.setNome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }

    @Test
    public void nao_deve_aceitar_nome_se_numeros() {
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage(CLIENTE_ESTA_COM_CARACTERES_NUMEROS);
        cliente.setNome("5454545544");
    }

    @Test
    public void nao_deve_aceitar_nome_se_vazio() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CLIENTE_ESTA_VAZIO);
        cliente.setNome(" ");
    }

    @Test
    public void nao_deve_aceitar_nome_se_nulo() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CLIENTE_ESTA_NULO);
        cliente.setNome(null);
    }

    @Test
    public void nao_deve_aceitar_produto_se_nulo() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(PRODUTO_ESTA_NULO);
        List<Produto> produtos = null;
        cliente.setProdutos(produtos);
    }
    @Test
    public void nao_deve_aceitar_produto_se_vazio() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(PRODUTO_ESTA_VAZIO);
        List<Produto> produtos = new ArrayList<>();
        cliente.setProdutos(produtos);
    }

    @Test
    public void nao_deve_aceitar_cpf_se_vazio() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CPF_ESTA_VAZIO);
        cliente.setCpf(" ");
    }

    @Test
    public void nao_deve_aceitar_cpf_se_caracter_repetido() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CPF_ESTA_REPETIDO);
        cliente.setCpf("44444444444");
    }

    @Test
    public void nao_deve_aceitar_cpf_se_invalido() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CPF_ESTA_INVALIDO);
        cliente.setCpf("88844477458");
    }

    @Test
    public void nao_deve_aceitar_cpf_com_mais_de_11_caracteres() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CPF_ESTA_REPETIDO);
        cliente.setCpf("507932322332302835");
    }
}
