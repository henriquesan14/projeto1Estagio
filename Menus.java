import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Menus {
	
	static Agencia a= new Agencia();
	
	public static void menu(){
		Scanner entrada=new Scanner(System.in);
		Agencia a=new Agencia();
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
				case 3:Conta c=a.acessarConta();
					    int opc2;
							if(c!=null){
							do{
								System.out.println("Conta n�: "+c.getNumConta());
								System.out.println("1-Realizar saque");
								System.out.println("2-Realizar deposito");
								System.out.println("3-Realizar transfer�ncia");
								System.out.println("4-Extrato banc�rio");
								System.out.println("5-Sair");
								opc2=entrada.nextInt();
								
								switch(opc2){
									case 1: 
										System.out.println("Valor do saque: ");
										double saque=entrada.nextDouble();
										try {
											c.sacar(saque);
											System.out.println("Saque realizado");
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
										System.out.println("Valor da transfer�ncia: ");
										double valor=entrada.nextDouble();
										Conta conta_destino=a.acessarConta();
										try {
											c.transferir(valor,conta_destino);
											System.out.println("Transfer�ncia realizada");
										} catch (SaldoNegativoException e) {
											// TODO Auto-generated catch block
											System.out.println(e.getMessage());
										}
										break;
									case 4:System.out.println("eak");
										break;
									case 5:System.out.println("Sistema Encerrado");
									System.exit(0);break;
									default: System.out.println("Op��o inv�lida");break;
								
								} //fech switch2
							}while(opc2!=5); //fech do while2
							}else{ //fech if
								System.out.println("Conta n�o existe");
							}// fech else
				
				break;
				default:System.out.println("Op��o inv�lida"); menu();break;
			}  //fech switch
		}while(opc!=4); //fech do while
		
	} //fech metodo

		
		

}
