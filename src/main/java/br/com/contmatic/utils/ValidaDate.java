package br.com.contmatic.utils;

import java.time.LocalDateTime;

public class ValidaDate {
    private static final LocalDateTime localDate = LocalDateTime.now();

    private static final Integer ANO_ATUAL = localDate.getYear();
    private static final Integer MES_ATUAL = localDate.getMonthValue();
    private static final Integer DIA_ATUAL = localDate.getDayOfMonth();
    private static final String DATA_CAMPO = "a data do campo ";
    public static void isValidLocalDateTime(LocalDateTime data, String nomeDoCampo, String classe) {
        validarAno(data.getYear(), nomeDoCampo, classe);
        validarMes(data.getMonthValue(), nomeDoCampo, classe);
        validarDia(data.getDayOfMonth(), nomeDoCampo, classe);
    }

    private static void validarAno(int ano, String nomeDoCampo, String classe) {
        if (ano > ANO_ATUAL) {
            throw new IllegalArgumentException(DATA_CAMPO + nomeDoCampo + " em " + classe + " esta com ano invalido");
        }
    }

    private static void validarMes(int mes, String nomeDoCampo, String classe) {
        if (mes > MES_ATUAL) {
            throw new IllegalArgumentException(DATA_CAMPO + nomeDoCampo + " em " + classe + " esta com mes invalido");
        }
    }

    private static void validarDia(int dia, String nomeDoCampo, String classe) {
        if (dia > DIA_ATUAL) {
            throw new IllegalArgumentException(DATA_CAMPO + nomeDoCampo + " em " + classe + " esta com dia invalido");
        }
    }

}
