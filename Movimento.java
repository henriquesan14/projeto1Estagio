import java.util.Date;

public class Movimento {
	
	private int tipo;
	private String dataMovimentacao;
	private String horaMovimentacao;
	private double valMovimentado;
	
	public Movimento() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Movimento(int tipo, String dataMovimentacao, String horaMovimentacao, double valMovimentado) {
		super();
		this.tipo = tipo;
		this.dataMovimentacao = dataMovimentacao;
		this.horaMovimentacao = horaMovimentacao;
		this.valMovimentado = valMovimentado;
	}
	
	@Override
	public String toString() {
		return "Movimento| Tipo: " + tipo + " | Data de Movimentação: " + dataMovimentacao + " | Hora da Movimentacão: "
				+ horaMovimentacao + "| Valor Movimentado: " + valMovimentado ;
	}



	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getDataMovimentacao() {
		return dataMovimentacao;
	}
	public void setDataMovimentacao(String dataMovimentacao) {
		this.dataMovimentacao = dataMovimentacao;
	}
	public String getHoraMovimentacao() {
		return horaMovimentacao;
	}
	public void setHoraMovimentacao(String horaMovimentacao) {
		this.horaMovimentacao = horaMovimentacao;
	}
	public double getValMovimentado() {
		return valMovimentado;
	}
	public void setValMovimentado(double valMovimentado) {
		this.valMovimentado = valMovimentado;
	}
}
