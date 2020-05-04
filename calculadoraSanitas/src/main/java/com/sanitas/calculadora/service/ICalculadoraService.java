package com.sanitas.calculadora.service;

import java.util.List;

import com.sanitas.calculadora.model.Operador;

public interface ICalculadoraService {

	/**
	 * Realiza la operación sumar.
	 * @param op
	 * @return Operador
	 */
	Operador sumar(Operador op);

	/**
	 * Realiza la operación restar.
	 * @param op
	 * @return Operador
	 */
	Operador restar(Operador op);

	/**
	 * Realiza la operacin multiplicar.
	 * @param op
	 * @return Operador
	 */
	Operador multiplicar(Operador op);

	/**
	 * Realiza la operación dividir.
	 * @param op
	 * @return Operador
	 */
	Operador dividir(Operador op);

	/**
	 * Realiza la operación raiz cuadrada.
	 * @param op
	 * @return Operador
	 */
	Operador raiz(Operador op);
	
	/**
	 * Realiza las operaciones que se le pasan.
	 * @param operaciones
	 * @return Operador
	 */
	Operador calcular(List<Operador> operaciones);

}