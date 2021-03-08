package CONTA;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		char question1, cont = '.', portalao;
		int mov = 0;
		double deposito;
		int saque;
		int niver;
		char funcao;
		char saida;
		double valor, credito;
		char opcao, opcao2;
		// String pegaresposta;

		//ContaCorrente pessoa = new ContaCorrente();

		do {
			System.out.println("[BANCO G-9]\n[SLOGAN]\n");
			System.out.println(" 1-CONTA POUPANÇA\n " + "2-CONTA CORRENTE\n " + "3-CONTA ESPECIAL\n "
					+ "4-CONTA EMPRESA\n " + "5-CONTA ESTUDANTIL\n " + "6-SAIR");
			question1 = leia.next().toUpperCase().charAt(0);

			// Conta poupança
			if (question1 == '1') {
				while (cont != 'N') {

					ContaPoupanca cp = new ContaPoupanca();

					System.out.println("Digite o número da conta");
					int numero = leia.nextInt();

					System.out.println("Digite o número do seu CPF");
					String cpf = leia.next();

					if (cp.getNumero() == numero && cp.getCpf().equalsIgnoreCase(cpf)) {
						System.out.println();
						System.out.println("__[BANCO G-9]__\n__[O BANCO FEITO PARA VOCÊ]__");
						System.out.println("\n__[CONTA POUPANÇA]__\n");
						System.out.println("Nº Conta Corrente: " + cp.getNumero());
						System.out.println("CPF do titular: " + cp.getCpf());

						System.out.println(
								"Digite C, para usar a função Credito, Digite D, para usar a função debito");
						question1 = leia.next().toUpperCase().charAt(0);

						if (question1 == 'C') {
							System.out.println("--> CREDITO <--");
							System.out.println("Digite seu deposito aqui: ");
							deposito = leia.nextDouble();
							cp.credito(deposito);
							System.out.println("Saldo atual: " + cp.getSaldo());
						} else {
							System.out.println("--> DEBITO <--");
							System.out.println("Digite seu deposito aqui: ");
							deposito = leia.nextDouble();
							cp.debito(deposito);
							System.out.println("Saldo atual: " + cp.getSaldo());
						}

						System.out.println("Para sacar digite a quantia aqui ou zero para continuar: ");
						saque = leia.nextInt();
						if (saque > cp.getSaldo()) {
							System.err.println("SAQUE NEGADO!");
							System.err.println("VALOR SOLICITADO MAIOR QUE O SALDO.");
						} else {
							cp.saqueBancario(saque);
							System.out.println("Saldo atual: " + (cp.getSaldo() - saque) + "R$ \n");
						}

						System.out.println("Para promoções informe o dia da criação da conta");
						niver = leia.nextInt();
						cp.correcao(niver);

						System.out.println("Para continuar depositando, digite 1. \n Para sair, digite 6.");
						question1 = leia.next().toUpperCase().charAt(0);
						if (question1 == '6') {
							break;
						}

						// System.out.println("Continuar depositando S/N ?");
						// saida = leia.next().toUpperCase().charAt(0);

					} else {
						System.err.println("---> SENHA OU LOGIN INVÁLIDOS <---");
						System.err.println("---> TENTE NOVAMENTE <---");
						break;
					}
				}
			} else if (question1 == '6') {
				// mov = 2;
				break;
			}

			// conta corrente
			if (question1 == '2') {
				while (cont != 'N') {
					System.out.println("[BANCO G-9]\n[SLOGAN]");
					System.out.println("\nCONTA[CONTA CORRENTE]\n");
				//	System.out.println("Saldo atual R$ " + pessoa.getSaldo());
				//	System.out.println("MOVIMENTOS-CREDITO " + pessoa.getMovimento());

					System.out.println("\nDeseja um talÃ£o? S/N ?");
					portalao = leia.next().toUpperCase().charAt(0);
					if (portalao == 'S') {
				//		pessoa.setContadorTalao();
				//		pessoa.setMovimento();
					}

					System.out.println("Continuar S/N ?");
					cont = leia.next().toUpperCase().charAt(0);

				}
			} 
			
			/* ======================= */
			/* PERFIL - CONTA ESPECIAL */
			/* ======================= */
			
			// Conta especial
			if (question1 == '3') {
				
				System.out.println("Digite o número da conta");
				int numero = leia.nextInt();

				System.out.println("Digite o número do seu CPF");
				String cpf = leia.next();
				
				boolean ativa = true;
				double limite = 1000;
				ContaEspecial ce = new ContaEspecial(numero, cpf, ativa, limite);
				
				while (cont != 'N' && ce.getContador() < 10) {
						
					if (ce.getNumero() == numero && ce.getCpf().equalsIgnoreCase(cpf)) {
						System.out.println();
						System.out.println("__[BANCO G-9]__\n__[O BANCO FEITO PARA VOCÊ]__");
						System.out.println("\n__[CONTA ESPECIAL]__\n");
						System.out.println("Nº Conta Corrente: " + ce.getNumero());
						System.out.println("CPF do titular: " + ce.getCpf());

						System.out.println("Digite C, para usar a função Credito, Digite D, para usar a função debito");
						question1 = leia.next().toUpperCase().charAt(0);

						if (question1 == 'C') {
							System.out.println("--> CREDITO <--");
							System.out.println("Digite seu deposito aqui: ");
							deposito = leia.nextDouble();
							
							ce.credito(deposito);
							System.out.println("Saldo atual: " + ce.getSaldo());
							
						} else {
							System.out.println("--> DEBITO <--");
							System.out.println("Digite seu deposito aqui: ");
							deposito = leia.nextDouble();
							
							ce.debito(deposito);
							System.out.println("Saldo atual: " + ce.getSaldo());
							
						}

					
						System.out.println("Para continuar depositando, digite 1. \n Para sair, digite 6.");
						question1 = leia.next().toUpperCase().charAt(0);
						
						if (question1 == '6') {
							break;
						}

				
					} else {
						System.err.println("---> SENHA OU LOGIN INVÁLIDOS <---");
						System.err.println("---> TENTE NOVAMENTE <---");
						break;
					}
				}
				if (ce.getContador() == 10) {
					System.out.println("Você atingiu o seu limite de Movimentos");
				}
			} else if (question1 == '6') {
				// mov = 2;
				break;
			}
			
			// conta estudantil
			if (question1 == '5') {
				while (cont != 'N') {
					
					ContaEstudantil minhaConta = new ContaEstudantil(001, "111222333-44");
					
					for(int x=0; x<10; x++) {
						System.out.println("Olá, informe o valor da transação: ");
						valor = leia.nextDouble();
						System.out.println("Deseja C-creditar ou D-debitar?");
						opcao = leia.next().toUpperCase().charAt(0);
						if (opcao == 'C') {
							
							minhaConta.credito(valor);
							
						} else if (opcao == 'D' ) {
							
							minhaConta.debito(valor);
							
						} 
						System.out.println("\nSeu saldo atual é de: "+minhaConta.getSaldo());
						
						
						System.out.printf("Você tem um limite de R$ %.2f, gostaria de utiliza-lo?\n",minhaConta.getLimiteEstudantil());
						System.out.println();
						System.out.println("Digite S - SIM ou N - NÃO");
						opcao2 = leia.next().toUpperCase().charAt(0);
						
						
						if (opcao2 == 'S') {
							System.out.println("Informe valor desejado: ");
							credito = leia.nextDouble();
							minhaConta.limite(credito);
							
							System.out.println("Seu saldo atual é de: "+minhaConta.getSaldo());
							
						} else if (opcao2 == 'N') {
							System.out.println("Seu saldo atual é de: "+minhaConta.getSaldo());
						}
					}

				}
			}else if (question1 == '6') {
				mov = 2;
			}

		} while (mov != 6);

		System.err.println("CAIXA FECHADO!!!\nNão esqueça de tirar o cartão da maquina!");
		leia.close();

	}

}