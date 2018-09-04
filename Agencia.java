import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
		System.out.println("Digite 1-Pessoa Fisica e 2-Pessoa Juridica ");
		int opc = entrada.nextInt();
		switch(opc){
			case 1:System.out.println("Qual seu nome? ");
				String nome=entrada.next();
				System.out.println("Qual sua renda? ");
				double renda=entrada.nextDouble();
				System.out.println("Digite seu endereço: ");
				System.out.println("Rua: ");
				String rua=entrada.next();
				System.out.println("Número: ");
				int numero=entrada.nextInt();
				System.out.println("Bairro:  ");
				String bairro=entrada.next();
				System.out.println("Cidade: ");
				String cidade=entrada.next();
				System.out.println("CEP: ");
				long cep=entrada.nextLong();
				System.out.println("Digite seu CPF: ");
				long cpf=entrada.nextLong();
				System.out.println("Digite seu RG: ");
				long rg=entrada.nextLong();
				System.out.println("Digite uma senha para sua conta: ");
				String senha=entrada.next();
				
				Endereco endereco=new Endereco(rua,numero,bairro,cidade,cep);
				PessoaFisica pf = new PessoaFisica(nome,renda,1,endereco,cpf,rg);
				Conta conta=new Conta();
				Date date=new Date();
				SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
				String data=sdf.format(date);
				conta.setNumConta(1);
				conta.setDataAbertura(data);
				conta.setPessoa(pf);
				conta.setSenha(senha);
				conta.setSituacao(1);
				this.contas.add(conta);
				break;
			case 2:System.out.println("Qual seu nome? ");
				String nome2=entrada.next();
				System.out.println("Qual sua renda? ");
				double renda2=entrada.nextDouble();
				System.out.println("Digite seu endereço: ");
				System.out.println("Rua: ");
				String rua2=entrada.next();
				System.out.println("Número: ");
				int numero2=entrada.nextInt();
				System.out.println("Bairro:  ");
				String bairro2=entrada.next();
				System.out.println("Cidade: ");
				String cidade2=entrada.next();
				System.out.println("CEP: ");
				long cep2=entrada.nextLong();
				System.out.println("Digite seu CNPJ: ");
				long cnpj=entrada.nextLong();
				System.out.println("Digite uma senha para sua conta: ");
				String senha2=entrada.next();
				
				Endereco endereco2=new Endereco(rua2,numero2,bairro2,cidade2,cep2);
				PessoaJuridica pj = new PessoaJuridica(nome2,renda2,1,endereco2,cnpj);
				Conta conta2=new Conta();
				Date date2=new Date();
				SimpleDateFormat sdf2=new SimpleDateFormat("dd/MM/yyyy");
				String data2=sdf2.format(date2);
				conta2.setNumConta(1);
				conta2.setDataAbertura(data2);
				conta2.setPessoa(pj);
				conta2.setSenha(senha2);
				conta2.setSituacao(1);
				this.contas.add(conta2);
				break;
				
			default: System.out.println("Opção inválida");cadastrarConta();break;
		}
	}
}
