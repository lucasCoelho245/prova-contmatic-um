package br.com.contmatic.empresa.constants.empresa;

import br.com.contmatic.contato.Contato;
import br.com.contmatic.contato.Telefone;
import br.com.contmatic.empresa.Cargo;
import br.com.contmatic.empresa.Empresa;
import br.com.contmatic.empresa.Funcionario;
import br.com.contmatic.endereco.Endereco;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static br.com.contmatic.contato.DDDType.DDD11;
import static br.com.contmatic.endereco.UFType.MA;

public final class EmpresaConstants {
    public static final BigDecimal salario = new BigDecimal(1000);
    public static LocalDateTime data = LocalDateTime.of(2002, 2, 2, 12, 0);
    public static List<Empresa> empresas = new ArrayList<>();
    public static List<Telefone> telefones = Arrays.asList(new Telefone(DDD11, "55", "941584007"));
    public static List<Contato> contatos = Arrays.asList(new Contato("contmatic@gmail.com", telefones));
    public static  List<Cargo> cargos = Arrays.asList(new Cargo("analista", "desenvolvimento", 553));
    public static List<Endereco> enderecos = Arrays.asList(new Endereco("cambuci", 22, "barata Ribeiro", "sao paulo", MA, "apto 61", "01235-000"));
    public static  List<Funcionario> funcionario = Arrays.asList(new Funcionario("nome", cargos, "50279302835", salario, data, empresas, contatos));
    public static Empresa empresaCompleta = new Empresa("26631884000176", "Coca Cola inc", enderecos, funcionario, contatos);
    public static Empresa empresaErrada = new Empresa("15423393000113", "Coca Cola inc", enderecos, funcionario, contatos);
    public static Empresa empresaPadrao = new Empresa("26631884000176", "Coca Cola Indústrias Ltda", enderecos, funcionario, contatos);
    public static final String TAMANHO_DE_EMPRESA_ESTA_ACIMA_DE_60_CARACTERES = "Tamanho de string nome empresa em empresa está acima de 60 caracteres";
    public static final String TAMANHO_DE_EMPRESA_ESTA_ABAIXO_DE_3_CARACTERES = "Tamanho de string nome empresa em empresa está abaixo de 2 caracteres";
    public static final String CAMPO_EMPRESA_ESTA_VAZIO = "O Campo nome empresa em empresa está vazio";
    public static final String CAMPO_EMPRESA_ESTA_NULO = "nome empresa em empresa não pode ser nulo";
    public static final String CAMPO_RAZAO_SOCIAL_ESTA_VAZIO = "O Campo razao social em empresa está vazio";
    public static final String CAMPO_RAZAO_SOCIAL_ESTA_NULO = "razao social em empresa não pode ser nulo";
    public static final String CAMPO_ENDERECO_NULO = "endereco em empresa não pode ser nulo";
    public static final String CAMPO_ENDERECO_VAZIO = "endereco em empresa não pode ser nulo";
    public static final String TAMANHO_DE_RAZAO_SOCIAL_ESTA_ABAIXO_DE_10_CARACTERES = "Tamanho de string razao social em empresa está abaixo de 10 caracteres";
    public static final String TAMANHO_DE_RAZAO_SOCIAL_ESTA_ACIMA_DE_60_CARACTERES = "Tamanho de string razao social em empresa está acima de 60 caracteres";
    public static final String RAZAO_SOCIAL_TEM_NUMEROS = "razao social em empresa não pode ter caracteres numeros";
    public static final String CAMPO_STATUS_ESTA_NULO = "empresa Ativa em empresa não pode ser nulo";
    public static final String CNPJ_REPETIDO_INVALIDO = "O CNPJ tem caracteres repetidos ou está fora da formatação padrão";
    public static final String CNPJ_INVALIDO = "O CNPJ está invalido";
    public static final String CNPJ_NULO = "O Campo CNPJ em empresa está vazio";
    public static final String FUNCIONARIO_VAZIO = "O Campo funcionario em empresa está vazio";
    public static final String FUNCIONARIO_NULO = "funcionario em empresa não pode ser nulo";

}
