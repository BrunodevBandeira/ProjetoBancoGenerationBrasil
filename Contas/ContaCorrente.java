package Contas;

// Daniel ---------------------------------------->
public class ContaCorrente extends Conta {
    private int contadorTalao = 3;
    private int movimento = 10;

    public ContaCorrente() {

    }

    public ContaCorrente(int contadorTalao, int movimento) {
        super();
        this.contadorTalao = contadorTalao;
        this.movimento = movimento;
    }

    public int getContadorTalao() {
        return contadorTalao;
    }

    void setContadorTalao() {
        if (contadorTalao <= 0) {
            System.out.println("Desculpe voc� n�o tem mais tal�o para ser usado!");
        } else {
            this.contadorTalao = this.contadorTalao - 1;
            System.out.println("Voc� solicitou um tal�o.\n Voc� tem " + contadorTalao + " Tal�es restantes");
        }
    }

    @Override
	public void debito(double valor) {
		if (this.saldo>=valor) {
			this.saldo = this.saldo - valor;
		} else if (valor>saldo) {
			System.out.println("VOC� N�O TEM SALDO PARA ESSA OPERA��O.\n");
		}
	}
    // movimentos
    public int getMovimento() {
        return movimento;
    }

    void setMovimento() {
        this.movimento = movimento - 1;

        if (movimento <= 0) {
            System.out.println("Suas movimenta��es diarias acabaram! ");

        }
    }
}