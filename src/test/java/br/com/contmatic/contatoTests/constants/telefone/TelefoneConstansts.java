package br.com.contmatic.contatoTests.constants.telefone;

import br.com.contmatic.contato.Telefone;

import java.util.ArrayList;
import java.util.List;

public class TelefoneConstansts {
    public static final String MSG_DDI_NULO = ("DDI em telefone não pode ser nulo");
    public static final String MSG_DDI_MAIOR_DE_3_CARACTERES = ("Tamanho de string DDI em telefone está acima de 3 caracteres");
    public static final String MSG_DDI_COM_CARACTERES = ("DDI em telefone não pode ter caracteres");
    public static final String MSG_TELEFONE_VAZIO = ("O Campo numero em telefone está vazio");
    public static final String MSG_TELEFONE_MAIOR_DE_10_CARACTERES = ("Tamanho de string numero em telefone está acima de 10 caracteres");
    public static final String MSG_TELEFONE_MENOR_DE_8_CARACTERES = ("Tamanho de string numero em telefone está abaixo de 8 caracteres");
    public static final String MSG_TELEFONE_COM_LETRAS = ("numero em telefone não pode ter caracteres");
    public static final List<Telefone> telefoneErrado = new ArrayList<>();
    public static final List<Telefone> telefoneCompleto = new ArrayList<>();
    public static final List<Telefone> telefonePadrao = new ArrayList<>();

}
