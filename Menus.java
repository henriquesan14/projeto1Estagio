import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Menus {
	
	static Agencia a=new Agencia(); // cria um objeto estatico de agencia pra ser compartilhado
	
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
				case 3:menu2();break; // case3 redireciona pra o menu2 pra acessar uma conta
				case 4:System.out.println("Sistema encerrado");
						System.exit(0);break;
				default:System.out.println("Op��o inv�lida"); menu();break;
			}  //fech switch
		}while(opc!=4); //fech do while
		
	} //fech metodo
	
	public static void menu2(){
		Scanner entrada=new Scanner(System.in);
		Conta c=a.acessarConta(); //uma variavel conta recebe o retorno de acessarConta
	    int opc2;
			if(c!=null){ //se o retorno for diferente de nulo acessa a conta e as opera��es
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
						try { //tratando exce��es
								c.sacar(saque);
								System.out.println("Saque realizado");
						} catch (SaldoNegativoException e) {
							// TODO Auto-generated catch block
							System.out.println(e.getMessage());
						} catch (ValorException e){
							System.out.println(e.getMessage());
						}
						break;
					case 2: 
						System.out.println("Valor do deposito: ");
						double deposito=entrada.nextDouble();
						try { //tratando exce��o
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
						Conta conta_destino=a.acessarConta(); //conta destino recebe o retorno de acessarConta
						if(conta_destino!=null){ //se conta destino for diferente de nulo
							//se o numero da conta for diferente do numero da conta destino
							if(conta_destino.getNumConta()!=c.getNumConta()){ 
								try { //tratando exce��es
										c.transferir(valor,conta_destino);
										System.out.println("Transfer�ncia realizada");
									
								} catch (SaldoNegativoException e) {
									// TODO Auto-generated catch block
									System.out.println(e.getMessage());
								} catch(ValorException e){
									System.out.println(e.getMessage());
								}
							}else{
								System.out.println("Transfer�ncia n�o pode ser feita na mesma conta!");
							}
						}else{
							System.out.println("Conta n�o existe!");
						}
						break;
					case 4:c.listarExtrato();
						break;
					case 5:menu();
						break;
					default: System.out.println("Op��o inv�lida");break;
				
				} //fech switch2
			}while(opc2!=5); //fech do while2
			}else{ //fech if
				System.out.println("Conta n�o existe");
			}// fech else

	}
	


		
		

}
