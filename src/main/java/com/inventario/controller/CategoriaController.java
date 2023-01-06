package com.inventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.inventario.dto.CategoriaDto;
import com.inventario.respuesta.CategoriaRespuestaRest;
import com.inventario.service.ICategoriaService;

@RestController
@RequestMapping("/categoriaMicrov1")
public class CategoriaController {
	
	@Autowired
	private ICategoriaService service;
	
	
	@GetMapping("/categorias")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<CategoriaRespuestaRest> listaCategorias(){
		//ResponseEntity<CategoriaRespuestaRest> respuesta = service.listaBsd();
		//return respuesta;
		return service.listaBsd();
	}

	@GetMapping("/categorias/busquedaId/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<CategoriaRespuestaRest> busquedaCategoriasById(@PathVariable Integer id){
		//ResponseEntity<CategoriaRespuestaRest> respuesta = service.busquedaId(id);
		//return respuesta;
		return service.busquedaId(id);
	}
	@PostMapping("/categorias/guardar")
	@ResponseStatus(HttpStatus.OK)
	public  ResponseEntity<CategoriaRespuestaRest> guardarInvent(@RequestBody CategoriaDto gCategoria){
		//ResponseEntity<CategoriaRespuestaRest>respuesta = service.guagarPost(categoriaPost);
		//return respuesta;
		return service.guardarInvent(gCategoria);
	}
	
	@PutMapping("/categorias/actualizar/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<CategoriaRespuestaRest>actualizarInvent(@RequestBody CategoriaDto actCategoria, @PathVariable Integer id ){
				//ResponseEntity<CategoriaRespuestaRest>respuesta = service.actualizarInvent(actCategoria, id);
				//return respuesta;
		return service.actualizarInvent(actCategoria, id);
	}
	@DeleteMapping("/categorias/eliminacion/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<CategoriaRespuestaRest> eliminarId(@PathVariable Integer id){
		//ResponseEntity<CategoriaRespuestaRest> respuesta = service.eliminarId(id);
		//return respuesta;
		return service.eliminarId(id);
		
	}
}
