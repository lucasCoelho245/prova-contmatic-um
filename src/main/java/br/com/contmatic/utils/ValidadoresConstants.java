package br.com.contmatic.utils;

public final class ValidadoresConstants {
    private ValidadoresConstants() {
    }
    public static final String CARACTER_ESPECIAL_MASK = "[^a-zA-Z0-9]";
    public static final String CEP_MASK = "^\\d{5}-\\d{3}$";
    public static final String EMAIL_MASK = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    public static final String OCTETO_REGEX = "(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)";
    public static final String IP_MASK = "^(" + OCTETO_REGEX + "\\.){3}" + OCTETO_REGEX + "$";
    public static final String NUMERO_MASK = "\\d+";
    public static final String CARACTER_MASK = "^[0-9.-]*$";
    public static final String AUDITORIA_EXCEPTION = "Falha nas informações de auditoria";
}
