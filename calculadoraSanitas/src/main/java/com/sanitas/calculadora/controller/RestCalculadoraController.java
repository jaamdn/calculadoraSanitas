/**
 * 
 */
package com.sanitas.calculadora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sanitas.calculadora.model.Operador;
import com.sanitas.calculadora.service.CalculadoraService;

/**
 * @author dvazquez
 *
 */
@RestController
@RequestMapping("/Calculadora")
public class RestCalculadoraController {
	
	@Autowired
	CalculadoraService service;

	@GetMapping
	public Operador sumar(@RequestParam String operador1,@RequestParam String operador2) {
		
		return service.sumar(new Operador("Sumar",new Double(operador1),new Double(operador2),new Double(0)));
		
	}
	
	@PutMapping
	public Operador operacion() {
		return null;
	}
	
	@DeleteMapping
	public Operador reset() {
		return new Operador("Reset",new Double(0),new Double(0),new Double(0));
	}
	
	
	
	
}
