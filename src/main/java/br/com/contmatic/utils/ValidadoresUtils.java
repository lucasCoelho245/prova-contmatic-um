package br.com.contmatic.utils;


import java.util.regex.Pattern;

public class ValidadoresUtils {
    private ValidadoresUtils() {
    }

    public static void validarStringTamanhoMinimo(String str, Integer minimo, String nomeDoCampo, String classe) {
        if (str.length() <= minimo) {
            throw new IllegalStateException("Tamanho de string " + nomeDoCampo + " em " + classe + " está abaixo de " + minimo + " caracteres ");
        }
    }

    public static void validarStringTamanhoMaximo(String str, Integer maximo, String nomeDoCampo, String classe) {
        if (str.length() >= maximo) {
            throw new IllegalStateException("Tamanho de string " + nomeDoCampo + " em " + classe + " está acima de " + maximo + " caracteres");
        }
    }

    public static void validarCaracterEspecial(String str, String nomeDoCampo, String classe) {
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        if (pattern.matcher(str).find()) {
            throw new IllegalStateException(nomeDoCampo + " em " + classe + " não pode ter caracteres especiais ");
        }
    }

    public static void validarPatternCep(String str, String nomeDoCampo, String classe) {
        Pattern pattern = Pattern.compile("^\\d{5}-\\d{3}$");
        if (!pattern.matcher(str).matches()) {
            throw new IllegalStateException(nomeDoCampo + " em " + classe + " não é válido");
        }
    }

    public static void validarPatternEmail(String str, String nomeDoCampo, String classe) {
        Pattern pattern = Pattern.compile("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        if (!pattern.matcher(str).matches()) {
            throw new IllegalStateException(nomeDoCampo + " em " + classe + " não é um email válido ");
        }
    }

    public static void validarPatternIp(String str, String nomeDoCampo, String classe) {
        final String OCTETO_REGEX = "(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)";
        final String IP_REGEX = "^(" + OCTETO_REGEX + "\\.){3}" + OCTETO_REGEX + "$";
        Pattern pattern = Pattern.compile(IP_REGEX);
        if (!pattern.matcher(str).matches()) {
            throw new IllegalStateException(nomeDoCampo + " em " + classe + " não é um ip válido ");
        }
    }

    public static void validarNumerosString(String str, String nomeDoCampo, String classe) {
        if (str.matches("\\d+")) {
            throw new IllegalStateException(nomeDoCampo + " em " + classe + " não pode ter caracteres numeros ");
        }
    }

    public static void validarCaracterString(String str, String nomeDoCampo, String classe) {
        Pattern pattern = Pattern.compile("^[0-9.-]*$");
        if (!pattern.matcher(str).matches()) {
            throw new IllegalStateException(nomeDoCampo + " em " + classe + " não pode ter caracteres ");
        }
    }
    public static void validarStringSomenteNumeros(String str, String nomeDoCampo, String classe) {
        Pattern pattern = Pattern.compile(".*[a-zA-Z]+.*");
        if (pattern.matcher(str).matches()) {
            throw new IllegalStateException(nomeDoCampo + " em " + classe + " não pode ter caracteres ");
        }
    }

    public static void validarObjetoNulo(Object obj, String nomeDoCampo, String classe) {
        if (obj == null) {
            throw new IllegalArgumentException(nomeDoCampo + " em " + classe + " não pode ser nulo ");
        }
    }

    public static void validarStringVazio(String str, String nomeDoCampo, String classe) {
        if (str.trim().length() == 0) {
            throw new IllegalArgumentException("O Campo " + nomeDoCampo + " em " + classe + " está vazio");
        }
    }



}