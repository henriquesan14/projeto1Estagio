
public class PessoaFisica extends Pessoa { //subclasse de Pessoa
	
	//atributos
	private long cpf;
	private long rg;
	
	//getters e setters
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public long getRg() {
		return rg;
	}
	public void setRg(long rg) {
		this.rg = rg;
	}
	
	//construtor vazio
	public PessoaFisica() {
		// TODO Auto-generated constructor stub
	}
	
	//construtor passando atributos pra super classe
	public PessoaFisica(String nome, double rendaPessoa, int sitPessoa, Endereco endereco, long cpf,long rg) {
		super(nome, rendaPessoa, sitPessoa, endereco);
		this.cpf = cpf;
		this.rg = rg;
	}
}
