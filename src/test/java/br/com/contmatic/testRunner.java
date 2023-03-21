package br.com.contmatic;

import br.com.contmatic.auditoria.TestAuditoria;
import br.com.contmatic.contatoTests.*;
import br.com.contmatic.empresa.*;
import br.com.contmatic.endereco.TestEndereco;
import br.com.contmatic.utils.TestUtilsCnpj;
import br.com.contmatic.utils.TestUtilsCpf;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
public class testRunner {
    public static void main(String[] args) {
        Result classes = JUnitCore.runClasses(TestEmpresa.class, TestAuditoria.class, TestContato.class , TestTelefone.class, TestCargo.class, TestCliente.class, TestFornecedor.class, TestFuncionario.class, TestProduto.class, TestEndereco.class, TestUtilsCnpj.class, TestUtilsCpf.class);

        for (Failure failure : classes.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(classes.wasSuccessful());
    }
}
