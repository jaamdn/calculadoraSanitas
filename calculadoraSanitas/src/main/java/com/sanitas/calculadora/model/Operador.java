package com.sanitas.calculadora.model;

public class Operador {




	/**
	 * @param operacion
	 * @param operador1
	 * @param operador2
	 * @param resultado
	 */
	public Operador(String operacion, double operador1, double operador2, double resultado) {
		super();
		this.operacion = operacion;
		this.operador1 = operador1;
		this.operador2 = operador2;
		this.resultado = resultado;
	}

	//operacion
	private String operacion;
	
	//operador1
	private double operador1;
	
	//operador2
	private double operador2;
	
	//resultado operaciones
	private double resultado;

	public double getOperador1() {
		return operador1;
	}
	
	
	
	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public void setOperador1(double operador1) {
		this.operador1 = operador1;
	}

	public double getOperador2() {
		return operador2;
	}

	public void setOperador2(double operador2) {
		this.operador2 = operador2;
	}

	public double getResultado() {
		return resultado;
	}

	public void setResultado(double resultado) {
		this.resultado = resultado;
	}


}
