import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Conta {
	
	private Pessoa pessoa;
	private long numConta;
	private String dataAbertura;
	private String dataEncerramento;
	private int situacao;
	private String senha;
	private double saldo;
	private ArrayList<Movimento> movimentos = new ArrayList<Movimento>();
	
	@Override
	public String toString() {
		return "Numéro da Conta: " + numConta + "| Pessoa: " + pessoa.getNome() + "| Saldo: " + saldo + "| Data de abertura: " + dataAbertura;
	}
	
	public Conta() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Conta(Pessoa pessoa, long numConta, String dataAbertura, String dataEncerramento, int situacao, String senha,
			double saldo, ArrayList<Movimento> movimento) {
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
	public ArrayList<Movimento> getMovimento() {
		return movimentos;
	}
	public void setMovimento(ArrayList<Movimento> movimento) {
		this.movimentos = movimento;
	}
	
	public void sacar(double saque) throws SaldoNegativoException{
		if(saque>this.saldo){
			throw new SaldoNegativoException("Saldo insuficiente");
		}else{
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
			this.movimentos.add(m);
		}
	}
	
	public void depositar(double deposito) throws ValorException{
		if(deposito<=0){
			throw new ValorException("Deposito tem que ser positivo");
		}else{
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
			this.movimentos.add(m);
		}	
	}
	
	public void transferir(double valor,Conta conta) throws SaldoNegativoException{
		if(valor>this.saldo){
			throw new SaldoNegativoException("Saldo insuficiente");
		}else{
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
			this.movimentos.add(m);
		}
	}
}
