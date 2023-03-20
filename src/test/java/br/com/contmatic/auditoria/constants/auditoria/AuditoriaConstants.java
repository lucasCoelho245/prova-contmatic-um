package br.com.contmatic.auditoria.constants.auditoria;

public class AuditoriaConstants {
    public static final String LOG_CRIACAO = ("Tamanho de string login criacao em auditoria está acima de 25 caracteres");
    public static final String LOG_ALTERACAO = ("Tamanho de string login criacao em auditoria está abaixo de 2 caracteres");
    public static final String LOG_ALTERACAO_NULL = ("login criacao em auditoria não pode ser nulo");
    public static final String LOG_ALTERACAO_VAZIO = ("O Campo login criacao em auditoria está vazio");
    public static final String LOG_ALTERACAO_CARACTER_ESPECIAL = ("login criacao em auditoria não pode ter caracteres especiais");
    public static final String IP_CRIACAO_MENOR_QUE_6_CARACTERES = ("Tamanho de string ipcriacao em auditoria está abaixo de 6 caracteres");
    public static final String IP_CRIACAO_MAIO_QUE_15_CARACTERES = ("Tamanho de string ipcriacao em auditoria está acima de 15 caracteres");
    public static final String IP_CRIACAO_NULO = ("ipcriacao em auditoria não pode ser nulo");
    public static final String IP_CRIACAO_VAZIO = ("O Campo ipcriacao em auditoria está vazio");
    public static final String IP_CRIACAO_NAO_PODE_TER_CARACTERES = ("ipcriacao em auditoria não pode ter caracteres");

}
