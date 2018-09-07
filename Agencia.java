import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Agencia {
	private long numero;
	private ArrayList<Conta> contas=new ArrayList<Conta>();
	private Endereco endereco; 
	
	public Agencia() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public Agencia(long numero, ArrayList<Conta> conta, Endereco endereco) {
		super();
		this.numero = numero;
		this.contas = conta;
		this.endereco = endereco;
	}





	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	public List<Conta> getConta() {
		return contas;
	}
	public void setConta(ArrayList<Conta> conta) {
		this.contas = conta;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public void cadastrarConta(){
		Scanner entrada=new Scanner(System.in);
		Random n=new Random();
		System.out.println("Digite 1-Pessoa Fisica e 2-Pessoa Juridica ");
		int opc = entrada.nextInt();
		switch(opc){
			case 1:System.out.println("Qual seu nome? ");
				String nome=entrada.next();
				entrada.nextLine();
				
				System.out.println("Qual sua renda? ");
				double renda=entrada.nextDouble();
				
				System.out.println("Digite seu endere�o: ");
				System.out.println("Rua: ");
				String rua=entrada.next();
				entrada.nextLine();
				
				System.out.println("N�mero: ");
				int numero=entrada.nextInt();
				
				System.out.println("Bairro:  ");
				String bairro=entrada.next();
				entrada.nextLine();
				
				System.out.println("Cidade: ");
				String cidade=entrada.next();
				entrada.nextLine();
				
				System.out.println("CEP: ");
				long cep=entrada.nextLong();
				
				System.out.println("Digite seu CPF: ");
				long cpf=entrada.nextLong();
				
				System.out.println("Digite seu RG: ");
				long rg=entrada.nextLong();
				
				System.out.println("Digite uma senha para sua conta: ");
				String senha=entrada.next();
				entrada.nextLine();
				
				Endereco endereco=new Endereco(rua,numero,bairro,cidade,cep);
				PessoaFisica pf = new PessoaFisica(nome,renda,1,endereco,cpf,rg);
				Conta conta=new Conta();
				Date date=new Date();
				SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
				String data=sdf.format(date);
				conta.setDataAbertura(data);
				conta.setPessoa(pf);
				conta.setSenha(senha);
				conta.setSituacao(1);
				this.contas.add(conta);
				break;
			case 2:System.out.println("Qual seu nome? ");
				String nome2=entrada.next();
				entrada.nextLine();
				
				System.out.println("Qual sua renda? ");
				double renda2=entrada.nextDouble();
				
				System.out.println("Digite seu endere�o: ");
				System.out.println("Rua: ");
				String rua2=entrada.next();
				entrada.nextLine();
				
				System.out.println("N�mero: ");
				int numero2=entrada.nextInt();
				
				System.out.println("Bairro:  ");
				String bairro2=entrada.next();
				entrada.nextLine();
				
				System.out.println("Cidade: ");
				String cidade2=entrada.next();
				entrada.nextLine();
				
				System.out.println("CEP: ");
				long cep2=entrada.nextLong();
				
				System.out.println("Digite seu CNPJ: ");
				long cnpj=entrada.nextLong();
				
				System.out.println("Digite uma senha para sua conta: ");
				String senha2=entrada.next();
				entrada.nextLine();
				
				Endereco endereco2=new Endereco(rua2,numero2,bairro2,cidade2,cep2);
				PessoaJuridica pj = new PessoaJuridica(nome2,renda2,1,endereco2,cnpj);
				Conta conta2=new Conta();
				Date date2=new Date();
				SimpleDateFormat sdf2=new SimpleDateFormat("dd/MM/yyyy");
				String data2=sdf2.format(date2);
				conta2.setDataAbertura(data2);
				conta2.setPessoa(pj);
				conta2.setSenha(senha2);
				conta2.setSituacao(1);
				this.contas.add(conta2);
				break;
				
			default: System.out.println("Op��o inv�lida");cadastrarConta();break;
		}
	}
	
	public void listarContas(){
		if(this.contas.size()>0){
			for(Conta c: contas){
				System.out.println(c);
			}
		}else{
			System.out.println("Ag�ncia N�o possui contas!");
		}
	}
	
	public Conta acessarConta(){
		Scanner entrada=new Scanner(System.in);
		System.out.println("Informe n�mero da conta: ");
		int num=entrada.nextInt();
		for(Conta c:contas){
			if(c.getNumConta()==num){
				return c;
			}
		}
		return null;
		
	}
	
	
	
}
