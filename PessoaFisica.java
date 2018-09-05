
public class PessoaFisica extends Pessoa {
	private long cpf;
	private long rg;
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
	
	public PessoaFisica() {
		// TODO Auto-generated constructor stub
	}
	
	public PessoaFisica(String nome, double rendaPessoa, int sitPessoa, Endereco endereco, long cpf,long rg) {
		super(nome, rendaPessoa, sitPessoa, endereco);
		this.cpf = cpf;
		this.rg = rg;
	}
}
