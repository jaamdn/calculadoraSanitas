package com.sanitas.calculadora.service;

import java.util.List;
import java.util.Optional;

import com.sanitas.calculadora.model.Operador;

public interface ICalculadoraService {

	/**
	 * Realiza la operación sumar.
	 * @param op
	 * @return Operador
	 */
	Optional<Operador> sumar(Operador op);

	/**
	 * Realiza la operación restar.
	 * @param op
	 * @return Operador
	 */
	Optional<Operador> restar(Operador op);

	/**
	 * Realiza la operacin multiplicar.
	 * @param op
	 * @return Operador
	 */
	Optional<Operador> multiplicar(Operador op);

	/**
	 * Realiza la operación dividir.
	 * @param op
	 * @return Operador
	 */
	Optional<Operador> dividir(Operador op);

	/**
	 * Realiza la operación raiz cuadrada.
	 * @param op
	 * @return Operador
	 */
	Optional<Operador> raiz(Operador op);
	
	/**
	 * Realiza las operaciones que se le pasan.
	 * @param operaciones
	 * @return Operador
	 */
	Optional<Operador> calcular(List<Operador> operaciones);

}