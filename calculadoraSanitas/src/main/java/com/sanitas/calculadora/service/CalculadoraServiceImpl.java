/**
 * 
 */
package com.sanitas.calculadora.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sanitas.calculadora.model.Operador;

import io.corp.calculator.TracerImpl;

/**
 * @author dvazquez
 * 
 *         Servicio que encapsula las operaciones de una calculadora
 *
 */

@Service
public class CalculadoraServiceImpl implements ICalculadoraService {

	private static final String SUMAR = "sumar";
	private static final String RESTAR = "restar";
	private static final String MULTIPLICAR = "multiplicar";
	private static final String DIVIDIR = "dividir";
	private static final String RAIZ = "raiz";

	/**
	 * Realiza la operación de sumar.
	 * 
	 * @param op
	 * @return Operador
	 */
	@Override
	public Optional<Operador> sumar(Operador op) {
		op.setOperacion(SUMAR);
		op.setResultado(op.getOperador1().add(op.getOperador2()));

		return Optional.ofNullable(op);

	}

	/**
	 * Realiza la operación de restar.
	 * 
	 * @param op
	 * @return Operador
	 */
	@Override
	public Optional<Operador> restar(Operador op) {

		op.setOperacion(RESTAR);
		op.setResultado(op.getOperador1().subtract(op.getOperador2()).setScale(2));

		return Optional.ofNullable(op);

	}

	/**
	 * Realiza la operacin de multiplicar.
	 * 
	 * @param op
	 * @return Operador
	 */
	@Override
	public Optional<Operador> multiplicar(Operador op) {

		op.setOperacion(MULTIPLICAR);
		op.setResultado(op.getOperador1().multiply(op.getOperador2()));

		return Optional.ofNullable(op);

	}

	/**
	 * Realiza la operación de dividir.
	 * 
	 * @param op
	 * @return Operador
	 */
	@Override
	public Optional<Operador> dividir(Operador op) {

		op.setOperacion(DIVIDIR);
		op.setResultado(op.getOperador1().divide(op.getOperador2(), 10, RoundingMode.HALF_EVEN));

		return Optional.ofNullable(op);

	}

	/**
	 * Realiza la operación de raiz cuadrada.
	 * 
	 * @param op
	 * @return Operador
	 */
	@Override
	public Optional<Operador> raiz(Operador op) {

		op.setOperacion(RAIZ);
		op.setResultado(BigDecimal.valueOf(Math.sqrt(op.getOperador1().doubleValue())));

		return Optional.ofNullable(op);

	}

	/**
	 * Realiza las operaciones que se le pasan.
	 * 
	 * @param operaciones
	 * @return Operador
	 */
	public Optional<Operador> calcular(List<Operador> operaciones) {

		BigDecimal resultado = new BigDecimal(0);
		Optional<Operador> optionalResultado = null;

		for (Operador operacion : operaciones) {

			// ponemos el operador1 en el operador 2 para poner el resultado en el operador1
			switch (operacion.getOperacion()) {
			case SUMAR:
				operacion.setOperador2(operacion.getOperador1());
				operacion.setOperador1(resultado);
				optionalResultado = sumar(operacion);
				break;
			case RESTAR:
				operacion.setOperador2(operacion.getOperador1());
				operacion.setOperador1(resultado);
				optionalResultado = restar(operacion);
				break;
			case MULTIPLICAR:
				operacion.setOperador2(operacion.getOperador1());
				operacion.setOperador1(resultado);
				optionalResultado = multiplicar(operacion);
				break;
			case DIVIDIR:
				operacion.setOperador2(operacion.getOperador1());
				operacion.setOperador1(resultado);
				optionalResultado = dividir(operacion);
				break;
			case RAIZ:
				operacion.setOperador2(operacion.getOperador1());
				operacion.setOperador1(resultado);
				optionalResultado = raiz(operacion);
				break;
			default:
				TracerImpl traza = new TracerImpl();
				traza.trace("No se ha realizado ninguna operación");
			}

			if (optionalResultado.isPresent()) {
				resultado = optionalResultado.get().getResultado();
			}
		}

		return Optional.ofNullable(new Operador(null,null,null,resultado));
	}

}
