
public class Pessoa {
	private String nome;
	private double rendaPessoa;
	private int sitPessoa;
	private Endereco endereco;
	
	public Pessoa() {
		// TODO Auto-generated constructor stub
	}
	
	public Pessoa(String nome, double rendaPessoa, int sitPessoa, Endereco endereco) {
		super();
		this.nome = nome;
		this.rendaPessoa = rendaPessoa;
		this.sitPessoa = sitPessoa;
		this.endereco = endereco;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getRendaPessoa() {
		return rendaPessoa;
	}
	public void setRendaPessoa(double rendaPessoa) {
		this.rendaPessoa = rendaPessoa;
	}
	public int getSitPessoa() {
		return sitPessoa;
	}
	public void setSitPessoa(int sitPessoa) {
		this.sitPessoa = sitPessoa;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
