package br.com.contmatic.empresa;

import br.com.contmatic.contato.Contato;
import br.com.contmatic.contato.Telefone;
import br.com.contmatic.endereco.Endereco;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static br.com.contmatic.contato.DDDType.DDD11;
import static br.com.contmatic.empresa.constants.empresa.EmpresaConstants.*;
import static br.com.contmatic.endereco.UFType.MA;
import static org.junit.Assert.*;
import static org.junit.rules.ExpectedException.*;


public class TestEmpresa {
    private Empresa empresa;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Iniciamos os testes na classe empresa");

        telefones.add(new Telefone(DDD11, 555, "941584007"));

        contatos.add(new Contato("contmatic@gmail.com", telefones));

        cargos.add(new Cargo("analista", "desenvolvimento", 553));

        empresas.add(new Empresa("26631884000176"));

        funcionario.add(new Funcionario("nome", cargos, "50279302835", salario, data, empresas, contatos));

        enderecos.add(new Endereco("cambuci", 22, "barata Ribeiro", "01235000", MA, "apto 61", "01233300"));
    }

    @Before
    public void setBeforeFornecedor() {
        empresa = new Empresa();
    }

    @Rule
    public ExpectedException exceptionRule = none();

    @Test
    public void deve_aceitar_nome_correto() {
        empresa.setNome("salgadelicia");
        assertEquals("salgadelicia", empresa.getNome());
    }

    @Test
    public void deve_aceitar_cnpj_correto() {
        empresa.setCnpj("26631884000176");
        assertEquals("26631884000176", empresa.getCnpj());
    }

    @Test
    public void deve_aceitar_razao_social_correta() {
        empresa.setRazaoSocial("cocaColaEmpresa");
        assertEquals("cocaColaEmpresa", empresa.getRazaoSocial());
    }

    @Test
    public void deve_aceitar_contato_valido() {
        empresa.setContatos(contatos);
        assertEquals(contatos, empresa.getContatos());
    }

    @Test
    public void deve_aceitar_funcionario_valido() {
        empresa.setFuncionarios(funcionario);
        assertEquals(funcionario, empresa.getFuncionarios());
    }

    @Test
    public void deve_aceitar_endereco_valido() {
        empresa.setEnderecos(enderecos);
        assertEquals(enderecos, empresa.getEnderecos());

    }

    @Test
    public void testEmpresaHashCodeTrue() {
        assertEquals(empresaCompleta.hashCode(), empresaPadrao.hashCode());
    }
    @Test
    public void testEmpresaHashCodeFalse() {
        assertNotEquals(empresaCompleta.hashCode(), empresaErrada.hashCode());
    }
    @Test
    public void testEmpresaEqualsTrue() {
        assertEquals(empresaCompleta, empresaPadrao);
    }
    @Test
    public void testEmpresaEqualsFalse() {
        assertNotEquals(empresaErrada, empresaCompleta);
    }

    @Test
    public void testEmpresaToString() {
        String expectedString = "Empresa {cnpj= 502793028385, razaoSocial= Coca Cola, enderecos= [Endereco {logradouro= cambuci, numero= 22, bairro= barata Ribeiro, cidade= 01235000, uf= MA, complemento= apto 61, cep= 01233300}], funcionarios= [Funcionario {nomeCompleto= nome, Cargos= [Cargo {nome= analista, codigo= 553}], cpf= 50279302835, salario= 1000, dataNascimento= 2024-12-02T12:00, empresa= [Empresa {cnpj= 26631884000176, razaoSocial= null, enderecos= null, funcionarios= null, contatos= null], Contatos= [Contato {email= contmatic@gmail.com, telefones= [Telefone {DDD= DDD11, DDDI= 555, numero= 941584007]}]}], contatos= [Contato {email= contmatic@gmail.com, telefones= [Telefone {DDD= DDD11, DDDI= 555, numero= 941584007]}]";
        assertEquals(expectedString, empresaCompleta.toString());
    }

    @Test
    public void deve_aceitar_status_correto_de_atividade_correto() {
        empresa.setAtiva(true);
        assertEquals(true, empresa.getAtiva());
    }

    @Test
    public void nao_deve_aceitar_nome_com_mais_de_30_caracteres() {
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage(TAMANHO_DE_EMPRESA_ESTA_ACIMA_DE_60_CARACTERES);
        empresa.setNome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }

    @Test
    public void nao_deve_aceitar_nome_menor_que_3() {
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage(TAMANHO_DE_EMPRESA_ESTA_ABAIXO_DE_3_CARACTERES);
        empresa.setNome("s");
    }

    @Test
    public void nao_deve_aceitar_nome_vazio() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CAMPO_EMPRESA_ESTA_VAZIO);
        empresa.setNome("");
    }

    @Test
    public void nao_deve_aceitar_nome_nulo() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CAMPO_EMPRESA_ESTA_NULO);
        empresa.setNome(null);
    }

    @Test
    public void nao_deve_aceitar_razao_social_vazio() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CAMPO_RAZAO_SOCIAL_ESTA_VAZIO);
        empresa.setRazaoSocial("");
    }

    @Test
    public void nao_deve_aceitar_razao_social_nulo() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CAMPO_RAZAO_SOCIAL_ESTA_NULO);
        empresa.setRazaoSocial(null);
    }

    @Test
    public void nao_deve_aceitar_funcionario_social_nulo() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CAMPO_FUNCIONARIO_ESTA_NULO);
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(null);
        empresa.setFuncionarios(funcionarios);
    }

    @Test
    public void nao_deve_aceitar_razao_social_menor_que_10() {
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage(TAMANHO_DE_RAZAO_SOCIAL_ESTA_ABAIXO_DE_10_CARACTERES);
        empresa.setRazaoSocial("a");
    }

    @Test
    public void nao_deve_aceitar_razao_social_maior_que_60() {
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage(TAMANHO_DE_RAZAO_SOCIAL_ESTA_ACIMA_DE_60_CARACTERES);
        empresa.setRazaoSocial("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }

    @Test
    public void nao_deve_aceitar_numero_razao_social() {
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage(RAZAO_SOCIAL_TEM_NUMEROS);
        empresa.setRazaoSocial("234332323232");
    }

    @Test
    public void nao_deve_aceitar_status_correto_de_atividade_nulo() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CAMPO_STATUS_ESTA_NULO);
        empresa.setAtiva(null);
    }

    @Test
    public void nao_deve_aceitar_cnpj_com_caracteres_iguais() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CNPJ_REPETIDO_INVALIDO);
        empresa.setCnpj("00000000000000");
    }

    @Test
    public void nao_deve_aceitar_cnpj_invalido() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CNPJ_INVALIDO);
        empresa.setCnpj("74756244765647");
    }

    @Test
    public void nao_deve_aceitar_cnpj_com_menos_de_14_caracteres() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CNPJ_REPETIDO_INVALIDO);
        empresa.setCnpj("5454");
    }

    @Test
    public void nao_deve_aceitar_cnpj_nulo() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CNPJ_NULO);
        empresa.setCnpj(" ");
    }


}

