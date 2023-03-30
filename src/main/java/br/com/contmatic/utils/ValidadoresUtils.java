package br.com.contmatic.utils;


import java.util.List;
import java.util.regex.Pattern;

import static br.com.contmatic.utils.ValidadoresConstants.*;

public class ValidadoresUtils {
    private ValidadoresUtils() {
    }

    public static void validarStringTamanhoMinimo(String str, Integer minimo, String nomeDoCampo, String classe) {
        if (str.length() < minimo) {
            throw new IllegalStateException("Tamanho de string " + nomeDoCampo + " em " + classe + " está abaixo de " + minimo + " caracteres ");
        }
    }

    public static void validarStringTamanhoMaximo(String str, Integer maximo, String nomeDoCampo, String classe) {
        if (str.length() > maximo) {
            throw new IllegalStateException("Tamanho de string " + nomeDoCampo + " em " + classe + " está acima de " + maximo + " caracteres");
        }
    }

    public static void validarCaracterEspecial(String str, String nomeDoCampo, String classe) {
        Pattern pattern = Pattern.compile(CARACTER_ESPECIAL_MASK);
        if (pattern.matcher(str).find()) {
            throw new IllegalStateException(nomeDoCampo + " em " + classe + " não pode ter caracteres especiais ");
        }
    }

    public static void validarPatternCep(String str, String nomeDoCampo, String classe) {
        Pattern pattern = Pattern.compile(CEP_MASK);
        if (!pattern.matcher(str).matches()) {
            throw new IllegalStateException(nomeDoCampo + " em " + classe + " não é válido");
        }
    }

    public static void validarPatternEmail(String str, String nomeDoCampo, String classe) {
        Pattern pattern = Pattern.compile(EMAIL_MASK);
        if (!pattern.matcher(str).matches()) {
            throw new IllegalStateException(nomeDoCampo + " em " + classe + " não é um email válido ");
        }
    }
    public static void validarPatternIp(String str, String nomeDoCampo, String classe) {
        Pattern pattern = Pattern.compile(IP_MASK);
        if (!pattern.matcher(str).matches()) {
            throw new IllegalStateException(nomeDoCampo + " em " + classe + " não é um ip válido");
        }
    }

    public static void validarNumerosString(String str, String nomeDoCampo, String classe) {
        if (str.matches(NUMERO_MASK)) {
            throw new IllegalStateException(nomeDoCampo + " em " + classe + " não pode ter caracteres numeros ");
        }
    }

    public static void validarCaracterString(String str, String nomeDoCampo, String classe) {
        Pattern pattern = Pattern.compile(CARACTER_MASK);
        if (!pattern.matcher(str).matches()) {
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
    public static void validarListVazia(List<?> lst, String nomeDoCampo, String classe) {
        if (lst.isEmpty()) {
            throw new IllegalArgumentException("O Campo " + nomeDoCampo + " em " + classe + " está vazio");
        }
    }

}
