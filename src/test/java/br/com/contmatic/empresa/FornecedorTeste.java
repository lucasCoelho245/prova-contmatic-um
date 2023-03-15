package br.com.contmatic.empresa;

import br.com.contmatic.contato.Contato;
import br.com.contmatic.contato.Telefone;
import br.com.contmatic.endereco.Endereco;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static br.com.contmatic.contato.DDDType.DDD11;

public class FornecedorTeste {
    private Fornecedor fornecedor;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Iniciamos os testes na classe fornecedor");
    }

    @Before
    public void setBeforeFornecedor(){
        fornecedor = new Fornecedor();
    }

    @Test
    public void deve_aceitar_nome_correto(){
        fornecedor.setNome("salgadelicia");
    }
    @Test
    public void deve_aceitar_contato_valido() {
        List<Telefone> telefones = new ArrayList<>();
        telefones.add(new Telefone(DDD11, 555, "941584007"));
        List<Contato> contatos = new ArrayList<>();
        contatos.add(new Contato("contmatic@gmail.com", telefones));
        fornecedor.setContatos(contatos);
    }
    @Test
    public void deve_aceitar_cnpj_correto() {
        fornecedor.setCnpj("26631884000176");
    }
    @Test
    public void deve_aceitar_produto_correto() {
        List<Produto> produtos = new ArrayList<>();
        BigDecimal valor = new BigDecimal(1000);
        BigDecimal quantidade = new BigDecimal(1000);
        produtos.add(new Produto("produtoA", "110", quantidade, valor));
        fornecedor.setProdutos(produtos);
    }
    @Test
    public void deve_aceitar_endereco_correto() {
        List<Endereco> enderecos = new ArrayList<>();
        enderecos.add(new Endereco(232, "0123500", "teste"));
        fornecedor.setEnderecos(enderecos);
    }
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_mais_30_caracteres () {
        fornecedor.setNome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_menor_que_3() {
        fornecedor.setNome("s");
    }
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nulo() {
        fornecedor.setNome("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numero() {
        fornecedor.setNome("3223");
    }
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_contato_nulo() {
        List<Contato> contatos = new ArrayList<>();
        contatos.add(null);
        fornecedor.setContatos(contatos);
    }
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_enderecos_nulo() {
        List<Endereco> enderecos = new ArrayList<>();
        enderecos.add(null);
        fornecedor.setEnderecos(enderecos);
    }
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_produtos_nulo() {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(null);
        fornecedor.setProdutos(produtos);
    }
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_com_caracteres_iguais() {
        fornecedor.setCnpj("00000000000000");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_invalido() {
        fornecedor.setCnpj("74756244765647");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_com_mais_de_14_caracteres() {
        fornecedor.setCnpj("7475624476564722232");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_com_menos_de_14_caracteres() {
        fornecedor.setCnpj("5454");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_nulo() {
        fornecedor.setCnpj(" ");
    }

}
