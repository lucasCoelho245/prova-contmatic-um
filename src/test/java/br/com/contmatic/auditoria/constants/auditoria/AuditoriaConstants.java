package br.com.contmatic.auditoria.constants.auditoria;

import br.com.contmatic.auditoria.Auditoria;

import java.time.LocalDateTime;

public final class AuditoriaConstants {
    public static final LocalDateTime exemploData = LocalDateTime.of(2022, 1, 1, 12, 30);
    public static final String LOG_CRIACAO = "Tamanho de string login criacao em auditoria está acima de 25 caracteres";
    public static final String LOG_ALTERACAO = "Tamanho de string login criacao em auditoria está abaixo de 2 caracteres";
    public static final String LOG_ALTERACAO_NULL = "login criacao em auditoria não pode ser nulo";
    public static final String LOG_ALTERACAO_VAZIO = "O Campo login criacao em auditoria está vazio";
    public static final String LOG_CRIACAO_INVALIDA = "a data do campo data criacao em auditoria esta com mes invalido";
    public static final String LOG_ALTERACAO_INVALIDA = "a data do campo data alteracao em auditoria esta com ano invalido";
    public static final String LOG_LOGIN_CARACTER_ESPECIAL = "login criacao em auditoria não pode ter caracteres especiais";
    public static final String LOG_LOGOUT_INVALIDA = "a data do campo data logout em auditoria esta com dia invalido";
    public static final String LOG_LOGIN_INVALIDA = "a data do campo data login em auditoria esta com ano invalido";
    public static final String IP_CRIACAO_INVALIDO = "ipcriacao em auditoria não é um ip válido";
    public static final String IP_ALTERACAO_INVALIDO = "ipAlteracao em auditoria não é um ip válido";
    public static final String IP_CRIACAO_NULO = "ipcriacao em auditoria não pode ser nulo";
    public static final String IP_ALTERACAO_NULO = "ipAlteracao em auditoria não pode ser nulo";
    public static final String IP_CRIACAO_VAZIO = "O Campo ipcriacao em auditoria está vazio";
    public static final String IP_ALTERACAO_VAZIO = "O Campo ipAlteracao em auditoria está vazio";
    public static final Auditoria auditoriaTeste = new Auditoria("testelogin", "255.255.255.10", exemploData, exemploData, exemploData);
    public static final Auditoria auditoriaTesteCompleto = new Auditoria("testelogin", exemploData, "255.255.255.10", exemploData, exemploData);
    public static final Auditoria auditoriaTesteIgual = new Auditoria("testelogin", "255.255.255.10", exemploData, exemploData, exemploData);
    public static final Auditoria auditoriaerrado = new Auditoria("teste2login", "255.255.255.11", exemploData, exemploData, exemploData);

}
