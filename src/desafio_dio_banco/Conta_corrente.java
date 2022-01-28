package desafio_dio_banco;

public class Conta_corrente extends Conta {

	public Conta_corrente(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimirExtrato() {
		System.out.printf("%n%n*** Extrato Conta Corrente ***%n%n");
		super.imprimirInfosComuns();
		System.out.printf("%n******************************%n%n");
		
		

	}
}