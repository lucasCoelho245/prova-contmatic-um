package br.com.contmatic;

import br.com.contmatic.auditoria.AuditoriaTeste;
import br.com.contmatic.contatoTests.*;
import br.com.contmatic.empresa.*;
import br.com.contmatic.endereco.EnderecoTeste;
import br.com.contmatic.utils.UtilsCnpjTest;
import br.com.contmatic.utils.UtilsCpfTest;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
public class testRunner {
    public static void main(String[] args) {
        Result classes = JUnitCore.runClasses(EmpresaTeste.class, AuditoriaTeste.class, ContatoTeste.class , TelefoneTeste.class, CargoTeste.class, ClienteTeste.class, FornecedorTeste.class, FuncionarioTeste.class, ProdutoTeste.class, EnderecoTeste.class, UtilsCnpjTest.class, UtilsCpfTest.class);

        for (Failure failure : classes.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(classes.wasSuccessful());
    }
}
