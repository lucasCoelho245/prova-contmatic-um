package br.com.contmatic.empresa;

import org.junit.Before;
import org.junit.Test;
import org.junit.BeforeClass;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class ClienteTeste {
    private Cliente cliente;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Iniciamos os testes na classe cliente");
    }

    @Before
    public void setBeforeCliente() {
        cliente = new Cliente();
    }

    @Test
    public void deve_aceitar_nome_correto() {
        cliente.setNome("lucas");
    }
    @Test
    public void deve_aceitar_cpf_correto() {
        cliente.setCpf("50279302835");
    }
    @Test
    public void deve_aceitar_produto_correto() {
        List<Produto> produtos = new ArrayList<>();
        BigDecimal valor = new BigDecimal(1000);
        BigDecimal quantidade = new BigDecimal(1000);
        produtos.add(new Produto("produtoA", "110", quantidade, valor));
        cliente.setProdutos(produtos);
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
