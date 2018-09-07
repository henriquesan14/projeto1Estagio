import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Menus {
	
	static Agencia a=new Agencia();
	
	public static void menu(){
		Scanner entrada=new Scanner(System.in);
		int opc;
		do{
			System.out.println("Gerenciamento de contas");
			System.out.println("|1 - Cadastrar Conta");
			System.out.println("|2 - Listar Conta");
			System.out.println("|3 - Acessar uma Conta");
			System.out.println("|4 - Sair");
			opc=entrada.nextInt();
			switch(opc){
				case 1:a.cadastrarConta();System.out.println("Conta cadastrada!");break;
				case 2:a.listarContas();break;
				case 3:menu2();break;
				case 4:System.out.println("Sistema encerrado");
						System.exit(0);break;
				default:System.out.println("Opção inválida"); menu();break;
			}  //fech switch
		}while(opc!=4); //fech do while
		
	} //fech metodo
	
	public static void menu2(){
		Scanner entrada=new Scanner(System.in);
		Conta c=a.acessarConta();
	    int opc2;
			if(c!=null){
			do{
				System.out.println("Conta nº: "+c.getNumConta());
				System.out.println("1-Realizar saque");
				System.out.println("2-Realizar deposito");
				System.out.println("3-Realizar transferência");
				System.out.println("4-Extrato bancário");
				System.out.println("5-Sair");
				opc2=entrada.nextInt();
				
				switch(opc2){
					case 1: 
						System.out.println("Valor do saque: ");
						double saque=entrada.nextDouble();
						try {
							try {
								c.sacar(saque);
								System.out.println("Saque realizado");
							} catch (ValorException e) {
								// TODO Auto-generated catch block
								System.out.println(e.getMessage());
							}
							
						} catch (SaldoNegativoException e) {
							// TODO Auto-generated catch block
							System.out.println(e.getMessage());
						}
						break;
					case 2: 
						System.out.println("Valor do deposito: ");
						double deposito=entrada.nextDouble();
						try {
							c.depositar(deposito);
							System.out.println("Deposito realizado");
						} catch (ValorException e) {
							// TODO Auto-generated catch block
							System.out.println(e.getMessage());
						}
						break;
					case 3: 
						System.out.println("Valor da transferência: ");
						double valor=entrada.nextDouble();
						Conta conta_destino=a.acessarConta();
						if(conta_destino!=null){
							if(conta_destino.getNumConta()!=c.getNumConta()){
								try {
									try {
										c.transferir(valor,conta_destino);
										System.out.println("Transferência realizada");
									} catch (ValorException e) {
										// TODO Auto-generated catch block
										System.out.println(e.getMessage());
									}
									
								} catch (SaldoNegativoException e) {
									// TODO Auto-generated catch block
									System.out.println(e.getMessage());
								}
							}else{
								System.out.println("Transferência não pode ser feita na mesma conta!");
							}
						}else{
							System.out.println("Conta não existe!");
						}
						break;
					case 4:c.listarExtrato();
						break;
					case 5:menu();
						break;
					default: System.out.println("Opção inválida");break;
				
				} //fech switch2
			}while(opc2!=5); //fech do while2
			}else{ //fech if
				System.out.println("Conta não existe");
			}// fech else

	}
	


		
		

}
