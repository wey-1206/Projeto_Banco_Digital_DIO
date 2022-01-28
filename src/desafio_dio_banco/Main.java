package desafio_dio_banco;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;
//import desafio_dio_banco.Conta;
public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		char resp ;
		List<Conta> contas = new ArrayList<Conta>();
		Boolean ContaEncontrada = false;
		Boolean	Conta2Encontrada = false;
		Conta Depositante = null;
		Conta Recebedor = null;
		Boolean OperacaoRealizada = null;
		Boolean existeConta = null;
/*
 	CRIEI UMA LISTA 10  "VENILTON" PARA A MANIPULAÇÃO DO SISTEMA 
    SEM A NECESSIDADE DE CRIAR UMA NOVA CONTA 
*/		
		
		for(int i = 0; i < 9; i++) {
			Cliente venilton = new Cliente();
			venilton.setNome("Venilton" + (i+1));
			Conta cc = new Conta_corrente(venilton);
			contas.add(cc);

		}
		
		System.out.println("Bem vindo a DioPay!");
		System.out.println("Estes são os serviços que oferecemos: ");
		do {
			 resp = 0;
				System.out.printf(".........................%n");
				System.out.println("Abertura de conta     [1]");
				System.out.println("Listagem de contas    [2]");

				System.out.println("Saque		      [3]");
				System.out.println("Depósito              [4]");
				System.out.println("Tranferência          [5]");
				System.out.println("Extrato               [6]");

				System.out.println("Finalizar	      [9]");
				System.out.printf(".........................%n");				
				int servicos = sc.nextInt();

				switch(servicos){
				case 1:
					System.out.printf("=== ABERTURA DE CONTA ===%n %n");
					System.out.println("Para a abertura de conta iremos precisar de alguns dados: ");
					System.out.println("Primeiro informe o tipo de conta que deseja abrir:");
					System.out.println("Digite [1] para conta corrente | Digite [2] para conta poupanca");
					int tipoDeConta = sc.nextInt();
					
					switch(tipoDeConta) {
						case 1:
							sc.nextLine();
							System.out.println("Você selecionou Conta corrente: ");
							Cliente clienteCC = new Cliente();
							Conta ContaCorrente = new Conta_corrente(clienteCC);
							System.out.println("Digite o seu nome completo: ");
							clienteCC.setNome(sc.nextLine());
							contas.add(ContaCorrente);
							ContaCorrente.imprimirExtrato();
							
							
							break;
							
						case 2:	
							sc.nextLine();
							System.out.println("Você selecionou Conta Poupança: ");						
							Cliente clienteCP = new Cliente();
							Conta ContaPoupanca= new Conta_poupanca(clienteCP);
							System.out.println("Digite o seu nome completo: ");
							clienteCP.setNome(sc.nextLine());
							contas.add(ContaPoupanca);
							ContaPoupanca.imprimirExtrato();
							
							break;
							
						default:
							break;
					}
					break;
				 
					
					
					
				case 2:
					System.out.printf("======LISTAGEM DE CONTAS======%n");
					if(!contas.isEmpty()) {
						for (Conta conta : contas) {
							conta.imprimircontas();
							System.out.println("");
							}
					}else {
						System.out.println("Não existem contas cadastradas");
					}
					
					System.out.printf("==============================%n%n");

					break;
				
				case 3:
					
					System.out.printf("========= SAQUE =========%n %n");
					 existeConta = false;
					do {
						System.out.println("Digite o número da sua conta: ");
						System.out.printf( "---Digite 0000 para sair----- ");
						
						Integer NumeroConta = sc.nextInt();
						if (NumeroConta == 0000) {
							break;
						} 

						
						for (Conta conta : contas) {
							if(conta.getNumero().equals(NumeroConta))
							{
								
								System.out.println("Conta Encontrada");
								System.out.println("Digite o valor que deseja sacar: ");
								conta.sacar(sc.nextDouble());
								conta.imprimirExtrato();
								
								existeConta = true;
								
							}
						}
						if(existeConta != true) {
							System.out.println("Conta Não encontrada");
						}
						
					}while(existeConta != true);
					
					
			
					
					break;
				
				case 4:
					System.out.printf("======== DEPÓSITO ========%n %n");
					 existeConta = false;
					do {
						System.out.println("Digite o número da sua conta: ");
						System.out.printf( "---Digite 0000 para sair----- ");
						
						Integer NumeroConta = sc.nextInt();
						if (NumeroConta == 0000) {
							break;
						} 

						
						for (Conta conta : contas) {
							if(conta.getNumero().equals(NumeroConta))
							{
								
								System.out.println("Conta Encontrada");
								System.out.println("Digite o valor que deseja depositar: ");
								conta.depositar(sc.nextDouble());
								conta.imprimirExtrato();
								
								existeConta = true;
								
							}
							
						}
						if(existeConta != true) {
							System.out.println("Conta Não encontrada");
						}
							
						
					}while(existeConta != true);
					
					
					
					
					
					
					
					break;
				case 5:
					
					System.out.printf("===== TRANSFERÊNCIA =====%n %n");
					do {
					System.out.println("Digite o número da sua conta");
					System.out.printf( "---Digite 0000 para sair----- ");
					Integer contaDepositante = sc.nextInt();
					if (contaDepositante == 0000) {
						break;
					} 
					System.out.println("Digite o número da conta do recebedor;");
					System.out.printf( "---Digite 0000 para sair----- ");
					Integer contaRecebedor = sc.nextInt();
					if (contaRecebedor == 0000) {
						break;
					} 
					
					 
					 for (Conta conta : contas) {
						 if (conta.getNumero().equals(contaDepositante)) {
								ContaEncontrada = true;
								Depositante = conta;
						} 
						 
						 if (conta.getNumero().equals(contaRecebedor)) {
								Conta2Encontrada = true;
								Recebedor = conta;
						 }						 
						
					 }
					 
					 if (ContaEncontrada && Conta2Encontrada ) {
						 System.out.println("Ambas as contas foram encontradas");
						 System.out.println("Digite o valor que deseja depositar: ");
						 double valor = sc.nextDouble();
						 Depositante.transferir(valor, Recebedor);
						 Depositante.imprimirExtrato();
						 OperacaoRealizada = true;
						 
					 }
					 else if (ContaEncontrada || Conta2Encontrada ) {
						 System.out.println("Revise os dados");
						 OperacaoRealizada = false;

						 
						 if(ContaEncontrada == true && Conta2Encontrada == false) {
							 System.out.println("Apenas a conta Depositante foi encontrada");
						 }
						 else if (ContaEncontrada == false && Conta2Encontrada == true){
							 System.out.println("Apenas a conta Destinataria foi encontrada");

						 }
					 }
				} while(OperacaoRealizada == false);
					 
					
					break;
					
				case 6:
					System.out.printf("===== EXTRATO =====%n %n");
					do {
						System.out.println("Digite o numero da sua conta: ");
						System.out.printf( "---Digite 0000 para sair----- ");

						Integer NumeroDaConta = sc.nextInt();
						if (NumeroDaConta == 0000) {
							break;
						} 
						
						for (Conta conta : contas) {
							if (conta.getNumero().equals(NumeroDaConta)) {
								conta.imprimirExtrato();
								existeConta = true;
							}
						}
						if(existeConta != true) {
							System.out.println("Conta não encontrada");
						}
					}while(existeConta != true);
					
					break;
					
				case 9:
					System.out.println("Você saiu");
					resp = 9;
					break;
				} //fechamento do switch das operações;
				
			} while (resp!= 9); // fechamento DO WHILE;

		sc.close();
	}
}
