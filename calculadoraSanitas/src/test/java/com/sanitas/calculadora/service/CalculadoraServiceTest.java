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

/**
 * @author dvazquez
 *
 */
@SpringBootTest
class CalculadoraServiceTest  {
	
	@Autowired
	CalculadoraService service;
	
	
//	@BeforeAll
//	static void setup() {
//	    log.info("@BeforeAll - executes once before all test methods in this class");
//	}
//	 
//	@BeforeEach
//	void init() {
//	    log.info("@BeforeEach - executes before each test method in this class");
//	}
//	
//	@AfterEach
//	void tearDown() {
//	    log.info("@AfterEach - executed after each test method.");
//	}
//	 
//	@AfterAll
//	static void done() {
//	    log.info("@AfterAll - executed after all test methods.");
//	}

	/**
	 * Test Sumar.
	 */
	@Test
	@DisplayName("Test Sumar")
	void testSumar() {
		Operador operacion = generateOperador("sumar","3","3");
		service.sumar(operacion);
		System.out.println(operacion.toString());
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
		System.out.println(operacion.toString());
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
		System.out.println(operacion.toString());
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
		System.out.println(operacion.toString());
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
		System.out.println(operacion.toString());
		assertTrue(operacion.getResultado() !=null);
	}

//	/**
//	 * Test Potencia.
//	 */
//	@Test
//	@DisplayName("Test Potencia")
//	void testPotencia() {
//		Operador operacion = generateOperador();
//		service.potencia(operacion);
//		assertTrue(operacion.getResultado() !=null);
//	}

	/**
	 * Metodo que inicializa el objeto operacion.
	 * @return objeto Operador
	 */
	private Operador generateOperador(String operacion,String op1,String op2) {
		return new Operador(operacion, new BigDecimal(op1), new BigDecimal(op2), null);
	}
}
