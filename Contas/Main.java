package Contas;

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
		int contador = 0;
		// String pegaresposta;

		ContaCorrente pessoa = new ContaCorrente();

		do {
			System.out.println("[BANCO G-9]\n[SLOGAN]\n");
			System.out.println(" 1-CONTA POUPANÇA\n " + "2-CONTA CORRENTE\n " + "3-CONTA ESPECIAL\n "
					+ "4-CONTA EMPRESA\n " + "5-CONTA ESTUDANTIL\n " + "6-SAIR");
			question1 = leia.next().toUpperCase().charAt(0);

			// Conta poupança--------------------------------------------------------------------------------------------------------
			
			if (question1 == '1') {
				for (contador = 1; contador < 10; contador++) {
					System.out.println();
					System.err.println("Você pode movimentar sua conta 10 vezes " + "\nNúmero de vezes: " + contador);


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
				System.err.println("Movimentação limite do sistema alcançado.");
				System.err.println("SISTEMA ENCERRADO.");
			} else if (question1 == '6') {
				mov = 2;
				break;
			}
		
		

			// conta corrente-----------------------------------------------------------------------------
			if (question1 == '2') {
				while (cont != 'N') {
					System.out.println("[BANCO G-9]\n[SLOGAN]");
					System.out.println("\nCONTA[CONTA CORRENTE]\n");
					System.out.println("Saldo atual R$ " + pessoa.getSaldo());
					System.out.println("MOVIMENTOS-CREDITO " + pessoa.getMovimento());
					
					System.out.println("Ol�, informe o valor da transação: ");
					valor = leia.nextDouble();
					System.out.println("Deseja C-creditar ou D-debitar?");
					opcao = leia.next().toUpperCase().charAt(0);
					if (opcao == 'C') {

						pessoa.credito(valor);

					} else if (opcao == 'D' ) {

						pessoa.debito(valor);

					} 
					System.out.println("\nSeu saldo atual é de: "+pessoa.getSaldo());

					System.out.println("\nDeseja um talÃ£o? S/N ?");
					portalao = leia.next().toUpperCase().charAt(0);
					if (portalao == 'S') {
						pessoa.setContadorTalao();
						pessoa.setMovimento();
					}

					System.out.println("Continuar S/N ?");
					cont = leia.next().toUpperCase().charAt(0);

				}
			}
			
			// ContaEmpresa ---------------------------------------------------------------------------------------------
						if(question1 =='4') {

							while (cont != 'N') {
								ContaEmpresa pessoa1 = new ContaEmpresa();
								
								System.out.println("[BANCO G-9]\n[SLOGAN]");
								System.out.println("\nCONTA[CONTA EMPRESA]\n");
								System.out.println("Saldo atual R$ " + pessoa1.getSaldo());
								System.out.println(pessoa1.getMovimento()+" MOVIMENTOS da CONTA EMPRESA ");

								System.out.println("Ol�, informe o valor da transação: ");
								valor = leia.nextDouble();
								System.out.println("Deseja C-creditar ou D-debitar?");
								opcao = leia.next().toUpperCase().charAt(0);
								if (opcao == 'C') {

									pessoa1.credito(valor);
									pessoa1.setMovimento();

								} else if (opcao == 'D' ) {

									pessoa1.debito(valor);
									pessoa1.setMovimento();

								} 
								System.out.println("\nSeu saldo atual é de: "+pessoa1.getSaldo());

								System.out.printf("Voc� tem um limite de R$ %.2f, gostaria de utiliza-lo?\n",pessoa1.getEmprestimoEmpresa());
								System.out.println();
								System.out.println("Digite S - SIM ou N - NÃO");
								opcao2 = leia.next().toUpperCase().charAt(0);


								if (opcao2 == 'S') {
									System.out.println("Informe valor desejado: ");
									credito = leia.nextDouble();
									pessoa1.limite(credito);
									pessoa1.setMovimento();

									System.out.println("Seu saldo atual é de: "+pessoa1.getSaldo());

								} else if (opcao2 == 'N') {
									System.out.println("Seu saldo atual é de: "+pessoa1.getSaldo());
								}




							}

						}
			
		
			
			// conta estudantil-----------------------------------------
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
							
							System.out.println("\nSeu saldo atual é de: R$"+minhaConta.getSaldo());							
						} else if (opcao2 == 'N') {
							System.out.println("Seu saldo atual é de: "+minhaConta.getSaldo());
						}
					}

				}
			}else if (question1 == '6') {
				mov = 2;
			}

		} while (mov != 6);

		System.err.println("Aplicativo encerrado!");		
		leia.close();
		}
	}

