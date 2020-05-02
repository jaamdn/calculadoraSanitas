package com.sanitas.calculadora.model;

import java.math.BigDecimal;

public class Operador {

	//operacion
	private String operacion;
	
	//operador1
	private BigDecimal operador1;
	
	//operador2
	private BigDecimal operador2;
	
	//resultado
	private BigDecimal resultado;
	
	
	

	/**
	 * @param operacion
	 * @param operador1
	 * @param operador2
	 * @param resultado
	 */
	public Operador(String operacion, BigDecimal operador1, BigDecimal operador2, BigDecimal resultado) {
		super();
		this.operacion = operacion;
		this.operador1 = operador1;
		this.operador2 = operador2;
		this.resultado = resultado;
	}

	/**
	 * 
	 */
	public Operador() {
		super();
	}



	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public BigDecimal getOperador1() {
		return operador1;
	}

	public void setOperador1(BigDecimal operador1) {
		this.operador1 = operador1;
	}

	public BigDecimal getOperador2() {
		return operador2;
	}

	public void setOperador2(BigDecimal operador2) {
		this.operador2 = operador2;
	}

	public BigDecimal getResultado() {
		return resultado;
	}

	public void setResultado(BigDecimal resultado) {
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		return "Operador [operacion=" + operacion + ", operador1=" + operador1 + ", operador2=" + operador2
				+ ", resultado=" + resultado + "]";
	}



	


}
