import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Agencia {
	//atributos
	private long numero;
	private List<Conta> contas=new ArrayList<Conta>();
	private Endereco endereco; 
	
	//construtor vazio
	public Agencia() {
		// TODO Auto-generated constructor stub
	}
	
	//construtor com args
	public Agencia(long numero, List<Conta> conta, Endereco endereco) {
		super();
		this.numero = numero;
		this.contas = conta;
		this.endereco = endereco;
	}



	//getters e setters
	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	public List<Conta> getConta() {
		return contas;
	}
	public void setConta(List<Conta> conta) {
		this.contas = conta;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	//metodo pra cadastrar conta na agência
	public void cadastrarConta(){
		Scanner entrada=new Scanner(System.in);
		System.out.println("Digite 1-Pessoa Fisica e 2-Pessoa Juridica ");
		int opc = entrada.nextInt();
		switch(opc){
			case 1:System.out.println("Qual seu nome? "); //case1 cria objeto de PessoaFisica
				String nome=entrada.next();
				entrada.nextLine();
				
				System.out.println("Qual sua renda? ");
				double renda=entrada.nextDouble();
				
				System.out.println("Digite seu endereço: ");
				System.out.println("Rua: ");
				String rua=entrada.next();
				entrada.nextLine();
				
				System.out.println("Número: ");
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
				
				Endereco endereco=new Endereco(rua,numero,bairro,cidade,cep); //instanciando endereço com args
				PessoaFisica pf = new PessoaFisica(nome,renda,1,endereco,cpf,rg); //instanciando P Fisica com args
				Conta conta=new Conta();
				Date date=new Date();
				SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy"); // formata a data
				String data=sdf.format(date);
				conta.setDataAbertura(data);
				conta.setPessoa(pf);
				conta.setSenha(senha);
				conta.setSituacao(1);
				this.contas.add(conta); //adiciona o objeto conta ao array de contas
				break;
			case 2:System.out.println("Qual seu nome? "); //case2 cria objeto de PessoaJuridica
				String nome2=entrada.next();
				entrada.nextLine();
				
				System.out.println("Qual sua renda? ");
				double renda2=entrada.nextDouble();
				
				System.out.println("Digite seu endereço: ");
				System.out.println("Rua: ");
				String rua2=entrada.next();
				entrada.nextLine();
				
				System.out.println("Número: ");
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
			//caso digite um valor inválido, chama o metódo de cadastrarConta de novo
			default: System.out.println("Opção inválida");cadastrarConta();break;
		}
	}
	
	public void listarContas(){
		if(this.contas.size()>0){ //se tamanho do array de contas for maior que zero percorre o array
			for(Conta c: contas){
				System.out.println(c); //printa objeto conta com toString sobrescrito
			}
		}else{
			System.out.println("Agência Não possui contas!");
		}
	}
	
	public Conta acessarConta(){
		Scanner entrada=new Scanner(System.in);
		System.out.println("Informe número da conta: ");
		int num=entrada.nextInt(); 
		for(Conta c:contas){
			if(c.getNumConta()==num){ //verifica se possui uma conta com numero digitado
				return c;  //retorna o objeto se for true
			}
		}
		return null; //senão retorna nulo
		
	}
	
	
	
	
}
