package br.com.contmatic.empresa;

import br.com.contmatic.contato.Contato;
import br.com.contmatic.contato.Telefone;
import br.com.contmatic.endereco.Endereco;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static br.com.contmatic.contato.DDDType.DDD11;
import static br.com.contmatic.empresa.constants.fornecedor.FornecedorConstants.*;
import static br.com.contmatic.endereco.UFType.MA;
import static org.junit.Assert.*;
import static org.junit.rules.ExpectedException.none;

public class TestFornecedor {
    private Fornecedor fornecedor;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Iniciamos os testes na classe fornecedor");

        telefones.add(new Telefone(DDD11, 555, "941584007"));
        contatos.add(new Contato("contmatic@gmail.com", telefones));
        BigDecimal valor = new BigDecimal(1000);
        BigDecimal quantidade = new BigDecimal(1000);
        produtos.add(new Produto("produtoA", "110", quantidade, valor));
        enderecos.add(new Endereco("cambuci", 22, "barata Ribeiro" ,"01235000", MA ,"apto 61", "01233300"));
    }

    @Before
    public void setBeforeFornecedor(){
        fornecedor = new Fornecedor();
    }
    @Rule
    public ExpectedException exceptionRule = none();
    @Test
    public void deve_aceitar_nome_correto(){
        fornecedor.setNome("salgadelicia");
        assertEquals("salgadelicia", fornecedor.getNome());
    }
    @Test
    public void deve_aceitar_contato_valido() {
        fornecedor.setContatos(contatos);
        assertEquals(contatos, fornecedor.getContatos());
    }
    @Test
    public void deve_aceitar_cnpj_correto() {
        fornecedor.setCnpj("26631884000176");
        assertEquals("26631884000176", fornecedor.getCnpj());

    }
    @Test
    public void deve_aceitar_produto_correto() {

        fornecedor.setProdutos(produtos);
        assertEquals(produtos, fornecedor.getProdutos());
    }
    @Test
    public void deve_aceitar_endereco_correto() {
        fornecedor.setEnderecos(enderecos);
        assertEquals(enderecos, fornecedor.getEnderecos());
    }
    @Test
    public void testFornecedorHashCodeTrue() {
        assertEquals(fornecedorCompleto.hashCode(), fornecedorPadrao.hashCode());
    }
    @Test
    public void testFornecedorHashCodeFalse() {
        assertNotEquals(fornecedorCompleto.hashCode(), fornecedorErrado.hashCode());
    }
    @Test
    public void testFornecedorEqualsTrue() {
        assertEquals(fornecedorCompleto, fornecedorPadrao);
    }
    @Test
    public void testFornecedorEqualsFalse() {
        assertNotEquals(fornecedorErrado, fornecedorCompleto);
    }

    @Test
    public void testCargoToString() {
        String expectedString = "Fornecedor {nome= julio, produtos= [Produto {nome= produtoA, Id= 110, quantidade= 1000, valor= 1000}], cnpj= 26631884000176, contatos= [Contato {email= contmatic@gmail.com, telefones= [Telefone {DDD= DDD11, DDDI= 555, numero= 941584007]}], enderecos= [Endereco {logradouro= cambuci, numero= 22, bairro= barata Ribeiro, cidade= 01235000, uf= MA, complemento= apto 61, cep= 01233300}]}";
        assertEquals(expectedString, fornecedorCompleto.toString());
    }

    @Test
    public void nao_deve_aceitar_mais_30_caracteres () {
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage(NOME_LONGO);
        fornecedor.setNome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }
    @Test
    public void nao_deve_aceitar_nome_menor_que_3() {
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage(NOME_CURTO);
        fornecedor.setNome("s");
    }
    @Test
    public void nao_deve_aceitar_nulo() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(NOME_VAZIO);
        fornecedor.setNome("");
    }

    @Test
    public void nao_deve_aceitar_numero() {
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage(NOME_NUMERICO);
        fornecedor.setNome("54651561561");
    }
    @Test
    public void nao_deve_aceitar_contato_nulo() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CONTATO_NULO);
        List<Contato> contatos = new ArrayList<>();
        contatos.add(null);
        fornecedor.setContatos(contatos);
    }
    @Test
    public void nao_deve_aceitar_enderecos_nulo() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(ENDERECO_NULO);
        List<Endereco> enderecos = new ArrayList<>();
        enderecos.add(null);
        fornecedor.setEnderecos(enderecos);
    }
    @Test
    public void nao_deve_aceitar_produtos_nulo() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(PRODUTO_NULO);
        List<Produto> produtos = new ArrayList<>();
        produtos.add(null);
        fornecedor.setProdutos(produtos);
    }
    @Test
    public void nao_deve_aceitar_cnpj_com_caracteres_iguais() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CNPJ_INVALIDO_REPETIDO);
        fornecedor.setCnpj("00000000000000");
    }

    @Test
    public void nao_deve_aceitar_cnpj_invalido() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CNPJ_INVALIDO);
        fornecedor.setCnpj("74756244765647");
    }

    @Test
    public void nao_deve_aceitar_cnpj_com_menos_de_14_caracteres() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CNPJ_INVALIDO_REPETIDO);
        fornecedor.setCnpj("5454");
    }

    @Test
    public void nao_deve_aceitar_cnpj_nulo() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CNPJ_VAZIO);
        fornecedor.setCnpj(" ");
    }

}
