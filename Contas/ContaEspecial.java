package Contas;
	
public class ContaEspecial extends Conta {
	
	private double limite;
	private int contador=0; 
	
			
	

	public ContaEspecial(double limite, int contador) {
		super();
		this.limite = limite;
		this.contador = contador;
	}
	
	public void setLimite(double limite) { // definir valor.
		this.limite= limite ;
		
	}
	public double getLimite() {   // imprimi o valor desejado!
 		return this.limite;
	}
	public int getContador() {
		return this.contador;
	}
	
	public void setContador (int cont) {
	    this.contador = cont;
	}
	@Override
	public void credito(double valor) {
		// TODO Auto-generated method stub
		super.credito(valor);
		if(valor>0) {
		this.contadorMovivemento();
		
		}
	}

	@Override
	public void debito(double valor) {
		// TODO Auto-generated method stub
		// super.debito(valor);
		this.saldo = this.getSaldo()- valor ;
		
		if (this.getSaldo()<0 && valor <= this.getLimite()) {
			System.out.println(" Seu saldo � insuficiente, voc� esta utilizando o seu limite de credito! ");
			
			this.usarLimite(this.getSaldo());
			
			System.out.println("O seu limite atual � : "+ this.getLimite());
			this.saldo = 0;
			
			this.contadorMovivemento();
		}
		else {
			System.out.println("O saldo atual � "+ this.getSaldo());
				this.contadorMovivemento();
		}
	}

	public double usarLimite (double valor) {
		this.setLimite(valor+ this.getLimite());
		
		return this.getLimite();	
	}
	
	public void contadorMovivemento () {
		this.setContador(this.getContador()+1);
	}
}

		