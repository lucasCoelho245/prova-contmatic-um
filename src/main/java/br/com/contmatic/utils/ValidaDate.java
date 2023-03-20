package br.com.contmatic.utils;

import java.time.LocalDateTime;

public class ValidaDate {
    public static void isValidLocalDateTime(LocalDateTime data, String nomeDoCampo, String classe) {
        if (data == null) {
            throw new IllegalArgumentException("O " + nomeDoCampo + " da " + classe + " está nulo");
        }

        validarAno(data.getYear(), nomeDoCampo, classe);
        validarMes(data.getMonthValue(), nomeDoCampo, classe);
        validarDia(data.getDayOfMonth(), nomeDoCampo, classe);
        validarHora(data.getHour(), nomeDoCampo, classe);
        validarMinuto(data.getMinute(), nomeDoCampo, classe);
        validarSegundo(data.getSecond(), nomeDoCampo, classe);
    }

    private static void validarAno(int ano, String nomeDoCampo, String classe) {
        if (ano < 2000 || ano > 2023) {
            throw new IllegalArgumentException("a data do campo " + nomeDoCampo + " em " + classe + " esta com ano invalido");
        }
    }

    private static void validarMes(int mes, String nomeDoCampo, String classe) {
        if (mes < 1 || mes > 12) {
            throw new IllegalArgumentException("a data do campo " + nomeDoCampo + " em " + classe + " esta com mes invalido");
        }
    }

    private static void validarDia(int dia, String nomeDoCampo, String classe) {
        if (dia < 1 || dia > 31) {
            throw new IllegalArgumentException("a data do campo " + nomeDoCampo + " em " + classe + " esta com dia invalido");
        }
    }

    private static void validarHora(int hora, String nomeDoCampo, String classe) {
        if (hora < 0 || hora > 23) {
            throw new IllegalArgumentException("a data do campo " + nomeDoCampo + " em " + classe + " esta com hora invalido");
        }
    }

    private static void validarMinuto(int minuto, String nomeDoCampo, String classe) {
        if (minuto < 0 || minuto > 59) {
            throw new IllegalArgumentException("a data do campo " + nomeDoCampo + " em " + classe + " esta com minuto invalido");
        }
    }

    private static void validarSegundo(int segundo, String nomeDoCampo, String classe) {
        if (segundo < 0 || segundo > 59) {
            throw new IllegalArgumentException("a data do campo " + nomeDoCampo + " em " + classe + " esta com segundo invalido");
        }
    }
}
