/**
 * 
 */
package com.sanitas.calculadora.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanitas.calculadora.model.Operador;
import com.sanitas.calculadora.service.CalculadoraService;

/**
 * @author dvazquez
 *
 */
@RestController
@RequestMapping("/")
public class RestCalculadoraController {

	@Autowired
	CalculadoraService service;

	@GetMapping
	@RequestMapping("/Calculadora/sumar")
	public ResponseEntity<Operador> sumar(@RequestBody @Valid Operador operador) {

		HttpStatus status;

		Optional<Operador> operadorResponse = service.sumar(operador);

		status = operadorResponse.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND;

		return new ResponseEntity<Operador>(operadorResponse.get(), status);

	}

	@GetMapping
	@RequestMapping("/Calculadora/restar")
	public ResponseEntity<Operador> restar(@RequestBody @Valid Operador operador) {

		HttpStatus status;

		Optional<Operador> operadorResponse = service.restar(operador);

		status = operadorResponse.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND;

		return new ResponseEntity<Operador>(operadorResponse.get(), status);

	}

	@GetMapping
	@RequestMapping("/Calculadora/multiplicar")
	public ResponseEntity<Operador> multiplicar(@RequestBody @Valid Operador operador) {

		HttpStatus status;

		Optional<Operador> operadorResponse = service.multiplicar(operador);

		status = operadorResponse.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND;

		return new ResponseEntity<Operador>(operadorResponse.get(), status);

	}

	@GetMapping
	@RequestMapping("/Calculadora/dividir")
	public ResponseEntity<Operador> dividir(@RequestBody @Valid Operador operador) {

		HttpStatus status;

		Optional<Operador> operadorResponse = service.dividir(operador);

		status = operadorResponse.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND;

		return new ResponseEntity<Operador>(operadorResponse.get(), status);

	}

	@GetMapping
	@RequestMapping("/Calculadora/raiz")
	public ResponseEntity<Operador> raiz(@RequestBody @Valid Operador operador) {

		HttpStatus status;

		Optional<Operador> operadorResponse = service.raiz(operador);

		status = operadorResponse.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND;

		return new ResponseEntity<Operador>(operadorResponse.get(), status);

	}

//	@GetMapping
//	@RequestMapping("/Calculadora/potencia")
//	public ResponseEntity<Operador> potencia(@RequestBody @Valid Operador operador) {
//
//		HttpStatus status;
//
//		Optional<Operador> operadorResponse = service.potencia(operador);
//
//		status = operadorResponse.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND;
//
//		return new ResponseEntity<Operador>(operadorResponse.get(), status);
//
//	}

}
