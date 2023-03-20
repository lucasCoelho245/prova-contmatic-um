package br.com.contmatic.empresa;

import br.com.contmatic.empresa.constants.cargo.CargoConstants;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;
import static br.com.contmatic.empresa.constants.cargo.CargoConstants.*;

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
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

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

        assertEquals(CargoConstants.cargoCompleto.hashCode(), cargoPadrao.hashCode());
        assertNotEquals(cargoCompleto.hashCode(), cargoErrado.hashCode());

        assertTrue(cargoCompleto.equals(cargoPadrao));
        assertFalse(cargoErrado.equals(cargoCompleto));
    }

    @Test
    public void testCargoToString() {
        String expectedString = "Cargo {nome= lucas, codigo= 555}";
        assertEquals(expectedString, cargoCompleto.toString());
    }
    @Test
    public void nao_deve_aceitar_nome_menor_que_2() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(TAMANHO_DE_CARGO_ESTÁ_ABAIXO_DE_2_CARACTERES);
        cargo.setNome("s");
    }

    @Test
    public void nao_deve_aceitar_nome_maior_que_60() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(TAMANHO_DE_CARGO_ESTÁ_ACIMA_DE_60_CARACTERES);
        cargo.setNome("shshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshsh");
    }
    @Test
    public void nome_nao_deve_aceitar_numeros() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(NOME_DE_CARGO_TEM_NUMEROS);
        cargo.setNome("3223232");
    }

    @Test
    public void nao_deve_aceitar_nome_nulo() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(NOME_DE_CARGO_ESTA_NULO);
        cargo.setNome(null);
    }
    @Test
    public void nao_deve_aceitar_nome_vazio() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(NOME_DE_CARGO_ESTA_VAZIO);
        cargo.setNome("");
    }

    @Test
    public void nao_deve_aceitar_nome_setor_menor_que_3() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(SETOR_NAO_DEVE_TER_MENOS_DE_3_CARACTERES);
        cargo.setSetor("s");
    }

    @Test
    public void nao_deve_aceitar_setor_vazio() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(SETOR_DE_CARGO_ESTA_VAZIO);
        cargo.setSetor("");
    }
    @Test
    public void nao_deve_aceitar_setor_nulo() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(SETOR_DE_CARGO_ESTA_NULO);
        cargo.setSetor(null);
    }
    @Test
    public void nao_deve_aceitar_setor_maior_que_30() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(TAMANHO_DE_SETOR_DE_CARGO_ESTÁ_ACIMA_DE_30_CARACTERES);
        cargo.setSetor("shshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshshsh");
    }

    @Test
    public void nao_deve_aceitar_codigo_nulo() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CODIGO_DE_CARGO_ESTA_NULO);
        cargo.setCodigo(null);
    }

    @Test
    public void nao_deve_aceitar_codigo_menor_que_2() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(TAMANHO_DE_CODIGO_ESTÁ_ABAIXO_DE_2_CARACTERES);
        cargo.setCodigo(1);
    }


}
