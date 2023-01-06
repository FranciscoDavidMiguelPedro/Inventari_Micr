package com.inventario.service;

import org.springframework.http.ResponseEntity;

import com.inventario.dto.CategoriaDto;
import com.inventario.respuesta.CategoriaRespuestaRest;

public interface ICategoriaService {

	public ResponseEntity<CategoriaRespuestaRest> listaBsd();
	public ResponseEntity<CategoriaRespuestaRest> busquedaId(Integer id);
	public ResponseEntity<CategoriaRespuestaRest> guardarInvent(CategoriaDto gCategoria);
	public ResponseEntity<CategoriaRespuestaRest> actualizarInvent(CategoriaDto actCategoria,Integer id);
	public ResponseEntity<CategoriaRespuestaRest> eliminarId(Integer id);
	
	
}
