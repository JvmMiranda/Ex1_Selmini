
public class Cliente {
	int cpf;
	String nome;
	double saldo;
	No<Cliente> ant, prox;
	
	public void deposito(double valor) {
		this.saldo += valor;
	}
	public void saque(double valor) {
		this.saldo -= valor;
	}
	
	public Cliente(int cpf, String nome, double saldo) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.saldo = saldo;
	}

	public Cliente(int cpf) {
		super();
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		return cpf + " --> " + nome;
	}
	
	@Override
	public boolean equals(Object obj) {
		Cliente cliente = (Cliente) obj;
		if(cpf == cliente.cpf) {
			return true;
		}
		return false;
	}
	
	
}
