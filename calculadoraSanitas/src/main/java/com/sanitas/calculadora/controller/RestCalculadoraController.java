/**
 * 
 */
package com.sanitas.calculadora.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sanitas.calculadora.model.Operador;
import com.sanitas.calculadora.service.ICalculadoraService;

import io.corp.calculator.TracerImpl;

/**
 * @author dvazquez
 *
 */
@RestController
@RequestMapping("/")
public class RestCalculadoraController {

	@Autowired
	ICalculadoraService service;

	@RequestMapping(value = "/Calculadora/sumar", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Operador> sumar(@RequestBody @Valid Operador operador) {

		Optional<Operador> operadorResponse = service.sumar(operador);
		
		return tratarRespuesta(operador, operadorResponse);

	}

	@RequestMapping(value = "/Calculadora/restar", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Operador> restar(@RequestBody @Valid Operador operador) {

		Optional<Operador> operadorResponse = service.restar(operador);

		return tratarRespuesta(operador, operadorResponse);

	}

	@RequestMapping(value = "/Calculadora/multiplicar", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Operador> multiplicar(@RequestBody @Valid Operador operador) {

		Optional<Operador> operadorResponse = service.multiplicar(operador);

		return tratarRespuesta(operador, operadorResponse);


	}

	@RequestMapping(value = "/Calculadora/dividir", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Operador> dividir(@RequestBody @Valid Operador operador) {

		Optional<Operador> operadorResponse = service.dividir(operador);

		return tratarRespuesta(operador, operadorResponse);


	}

	@RequestMapping(value = "/Calculadora/raiz", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Operador> raiz(@RequestBody @Valid Operador operador) {

		Optional<Operador> operadorResponse = service.raiz(operador);

		return tratarRespuesta(operador, operadorResponse);


	}
	
	
	@RequestMapping(value = "/Calculadora/calcular", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Operador> calcular(@RequestBody @Valid List<Operador> operaciones) {

			Optional<Operador> operadorResponse = service.calcular(operaciones);
			return tratarRespuesta(new Operador(), operadorResponse);


	}

	/**
	 * @param operador
	 * @param operadorResponse
	 * @return
	 */
	private ResponseEntity<Operador> tratarRespuesta(Operador operador, Optional<Operador> operadorResponse) {
		
		ResponseEntity<Operador> responseEntity;
		TracerImpl traza =new TracerImpl();
		
		if (operadorResponse.isPresent()) {
			responseEntity = new ResponseEntity<>(operadorResponse.get(), HttpStatus.OK);
			traza.trace(operadorResponse.get());
		} else {
			responseEntity = new ResponseEntity<>(operador, HttpStatus.INTERNAL_SERVER_ERROR);
			traza.trace(operador);
		}
		return responseEntity;
	}
}
