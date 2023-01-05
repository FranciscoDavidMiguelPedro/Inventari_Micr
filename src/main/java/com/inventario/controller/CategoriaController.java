package com.inventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.inventario.respuesta.CategoriaRespuestaRest;
import com.inventario.service.ICategoriaService;

@RestController
@RequestMapping("/categoriaMicrov1")
public class CategoriaController {
	
	@Autowired
	private ICategoriaService service;
	
	@GetMapping("/categorias")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<CategoriaRespuestaRest> entityCategorias(){
		ResponseEntity<CategoriaRespuestaRest> respuesta = service.entity();
		return respuesta;
	}

}
