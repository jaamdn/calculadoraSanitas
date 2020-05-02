/**
 * 
 */
package com.sanitas.calculadora.service;

import java.math.BigDecimal;
import java.util.Optional;

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
	
	
	private static final String SUMAR = "Sumar";
	private static final String RESTAR = "Restar";
	private static final String MULTIPLICAR = "Multiplicar";
	private static final String DIVIDIR = "Dividir";
	private static final String RAIZ = "Raiz";

	/**
	 * Realiza la operación de sumar.
	 * @param op
	 * @return Operador
	 */
	public Optional<Operador> sumar(Operador op) {
		op.setOperacion(SUMAR);
		op.setResultado(op.getOperador1().add(op.getOperador2()));
		
		return Optional.ofNullable(op);
		
	}
	
	/**
	 * Realiza la operación de restar.
	 * @param op
	 * @return Operador
	 */
	public Optional<Operador> restar(Operador op) {
		
		op.setOperacion(RESTAR);
		op.setResultado(op.getOperador1().subtract(op.getOperador2()));
		
		return Optional.ofNullable(op);
		
	}
	
	/**
	 * Realiza la operacin de multiplicar.
	 * @param op
	 * @return Operador
	 */
	public Optional<Operador> multiplicar(Operador op) {
		
		op.setOperacion(MULTIPLICAR);
		op.setResultado(op.getOperador1().multiply(op.getOperador2()));
		
		return Optional.ofNullable(op);
		
	}
	
	/**
	 * Realiza la operación de dividir.
	 * @param op
	 * @return Operador
	 */
	public Optional<Operador> dividir(Operador op) {
		
		op.setOperacion(DIVIDIR);
		op.setResultado(op.getOperador1().divide(op.getOperador2()));
		
		return Optional.ofNullable(op);
		
	}
	
	/**
	 * Realiza la operación de raiz cuadrada.
	 * @param op
	 * @return Operador
	 */
	public Optional<Operador> raiz(Operador op) {
		
		op.setOperacion(RAIZ);
		op.setResultado( BigDecimal.valueOf(Math.sqrt(op.getOperador1().doubleValue())));
		
		return Optional.ofNullable(op);
		
	}

}
