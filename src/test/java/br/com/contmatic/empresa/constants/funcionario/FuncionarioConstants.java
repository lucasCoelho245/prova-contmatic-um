package br.com.contmatic.empresa.constants.funcionario;

import br.com.contmatic.contato.Contato;
import br.com.contmatic.contato.Telefone;
import br.com.contmatic.empresa.Cargo;
import br.com.contmatic.empresa.Empresa;
import br.com.contmatic.empresa.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioConstants {
    public static final String CAMPO_FUNCIONARIO_ESTA_NULO = ("cargo em funcionario não pode ser nulo");
    public static final String CAMPO_EMPRESA_ESTA_NULO = ("empresa em funcionario não pode ser nulo");
    public static final String CAMPO_CONTATOS_ESTA_NULO = ("contatos em funcionario não pode ser nulo");
    public static final String CAMPO_SALARIO_CURTO = ("Tamanho de string Salario em funcionario está abaixo de 3 caracteres");
    public static final String CPF_INVALIDO = ("CPF esta com caracteres repetidos ou diferente do numeracao padrao");
    public static final BigDecimal salario = new BigDecimal(1000);
    public static final LocalDateTime dataNascimento = LocalDateTime.of(2002, 12, 2, 12, 00);
    public static final List<Empresa> empresas = new ArrayList<>();
    public static final List<Contato> contatos = new ArrayList<>();
    public static final List<Cargo> cargos = new ArrayList<>();
    public static final List<Telefone> telefones = new ArrayList<>();

    public static final Funcionario funcionarioCompleto = new Funcionario("João", cargos, "50279302835", salario, dataNascimento, empresas, contatos);
    public static final Funcionario funcionarioErrado = new Funcionario("julio", cargos, "502793022828", salario, dataNascimento, empresas, contatos);

}