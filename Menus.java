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
				default:System.out.println("Op��o inv�lida"); menu();break;
			}
		}while(opc!=4);
		
	}
		
		

}
