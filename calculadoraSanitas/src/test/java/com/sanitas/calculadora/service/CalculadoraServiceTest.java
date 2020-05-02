/**
 * 
 */
package com.sanitas.calculadora.service;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sanitas.calculadora.model.Operador;

import io.corp.calculator.TracerImpl;

/**
 * @author dvazquez
 *
 */
@SpringBootTest
class CalculadoraServiceTest  {
	
	@Autowired
	CalculadoraService service;
	
		/**
	 * Test Sumar.
	 */
	@Test
	@DisplayName("Test Sumar")
	void testSumar() {
		Operador operacion = generateOperador("sumar","3","3");
		service.sumar(operacion);
		traza(operacion);
		assertTrue(operacion.getResultado() !=null);
	}


	/**
	 * Test Restar.
	 */
	@Test
	@DisplayName("Test Restar")
	void testRestar() {
		Operador operacion = generateOperador("restar","3","3");
		service.restar(operacion);
		traza(operacion);
		assertTrue(operacion.getResultado() !=null);
	}

	/**
	 * Test Multiplicar.
	 */
	@Test
	@DisplayName("Test Multiplicar")
	void testMultiplicar() {
		Operador operacion = generateOperador("multiplicar","3","3");
		service.multiplicar(operacion);
		traza(operacion);
		assertTrue(operacion.getResultado() !=null);
	}

	/**
	 * Test Dividir.
	 */
	@Test
	@DisplayName("Test Dividir")
	void testDividir() {
		Operador operacion =generateOperador("dividir","3","3");
		service.dividir(operacion);
		traza(operacion);
		assertTrue(operacion.getResultado() !=null);
	}

	/**
	 * Test Raiz Cuadrada.
	 */
	@Test
	@DisplayName("Test Raiz Cuadrada")
	void testRaiz() {
		Operador operacion = generateOperador("raiz","3","3");
		service.raiz(operacion);
		traza(operacion);
		assertTrue(operacion.getResultado() !=null);
	}


	
	
	
	
	/**
	 * Metodo que inicializa el objeto operacion.
	 * @return objeto Operador
	 */
	private Operador generateOperador(String operacion,String op1,String op2) {
		return new Operador(operacion, new BigDecimal(op1), new BigDecimal(op2), null);
	}
	
	
	/**
	 * Metodo utiliza la API Tracer para tracear las operaciones.
	 */
	private void traza(Operador operador) {
		TracerImpl traza = new TracerImpl();
		traza.trace(operador);
	}
}
