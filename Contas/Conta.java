package CONTA;

public abstract class Conta {

	private int numero = 12345;
	private String cpf = "987987987";
	private double saldo = 0;
	private boolean ativa;

	public Conta() {

	}

	public Conta(int numero, String cpf, double saldo, boolean ativa) {
		super();
		this.numero = numero;
		this.cpf = cpf;
		this.saldo = saldo;
		this.ativa = ativa;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getSaldo() {
		return saldo;
	}

	public boolean isAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

	public void credito(double credito) {
		this.saldo = saldo + credito;
	}

	public void debito(double debito) {
		this.saldo = saldo + debito;
	}
	
	/*
	public void debito(double valor) {
		if (valor >= this.saldo) {
			this.saldo = this.saldo - valor;
		} else {
			System.out.println("Você não tem saldo suficiente!");
		}
	}
	*/
}
