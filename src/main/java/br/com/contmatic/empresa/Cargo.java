package br.com.contmatic.empresa;

import java.util.Objects;
import static br.com.contmatic.utils.UtilsConstantes.*;

import static br.com.contmatic.utils.ValidadoresUtils.*;

public class Cargo {
    private String nome;
    private String setor;
    private Integer codigo;


    public Cargo(String nome, String setor, Integer codigo) {
        this.nome = nome;
        this.setor = setor;
        this.codigo = codigo;
    }

    public Cargo() {

    }


    public String getNome() {
        return nome;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        validarObjetoNulo(setor, SETOR_CARGO, NOME_CLASSE_CARGO);
        validarStringVazio(setor, SETOR_CARGO, NOME_CLASSE_CARGO);
        validarStringTamanhoMinimo(setor, 2, SETOR_CARGO, NOME_CLASSE_CARGO);
        validarStringTamanhoMaximo(setor, 30, SETOR_CARGO, NOME_CLASSE_CARGO);
        this.setor = setor;
    }

    public void setNome(String nome) {
        validarObjetoNulo(nome, NOME_CARGO, NOME_CLASSE_CARGO);
        validarStringVazio(nome, NOME_CARGO, NOME_CLASSE_CARGO);
        validarStringTamanhoMinimo(nome, 2, NOME_CARGO, NOME_CLASSE_CARGO);
        validarStringTamanhoMaximo(nome, 60, NOME_CARGO, NOME_CLASSE_CARGO);
        validarNumerosString(nome, NOME_CARGO, NOME_CLASSE_CARGO);
        this.nome = nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        validarObjetoNulo(codigo, "Codigo", NOME_CLASSE_CARGO);
        validarStringTamanhoMinimo(codigo.toString(), 2, "Codigo", NOME_CLASSE_CARGO);
        this.codigo = codigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cargo)) return false;
        Cargo cargo = (Cargo) o;
        return getCodigo().equals(cargo.getCodigo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigo());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Cargo {nome= ");
        builder.append(nome);
        builder.append(", codigo= ");
        builder.append(codigo);
        builder.append("}");
        return builder.toString();
    }
}
