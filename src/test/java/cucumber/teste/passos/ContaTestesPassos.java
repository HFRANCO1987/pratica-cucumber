package cucumber.teste.passos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import cucumber.modelo.Conta;

public class ContaTestesPassos {

	 private Conta conta;
	  
     @Dado("^a conta criada para o dono \"(.*?)\" de numero (\\d+) com o limite (\\d+) e saldo (\\d+)$")
     public void a_conta_criada_para_o_dono_de_numero_com_o_limite_e_saldo(String dono, int numero, Double limite,
                  Double saldo) throws Throwable {
           // Defini��o de conta
           conta = new Conta(dono, numero, limite, saldo);
     }

     @Quando("^o dono realiza o deposito no valor de (\\d+) na conta$")
     public void o_dono_realiza_o_deposito_no_valor_de_na_conta(Double valorDeposito) throws Throwable {
           assertTrue("O dono " + conta.getDono() + " n�o tem limite dispon�vel na conta para este valor de deposito",
                         conta.depositar(valorDeposito));
     }

     @E("^o dono realiza o primeiro saque no valor de (\\d+) na conta$")
     public void o_dono_realiza_o_primeiro_saque_no_valor_de_na_conta(Double valorSaque) throws Throwable {
           assertTrue("O dono " + conta.getDono() + " n�o tem saldo dispon�vel na conta para este valor de saque",
                         conta.sacar(valorSaque));
     }

     @E("^o dono realiza o segundo saque no valor de (\\d+) na conta$")
     public void o_dono_realiza_o_segundo_saque_no_valor_de_na_conta(Double valorSaque) throws Throwable {
           assertTrue("O dono " + conta.getDono() + " n�o tem saldo dispon�vel na conta para este valor de saque",
                         conta.sacar(valorSaque));
     }

     @Entao("^o dono tem o saldo no valor de (\\d+) na conta$")
     public void o_dono_tem_o_saldo_na_conta_no_valor_de(Double saldoEsperado) throws Throwable {
           assertEquals("O dono " + conta.getDono() + " est� com o saldo incorreto na conta", saldoEsperado,
                         conta.getSaldo());
     }
	
}
