import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;
public class Controle {
	int k = 0;
	int numdecont = 0;
	private No<Cliente> inicio, rep;
	Lista<Cliente> lista = new Lista<Cliente>();
	public void menu() {
		int op;
		String aux = "Escolha uma opção: \n";
		aux += "1. Abrir conta\n";
		aux += "2. Realizar saque\n";
		aux += "3. Realizar depósito \n";
		aux += "4. Relatório de contas\n";
		aux += "5. Encerrar conta\n";
		aux += "6. Encerrar aplicação ";
		
		do {
			op = parseInt(showInputDialog(aux));
			if ( op < 1 || op > 6) {
				showMessageDialog(null,"Opção Invalida");
			}else {
				switch(op) {
					case 1:
						int cpf = parseInt(showInputDialog("CPF: "));
						if(k == 0) {
							k++;
						}else {
							rep = lista.pesquisar(new Cliente(cpf));
							if( rep != null) {
								showMessageDialog(null, "CPF já registrado:");
								break;
							}
						}
						String nome = showInputDialog("Nome: ");
						double saldo = parseDouble(showInputDialog("Saldo: "));
						lista.inserirFinal(new Cliente(cpf,nome,saldo));
						showMessageDialog(null, "Conta criada com sucesso!!");
						if(numdecont == 0) {
							inicio = lista.pesquisar(new Cliente(cpf));
							numdecont++;
						}
						break;
					case 2:
						 No<Cliente>saq = lista.pesquisar(new Cliente(parseInt(showInputDialog("CPF: "))));
						 if(saq != null) {
							 double val = parseDouble(showInputDialog("Valor do Saque: "));
							 if(saq.info.saldo < val) {
								 showMessageDialog(null, "Saldo insuficiênte:");
							 }else {
								 saq.info.saque(val);
								 showMessageDialog(null, "Saque no valor de "+val+" realizado com sucesso!!\n(saldo atual " + saq.info.saldo + ")." );
							 }
						 }else {
							 showMessageDialog(null, "Cpf não encontrado:");
						 }
						break;
					case 3:
						 No<Cliente>dep = lista.pesquisar(new Cliente(parseInt(showInputDialog("CPF: "))));
						 if(dep != null) {
							 double val = parseDouble(showInputDialog("Valor do Depositado: "));
							 dep.info.deposito(val);
							 showMessageDialog(null, "Deposito no valor de "+val+" realizado com sucesso!!\n(saldo atual " + dep.info.saldo + ")." );
						 }else {
							 showMessageDialog(null, "Cpf não encontrado:");
						 }
						break;
					case 4:
						No<Cliente> au = inicio;
						String re = "";
						while (au != null) {
							re += "Nome: " + au.info.nome + "\n";
							re += "CPF: " + au.info.cpf + "\n";
							re += "Saldo: " + au.info.saldo + "\n";
							re += "\n";
							au = au.prox;
						}
						showMessageDialog(null,re);
						break;					
					case 5:
						No<Cliente> teste = lista.pesquisar(new Cliente(parseInt(showInputDialog("CPF: "))));
						if(teste != null) {
							if(teste == inicio) {
								inicio = inicio.prox;
							}
							lista.remover(new Cliente(teste.info.cpf));
							showMessageDialog(null, "Conta encerrado com sucesso.");
						}else {
							showMessageDialog(null, "Cpf não encontrado:");
						}
						break;

				}
			}
		}while( op != 6);
	}
}
