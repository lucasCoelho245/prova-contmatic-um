package br.com.contmatic.empresa;

import br.com.contmatic.contato.Contato;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import static br.com.contmatic.utils.Utils.*;
import static br.com.contmatic.utils.UtilsCpf.validarCpf;

public class Funcionario {
    private String cpf;

    private String nome;

    private List<Cargo> Cargos;

    private BigDecimal salario;

    private LocalDateTime dataNascimento;

    private List<Empresa> empresas;

    private List<Contato> contatos;

    public Funcionario() {
    }

    public Funcionario(String nome, List<Cargo> cargos, String cpf, BigDecimal salario, LocalDateTime dataNascimento,  List<Empresa> empresa, List<Contato> contatos) {
        this.nome = nome;
        Cargos = cargos;
        this.cpf = cpf;
        this.salario = salario;
        this.dataNascimento = dataNascimento;
        this.empresas = empresa;
        this.contatos = contatos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validarStringTamanhoMinimo(nome, 3, "nome", "Funcionario");
        validarStringTamanhoMaximo(nome, 40, "nome", "Funcionario");
        validarNumerosString(nome, "nome", "Funcionario" );
        validarObjetoNulo(nome, "nome", "Funcionario");
        validarCaracterEspecial(nome,"nome", "Funcionario");
        this.nome = nome;
    }

    public List<Cargo> getCargos() {
        return Cargos;
    }

    public void setCargos(List<Cargo> cargos) {
        validarObjetoNulo(cargos.get(0), "Cargo", "Funcionario");
        Cargos = cargos;
    }

    public List<Empresa> getEmpresa() {
        return empresas;
    }

    public void setEmpresa(List<Empresa> empresa) {
        validarObjetoNulo(empresa.get(0), "Empresa", "Funcionario");
        this.empresas = empresa;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        validarObjetoNulo(contatos.get(0), "contatos", "Funcionario");
        this.contatos = contatos;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        validarCpf(cpf, "contatos", "Funcionario");
        this.cpf = cpf;
    }

    public BigDecimal getSalario() {

        return salario;
    }

    public void setSalario(BigDecimal salario) {
        validarStringTamanhoMinimo(String.valueOf(salario), 3, "Salario", "Funcionario");
        this.salario = salario;
    }

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDateTime dataNascimento) {
        validarDate(dataNascimento, "data nascimento", "Funcionario");
        this.dataNascimento = dataNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Funcionario)) return false;
        Funcionario that = (Funcionario) o;
        return getCpf().equals(that.getCpf());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCpf());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Funcionario {nomeCompleto= ");
        builder.append(nome);
        builder.append(", Cargos= ");
        builder.append(Cargos);
        builder.append(", cpf= ");
        builder.append(cpf);
        builder.append(", salario= ");
        builder.append(salario);
        builder.append(", dataNascimento= ");
        builder.append(dataNascimento);
        builder.append(", empresa= ");
        builder.append(empresas);
        builder.append(", Contatos= ");
        builder.append(contatos);
        builder.append("}");
        return builder.toString();
    }
}