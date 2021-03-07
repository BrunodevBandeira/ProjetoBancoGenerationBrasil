	package Contas;
	
	public class ContaPoupanca extends Conta{
	
		    int diaAniversarioConta = 5;
		 
		    public ContaPoupanca() {
	
		     }
	
		    public ContaPoupanca(int numero, String cpf) {
		        super();
		     }
	
		    public ContaPoupanca(int diaAniversarioConta) {
		        super();
		        this.diaAniversarioConta = diaAniversarioConta;
		      }
	
	
		    public void saqueBancario(int saque) {
		        if (saque < getSaldo()) {
		            //getSaldo() = getSaldo() - saque;
		            System.out.println("O seu saque de: " + saque + " foi efetuado com sucesso");
	
		        } else {
		            System.err.println("Saque maior que saldo total.");
		        }
	
		        if (saque == getSaldo()) {
		            System.out.println("O seu saque de: " + saque + " foi efetuado com sucesso");
		        }
		    }
	
		    public void correcao(int niverDaConta) {
		        if (diaAniversarioConta == niverDaConta) {
		            System.out.println("-------> Parabéns o ajuste foi dado em 5%.");
		            String texto = "-------> O seu novo saldo é:  ";
		            System.out.println(texto + ((getSaldo()*0.05) + getSaldo()) + "R$");
	
		        } else {
		            System.err.println("-------> A data não bate, deixou de ganhar 5%.");
		        }
		    }
		}
	
