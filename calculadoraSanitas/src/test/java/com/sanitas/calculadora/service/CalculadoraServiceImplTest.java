/**
 * 
 */
package com.sanitas.calculadora.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
	@DisplayName("Test Sumar dos números")
	void testSumar() {
		Operador operacion = generateOperador("sumar", "3.3", "3.45");
		service.sumar(operacion);
		traza(operacion);
		assertTrue(operacion.getResultado() != null);
	}

	/**
	 * Test Sumar numeros negativos.
	 */
	@Test
	@DisplayName("Test Sumar Negativos")
	void testSumarNegativos() {
		Operador operacion = generateOperador("sumar", "-2", "-3");
		service.sumar(operacion);
		traza(operacion);
		assertTrue(operacion.getResultado() != null);
	}

	/**
	 * Test Sumar nulo.
	 */
	@Test
	@DisplayName("Test Sumar nulo")
	void testSumarNulo() {
		Operador operacion = generateOperador("sumar", "8", null);
		service.sumar(operacion);
		traza(operacion);
		assertTrue(operacion.getResultado() != null);
	}

	/**
	 * Test Restar dos números.
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
	 * Test Restar.
	 */
	@Test
	@DisplayName("Test Restar negativos")
	void testRestarNegativos() {
		Operador operacion = generateOperador("restar", "-2", "-8");
		service.restar(operacion);
		traza(operacion);
		assertTrue(operacion.getResultado() != null);
	}

	/**
	 * Test Restar nulos.
	 */
	@Test
	@DisplayName("Test Restar Nulos")
	void testRestarNulo() {
		Operador operacion = generateOperador("restar", "-3", null);
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
	 * Test Multiplicar por cero.
	 */
	@Test
	@DisplayName("Test Multiplicar por Cero")
	void testMultiplicarPorCero() {
		Operador operacion = generateOperador("multiplicar", "0", "3");
		service.multiplicar(operacion);
		traza(operacion);
		assertTrue(operacion.getResultado() != null);
	}

	/**
	 * Test Multiplicar negativo.
	 */
	@Test
	@DisplayName("Test Multiplicar negativo")
	void testMultiplicarNegativo() {
		Operador operacion = generateOperador("multiplicar", "-2", "5");
		service.multiplicar(operacion);
		traza(operacion);
		assertTrue(operacion.getResultado() != null);
	}

	/**
	 * Test Multiplicar dos números negativos.
	 */
	@Test
	@DisplayName("Test Multiplicar dos negativos")
	void testMultiplicarDosNegativos() {
		Operador operacion = generateOperador("multiplicar", "-2", "-5");
		service.multiplicar(operacion);
		traza(operacion);
		assertTrue(operacion.getResultado() != null);
	}

	/**
	 * Test Multiplicar dos números decimales.
	 */
	@Test
	@DisplayName("Test Multiplicar decimales")
	void testMultiplicarDecimales() {
		Operador operacion = generateOperador("multiplicar", "-2.1", "5.8");
		service.multiplicar(operacion);
		traza(operacion);
		assertTrue(operacion.getResultado() != null);
	}

	/**
	 * Test Multiplicar nulo.
	 */
	@Test
	@DisplayName("Test Multiplicar nulo")
	void testMultiplicarNulo() {
		Operador operacion = generateOperador("multiplicar", "8", null);
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
	 * Test Dividir numero decimal.
	 */
	@Test
	@DisplayName("Test Dividir decimales")
	void testDividirDecimal() {
		Operador operacion = generateOperador("dividir", "4.1", "3");
		service.dividir(operacion);
		traza(operacion);
		assertTrue(operacion.getResultado() != null);
	}

	/**
	 * Test Dividir negativos.
	 */
	@Test
	@DisplayName("Test Dividir Negativos")
	void testDividirNegativos() {
		Operador operacion = generateOperador("dividir", "-11", "-8");
		service.dividir(operacion);
		traza(operacion);
		assertTrue(operacion.getResultado() != null);
	}

	/**
	 * Test Dividir denominador mas grande.
	 */
	@Test
	@DisplayName("Test Dividir denominador grande")
	void testDividirDenominadorGrande() {
		Operador operacion = generateOperador("dividir", "22", "33");
		service.dividir(operacion);
		traza(operacion);
		assertTrue(operacion.getResultado() != null);
	}
	
	/**
	 * Test Dividir null.
	 */
	@Test
	@DisplayName("Test Dividir por null")
	void testDividirPorNull() {
		Assertions.assertThrows(ArithmeticException.class, () -> {
			service.dividir(generateOperador("dividir", "45", null));
		});
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
	 * Test Raiz Cuadrada negativa.
	 */
	@Test
	@DisplayName("Test Raiz Cuadrada Negativa")
	void testRaizNegativa() {
		Assertions.assertThrows(NumberFormatException.class, () -> {
			service.raiz(generateOperador("raiz", "-4", null));
		});
	}

	/**
	 * Test Error formato parámetros.
	 */
	@Test
	@DisplayName("Test Error de formato parámetros")
	void testNumberFormatExceptionError() {
		Assertions.assertThrows(NumberFormatException.class, () -> {
			generateOperador("raiz", "a", null);
		});

	}

	/**
	 * Test Error formato parámetros.
	 */
	@Test
	@DisplayName("Test Error ArithmeticException")
	void testDivideNumberFormatExceptionError() {
		Assertions.assertThrows(ArithmeticException.class, () -> {
			service.dividir(generateOperador("dividir", "1", "0"));
		});

	}

	/**
	 * Test Error formato parámetros.
	 */
	@Test
	@DisplayName("Test Error NullPointerException")
	void testNullPointerExceptionError() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			generateOperador("sumar", null, "3");
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

	@Test
	@DisplayName("Test cálculo NumberFormatException")
	void testCalcularErrorNumberFormatException() {

		Exception exception = Assertions.assertThrows(NumberFormatException.class, () -> {
			List<Operador> operaciones = new ArrayList<Operador>();

			operaciones.add(generateOperador("restar", "3", null));
			operaciones.add(generateOperador("raiz", "1", null));
			service.calcular(operaciones);

		});
		assertEquals(null, exception.getMessage());
	}

	@Test
	@DisplayName("Test cálculo NullPointerException")
	void testCalcularErrorNullPointerExceptio() {

		Exception exception = Assertions.assertThrows(NullPointerException.class, () -> {
			List<Operador> operaciones = new ArrayList<Operador>();

			operaciones.add(generateOperador("restar", "3", null));
			operaciones.add(generateOperador("sumar", "1", null));
			operaciones.add(generateOperador("multiplicar", null, "0"));
			service.calcular(operaciones);

		});
		assertEquals(null, exception.getMessage());
	}

	/**
	 * Metodo que inicializa el objeto operacion.
	 * 
	 * @return objeto Operador
	 */
	private Operador generateOperador(String operacion, String op1, String op2) {
		return new Operador(operacion, new BigDecimal(op1), (op2 != null ? new BigDecimal(op2) : null), null);
	}

	/**
	 * Metodo utiliza la API Tracer para tracear las operaciones.
	 */
	private void traza(Operador operador) {
		TracerImpl traza = new TracerImpl();
		traza.trace(operador);
	}
}
