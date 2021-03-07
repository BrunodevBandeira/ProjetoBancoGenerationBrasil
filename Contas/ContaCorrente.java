package Contas;

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
            System.out.println("Desculpe você não tem mais talão para ser usado!");
        } else {
            this.contadorTalao = this.contadorTalao - 1;
            System.out.println("Vocêª solicitou um talão.\n Vocêª tem " + contadorTalao + " Talões restantes");
        }
    }

    // movimentos
    public int getMovimento() {
        return movimento;
    }

    void setMovimento() {
        this.movimento = movimento - 1;

        if (movimento <= 0) {
            System.out.println("Suas movimentações diarias acabaram! ");

        }
    }
}