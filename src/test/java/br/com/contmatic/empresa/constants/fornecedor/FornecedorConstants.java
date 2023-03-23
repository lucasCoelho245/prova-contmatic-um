package br.com.contmatic.empresa.constants.fornecedor;

import br.com.contmatic.contato.Contato;
import br.com.contmatic.contato.Telefone;
import br.com.contmatic.empresa.Fornecedor;
import br.com.contmatic.empresa.Produto;
import br.com.contmatic.endereco.Endereco;

import java.util.ArrayList;
import java.util.List;

public final class FornecedorConstants {
    public static final String NOME_VAZIO = "O Campo nome em fornecedor está vazio";
    public static final String NOME_CURTO = "Tamanho de string nome em fornecedor está abaixo de 3 caracteres";
    public static final String NOME_LONGO = "Tamanho de string nome em fornecedor está acima de 30 caracteres";
    public static final String NOME_NUMERICO = "nome em fornecedor não pode ter caracteres numeros";
    public static final String CONTATO_NULO = "contatos em fornecedor não pode ser nulo";
    public static final String ENDERECO_NULO = "endereco em fornecedor não pode ser nulo";
    public static final String PRODUTO_NULO = "produtos em fornecedor não pode ser nulo";
    public static final String CNPJ_INVALIDO_REPETIDO = "O CNPJ tem caracteres repetidos ou está fora da formatação padrão";
    public static final String CNPJ_VAZIO = "O Campo CNPJ em fornecedor está vazio";
    public static final String CNPJ_INVALIDO = "O CNPJ está invalido";
    public static final List<Telefone> telefones = new ArrayList<>();
    public static final List<Contato> contatos = new ArrayList<>();
    public static final List<Produto> produtos = new ArrayList<>();
    public static final List<Endereco> enderecos = new ArrayList<>();
    public static final Fornecedor fornecedorCompleto = new Fornecedor("26631884000176", "julio", produtos, contatos, enderecos);
    public static final Fornecedor fornecedorErrado = new Fornecedor("25531884000176", "joao", produtos, contatos, enderecos);
    public static final Fornecedor fornecedorPadrao = new Fornecedor("26631884000176", "julio", produtos, contatos, enderecos);


}
