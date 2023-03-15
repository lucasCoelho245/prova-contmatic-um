package br.com.contmatic.utils;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public class Utils {
    public static void validarStringTamanhoMinimo(String str, Integer minimo, String nomeDoCampo, String classe) {
        if (str.length() <= minimo) {
            throw new IllegalArgumentException("Tamanho de string " + nomeDoCampo + " em " + classe + " está abaixo de " + minimo + " caracteres ");
        }
    }

    public static void validarStringTamanhoMaximo(String str, Integer maximo, String nomeDoCampo, String classe) {
        if (str.length() >= maximo) {
            throw new IllegalArgumentException("Tamanho de string " + nomeDoCampo + " em " + classe + " está acima de " + maximo + " caracteres");
        }
    }

    public static void validarCaracterEspecial(String str, String nomeDoCampo, String classe) {
        if (str.matches("(?=.*[}{,.^?~=+\\-_\\/*\\-+.\\|])(?=.*[a-zA-Z])(?=.*[0-9]).{8,}")) {
            throw new IllegalArgumentException(nomeDoCampo + " em " + classe + " não pode ter caracteres especiais ");
        }
    }
    public static void validarCep(String str, String nomeDoCampo, String classe) {
        if (str.matches("\\d{5}-\\d{3}")) {
            throw new IllegalArgumentException(nomeDoCampo + " em " + classe + " não pode ter caracteres especiais ");
        }
    }

    public static void validarEmail(String str, String nomeDoCampo, String classe) {
        if (str.matches("/^[a-zA-Z0-9.! #$%&'*+/=? ^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\. [a-zA-Z0-9-]+)*$/")) {
            throw new IllegalArgumentException(nomeDoCampo + " em " + classe + " não é um email válido ");
        }
    }
    public static void validarIp(String str, String nomeDoCampo, String classe) {
        if (str.matches("^((25[0-5]|(2[0-4]|1\\d|[1-9]|)\\d)(\\.(?!$)|$)){4}$")) {
            throw new IllegalArgumentException(nomeDoCampo + " em " + classe + " não é um ip válido ");
        }
    }
    public static void validarNumerosString(String str, String nomeDoCampo, String classe) {
        if (str.matches("[0-9]+")) {
            throw new IllegalArgumentException(nomeDoCampo + " em " + classe + " não pode ter caracteres numeros ");
        }
    }

    public static void validarCaracterString(String str, String nomeDoCampo, String classe) {
        if (str.matches("(?=.*[ a-zA-Z á]).{8,}")) {
            throw new IllegalArgumentException(nomeDoCampo + " em " + classe + " não pode ter caracteres ");
        }
    }

    public static void validarObjetoNulo(Object obj, String nomeDoCampo, String classe) {
        if (obj == null) {
            throw new IllegalArgumentException("O Campo " + nomeDoCampo + " em " + classe + " está vazio");
        }
    }
    public static void validarDate(LocalDateTime data, String nomeDoCampo, String classe) {
        LocalDateTime dataAtual = LocalDateTime.now();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if (dataAtual.compareTo(data) < 0) {
            throw new IllegalArgumentException(nomeDoCampo + " na classe " + classe + " está no futuro: " + sdf.format(data));
        }
    }

}
