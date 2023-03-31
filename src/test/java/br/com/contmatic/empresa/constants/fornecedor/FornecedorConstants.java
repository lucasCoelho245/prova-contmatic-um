package br.com.contmatic.empresa.constants.fornecedor;

import br.com.contmatic.contato.Contato;
import br.com.contmatic.contato.Telefone;
import br.com.contmatic.empresa.Fornecedor;
import br.com.contmatic.empresa.Produto;
import br.com.contmatic.endereco.Endereco;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static br.com.contmatic.contato.DDDType.DDD11;
import static br.com.contmatic.endereco.UFType.MA;

public final class FornecedorConstants {
    public static final String NOME_VAZIO = "O Campo nome em fornecedor está vazio";
    public static final String NOME_CURTO = "Tamanho de string nome em fornecedor está abaixo de 3 caracteres";
    public static final String NOME_LONGO = "Tamanho de string nome em fornecedor está acima de 30 caracteres";
    public static final String NOME_NUMERICO = "nome em fornecedor não pode ter caracteres numeros";
    public static final String CONTATO_NULO = "contatos em fornecedor não pode ser nulo";
    public static final String CONTATO_VAZIO = "O Campo contatos em fornecedor está vazio";
    public static final String ENDERECO_NULO = "endereco em fornecedor não pode ser nulo";
    public static final String ENDERECO_VAZIO = "O Campo endereco em fornecedor está vazio";
    public static final String PRODUTO_NULO = "produtos em fornecedor não pode ser nulo";
    public static final String PRODUTO_VAZIO = "O Campo produtos em fornecedor está vazio";
    public static final String CNPJ_INVALIDO_REPETIDO = "O CNPJ tem caracteres repetidos ou está fora da formatação padrão";
    public static final String CNPJ_VAZIO = "O Campo CNPJ em fornecedor está vazio";
    public static final String CNPJ_INVALIDO = "O CNPJ está invalido";
    public static final BigDecimal valor = new BigDecimal(1000);
    public static final BigDecimal quantidade = new BigDecimal(1000);
    public static final List<Telefone> telefones = Arrays.asList(new Telefone(DDD11, "555", "941584007"));
    public static final List<Contato> contatos = Arrays.asList(new Contato("test@gmail.com", telefones));
    public static final List<Endereco> enderecos = Arrays.asList(new Endereco("cambuci", 22, "barata Ribeiro" ,"sao paulo", MA ,"apto 61", "01235-000"));
    public static final List<Produto> produtos = Arrays.asList(new Produto("produtoA", "110", quantidade, valor));
    public static final Fornecedor fornecedorCompleto = new Fornecedor("51340283000151", "julio", produtos, contatos, enderecos);
    public static final Fornecedor fornecedorErrado = new Fornecedor("15423393000113", "joao", produtos, contatos, enderecos);
    public static final Fornecedor fornecedorPadrao = new Fornecedor("51340283000151", "julio", produtos, contatos, enderecos);


}
