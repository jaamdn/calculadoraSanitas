/**
 * 
 */
package com.sanitas.calculadora.service;

import org.springframework.stereotype.Service;

import com.sanitas.calculadora.model.Operador;

/**
 * @author dvazquez
 * 
 * Servicio que encapsula las operaciones de una calculadora
 *
 */

@Service
public class CalculadoraService {
	
	
	/**
	 * Realiza la operación de sumar.
	 * @param op
	 * @return Operador
	 */
	public Operador sumar(Operador op) {
		
		op.setResultado(op.getOperador1()+op.getOperador2());
		
		return op;
		
	}
	
	/**
	 * Realiza la operación de restar.
	 * @param op
	 * @return Operador
	 */
	public Operador restar(Operador op) {
		
		op.setResultado(op.getOperador1()-op.getOperador2());
		
		return op;
		
	}
	
	/**
	 * Realiza la operacin de multiplicar.
	 * @param op
	 * @return Operador
	 */
	public Operador multiplicar(Operador op) {
		
		op.setResultado(op.getOperador1() * op.getOperador2());
		
		return op;
		
	}
	
	/**
	 * Realiza la operación de dividir.
	 * @param op
	 * @return Operador
	 */
	public Operador dividir(Operador op) {
		
		op.setResultado(op.getOperador1() / op.getOperador2());
		
		return op;
		
	}
	
	/**
	 * Realiza la operación de raiz cuadrada.
	 * @param op
	 * @return Operador
	 */
	public Operador raiz(Operador op) {
		
		op.setResultado(Math.sqrt(op.getOperador1()));
		
		return op;
		
	}
	
	/**
	 * Realiza la operación de potencia.
	 * @param op
	 * @return Operador
	 */
	public Operador potencia(Operador op) {
		
		op.setResultado(Math.pow(op.getOperador1(),op.getOperador1()));
		
		return op;
		
	}

}
