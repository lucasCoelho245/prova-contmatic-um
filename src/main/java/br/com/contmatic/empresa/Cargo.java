package br.com.contmatic.empresa;

import java.util.Objects;

import static br.com.contmatic.utils.Utils.*;

public class Cargo {
    private String nome;
    private String setor;
    private Integer codigo;

    private String setorCargo = "setorCargo";
    private String nomeClasse = "cargo";
    private String nomeCargo = "nome";

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
        validarStringTamanhoMinimo(setor, 2, setorCargo, nomeClasse);
        validarStringTamanhoMaximo(setor, 30, setorCargo, nomeClasse);
        validarObjetoNulo(setor, setorCargo, nomeClasse);
        validarCaracterEspecial(setor, setorCargo, nomeClasse);
        this.setor = setor;
    }

    public void setNome(String nome) {
        validarStringTamanhoMinimo(nome, 2, nomeCargo, nomeClasse);
        validarStringTamanhoMaximo(nome, 60, nomeCargo, nomeClasse);
        validarNumerosString(nome, nomeCargo, nomeClasse);
        validarObjetoNulo(nome, nomeCargo, nomeClasse);
        this.nome = nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        validarObjetoNulo(codigo, "Codigo", nomeClasse);
        validarStringTamanhoMinimo(codigo.toString(), 2, "Codigo", nomeClasse);
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
