package br.com.contmatic.empresa;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

import static br.com.contmatic.empresa.constants.produto.ProdutoConstants.*;
import static org.junit.Assert.*;

public class ProdutoTeste {

    private Produto produto;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Iniciamos os testes na classe Cargo");
    }

    @Before
    public void setBeforeProduto() {
        produto = new Produto();
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Test
    public void deve_aceitar_nome_correto() {
        produto.setNome("lucas");
        assertEquals("lucas", produto.getNome());
    }

    @Test
    public void deve_aceitar_id_correto() {
        produto.setId("abc2332");
        assertEquals("abc2332", produto.getId());

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

    @Test
    public void nao_deve_aceitar_nome_menor_que_2() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CAMPO_NOME_CURTO);
        produto.setNome("s");
    }

    @Test
    public void nao_deve_aceitar_nome_maior_que_60() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CAMPO_NOME_LONGO);
        produto.setNome("shshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshsh");
    }

    @Test
    public void nome_nao_deve_aceitar_numeros() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CAMPO_NOME_NUMEROS);
        produto.setNome("3223232");
    }

    @Test
    public void nao_deve_aceitar_nome_nulo() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CAMPO_NOME_NULO);
        produto.setNome(null);
    }

    @Test
    public void nao_deve_aceitar_nome_vazio() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CAMPO_NOME_VAZIO);
        produto.setNome("");
    }

    @Test
    public void nao_deve_aceitar_id_vazio() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CAMPO_ID_VAZIO);
        produto.setId("");
    }
    @Test
    public void nao_deve_aceitar_id_nulo() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CAMPO_ID_NULO);
        produto.setId(null);
    }

    @Test
    public void nao_deve_aceitar_id_menor_que_2() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CAMPO_ID_CURTO);
        produto.setId("s");
    }

    @Test
    public void nao_deve_aceitar_quantidade_menor_que_esperado() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CAMPO_QUANTIDADE_MENOR);
        BigDecimal quantidade = new BigDecimal(0);
        produto.setQuantidade(quantidade);
    }

    @Test
    public void nao_deve_aceitar_valor_menor_que_esperado() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CAMPO_VALOR_MENOR);
        BigDecimal valor = new BigDecimal(0);
        produto.setValor(valor);
    }
}
