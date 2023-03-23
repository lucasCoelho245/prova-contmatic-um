package br.com.contmatic.empresa;

import br.com.contmatic.contato.Contato;
import br.com.contmatic.utils.ValidaDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import static br.com.contmatic.utils.UtilsConstantes.*;
import static br.com.contmatic.utils.ValidadoresUtils.*;
import static br.com.contmatic.utils.UtilsCpf.validarCpf;

public class Funcionario {
    private String cpf;

    private String nome;

    private List<Cargo> cargos;

    private BigDecimal salario;

    private LocalDateTime dataNascimento;

    private List<Empresa> empresas;

    private List<Contato> contatos;

    public Funcionario() {
    }




    public Funcionario(String nome, List<Cargo> cargos, String cpf, BigDecimal salario, LocalDateTime dataNascimento,  List<Empresa> empresa, List<Contato> contatos) {
        this.nome = nome;
        this.cargos = cargos;
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
        validarStringTamanhoMinimo(nome, 3, FUNCIONARIO_NOME, NOME_CLASSE_FUNCIONARIO);
        validarStringTamanhoMaximo(nome, 40, FUNCIONARIO_NOME, NOME_CLASSE_FUNCIONARIO);
        validarNumerosString(nome, FUNCIONARIO_NOME, NOME_CLASSE_FUNCIONARIO);
        validarObjetoNulo(nome, FUNCIONARIO_NOME, NOME_CLASSE_FUNCIONARIO);
        this.nome = nome;
    }

    public List<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(List<Cargo> cargos) {
        validarObjetoNulo(cargos.get(0), FUNCIONARIO_CARGO, NOME_CLASSE_FUNCIONARIO);
        this.cargos = cargos;
    }

    public List<Empresa> getEmpresa() {
        return empresas;
    }

    public void setEmpresa(List<Empresa> empresa) {
        validarObjetoNulo(empresa.get(0), FUNCIONARIO_EMPRESA, NOME_CLASSE_FUNCIONARIO);
        this.empresas = empresa;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        validarObjetoNulo(contatos.get(0), "contatos", NOME_CLASSE_FUNCIONARIO);
        this.contatos = contatos;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        validarCpf(cpf, "contatos", NOME_CLASSE_FUNCIONARIO);
        this.cpf = cpf;
    }

    public BigDecimal getSalario() {

        return salario;
    }

    public void setSalario(BigDecimal salario) {
        validarStringTamanhoMinimo(String.valueOf(salario), 3, "Salario", NOME_CLASSE_FUNCIONARIO);
        this.salario = salario;
    }

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDateTime dataNascimento) {
        ValidaDate.isValidLocalDateTime(dataNascimento, "data nascimento", NOME_CLASSE_FUNCIONARIO);
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
        builder.append(cargos);
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
