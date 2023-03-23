package br.com.contmatic.utils;

import static br.com.contmatic.utils.CnpCpfjUtilsConstants.*;
import static br.com.contmatic.utils.ValidadoresUtils.*;
import static java.lang.Integer.parseInt;

public class CnpjUtils {
    private CnpjUtils() {}
    public static void validaCnpj(String cnpj, String nomeDoCampo, String classe) {
        validarObjetoNulo(cnpj, nomeDoCampo, classe);
        validarStringVazio(cnpj, nomeDoCampo, classe);
        validarCaracterString(cnpj, nomeDoCampo, classe);
        basicErrosCnpj(cnpj);
        int[] digitos = new int[CARACTERES_CNPJ];
        int digitoUm = getDigitoUm(cnpj, digitos);
        int digitoDois = getDigitoDois(digitos, digitoUm);
        verificaDigitosCnpj(digitos, digitoUm, digitoDois);

    }

    private static void verificaDigitosCnpj(int[] digitos, int digitoUm, int digitoDois) {
        if (!(digitos[12] == digitoUm && digitos[13] == digitoDois)) {
            throw new IllegalArgumentException(EXCEPTION_CNPJ);
        }
    }

    private static void basicErrosCnpj(String eCnpj) {
        if (basicErrorCnpjVerifier(eCnpj)) {
            throw new IllegalArgumentException(EXCEPTION_CNPJ_REPETIDO);
        }
    }

    private static int getDigitoDois(int[] digitos, int digitoUm) {
        return calcularDigitoDois(digitoUm, digitos);
    }

    private static int calcularDigitoDois(int digitoUm, int[] digitos) {
        int digitoDois = (digitoUm * NUM_CALCULAR_DIGITO_CNPJ_PRIMEIRO) + (digitos[11] * NUM_CALCULAR_DIGITO_CNPJ_SEGUNDO) + (digitos[10] * NUM_CALCULAR_DIGITO_CNPJ_TERCEIRO) + (digitos[9] * NUM_CALCULAR_DIGITO_CNPJ_QUARTO) + (digitos[8] * NUM_CALCULAR_DIGITO_CNPJ_QUINTO)
                + (digitos[7] * NUM_CALCULAR_DIGITO_CNPJ_SEXTO) + (digitos[6] * NUM_CALCULAR_DIGITO_CNPJ_SETIMO) + (digitos[5] * NUM_CALCULAR_DIGITO_CNPJ_OITAVO) + (digitos[4] * NUM_CALCULAR_DIGITO_CNPJ_PRIMEIRO) + (digitos[3] * NUM_CALCULAR_DIGITO_CNPJ_SEGUNDO) + (digitos[2] * NUM_CALCULAR_DIGITO_CNPJ_TERCEIRO)
                + (digitos[1] * NUM_CALCULAR_DIGITO_CNPJ_QUARTO) + (digitos[0] * NUM_CALCULAR_DIGITO_CNPJ_QUINTO);
        digitoDois = VALOR_ABAIXO_DOS_PRIMEIROS_CARACTERES_SEM_DIGITOS - (div(digitoDois));
        return digitoDois;
    }

    private static int getDigitoUm(String cnpj, int[] digitos) {
        separarDigitosDoCnpj(cnpj, digitos);
        return calcularDigitoUm(digitos);
    }

    private static void separarDigitosDoCnpj(String cnpj, int[] digitos) {
        for (int i = 0; i < CARACTERES_CNPJ; i++) {
            digitos[i] = parseInt(cnpj.split("")[i]);
        }
    }

    private static int calcularDigitoUm(int[] digitos) {
        int digitoUm = digitos[11] * NUM_CALCULAR_DIGITO_CNPJ_PRIMEIRO + digitos[10] * NUM_CALCULAR_DIGITO_CNPJ_SEGUNDO + digitos[9] * NUM_CALCULAR_DIGITO_CNPJ_TERCEIRO + digitos[8] * NUM_CALCULAR_DIGITO_CNPJ_QUARTO + digitos[7] * NUM_CALCULAR_DIGITO_CNPJ_QUINTO
                + digitos[6] * NUM_CALCULAR_DIGITO_CNPJ_SEXTO + digitos[5] * NUM_CALCULAR_DIGITO_CNPJ_SETIMO + digitos[4] * NUM_CALCULAR_DIGITO_CNPJ_OITAVO + digitos[3] * NUM_CALCULAR_DIGITO_CNPJ_NONO + digitos[2] * NUM_CALCULAR_DIGITO_CNPJ_DECIMO + digitos[1] * NUM_CALCULAR_DIGITO_CNPJ_DECIMO_PRIMEIRO
                + digitos[0] * NUM_CALCULAR_DIGITO_CNPJ_DECIMO_SEGUNDO;
        digitoUm = VALOR_ABAIXO_DOS_PRIMEIROS_CARACTERES_SEM_DIGITOS - (div(digitoUm));
        return digitoUm;
    }

    private static boolean basicErrorCnpjVerifier(String cnpj) {
        return cnpj.equals(CPF_CPNJ_CARAC_REPETIDO_ZERO) || cnpj.equals(CPF_CPNJ_CARAC_REPETIDO_UM) || cnpj.equals(CPF_CPNJ_CARAC_REPETIDO_DOIS)
                || cnpj.equals(CPF_CPNJ_CARAC_REPETIDO_TRES) || cnpj.equals(CPF_CPNJ_CARAC_REPETIDO_QUATRO) || cnpj.equals(CPF_CPNJ_CARAC_REPETIDO_CINCO)
                || cnpj.equals(CPF_CPNJ_CARAC_REPETIDO_SEIS) || cnpj.equals(CPF_CPNJ_CARAC_REPETIDO_SETE) || cnpj.equals(CPF_CPNJ_CARAC_REPETIDO_OITO)
                || cnpj.equals(CPF_CPNJ_CARAC_REPETIDO_NOVE) || (cnpj.length() != CARACTERES_CNPJ);
    }

    private static int div(int dividendo) {
        return dividendo - (dividendo / CnpCpfjUtilsConstants.VALOR_ABAIXO_DOS_PRIMEIROS_CARACTERES_SEM_DIGITOS) * CnpCpfjUtilsConstants.VALOR_ABAIXO_DOS_PRIMEIROS_CARACTERES_SEM_DIGITOS;
    }
}

