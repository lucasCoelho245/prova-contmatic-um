package br.com.contmatic.utils;


import java.time.LocalDateTime;

public class ValidaDate {
    private static final LocalDateTime localDate = LocalDateTime.now();

    private static final Integer anoAtual = localDate.getYear();
    private static final Integer mesAtual = localDate.getMonthValue();
    private static final Integer diaAtual = localDate.getDayOfMonth();
    public static void isValidLocalDateTime(LocalDateTime data, String nomeDoCampo, String classe) {
        if (data == null) {
            throw new IllegalArgumentException("O " + nomeDoCampo + " da " + classe + " está nulo");
        }
        validarAno(data.getYear(), nomeDoCampo, classe);
        validarMes(data.getMonthValue(), nomeDoCampo, classe);
        validarDia(data.getDayOfMonth(), nomeDoCampo, classe);
    }

    private static void validarAno(int ano, String nomeDoCampo, String classe) {
        if (ano > anoAtual) {
            throw new IllegalArgumentException("a data do campo " + nomeDoCampo + " em " + classe + " esta com ano invalido");
        }
    }

    private static void validarMes(int mes, String nomeDoCampo, String classe) {
        if (mes > mesAtual) {
            throw new IllegalArgumentException("a data do campo " + nomeDoCampo + " em " + classe + " esta com mes invalido");
        }
    }

    private static void validarDia(int dia, String nomeDoCampo, String classe) {
        if (dia > diaAtual) {
            throw new IllegalArgumentException("a data do campo " + nomeDoCampo + " em " + classe + " esta com dia invalido");
        }
    }

}
