package br.com.contmatic.contatoTests.constants.contato;

import br.com.contmatic.contato.Contato;
import br.com.contmatic.contato.Telefone;

import java.util.ArrayList;
import java.util.List;

public class ContatoConstants { public static final String MSG_LOG_CRIACAO = ("Tamanho de string login criacao em auditoria está acima de 25 caracteres");
    public static final String MSG_EMAIL_VAZIO = ("O Campo email em contato está vazio");
    public static final String MSG_EMAIL_MAIOR_QUE_60 = ("Tamanho de string email em contato está acima de 60 caracteres");
    public static final String MSG_EMAIL_MENOR_QUE_12 = ("Tamanho de string email em contato está abaixo de 12 caracteres");
    public static final String MSG_EMAIL_INVALIDO = ("email em contato não é um email válido");
    public static final String MSG_EMAIL_NULO = ("email em contato não pode ser nulo");
    public static final String MSG_TELEFONE_NULO = ("telefones em contato não pode ser nulo");
    public static final List<Telefone> telefones = new ArrayList<>();
    public static final Contato contatoErrado = new Contato("testeee@gmail.com", telefones);
    public static final Contato contatoCompleto = new Contato("test@gmail.com", telefones);

}
