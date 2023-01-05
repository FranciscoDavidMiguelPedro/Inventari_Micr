package com.inventario.service;

import org.springframework.http.ResponseEntity;

import com.inventario.dto.CategiraDto;
import com.inventario.respuesta.CategoriaRespuestaRest;

public interface ICategoriaService {

	public ResponseEntity<CategoriaRespuestaRest>listaBsd();
	public ResponseEntity<CategoriaRespuestaRest>busquedaId(Integer id);
	public ResponseEntity<CategoriaRespuestaRest>guagarPost(CategiraDto categoriaPost);
	
	
}
