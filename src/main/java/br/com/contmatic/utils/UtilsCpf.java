package br.com.contmatic.utils;

import static br.com.contmatic.utils.CpfUtilsConstants.*;
import static br.com.contmatic.utils.Utils.validarObjetoNulo;
import static java.lang.Integer.parseInt;

public final class UtilsCpf {
    private UtilsCpf() {
    }


    public static void validarCpf(String cpf, String nomeDoCampo, String classe) {
        validarObjetoNulo(cpf, nomeDoCampo, classe);
        errosCnpjBasicos(cpf);
        int[] digitos = separadorDigitos(cpf);
        int digitoUm = getDigitoUm(digitos);
        int digitoDois = getDigitoDois(digitos, digitoUm);
        if (!(digitoUm == digitos[9] && digitoDois == digitos[10])) {
            throw new IllegalArgumentException("O CPF está invalido");
        }
    }

    private static void errosCnpjBasicos(String cpf) {
        if (verificaCaracteresBasicos(cpf)) {
            throw new IllegalArgumentException("O CPF é invalido");
        }
    }

    private static int[] separadorDigitos(String cpf) {
        int digitos[] = new int[CPF_CARACTERS];
        for (int i = 0; i < CPF_CARACTERS; i++) {
            digitos[i] = parseInt(cpf.split("")[i]);
        }
        return digitos;
    }

    private static int getDigitoDois(int[] digitos, int digitoUm) {
        return calculosParaDigitoDois(digitos, digitoUm);
    }

    private static int calculosParaDigitoDois(int[] digitos, int digitoUm) {
        int digitoDois = (digitos[0] * NUM_CALCULAR_DIGITO_CPF_DECIMO) + (digitos[1] * NUM_CALCULAR_DIGITO_CPF_NONO) + (digitos[2] * NUM_CALCULAR_DIGITO_CPF_OITAVO) + (digitos[3] * NUM_CALCULAR_DIGITO_CPF_SETIMO) + (digitos[4] * NUM_CALCULAR_DIGITO_CPF_SEXTO)
                + (digitos[5] * NUM_CALCULAR_DIGITO_CPF_QUINTO) + (digitos[6] * NUM_CALCULAR_DIGITO_CPF_QUARTO) + (digitos[7] * NUM_CALCULAR_DIGITO_CPF_TERCEIRO) + (digitos[8] * NUM_CALCULAR_DIGITO_CPF_SEGUNDO) + (digitoUm * NUM_CALCULAR_DIGITO_CPF_PRIMEIRO);
        if (digitoDois % CPF_CARACTERS < 2) {
            digitoDois = 0;
        } else {
            digitoDois = CPF_CARACTERS - (digitoDois % CPF_CARACTERS);
        }
        return digitoDois;
    }

    private static int getDigitoUm(int[] digitos) {
        return calculoParaDigitoUm(digitos);
    }

    private static int calculoParaDigitoUm(int[] digitos) {
        int digitoUm = (digitos[0] * NUM_CALCULAR_DIGITO_CPF_NONO) + (digitos[1] * NUM_CALCULAR_DIGITO_CPF_OITAVO) + (digitos[2] * NUM_CALCULAR_DIGITO_CPF_SETIMO) + (digitos[3] * NUM_CALCULAR_DIGITO_CPF_SEXTO) + (digitos[4] * NUM_CALCULAR_DIGITO_CPF_QUINTO)
                + (digitos[5] * NUM_CALCULAR_DIGITO_CPF_QUARTO) + (digitos[6] * NUM_CALCULAR_DIGITO_CPF_TERCEIRO) + (digitos[7] * NUM_CALCULAR_DIGITO_CPF_SEGUNDO) + (digitos[8] * NUM_CALCULAR_DIGITO_CPF_PRIMEIRO);
        if (digitoUm % CPF_CARACTERS < 2) {
            digitoUm = 0;
        } else {
            digitoUm = CPF_CARACTERS - (digitoUm % CPF_CARACTERS);
        }
        return digitoUm;
    }

    private static boolean verificaCaracteresBasicos(String cpf) {
        return cpf.length() != CPF_CARACTERS || cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
                || cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
                || cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
                || cpf.equals("99999999999");
    }
}
