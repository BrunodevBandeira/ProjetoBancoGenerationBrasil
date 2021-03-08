package Contas;

//Miria Santos

public class ContaEstudantil extends Conta {
		private double limiteEstudantil=5000;

		public ContaEstudantil(int numero, String cpf) {
			super(numero, cpf);
		}

		public double getLimiteEstudantil() {
			return limiteEstudantil;
		}

		public void setLimiteEstudantil(double limiteEstudantil) {
			this.limiteEstudantil = limiteEstudantil;
		}
		
		@Override
		public void debito(double valor) {
			if (this.saldo>=valor) {
				this.saldo = this.saldo - valor;
			} else if (valor>saldo) {
				System.out.println("VOCÊ NÃO TEM SALDO PARA ESSA OPERAÇÃO.\n");
			}
		}
		
		public void limite(double credito) {
			if (credito<=limiteEstudantil) {
				this.limiteEstudantil = limiteEstudantil - credito;	
				this.saldo = this.saldo + credito;						
			} else if (credito>limiteEstudantil) {
				System.out.println("ESSE VALOR EXCEDE SEU LIMITE DE CRÉDITO!\n");
			}
		}
}
