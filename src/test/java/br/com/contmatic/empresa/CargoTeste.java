package br.com.contmatic.empresa;

import br.com.contmatic.contato.Telefone;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static br.com.contmatic.contato.DDDType.DDD11;
import static org.junit.Assert.*;

public class CargoTeste {
    private Cargo cargo;

    private Cargo cargoCompleto = new Cargo("lucas", "contabilidade", 555);
    private Cargo cargoErrado = new Cargo("gerson", "teste", 5434355);

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
        assertEquals(cargo.getNome(), "lucas");
    }

    @Test
    public void deve_aceitar_setor_correto() {
        cargo.setSetor("tecnologia");
        assertEquals(cargo.getSetor(), "tecnologia");
    }

    @Test
    public void deve_aceitar_codigo_correto() {
        Integer codigo = 54521;
        cargo.setCodigo(54521);
        assertEquals(cargo.getCodigo(), codigo);
    }
    @Test
    public void testCargoEqualsAndHashCode() {
        Cargo cargoPadrao = new Cargo("lucas", "contabilidade", 555);

        assertEquals(cargoCompleto.hashCode(), cargoPadrao.hashCode());
        assertNotEquals(cargoCompleto.hashCode(), cargoErrado.hashCode());

        assertTrue(cargoCompleto.equals(cargoPadrao));
        assertFalse(cargoErrado.equals(cargoCompleto));
    }

    @Test
    public void testCargoToString() {
        String expectedString = "Cargo {nome= lucas, codigo= 555}";
        assertEquals(expectedString, cargoCompleto.toString());
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
