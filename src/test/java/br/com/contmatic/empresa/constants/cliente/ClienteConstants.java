package br.com.contmatic.empresa.constants.cliente;

import br.com.contmatic.empresa.Cliente;
import br.com.contmatic.empresa.Produto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class ClienteConstants {
    public static final String TAMANHO_DE_CLIENTE_ESTA_ABAIXO_DE_2_CARACTERES = ("Tamanho de string nome em cliente está abaixo de 3 caracteres");
    public static final String TAMANHO_DE_CLIENTE_ESTA_ACIMA_DE_60_CARACTERES = ("Tamanho de string nome em cliente está acima de 60 caracteres");
    public static final String CLIENTE_ESTA_COM_CARACTERES_NUMEROS = ("nome em cliente não pode ter caracteres numeros");
    public static final String CLIENTE_ESTA_VAZIO = ("O Campo nome em cliente está vazio");
    public static final String CLIENTE_ESTA_NULO = ("nome em cliente não pode ser nulo");
    public static final String PRODUTO_ESTA_NULO = "produto em cliente não pode ser nulo";
    public static final String PRODUTO_ESTA_VAZIO = "O Campo produto em cliente está vazio";
    public static final String CPF_ESTA_VAZIO = ("O Campo cpf em cliente está vazio");
    public static final String CPF_ESTA_INVALIDO = ("O CPF está invalido");
    public static final String CPF_ESTA_REPETIDO = ("CPF esta com caracteres repetidos ou diferente do numeracao padrao");
    public static List<Produto> produtos = new ArrayList<>();
    public static  Cliente clientePadrao = new Cliente();
    public static Cliente clienteCompleto = new Cliente();
    public static Cliente clienteErrado = new Cliente();
    public static final BigDecimal valor = new BigDecimal(100);
    public static final BigDecimal quantidade = new BigDecimal(100);

}
