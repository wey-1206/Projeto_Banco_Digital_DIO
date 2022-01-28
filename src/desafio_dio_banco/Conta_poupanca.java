package desafio_dio_banco;

public class Conta_poupanca extends Conta {

	public Conta_poupanca(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimirExtrato() {
		System.out.printf("%n%n*** Extrato Conta Poupança ***%n%n");
		super.imprimirInfosComuns();
		System.out.printf("%n******************************%n%n");

	}
}