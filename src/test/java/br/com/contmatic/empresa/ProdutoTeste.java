package br.com.contmatic.empresa;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigDecimal;

public class ProdutoTeste {

    private Produto produto;
    private BigDecimal valor = new BigDecimal(1000);
    private BigDecimal quantidade = new BigDecimal(12);
    private Produto produtoCompleto = new Produto("Produto soja", "3232", quantidade, valor);
    private Produto produtoErrado = new Produto("Produto pao", "2222", quantidade, valor);

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Iniciamos os testes na classe Cargo");
    }

    @Before
    public void setBeforeProduto(){
        produto = new Produto();
    }

    @Test
    public void deve_aceitar_nome_correto() {
        produto.setNome("lucas");
        assertEquals(produto.getNome(), "lucas");
    }

    @Test
    public void deve_aceitar_id_correto() {
        produto.setId("abc2332");
        assertEquals(produto.getId(), "abc2332");

    }

    @Test
    public void aceitar_quantidade_correta() {
        produto.setQuantidade(quantidade);
        assertEquals(produto.getQuantidade(), quantidade);
    }
    @Test
    public void aceitar_salario_correto() {
        produto.setValor(valor);
        assertEquals(produto.getValor(), valor);
    }
    @Test
    public void testCargoEqualsAndHashCode() {
        Produto produtoPadrao = new Produto("Produto soja", "3232", quantidade, valor);

        assertEquals(produtoCompleto.hashCode(), produtoPadrao.hashCode());
        assertNotEquals(produtoCompleto.hashCode(), produtoErrado.hashCode());

        assertTrue(produtoCompleto.equals(produtoPadrao));
        assertFalse(produtoErrado.equals(produtoCompleto));
    }

    @Test
    public void testCargoToString() {
        String expectedString = "Produto {nome= Produto soja, Id= 3232, quantidade= 12, valor= 1000}";
        assertEquals(expectedString, produtoCompleto.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_menor_que_2() {
        produto.setNome("s");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_maior_que_60() {
        produto.setNome("shshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshsh");
    }
    @Test(expected = IllegalArgumentException.class)
    public void nome_nao_deve_aceitar_numeros_() {
        produto.setNome("3223232");
    }

    @Test(expected = NullPointerException.class)
    public void nao_deve_aceitar_nome_nulo() {
        produto.setNome(null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_vazio() {
        produto.setNome("");
    }
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_id_nulo() {
        produto.setId("");
    }
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_id_menor_que_2() {
        produto.setId("s");
    }
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_quantidade_zerada() {
        BigDecimal quantidade = new BigDecimal(0);
        produto.setQuantidade(quantidade);
    }
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_valor_zerado() {
        BigDecimal valor = new BigDecimal(0);
        produto.setValor(valor);
    }
}
