package br.com.contmatic.empresa;

import br.com.contmatic.contato.Contato;
import br.com.contmatic.contato.Telefone;
import br.com.contmatic.endereco.Endereco;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static br.com.contmatic.contato.DDDType.DDD11;
import static br.com.contmatic.endereco.UFType.MA;
import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class EmpresaTeste {
    private Empresa empresa;

    private BigDecimal salario = new BigDecimal(1000);

    private List<Empresa> empresas = new ArrayList<>();

    private LocalDateTime data = LocalDateTime.of(2024, 12, 2, 12, 00);

    private List<Telefone> telefones = new ArrayList<>();

    private List<Contato> contatos = new ArrayList<>();

    private List<Cargo> cargos = new ArrayList<>();

    private List<Endereco> enderecos = new ArrayList<>();

    private List<Funcionario> funcionario = new ArrayList<>();
    private Empresa empresaCompleta = new Empresa("502793028385","Coca Cola Indústrias Ltda", enderecos, funcionario, contatos);
    private Empresa empresaErrada = new Empresa("502993028385","Coca Cola", enderecos, funcionario, contatos);

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Iniciamos os testes na classe empresa");
    }

    @Before
    public void setBeforeFornecedor() {
        empresa = new Empresa();

        telefones.add(new Telefone(DDD11, 555, "941584007"));

        contatos.add(new Contato("contmatic@gmail.com", telefones));

        cargos.add(new Cargo("analista", "desenvolvimento", 553));

        empresas.add(new Empresa("26631884000176"));

        funcionario.add(new Funcionario("nome", cargos, "50279302835", salario, data, empresas, contatos));

        enderecos.add(new Endereco("cambuci", 22, "barata Ribeiro" ,"01235000", MA ,"apto 61", "01233300"));
    }

    @Test
    public void deve_aceitar_nome_correto() {
        empresa.setNome("salgadelicia");
        assertEquals(empresa.getNome(), "salgadelicia");
    }

    @Test
    public void deve_aceitar_cnpj_correto() {
        empresa.setCnpj("26631884000176");
        assertEquals(empresa.getCnpj(), "26631884000176");
    }

    @Test
    public void deve_aceitar_razao_social_correta() {
        empresa.setRazaoSocial("Coca Cola Indústrias Ltda");
        assertEquals(empresa.getRazaoSocial(), "Coca Cola Indústrias Ltda");
    }

    @Test
    public void deve_aceitar_contato_valido() {
        empresa.setContatos(contatos);
        assertEquals(empresa.getContatos(), contatos);
    }

    @Test
    public void deve_aceitar_funcionario_valido() {
        empresa.setFuncionarios(funcionario);
        assertEquals(empresa.getFuncionarios(), funcionario);
    }

    @Test
    public void deve_aceitar_endereco_valido() {
        empresa.setEnderecos(enderecos);
        assertEquals(empresa.getEnderecos(), enderecos);

    }
    @Test
    public void testEmpresaEqualsAndHashCode() {
        Empresa empresaPadrao = new Empresa("502793028385","Coca Cola Indústrias Ltda", enderecos, funcionario, contatos);

        assertEquals(empresaCompleta.hashCode(), empresaPadrao.hashCode());
        assertNotEquals(empresaCompleta.hashCode(), empresaErrada.hashCode());

        assertTrue(empresaCompleta.equals(empresaPadrao));
        assertFalse(empresaErrada.equals(empresaCompleta));
    }

    @Test
    public void testEmpresaToString() {
        String expectedString = "Empresa {cnpj= 502793028385, razaoSocial= Coca Cola Indústrias Ltda, enderecos= [Endereco {logradouro= cambuci, numero= 22, bairro= barata Ribeiro, cidade= 01235000, uf= MA, complemento= apto 61, cep= 01233300}], funcionarios= [Funcionario {nomeCompleto= nome, Cargos= [Cargo {nome= analista, codigo= 553}], cpf= 50279302835, salario= 1000, dataNascimento= 2024-12-02T12:00, empresa= [Empresa {cnpj= 26631884000176, razaoSocial= null, enderecos= null, funcionarios= null, contatos= null], Contatos= [Contato {email= contmatic@gmail.com, telefones= [Telefone {DDD= DDD11, DDDI= 555, numero= 941584007]}]}], contatos= [Contato {email= contmatic@gmail.com, telefones= [Telefone {DDD= DDD11, DDDI= 555, numero= 941584007]}]";
        assertEquals(expectedString, empresaCompleta.toString());
    }
    @Test
    public void deve_aceitar_status_correto_de_atividade_correto() {
        empresa.setAtiva(true);
        assertEquals(empresa.getAtiva(), true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_com_mais_de_30_caracteres() {
        empresa.setNome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_menor_que_3() {
        empresa.setNome("s");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_nulo() {
        empresa.setNome("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_razao_social_nulo() {
        empresa.setRazaoSocial("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_funcionario_social_nulo() {
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(null);
        empresa.setFuncionarios(funcionarios);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_razao_social_menor_que_10() {
        empresa.setRazaoSocial("a");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_razao_social_maior_que_10() {
        empresa.setRazaoSocial("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numero_razao_social() {
        empresa.setRazaoSocial("2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_caracter_especial_razao_social() {
        empresa.setRazaoSocial("%sdfdsfsd");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_status_correto_de_atividade_nulo() {
        empresa.setAtiva(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_com_caracteres_iguais() {
        empresa.setCnpj("00000000000000");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_invalido() {
        empresa.setCnpj("74756244765647");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_com_mais_de_14_caracteres() {
        empresa.setCnpj("7475624476564722232");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_com_menos_de_14_caracteres() {
        empresa.setCnpj("5454");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_nulo() {
        empresa.setCnpj(" ");
    }


}
