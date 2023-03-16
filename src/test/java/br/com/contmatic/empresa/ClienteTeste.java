package br.com.contmatic.empresa;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class ClienteTeste {
    private Cliente cliente;
    List<Produto> produtos = new ArrayList<>();

    private Cliente clienteCompleto = new Cliente("502793028385", "João", produtos);
    private Cliente clienteErrado = new Cliente("2324354445", "julio", produtos);
    private BigDecimal valor = new BigDecimal(1000);
    private BigDecimal quantidade = new BigDecimal(1000);

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Iniciamos os testes na classe cliente");
    }

    @Before
    public void setBeforeCliente() {
        cliente = new Cliente();
        produtos.add(new Produto("produtoA", "110", quantidade, valor));

    }

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

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_menor_que_3() {
        cliente.setNome("sh");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_maior_que_60() {
        cliente.setNome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_se_numeros() {
        cliente.setNome("5454545544");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_se_nulo() {
        cliente.setNome(" ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_produto_se_nulo() {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(null);
        cliente.setProdutos(produtos);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_se_nulo() {
        cliente.setCpf(" ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_se_caracter_repetido() {
        cliente.setCpf("44444444444");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_se_invalido() {
        cliente.setCpf("88844477458");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_menos_de_11_caracteres() {
        cliente.setCpf("545");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_mais_de_11_caracteres() {
        cliente.setCpf("502793028356");
    }


}
