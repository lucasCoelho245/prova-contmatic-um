package br.com.contmatic.empresa.constants.empresa;

import br.com.contmatic.contato.Contato;
import br.com.contmatic.contato.Telefone;
import br.com.contmatic.empresa.Cargo;
import br.com.contmatic.empresa.Empresa;
import br.com.contmatic.empresa.Funcionario;
import br.com.contmatic.endereco.Endereco;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EmpresaConstants {
    public static final BigDecimal salario = new BigDecimal(1000);

    public static final List<Empresa> empresas = new ArrayList<>();

    public static final LocalDateTime data = LocalDateTime.of(2024, 12, 2, 12, 0);

    public static final List<Telefone> telefones = new ArrayList<>();

    public static final List<Contato> contatos = new ArrayList<>();

    public static final List<Cargo> cargos = new ArrayList<>();

    public static final List<Endereco> enderecos = new ArrayList<>();

    public static final List<Funcionario> funcionario = new ArrayList<>();
    public static final Empresa empresaCompleta = new Empresa("502793028385", "Coca Cola", enderecos, funcionario, contatos);
    public static final Empresa empresaErrada = new Empresa("502993028385", "Coca Cola", enderecos, funcionario, contatos);

    public static final String TAMANHO_DE_EMPRESA_ESTA_ACIMA_DE_60_CARACTERES = ("Tamanho de string nome empresa em empresa está acima de 60 caracteres");
    public static final String TAMANHO_DE_EMPRESA_ESTA_ABAIXO_DE_3_CARACTERES = ("Tamanho de string nome empresa em empresa está abaixo de 2 caracteres");
    public static final String CAMPO_EMPRESA_ESTA_VAZIO = ("O Campo nome empresa em empresa está vazio");
    public static final String CAMPO_EMPRESA_ESTA_NULO = ("nome empresa em empresa não pode ser nulo");
    public static final String CAMPO_RAZAO_SOCIAL_ESTA_VAZIO = ("O Campo razao social em empresa está vazio");
    public static final String CAMPO_RAZAO_SOCIAL_ESTA_NULO = ("razao social em empresa não pode ser nulo");
    public static final String TAMANHO_DE_RAZAO_SOCIAL_ESTA_ABAIXO_DE_10_CARACTERES = ("Tamanho de string razao social em empresa está abaixo de 10 caracteres");
    public static final String TAMANHO_DE_RAZAO_SOCIAL_ESTA_ACIMA_DE_60_CARACTERES = ("Tamanho de string razao social em empresa está acima de 60 caracteres");
    public static final String CAMPO_FUNCIONARIO_ESTA_NULO = ("funcionario em empresa não pode ser nulo");
    public static final String RAZAO_SOCIAL_TEM_NUMEROS = ("razao social em empresa não pode ter caracteres numeros");
    public static final String CAMPO_STATUS_ESTA_NULO = ("empresa Ativa em empresa não pode ser nulo");
    public static final String CNPJ_REPETIDO_INVALIDO = ("O CNPJ tem caracteres repetidos ou está fora da formatação padrão");
    public static final String CNPJ_INVALIDO = ("O CNPJ está invalido");
    public static final String CNPJ_NULO = ("O Campo CNPJ em empresa está vazio");
    public static final Empresa empresaPadrao = new Empresa("502793028385", "Coca Cola Indústrias Ltda", enderecos, funcionario, contatos);

}
