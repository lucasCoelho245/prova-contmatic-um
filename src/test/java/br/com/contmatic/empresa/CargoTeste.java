package br.com.contmatic.empresa;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CargoTeste {
    private Cargo cargo;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Iniciamos os testes na classe Cargo");
    }

    @Before
    public void setBeforeCargo() {
        cargo = new Cargo();
    }

    @Test
    public void deve_aceitar_nome_correto() {
        cargo.setNome("lucas");
    }

    @Test
    public void deve_aceitar_setor_correto() {
        cargo.setSetor("tecnologia");
    }

    @Test
    public void deve_aceitar_codigo_correto() {
        cargo.setCodigo(54521);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_menor_que_2() {
        cargo.setNome("s");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_maior_que_60() {
        cargo.setNome("shshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshsh");
    }
    @Test(expected = IllegalArgumentException.class)
    public void nome_nao_deve_aceitar_numeros_() {
        cargo.setNome("3223232");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_nulo() {
        cargo.setNome("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_caracter_especial_setor() {
        cargo.setSetor("ç");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_setor_menor_que_3() {
        cargo.setSetor("s");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_setor_nulo() {
        cargo.setSetor("");
    }
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_setor_maior_que_30() {
        cargo.setSetor("shshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshsh");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_codigo_nulo() {
        cargo.setCodigo("".length());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_codigo_menor_que_2() {
        cargo.setCodigo(1);
    }


}
