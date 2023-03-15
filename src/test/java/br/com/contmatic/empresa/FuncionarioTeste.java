package br.com.contmatic.empresa;

import br.com.contmatic.contato.Contato;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioTeste {


    private Funcionario funcionario;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Iniciamos os testes na classe fornecedor");
    }

    @Before
    public void setBeforeFornecedor() {
        funcionario = new Funcionario();
    }

    @Test
    public void deve_aceitar_nome_correto() {
        funcionario.setNome("Lucas Coelho Galhanone da Cunha");
    }

    @Test
    public void deve_aceitar_cargo_correto() {
        List<Cargo> cargos = new ArrayList<>();
        cargos.add(new Cargo("analista", "desenvolvimento", 553));
        funcionario.setCargos(cargos);
    }

    @Test
    public void deve_aceitar_cpf_correto() {
        funcionario.setCpf("50279302835");
    }

    @Test
    public void deve_aceitar_salario_correto() {
        BigDecimal salario = new BigDecimal(1000);
        funcionario.setSalario(salario);
    }

    @Test
    public void deve_aceitar_data_correto() {
        Funcionario funcionario = new Funcionario();
        LocalDateTime data = LocalDateTime.now();
        funcionario.setDataNascimento(data);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cargo_nulo() {
        List<Cargo> cargos = new ArrayList<>();
        cargos.add(null);
        funcionario.setCargos(cargos);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_empresa_nula() {
        List<Empresa> empresas = new ArrayList<>();
        empresas.add(null);
        funcionario.setEmpresa(empresas);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_contato_nula() {
        List<Contato> contatos = new ArrayList<>();
        contatos.add(null);
        funcionario.setContatos(contatos);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_salario_menor_que_4_caracteres() {
        BigDecimal salario = new BigDecimal(224);
        funcionario.setSalario(salario);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_data_nascimento_invalida() {
        Funcionario funcionario = new Funcionario();
        LocalDateTime data = LocalDateTime.of(2024, 12, 2, 12, 00);
        funcionario.setDataNascimento(data);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_invalido() {
        funcionario.setCpf("11111111111");
    }
}