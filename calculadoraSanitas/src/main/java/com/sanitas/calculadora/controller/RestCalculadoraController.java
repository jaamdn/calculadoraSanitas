/**
 * 
 */
package com.sanitas.calculadora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanitas.calculadora.model.Operador;

/**
 * @author dvazquez
 *
 */
@RestController
@RequestMapping("/Calculadora")
public class RestCalculadoraController {
	
//	@Autowired
//	Operador operador;

	@GetMapping
	public Double resultado() {
		return new Double("1");
	}
	
	@PostMapping
	public List<Double> operacion() {
		return null;
	}
	
	@DeleteMapping
	public List<Double> reset() {
		return null;
	}
	
	
	
	
}
