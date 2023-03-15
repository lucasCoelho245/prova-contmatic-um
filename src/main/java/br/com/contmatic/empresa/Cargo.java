package br.com.contmatic.empresa;

import java.util.Objects;

import static br.com.contmatic.utils.Utils.*;

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
        validarStringTamanhoMinimo(setor, 2, "setor", "Cargo");
        validarStringTamanhoMaximo(setor, 30, "setor", "Cargo");
        validarObjetoNulo(setor, "setor", "Cargo");
        validarCaracterEspecial(setor, "setor", "Cargo");
        this.setor = setor;
    }

    public void setNome(String nome) {
        validarStringTamanhoMinimo(nome, 2, "Nome", "Cargo");
        validarStringTamanhoMaximo(nome, 60, "Nome", "Cargo");
        validarNumerosString(nome, "Nome", "Cargo");
        validarObjetoNulo(nome, "Nome", "Cargo");
        this.nome = nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        validarObjetoNulo(codigo, "Codigo", "Cargo");
        validarStringTamanhoMinimo(codigo.toString(), 2, "Codigo", "Cargo");
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
