package br.com.contmatic.empresa;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

import static br.com.contmatic.empresa.constants.produto.ProdutoConstants.*;
import static org.junit.Assert.*;
import static org.junit.rules.ExpectedException.none;

public class TestProduto {
    private Produto produto;

    @Rule
    public ExpectedException exceptionRule = none();

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Iniciamos os testes na classe Cargo");
    }

    @Before
    public void setBeforeProduto() {
        produto = new Produto();
    }
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
        assertEquals(quantidade, produto.getQuantidade());
    }

    @Test
    public void aceitar_salario_correto() {
        produto.setValor(valor);
        assertEquals(valor, produto.getValor());
    }

    @Test
    public void testProdutoHashCodeTrue() {
        assertEquals(produtoCompleto.hashCode(), produtoPadrao.hashCode());
    }
    @Test
    public void testProdutoHashCodeFalse() {
        assertNotEquals(produtoCompleto.hashCode(), produtoErrado.hashCode());
    }
    @Test
    public void testProdutoEqualsTrue() {
        assertEquals(produtoCompleto, produtoPadrao);
    }
    @Test
    public void testProdutoEqualsFalse() {
        assertNotEquals(produtoErrado, produtoCompleto);
    }

    @Test
    public void testCargoToString() {
        String expectedString = "Produto {nome= Produto soja, Id= 3232, quantidade= 12, valor= 1000}";
        assertEquals(expectedString, produtoCompleto.toString());
    }

    @Test
    public void nao_deve_aceitar_nome_menor_que_2() {
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage(CAMPO_NOME_CURTO);
        produto.setNome("s");
    }

    @Test
    public void nao_deve_aceitar_nome_maior_que_60() {
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage(CAMPO_NOME_LONGO);
        produto.setNome("shshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshsh");
    }

    @Test
    public void nome_nao_deve_aceitar_numeros() {
        exceptionRule.expect(IllegalStateException.class);
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
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage(CAMPO_ID_CURTO);
        produto.setId("s");
    }

    @Test
    public void nao_deve_aceitar_quantidade_menor_que_esperado() {
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage(CAMPO_QUANTIDADE_MENOR);
        BigDecimal quantidade = new BigDecimal(0);
        produto.setQuantidade(quantidade);
    }

    @Test
    public void nao_deve_aceitar_valor_menor_que_esperado() {
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage(CAMPO_VALOR_MENOR);
        BigDecimal valor = new BigDecimal(0);
        produto.setValor(valor);
    }
}
