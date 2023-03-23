package br.com.contmatic.utils;

import java.time.LocalDateTime;

public final class UtilsConstantes {

    private UtilsConstantes() {}
    public static final String NOME_CLASSE_AUDITORIA = "auditoria";
    public static final String LOGIN_DA_CRIACAO = "login criacao";
    public static final String LOGIN_DA_ALTERACAO = "login alteracao";
    public static final String IP_DA_CRIACAO = "ipcriacao";
    public static final String CONTATO_EMPRESA = "contato";
    public static final String NOME_CLASSE_TELEFONE = "telefone";
    public static final String NUMERO_TELEFONE = "numero";
    public static final String SETOR_CARGO = "setorCargo";
    public static final String NOME_CLASSE_CARGO = "cargo";
    public static final String NOME_CARGO = "nome";
    public static final String NOME_CLASSE_CLIENTE = "cliente";
    public static final String NOME_CLIENTE = "nome";
    public static final String PRODUTO_CLIENTE = "produto";
    public static final String CPF_CLIENTE = "cpf";
    public static final String NOME_CLASSE_EMPRESA = "empresa";
    public static final String NOME_CLASSE_FORNECEDOR = "fornecedor";
    public static final String FORNECEDOR_EMPRESA = "nome";
    public static final String FORNECEDOR_PRODUTO = "produtos";
    public static final String FORNECEDOR_CNPJ = "CNPJ";
    public static final String FORNECEDOR_CONTATO = "contatos";
    public static final String FORNECEDOR_ENDERECO = "endereco";
    public static final String NOME_CLASSE_FUNCIONARIO = "funcionario";
    public static final String FUNCIONARIO_NOME = "nome";
    public static final String FUNCIONARIO_CARGO = "cargo";
    public static final String FUNCIONARIO_EMPRESA = "empresa";
    public static final String NOME_CLASSE_PRODUTO = "produto";
    public static final String PRODUTO_NOME = "nome";
    public static final String PRODUTO_ID = "id";
    public static final String PRODUTO_QUANTIDADE = "quantidade";
    public static final String PRODUTO_VALOR = "valor";
    public static final String NOME_CLASSE_ENDERECO = "endereco";
    public static final String ENDERECO_LOGRADOURO = "logradouro";
    public static final String ENDERECO_NUMERO = "numero";
    public static final String ENDERECO_BAIRRO = "bairro";
    public static final String ENDERECO_CIDADE = "cidade";
    public static final String ENDERECO_COMPLEMENTO = "complemento";
    public static final String ENDERECO_CEP = "cep";
    public static final LocalDateTime localDate = LocalDateTime.now();
    public static final Integer ANO_ATUAL = localDate.getYear();
    public static final Integer MES_ATUAL = localDate.getMonthValue();
    public static final Integer DIA_ATUAL = localDate.getDayOfMonth();
    public static final String DATA_CAMPO = "a data do campo ";
}
