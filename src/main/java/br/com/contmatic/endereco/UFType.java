package br.com.contmatic.endereco;

public enum UFType {
    RO("Rondônia", 11),
    AC("Acre", 12),
    AM("Amazonas", 13),
    RR("Roraima", 14),
    PA("Pará", 15),
    AP("Amapá", 16),
    TO("Tocantins", 17),
    MA("Maranhão", 21),
    PI("Piauí", 22),
    CE("Ceará", 23),
    RN("Rio Grande do Norte", 24),
    PB("Paraíba", 25),
    PE("Pernambuco", 26),
    AL("Alagoas", 27),
    SE("Sergipe", 28),
    BH("Bahia", 29),
    ES("Espírito Santo", 32),
    RJ("Rio de Janeiro", 33),
    SP("São Paulo", 35),
    PR("Paraná", 41),
    SC("Santa Catarina", 41),
    RS("Rio Grande do Sul", 43),
    MS("Mato Grosso do Sul", 50),
    MT("Mato Grosso", 51),
    GO("Goiás", 52),
    DF("Distrito Federal", 53	);


    private String nome;
    private Integer codigo;

    UFType(String estado, Integer codigo) {
        this.nome = estado;
        this.codigo = codigo;
    }
}
