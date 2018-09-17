import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Conta {
	//atributos
	private Pessoa pessoa;
	//atributo estatico pra incrementar o numero de conta sempre q criar uma nova
	private static int sequence = 1; 
	private  long numConta;
	private String dataAbertura;
	private String dataEncerramento;
	private int situacao;
	private String senha;
	private double saldo;
	private List<Movimento> movimentos = new ArrayList<Movimento>();
	
	//metodo toString
	@Override
	public String toString() {
		return "Numéro da Conta: " + numConta + "| Nome do cliente: " + pessoa.getNome() + "| Saldo: " + saldo + "| Data de abertura: " + dataAbertura;
	}
	
	//construtor vazio
	public Conta() {
		this.numConta=sequence++;
	}
	
	
	//construtor com args
	public Conta(Pessoa pessoa, long numConta, String dataAbertura, String dataEncerramento, int situacao, String senha,
			double saldo, List<Movimento> movimento) {
		super();
		this.pessoa = pessoa;
		this.numConta = numConta;
		this.dataAbertura = dataAbertura;
		this.dataEncerramento = dataEncerramento;
		this.situacao = situacao;
		this.senha = senha;
		this.saldo = saldo;
		this.movimentos = movimento;
	}


	//getters e setters
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public long getNumConta() {
		return numConta;
	}
	public void setNumConta(long numConta) {
		this.numConta = numConta;
	}
	public String getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(String dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public String getDataEncerramento() {
		return dataEncerramento;
	}
	public void setDataEncerramento(String dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}
	public int getSituacao() {
		return situacao;
	}
	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public List<Movimento> getMovimento() {
		return movimentos;
	}
	public void setMovimento(List<Movimento> movimento) {
		this.movimentos = movimento;
	}
	
	
	public void sacar(double saque) throws SaldoNegativoException, ValorException{
		if(saque>this.saldo){ // se o valor do saque for maior que o saldo lança a exceção
			throw new SaldoNegativoException("Saldo insuficiente");
		}else if(saque<=0){ //se o saque for menor igual a zero lança a exceção
			throw new ValorException("Saque tem quer ser positivo");
		}
		else{ //senão faz o saque e cria um movimento tipo 1 e adiciona os atributos
			this.saldo-=saque;
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			String data=sdf.format(date);
			Date time=new Date();
			SimpleDateFormat sdf2=new SimpleDateFormat("hh:mm:ss");
			String hora=sdf2.format(time);
			Movimento m=new Movimento();
			m.setDataMovimentacao(data);
			m.setHoraMovimentacao(hora);
			m.setTipo(1);
			m.setValMovimentado(saque);
			this.movimentos.add(m); //adiciona o movimento ao array de movimentos
		}
	}
	
	public void depositar(double deposito) throws ValorException{
		if(deposito<=0){ //se deposito for menor igual a zero lança a exceção
			throw new ValorException("Deposito tem que ser positivo");
		}else{ //senão faz o deposito e cria um movimento tipo 2 e adiciona os atributos
			this.saldo+=deposito;
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			String data=sdf.format(date);
			Date time=new Date();
			SimpleDateFormat sdf2=new SimpleDateFormat("hh:mm:ss");
			String hora=sdf2.format(time);
			Movimento m=new Movimento();
			m.setDataMovimentacao(data);
			m.setHoraMovimentacao(hora);
			m.setTipo(2);
			m.setValMovimentado(deposito);
			this.movimentos.add(m); //adiciona o movimento ao array de movimentos
		}	
	}
	
	public void transferir(double valor,Conta conta) throws SaldoNegativoException, ValorException{
		if(valor>this.saldo){ //se o valor a ser transferido for maior q o saldo lança a exceção
			throw new SaldoNegativoException("Saldo insuficiente");
		}else if(valor<=0){ //se o valor a ser transferido for menor igual a zero lança a exceção
			throw new ValorException("Valor tem quer positivo");
		}
		else{ //senão faz a transferência e cria um movimento tipo 3 adiciona os atributos
			conta.setSaldo(conta.getSaldo()+valor);
			this.saldo-=valor;
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			String data=sdf.format(date);
			Date time=new Date();
			SimpleDateFormat sdf2=new SimpleDateFormat("hh:mm:ss");
			String hora=sdf2.format(time);
			Movimento m=new Movimento();
			m.setDataMovimentacao(data);
			m.setHoraMovimentacao(hora);
			m.setTipo(3);
			m.setValMovimentado(valor);
			this.movimentos.add(m); //adiciona o movimento ao array movimentos
		}
	}
	
	public void listarExtrato(){
		if(this.movimentos.size()>0){ //se o tamanho do array de movimentos for maior que zero
			for(Movimento m: movimentos){ //percorre o array e imprime
				System.out.println(m);
			}
		}else{
			System.out.println("Conta não possui movimentos");
		}
	}
}
