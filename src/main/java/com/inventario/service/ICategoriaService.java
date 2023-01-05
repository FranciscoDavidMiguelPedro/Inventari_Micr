package com.inventario.service;

import org.springframework.http.ResponseEntity;

import com.inventario.respuesta.CategoriaRespuestaRest;

public interface ICategoriaService {

	public ResponseEntity<CategoriaRespuestaRest>listaBsd();
	public ResponseEntity<CategoriaRespuestaRest>busquedaId(Long id);
	
}
