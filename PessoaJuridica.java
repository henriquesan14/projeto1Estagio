
public class PessoaJuridica extends Pessoa {
	//atributos
	private long cnpj;
	
	//construtor vazio
	public PessoaJuridica() {
		// TODO Auto-generated constructor stub
	}
	//construtor passando atributos para superclasse
	public PessoaJuridica(String nome, double rendaPessoa, int sitPessoa, Endereco endereco, long cnpj) {
		super(nome, rendaPessoa, sitPessoa, endereco);
		this.cnpj = cnpj;
	}
	
	//getters e setters
	public long getCnpj() {
		return cnpj;
	}

	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}
	
}
