package br.com.contmatic.empresa;

import br.com.contmatic.contato.Contato;
import br.com.contmatic.contato.Telefone;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static br.com.contmatic.contato.DDDType.DDD11;
import static br.com.contmatic.empresa.constants.funcionario.FuncionarioConstants.*;
import static org.junit.Assert.*;
import static org.junit.rules.ExpectedException.none;

public class TestFuncionario {
    private Funcionario funcionario;

    @Rule
    public ExpectedException exceptionRule = none();

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Iniciamos os testes na classe fornecedor");
        cargos.add(new Cargo("analista", "desenvolvimento", 553));
    }

    @Before
    public void setBeforeFornecedor() {
        funcionario = new Funcionario();
    }

    @Test
    public void deve_aceitar_nome_correto() {
        funcionario.setNome("Lucas Coelho Galhanone da Cunha");
        assertEquals("Lucas Coelho Galhanone da Cunha", funcionario.getNome());
    }

    @Test
    public void deve_aceitar_cargo_correto() {
        funcionario.setCargos(cargos);
        assertEquals(cargos, funcionario.getCargos());
    }

    @Test
    public void deve_aceitar_cpf_correto() {
        funcionario.setCpf("50279302835");
        assertEquals("50279302835", funcionario.getCpf());
    }

    @Test
    public void deve_aceitar_salario_correto() {

        funcionario.setSalario(salario);
        assertEquals(salario, funcionario.getSalario());
    }

    @Test
    public void deve_aceitar_data_correto() {
        Funcionario funcionario = new Funcionario();
        funcionario.setDataNascimento(dataNascimento);
        assertEquals(dataNascimento, funcionario.getDataNascimento());
    }
    @Test
    public void deve_aceitar_empresa_correto() {
        empresas.add(new Empresa());
        funcionario.setEmpresa(empresas);
        assertEquals(empresas, funcionario.getEmpresa());
    }
    @Test
    public void deve_aceitar_contato_correto() {
        telefones.add(new Telefone(DDD11, 555, "941584007"));
        contatos.add(new Contato("contmatic@gmail.com", telefones));
        funcionario.setContatos(contatos);
        assertEquals(contatos, funcionario.getContatos());
    }
    @Test
    public void testCargoToString() {
        String expectedString = "Funcionario {nomeCompleto= João, Cargos= [Cargo {nome= analista, codigo= 553}], cpf= 50279302835, salario= 1000, dataNascimento= 2022-02-01T22:12, empresa= [], Contatos= []}";
        assertEquals(expectedString, funcionarioCompleto.toString());
    }
    @Test
    public void testFuncionarioHashCodeTrue() {
        assertEquals(funcionarioCompleto.hashCode(), funcionarioPadrao.hashCode());
    }
    @Test
    public void testFuncionarioHashCodeFalse() {
        assertNotEquals(funcionarioCompleto.hashCode(), funcionarioErrado.hashCode());
    }
    @Test
    public void testFuncionarioEqualsCodeTrue() {
        assertEquals(funcionarioCompleto, funcionarioPadrao);
    }
    @Test
    public void testFuncionarioEqualsCodeFalse() {
        assertNotEquals(funcionarioErrado, funcionarioCompleto);
    }
    @Test
    public void nao_deve_aceitar_cargo_nulo() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CAMPO_FUNCIONARIO_ESTA_NULO);
        List<Cargo> cargos = new ArrayList<>();
        cargos.add(null);
        funcionario.setCargos(cargos);
    }

    @Test
    public void nao_deve_aceitar_empresa_nula() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CAMPO_EMPRESA_ESTA_NULO);
        List<Empresa> empresas = new ArrayList<>();
        empresas.add(null);
        funcionario.setEmpresa(empresas);
    }

    @Test
    public void nao_deve_contato_nula() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CAMPO_CONTATOS_ESTA_NULO);
        List<Contato> contatos = new ArrayList<>();
        contatos.add(null);
        funcionario.setContatos(contatos);
    }

    @Test
    public void nao_deve_aceitar_salario_menor_que_4_caracteres() {
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage(CAMPO_SALARIO_CURTO);
        BigDecimal salario = new BigDecimal(224);
        funcionario.setSalario(salario);
    }

    @Test
    public void nao_deve_aceitar_data_nascimento_invalida() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CAMPO_DATA_NASCIMENTO_INVALIDA);
        Funcionario funcionario = new Funcionario();
        LocalDateTime data = LocalDateTime.of(2024, 12, 30, 22, 12);
        funcionario.setDataNascimento(data);
    }

    @Test
    public void nao_deve_aceitar_cpf_invalido() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CPF_INVALIDO);
        funcionario.setCpf("11111111111");
    }
}
