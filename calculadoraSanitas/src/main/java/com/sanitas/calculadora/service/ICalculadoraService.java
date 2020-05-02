package com.sanitas.calculadora.service;

import java.util.Optional;

import com.sanitas.calculadora.model.Operador;

public interface ICalculadoraService {

	/**
	 * Realiza la operación de sumar.
	 * @param op
	 * @return Operador
	 */
	Optional<Operador> sumar(Operador op);

	/**
	 * Realiza la operación de restar.
	 * @param op
	 * @return Operador
	 */
	Optional<Operador> restar(Operador op);

	/**
	 * Realiza la operacin de multiplicar.
	 * @param op
	 * @return Operador
	 */
	Optional<Operador> multiplicar(Operador op);

	/**
	 * Realiza la operación de dividir.
	 * @param op
	 * @return Operador
	 */
	Optional<Operador> dividir(Operador op);

	/**
	 * Realiza la operación de raiz cuadrada.
	 * @param op
	 * @return Operador
	 */
	Optional<Operador> raiz(Operador op);

}