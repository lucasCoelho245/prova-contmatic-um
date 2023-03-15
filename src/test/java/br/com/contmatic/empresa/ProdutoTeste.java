package br.com.contmatic.empresa;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigDecimal;

public class ProdutoTeste {

    private Produto produto;

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
        BigDecimal quantidade = new BigDecimal(12);
        produto.setQuantidade(quantidade);
        assertEquals(produto.getQuantidade(), quantidade);
    }
    @Test
    public void aceitar_salario_correto() {
        BigDecimal salario = new BigDecimal(1000);
        produto.setValor(salario);
        assertEquals(produto.getValor(), salario);
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
