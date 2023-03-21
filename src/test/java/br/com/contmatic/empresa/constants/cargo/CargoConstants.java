package br.com.contmatic.empresa.constants.cargo;

import br.com.contmatic.empresa.Cargo;

public class CargoConstants {

    public static Cargo cargoCompleto = new Cargo("lucas", "contabilidade", 555);
    public static Cargo cargoErrado = new Cargo("gerson", "teste", 5434355);
    public static final String TAMANHO_DE_CARGO_ESTA_ABAIXO_DE_2_CARACTERES = ("Tamanho de string nome em cargo está abaixo de 2 caracteres");
    public static final String TAMANHO_DE_CARGO_ESTA_ACIMA_DE_60_CARACTERES = ("Tamanho de string nome em cargo está acima de 60 caracteres");
    public static final String NOME_DE_CARGO_TEM_NUMEROS = ("nome em cargo não pode ter caracteres numeros");
    public static final String NOME_DE_CARGO_ESTA_VAZIO = ("O Campo nome em cargo está vazio");
    public static final String NOME_DE_CARGO_ESTA_NULO = ("nome em cargo não pode ser nulo");

    public static final String SETOR_NAO_DEVE_TER_MENOS_DE_3_CARACTERES =("Tamanho de string setorCargo em cargo está abaixo de 2 caracteres");
    public static final String SETOR_DE_CARGO_ESTA_VAZIO = ("O Campo setorCargo em cargo está vazio");
    public static final String SETOR_DE_CARGO_ESTA_NULO = ("setorCargo em cargo não pode ser nulo");
    public static final String TAMANHO_DE_SETOR_DE_CARGO_ESTA_ACIMA_DE_30_CARACTERES = ("Tamanho de string setorCargo em cargo está acima de 30 caracteres");
    public static final String CODIGO_DE_CARGO_ESTA_NULO = ("Codigo em cargo não pode ser nulo ");
    public static final String TAMANHO_DE_CODIGO_ESTA_ABAIXO_DE_2_CARACTERES = ("Tamanho de string Codigo em cargo está abaixo de 2 caracteres");
    public static final Cargo cargoPadrao = new Cargo("lucas", "contabilidade", 555);


}
