package br.com.contmatic.empresa.constants.produto;

import br.com.contmatic.empresa.Produto;

import java.math.BigDecimal;

public final class ProdutoConstants {
    public static final BigDecimal valor = new BigDecimal(1000);
    public static final BigDecimal quantidade = new BigDecimal(12);
    public static final Produto produtoCompleto = new Produto("Produto soja", "3232", quantidade, valor);
    public static final Produto produtoErrado = new Produto("Produto pao", "2222", quantidade, valor);
    public static final String CAMPO_NOME_CURTO = ("Tamanho de string nome em produto está abaixo de 3 caracteres");
    public static final String CAMPO_NOME_LONGO = ("Tamanho de string nome em produto está acima de 60 caracteres");
    public static final String CAMPO_NOME_NUMEROS = ("nome em produto não pode ter caracteres numeros ");
    public static final String CAMPO_NOME_NULO = ("nome em produto não pode ser nulo");
    public static final String CAMPO_NOME_VAZIO = ("O Campo nome em produto está vazio");
    public static final String CAMPO_ID_CURTO = ("Tamanho de string id em produto está abaixo de 2 caracteres");
    public static final String CAMPO_ID_NULO = ("id em produto não pode ser nulo");
    public static final String CAMPO_ID_VAZIO = ("O Campo id em produto está vazio");
    public static final String CAMPO_VALOR_MENOR = ("Tamanho de string valor em produto está abaixo de 3 caracteres");
    public static final String CAMPO_QUANTIDADE_MENOR = ("Tamanho de string quantidade em produto está abaixo de 1 caracteres");
    public static final Produto produtoPadrao = new Produto("Produto soja", "3232", quantidade, valor);

}
