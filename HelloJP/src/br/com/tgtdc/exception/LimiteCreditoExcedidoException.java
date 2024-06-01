package br.com.tgtdc.exception;

public class LimiteCreditoExcedidoException extends Exception{
	
	private double quantiaExcedida;
	
	public LimiteCreditoExcedidoException(double quantiaExcedida) {
		super("Limite de crédito excedido por: " + quantiaExcedida);
		this.quantiaExcedida = quantiaExcedida;
	}
	
	public double getQuantiaExcedida() {
		return this.quantiaExcedida;
	}
	
}
