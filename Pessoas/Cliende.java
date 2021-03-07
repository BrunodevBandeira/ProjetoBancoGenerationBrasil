package Pessoas;

import java.util.Scanner;

public class Cliende {
	public static void main(String[] args) {

		int saldo;
		int deposito;
		int saque;
		int consultaDeJuros;
		int sair;

		try {
			while (true) {
				Scanner teclado = new Scanner(System.in);

				System.out.println("BEM VINDO AO BANCO G9");

				System.out.println("Digite 1 para ver seu saldo");
				saldo = teclado.nextInt();

				System.out.println("Digite 2 para DEPOSITAR");
				deposito = teclado.nextInt();

				System.out.println("Digite 3 para SACAR");
				saque = teclado.nextInt();

				System.out.println("Digite 4 para consultar o juros da sua poupança");
				consultaDeJuros = teclado.nextInt();

				System.out.println("Caso deseje sair dos sistema, apenas digite 0");
				sair = teclado.nextInt();

				if (sair == 0) {
					System.out.println("Tenha uma boa tarde");
					break;
				}
			}

		} catch (Exception e) {
			System.err.println("ERRO NO SISTEMA");
		}
	}
}
