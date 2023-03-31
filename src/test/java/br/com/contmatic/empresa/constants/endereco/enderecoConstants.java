package br.com.contmatic.empresa.constants.endereco;

import br.com.contmatic.endereco.Endereco;

import static br.com.contmatic.endereco.UFType.AP;
import static br.com.contmatic.endereco.UFType.MA;

public final class enderecoConstants {
    public static final Endereco enderecoCompleto = new Endereco("cambuci", 22, "barata Ribeiro" ,"sao paulo", MA ,"apto 61", "01235-000");;
    public static final Endereco enderecoErrado = new Endereco("cambu", 232, "barata" ,"sao bernardp", AP ,"sdsds", "77824-430");;
    public static final Endereco enderecoPadrao = new Endereco("cambuci", 22, "barata Ribeiro" ,"sao paulo", MA ,"apto 61", "01235-000");
    public static final String NUMERO_NULO = ("numero em endereco não pode ser nulo");
    public static final String BAIRRO_CURTO = ("Tamanho de string bairro em endereco está abaixo de 3 caracteres");
    public static final String BAIRRO_LONGO = ("Tamanho de string bairro em endereco está acima de 20 caracteres");
    public static final String BAIRRO_COM_NUMEROS = ("bairro em endereco não pode ter caracteres numeros");
    public static final String BAIRRO_VAZIO = ("O Campo bairro em endereco está vazio");
    public static final String BAIRRO_NULO = ("bairro em endereco não pode ser nulo");
    public static final String CIDADE_CURTA = ("Tamanho de string cidade em endereco está abaixo de 3 caracteres");
    public static final String CIDADE_LONGA = ("Tamanho de string cidade em endereco está acima de 20 caracteres");
    public static final String CIDADE_COM_NUMEROS = ("cidade em endereco não pode ter caracteres numeros");
    public static final String CIDADE_VAZIA = ("O Campo cidade em endereco está vazio");
    public static final String COMPLEMENTO_CURTO = ("Tamanho de string complemento em endereco está abaixo de 3 caracteres");
    public static final String COMPLEMENTO_LONGO = ("Tamanho de string complemento em endereco está acima de 20 caracteres");
    public static final String COMPLEMENTO_VAZIO = ("O Campo complemento em endereco está vazio");
    public static final String COMPLEMENTO_NULO = ("complemento em endereco não pode ser nulo");
    public static final String CEP_INVALIDO = ("cep em endereco não é válido");

}

