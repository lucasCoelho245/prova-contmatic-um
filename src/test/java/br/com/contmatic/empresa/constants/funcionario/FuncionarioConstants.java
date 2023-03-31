package br.com.contmatic.empresa.constants.funcionario;

import br.com.contmatic.contato.Contato;
import br.com.contmatic.contato.Telefone;
import br.com.contmatic.empresa.Cargo;
import br.com.contmatic.empresa.Empresa;
import br.com.contmatic.empresa.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static br.com.contmatic.contato.DDDType.DDD11;
import static br.com.contmatic.empresa.constants.empresa.EmpresaConstants.telefones;

public final class FuncionarioConstants {
    public static final String CAMPO_FUNCIONARIO_ESTA_NULO = "cargo em funcionario não pode ser nulo";
    public static final String CAMPO_FUNCIONARIO_ESTA_VAZIO = "O Campo cargo em funcionario está vazio";
    public static final String CAMPO_EMPRESA_ESTA_NULO = "empresa em funcionario não pode ser nulo";
    public static final String CAMPO_EMPRESA_ESTA_VAZIO = "O Campo empresa em funcionario está vazio";
    public static final String CAMPO_CONTATOS_ESTA_NULO = "contatos em funcionario não pode ser nulo";
    public static final String CAMPO_CONTATOS_ESTA_VAZIO = "O Campo contatos em funcionario está vazio";
    public static final String CAMPO_SALARIO_CURTO = "Tamanho de string Salario em funcionario está abaixo de 4 caracteres";
    public static final String CAMPO_DATA_NASCIMENTO_INVALIDA = "a data do campo data nascimento em funcionario esta com ano invalido";
    public static final String CPF_INVALIDO = "CPF esta com caracteres repetidos ou diferente do numeracao padrao";
    public static final BigDecimal salario = new BigDecimal(10000);
    public static final LocalDateTime dataNascimento = LocalDateTime.of(2022, 2, 1, 22, 12);
    public static final List<Empresa> empresas = Arrays.asList(new Empresa("15423393000113"));
    public static final List<Cargo> cargos = Arrays.asList(new Cargo("analista", "desenvolvimento", 553));
    public static final List<Telefone> telefones = Arrays.asList(new Telefone(DDD11, "555", "941584007"));
    public static final List<Contato> contatos = Arrays.asList(new Contato("contmatic@gmail.com", telefones));

    public static final Funcionario funcionarioCompleto = new Funcionario("João", cargos, "50279302835", salario, dataNascimento, empresas, contatos);
    public static final Funcionario funcionarioErrado = new Funcionario("julio", cargos, "42357359854", salario, dataNascimento, empresas, contatos);
    public static final Funcionario funcionarioPadrao = new Funcionario("João", cargos, "50279302835", salario, dataNascimento, empresas, contatos);

}
