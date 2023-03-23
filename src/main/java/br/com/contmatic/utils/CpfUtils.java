package br.com.contmatic.utils;

import static br.com.contmatic.utils.CnpCpfjUtilsConstants.*;
import static br.com.contmatic.utils.ValidadoresUtils.*;
import static java.lang.Integer.parseInt;

public final class CpfUtils {
    private CpfUtils() {}
    public static void validarCpf(String cpf, String nomeDoCampo, String classe) {
        validarObjetoNulo(cpf, nomeDoCampo, classe);
        validarStringVazio(cpf, nomeDoCampo, classe);
        errosCnpjBasicos(cpf);
        int[] digitos = separadorDigitos(cpf);
        int digitoUm = getDigitoUm(digitos);
        int digitoDois = getDigitoDois(digitos, digitoUm);
        if (!(digitoUm == digitos[9] && digitoDois == digitos[10])) {
            throw new IllegalArgumentException(EXEPTION_CPF);
        }
    }

    private static void errosCnpjBasicos(String cpf) {
        if (verificaCaracteresBasicos(cpf)) {
            throw new IllegalArgumentException(EXEPTION_CPF_REPETIDO);
        }
    }

    private static int[] separadorDigitos(String cpf) {
        int[] digitos = new int[CPF_CARACTERS];
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
        digitoDois = CPF_CARACTERS - (digitoDois % CPF_CARACTERS);
        return digitoDois;
    }

    private static int getDigitoUm(int[] digitos) {
        return calculoParaDigitoUm(digitos);
    }

    private static int calculoParaDigitoUm(int[] digitos) {
        int digitoUm = (digitos[0] * NUM_CALCULAR_DIGITO_CPF_NONO) + (digitos[1] * NUM_CALCULAR_DIGITO_CPF_OITAVO) + (digitos[2] * NUM_CALCULAR_DIGITO_CPF_SETIMO) + (digitos[3] * NUM_CALCULAR_DIGITO_CPF_SEXTO) + (digitos[4] * NUM_CALCULAR_DIGITO_CPF_QUINTO)
                + (digitos[5] * NUM_CALCULAR_DIGITO_CPF_QUARTO) + (digitos[6] * NUM_CALCULAR_DIGITO_CPF_TERCEIRO) + (digitos[7] * NUM_CALCULAR_DIGITO_CPF_SEGUNDO) + (digitos[8] * NUM_CALCULAR_DIGITO_CPF_PRIMEIRO);
        digitoUm = CPF_CARACTERS - (digitoUm % CPF_CARACTERS);
        return digitoUm;
    }

    private static boolean verificaCaracteresBasicos(String cpf) {
        return cpf.length() != CPF_CARACTERS || cpf.equals(CPF_CPNJ_CARAC_REPETIDO_ZERO) || cpf.equals(CPF_CPNJ_CARAC_REPETIDO_UM) || cpf.equals(CPF_CPNJ_CARAC_REPETIDO_DOIS)
                || cpf.equals(CPF_CPNJ_CARAC_REPETIDO_TRES) || cpf.equals(CPF_CPNJ_CARAC_REPETIDO_QUATRO) || cpf.equals(CPF_CPNJ_CARAC_REPETIDO_CINCO)
                || cpf.equals(CPF_CPNJ_CARAC_REPETIDO_SEIS) || cpf.equals(CPF_CPNJ_CARAC_REPETIDO_SETE) || cpf.equals(CPF_CPNJ_CARAC_REPETIDO_OITO)
                || cpf.equals(CPF_CPNJ_CARAC_REPETIDO_NOVE);
    }
}
