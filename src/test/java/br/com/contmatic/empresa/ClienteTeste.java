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


public class ClienteTeste {
    private Cliente cliente;


    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Iniciamos os testes na classe cliente");
    }

    @Before
    public void setBeforeCliente() {
        cliente = new Cliente();
        produtos.add(new Produto("produtoA", "110", quantidade, valor));

    }
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void deve_aceitar_nome_correto() {
        cliente.setNome("lucas");
        assertEquals(cliente.getNome(), "lucas");
    }

    @Test
    public void deve_aceitar_cpf_correto() {
        cliente.setCpf("50279302835");
        assertEquals(cliente.getCpf(), "50279302835");
    }

    @Test
    public void deve_aceitar_produto_correto() {
        cliente.setProdutos(produtos);
        assertEquals(cliente.getProdutos(), produtos);
    }

    @Test
    public void testClienteEqualsAndHashCode() {
        Cliente clientePadrao = new Cliente("502793028385", "João", produtos);

        assertEquals(clienteCompleto.hashCode(), clientePadrao.hashCode());
        assertNotEquals(clienteCompleto.hashCode(), clienteErrado.hashCode());

        assertTrue(clienteCompleto.equals(clientePadrao));
        assertFalse(clienteErrado.equals(clienteCompleto));
    }

    @Test
    public void testClienteToString() {
        String expectedString = "Cliente {nome= João, produtos= [Produto {nome= produtoA, Id= 110, quantidade= 1000, valor= 1000}]}";
        assertEquals(expectedString, clienteCompleto.toString());
    }

    @Test
    public void nao_deve_aceitar_nome_menor_que_3() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(TAMANHO_DE_CLIENTE_ESTA_ABAIXO_DE_2_CARACTERES);
        cliente.setNome("sh");
    }

    @Test
    public void nao_deve_aceitar_nome_maior_que_60() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(TAMANHO_DE_CLIENTE_ESTA_ACIMA_DE_60_CARACTERES);
        cliente.setNome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }

    @Test
    public void nao_deve_aceitar_nome_se_numeros() {
        exceptionRule.expect(IllegalArgumentException.class);
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
        exceptionRule.expectMessage(PRODUTO_ESTA_ACIMA_DE_60_CARACTERES);
        List<Produto> produtos = new ArrayList<>();
        produtos.add(null);
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
    public void nao_deve_aceitar_cpf_com_menos_de_11_caracteres() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CPF_ESTA_REPETIDO);
        cliente.setCpf("545");
    }

    @Test
    public void nao_deve_aceitar_cpf_com_mais_de_11_caracteres() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CPF_ESTA_REPETIDO);
        cliente.setCpf("502793028356");
    }


}
