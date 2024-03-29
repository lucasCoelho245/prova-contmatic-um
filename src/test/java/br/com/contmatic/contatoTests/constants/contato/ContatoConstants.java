package br.com.contmatic.contatoTests.constants.contato;

import br.com.contmatic.contato.Contato;
import br.com.contmatic.contato.Telefone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static br.com.contmatic.contato.DDDType.DDD11;

public final class ContatoConstants {
    public static final String MSG_EMAIL_VAZIO = "O Campo email em contato está vazio";
    public static final String MSG_EMAIL_MAIOR_QUE_60 = "Tamanho de string email em contato está acima de 60 caracteres";
    public static final String MSG_EMAIL_MENOR_QUE_12 = "Tamanho de string email em contato está abaixo de 12 caracteres";
    public static final String MSG_EMAIL_INVALIDO = "email em contato não é um email válido";
    public static final String MSG_EMAIL_NULO = "email em contato não pode ser nulo";
    public static final String MSG_TELEFONE_NULO = "telefones em contato não pode ser nulo";
    public static final String MSG_TELEFONE_VAZIO = "O Campo telefones em contato está vazio";
    public static final List<Telefone> telefones = new ArrayList<>();

}
