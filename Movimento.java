import java.util.Date;

public class Movimento {
	
	//atributos
	private int tipo;
	private String dataMovimentacao;
	private String horaMovimentacao;
	private double valMovimentado;
	
	//construtor vazio
	public Movimento() {
		// TODO Auto-generated constructor stub
	}
	
	
	//construtor com args
	public Movimento(int tipo, String dataMovimentacao, String horaMovimentacao, double valMovimentado) {
		super();
		this.tipo = tipo;
		this.dataMovimentacao = dataMovimentacao;
		this.horaMovimentacao = horaMovimentacao;
		this.valMovimentado = valMovimentado;
	}
	
	//metodo toString sobrescrito
	@Override
	public String toString() {
		return "Movimento| Tipo: " + getTipoNomePorId(tipo) + " | Data de Movimentação: " + dataMovimentacao + " | Hora da Movimentacão: "
				+ horaMovimentacao + "| Valor Movimentado: " + valMovimentado ;
	}

	public String getTipoNomePorId(int codigoTipo){
		switch(codigoTipo){
		case 1: return "Saque";
		case 2:return "Depósito";
		case 3:return "Transferencia";
		default:return "";
		}
	}
	
	//getters e setters
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
