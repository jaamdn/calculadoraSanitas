/**
 * 
 */
package com.sanitas.calculadora.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
		
		
		//service.sumar(operacion);
		//assertTrue(operacion.getResultado());
		fail("Not yet implemented");
	}

	/**
	 * Test Restar.
	 */
	@Test
	@DisplayName("Test Restar")
	void testRestar() {
		fail("Not yet implemented");
	}

	/**
	 * Test Multiplicar.
	 */
	@Test
	@DisplayName("Test Multiplicar")
	void testMultiplicar() {
		fail("Not yet implemented");
	}

	/**
	 * Test Dividir.
	 */
	@Test
	@DisplayName("Test Dividir")
	void testDividir() {
		fail("Not yet implemented");
	}

	/**
	 * Test Raiz Cuadrada.
	 */
	@Test
	@DisplayName("Test Raiz Cuadrada")
	void testRaiz() {
		fail("Not yet implemented");
	}

	/**
	 * Test Potencia.
	 */
	@Test
	@DisplayName("Test Potencia")
	void testPotencia() {
		fail("Not yet implemented");
	}

}
