
public class Endereco {
	private String rua;
	private int numero;
	private String cidade;
	private String bairro;
	private long cep;
	
	public String getRua() {
		return rua;
	}
	
	public Endereco() {
		// TODO Auto-generated constructor stub
	}
	
	public Endereco(String rua, int numero, String cidade, String bairro, long cep) {
		super();
		this.rua = rua;
		this.numero = numero;
		this.cidade = cidade;
		this.bairro = bairro;
		this.cep = cep;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public long getCep() {
		return cep;
	}
	public void setCep(long cep) {
		this.cep = cep;
	}
}
