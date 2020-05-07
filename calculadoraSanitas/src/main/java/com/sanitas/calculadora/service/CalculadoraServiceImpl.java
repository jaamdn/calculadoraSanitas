/**
 * 
 */
package com.sanitas.calculadora.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

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
	private static final String CALCULAR = "calcular";

	/**
	 * Realiza la operación de sumar.
	 * 
	 * @param op
	 * @return Operador
	 */
	@Override
	public Operador sumar(Operador op) {
		op.setOperacion(SUMAR);

		op.setResultado(op.getOperador1().add(op.getOperador2() != null ? op.getOperador2() : new BigDecimal(0)));

		return op;

	}

	/**
	 * Realiza la operación de restar.
	 * 
	 * @param op
	 * @return Operador
	 */
	@Override
	public Operador restar(Operador op) {

		op.setOperacion(RESTAR);
		op.setResultado(op.getOperador1().subtract(op.getOperador2() != null ? op.getOperador2() : new BigDecimal(0))
				.setScale(2));

		return op;

	}

	/**
	 * Realiza la operacin de multiplicar.
	 * 
	 * @param op
	 * @return Operador
	 */
	@Override
	public Operador multiplicar(Operador op) {

		op.setOperacion(MULTIPLICAR);
		op.setResultado(op.getOperador1().multiply(op.getOperador2() != null ? op.getOperador2() : new BigDecimal(0)));

		return op;

	}

	/**
	 * Realiza la operación de dividir.
	 * 
	 * @param op
	 * @return Operador
	 */
	@Override
	public Operador dividir(Operador op) {

		op.setOperacion(DIVIDIR);
		op.setResultado(op.getOperador1().divide(op.getOperador2() != null ? op.getOperador2() : new BigDecimal(0), 10,
				RoundingMode.HALF_EVEN));

		return op;

	}

	/**
	 * Realiza la operación de raiz cuadrada.
	 * 
	 * @param op
	 * @return Operador
	 */
	@Override
	public Operador raiz(Operador op) {

		op.setOperacion(RAIZ);
		op.setResultado(BigDecimal.valueOf(Math.sqrt(op.getOperador1().doubleValue())));

		return op;

	}

	/**
	 * Realiza las operaciones que se le pasan.
	 * 
	 * @param operaciones
	 * @return Operador
	 */
	public Operador calcular(List<Operador> operaciones) {

		BigDecimal resultado = new BigDecimal(0);
		Operador opResultado = null;

		for (Operador operacion : operaciones) {

			// ponemos el operador1 en el operador 2 para poner el resultado en el operador1
			// y realizar la operación
			switch (operacion.getOperacion()) {
			case SUMAR:
				operacion.setOperador2(operacion.getOperador1());
				operacion.setOperador1(resultado);
				opResultado = sumar(operacion);
				break;
			case RESTAR:
				operacion.setOperador2(operacion.getOperador1());
				operacion.setOperador1(resultado);
				opResultado = restar(operacion);
				break;
			case MULTIPLICAR:
				operacion.setOperador2(operacion.getOperador1());
				operacion.setOperador1(resultado);
				opResultado = multiplicar(operacion);
				break;
			case DIVIDIR:
				operacion.setOperador2(operacion.getOperador1());
				operacion.setOperador1(resultado);
				opResultado = dividir(operacion);
				break;
			case RAIZ:
				operacion.setOperador2(operacion.getOperador1());
				operacion.setOperador1(resultado);
				opResultado = raiz(operacion);
				break;
			default:
				TracerImpl traza = new TracerImpl();
				traza.trace("No se ha realizado ninguna operación");
			}

			if (opResultado.getResultado() != null) {
				resultado = opResultado.getResultado();
			}
		}
		return new Operador(CALCULAR, null, null, resultado);
	}

}
