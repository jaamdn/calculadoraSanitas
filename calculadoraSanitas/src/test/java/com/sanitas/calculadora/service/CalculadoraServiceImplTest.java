/**
 * 
 */
package com.sanitas.calculadora.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
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
class CalculadoraServiceImplTest {

	@Autowired
	ICalculadoraService service;

	/**
	 * Test Sumar.
	 */
	@Test
	@DisplayName("Test Sumar")
	void testSumar() {
		Operador operacion = generateOperador("sumar", "3.3", "3.45");
		service.sumar(operacion);
		traza(operacion);
		assertTrue(operacion.getResultado() != null);
	}

	/**
	 * Test Restar.
	 */
	@Test
	@DisplayName("Test Restar")
	void testRestar() {
		Operador operacion = generateOperador("restar", "3", "4");
		service.restar(operacion);
		traza(operacion);
		assertTrue(operacion.getResultado() != null);
	}

	/**
	 * Test Multiplicar.
	 */
	@Test
	@DisplayName("Test Multiplicar")
	void testMultiplicar() {
		Operador operacion = generateOperador("multiplicar", "3", "3");
		service.multiplicar(operacion);
		traza(operacion);
		assertTrue(operacion.getResultado() != null);
	}

	/**
	 * Test Dividir.
	 */
	@Test
	@DisplayName("Test Dividir")
	void testDividir() {
		Operador operacion = generateOperador("dividir", "8", "3");
		service.dividir(operacion);
		traza(operacion);
		assertTrue(operacion.getResultado() != null);
	}

	/**
	 * Test Raiz Cuadrada.
	 */
	@Test
	@DisplayName("Test Raiz Cuadrada")
	void testRaiz() {
		Operador operacion = generateOperador("raiz", "3", null);
		service.raiz(operacion);
		traza(operacion);
		assertTrue(operacion.getResultado() != null);
	}

	/**
	 * Test Error formato parámetros.
	 */
	@Test
	@DisplayName("Test Error de formato parámetros")
	void testNumberFormatExceptionError() {
		Assertions.assertThrows(NumberFormatException.class, () -> {
			generateOperador("raiz", "a", "3");
		});

	}

	@Test
	@DisplayName("Test cálculo varios parámetros")
	void testCalcular() {
		List<Operador> operaciones = new ArrayList<Operador>();

		operaciones.add(generateOperador("sumar", "3", null));
		operaciones.add(generateOperador("restar", "3", null));
		operaciones.add(generateOperador("restar", "3", null));
		operaciones.add(generateOperador("multiplicar", "3", null));

		Operador opResponse = service.calcular(operaciones);
		if (opResponse != null) {
			traza(opResponse);
			assertTrue(opResponse.getResultado() != null);
		} else {
			fail();
		}
	}

	/**
	 * Metodo que inicializa el objeto operacion.
	 * 
	 * @return objeto Operador
	 */
	private Operador generateOperador(String operacion, String op1, String op2) {
		return new Operador(operacion, (op1 != null ? new BigDecimal(op1) : null),
				(op2 != null ? new BigDecimal(op2) : null), null);
	}

	/**
	 * Metodo utiliza la API Tracer para tracear las operaciones.
	 */
	private void traza(Operador operador) {
		TracerImpl traza = new TracerImpl();
		traza.trace(operador);
	}
}
