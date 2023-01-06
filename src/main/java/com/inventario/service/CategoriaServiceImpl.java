package com.inventario.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventario.dao.ICategoriaDao;
import com.inventario.dto.CategoriaDto;
import com.inventario.respuesta.CategoriaRespuestaRest;

//con la anotacion @service les estoy indicando que se comportara como un servicio
@Service
public class CategoriaServiceImpl implements ICategoriaService {

	@Autowired
	private ICategoriaDao categoriaDao;

	/**
	 * 
	 */
	@Override
	@Transactional(readOnly = true) // este metodo funcionara como metodo transacional
	public ResponseEntity<CategoriaRespuestaRest> listaBsd() {

		CategoriaRespuestaRest respuesta = new CategoriaRespuestaRest();
		try {
			List<CategoriaDto> categiraDto = (List<CategoriaDto>) categoriaDao.findAll();// cateo del retonro de este
																							// metodo
			respuesta.getRespuestaCategoria().setCategiraDtos(categiraDto);// este setea la lista de categoria el cual
																			// se otubo las categorias
			respuesta.setOperacion("Mensaje", "200", "Operacion Exitosa..");
		} catch (Exception e) {
			respuesta.setOperacion("Mensaje", "500", "Error al Consumir Los datos");
			e.getStackTrace();
			return new ResponseEntity<CategoriaRespuestaRest>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<CategoriaRespuestaRest>(respuesta, HttpStatus.OK);
	}

	/**
	 * 
	 */
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<CategoriaRespuestaRest> busquedaId(Integer id) {
		CategoriaRespuestaRest respuesta = new CategoriaRespuestaRest();
		List<CategoriaDto> lista = new ArrayList<>();
		try {

			Optional<CategoriaDto> categoria = categoriaDao.findById(id);

			if (categoria.isPresent()) {
				lista.add(categoria.get());
				respuesta.getRespuestaCategoria().setCategiraDtos(lista);
				respuesta.setOperacion("Mensaje", "200", "Operacion Exitosa..");
			} else {
				respuesta.setOperacion("Mensaje", "404", "Datos no encontados en la base");
				return new ResponseEntity<CategoriaRespuestaRest>(respuesta, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			respuesta.setOperacion("Mensaje", "500", "Error al Consumir Los datos por Id");
			e.getStackTrace();
			return new ResponseEntity<CategoriaRespuestaRest>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<CategoriaRespuestaRest>(respuesta, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<CategoriaRespuestaRest> guardarInvent(CategoriaDto gCategoria) {

		CategoriaRespuestaRest respuesta = new CategoriaRespuestaRest();
		List<CategoriaDto> lista = new ArrayList<>();
		try {
			CategoriaDto categoriaGuardar = categoriaDao.save(gCategoria);// de esta forma guardo un registro y lo
																			// almaceno en categoriaGuaradr
			// validacion
			if (categoriaGuardar != null) {// si se cumple la validacion
				lista.add(categoriaGuardar);// se almacenara en la lista se guardara en categoriaGuardar
				respuesta.getRespuestaCategoria().setCategiraDtos(lista);// se almacenara en la respuesta
				respuesta.setOperacion("Mensaje", "200", "Operacion Exitosa..");
			} else {
				respuesta.setOperacion("Mensaje", "400", "Datos no Guarados Correctamente en la base");
				return new ResponseEntity<CategoriaRespuestaRest>(respuesta, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			respuesta.setOperacion("Mensaje", "500", "Error al Guaradar Datos en la Base de Datos");
			e.getStackTrace();
			return new ResponseEntity<CategoriaRespuestaRest>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<CategoriaRespuestaRest>(respuesta, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<CategoriaRespuestaRest> actualizarInvent(CategoriaDto actCategoria, Integer id) {
		CategoriaRespuestaRest respuesta = new CategoriaRespuestaRest();
		List<CategoriaDto> lista = new ArrayList<>();
		try {
			Optional<CategoriaDto> categoriaActulizar = categoriaDao.findById(id);
			if (categoriaActulizar.isPresent()) {// preguto si exite la categoriaActulizar si exite modifico los valores
				// se actualizara el registro
				categoriaActulizar.get().setName(actCategoria.getName());
				categoriaActulizar.get().setDescripcion(actCategoria.getDescripcion());

				CategoriaDto categoriaDtoActualizar = categoriaDao.save(categoriaActulizar.get());// categoriaDtoActualizar
																									// se mostrara los
																									// datos modificados
				if (categoriaDtoActualizar != null) {
					lista.add(categoriaDtoActualizar);// se almacenara en la lista se guardara en categoriaGuardar
					respuesta.getRespuestaCategoria().setCategiraDtos(lista);// se almacenara en la respuesta
					respuesta.setOperacion("Mensaje", "200", "Operacion Exitosa..");
				} else {// si es que nullo la categoria se tendra que indicar que se fallo
					respuesta.setOperacion("Mensaje", "400", "Dato de Inventario no Actualizado");
					return new ResponseEntity<CategoriaRespuestaRest>(respuesta, HttpStatus.BAD_REQUEST);
				}
			} else {
				respuesta.setOperacion("Mensaje", "404", "Dato de Inventario no encontrado para su Actualizacion");
				return new ResponseEntity<CategoriaRespuestaRest>(respuesta, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			respuesta.setOperacion("Mensaje", "500", "Error al Guaradar Datos en la Base de Datos");
			e.getStackTrace();
			return new ResponseEntity<CategoriaRespuestaRest>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<CategoriaRespuestaRest>(respuesta, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<CategoriaRespuestaRest> eliminarId(Integer id) {
		CategoriaRespuestaRest respuesta = new CategoriaRespuestaRest();
		try {
			categoriaDao.deleteById(id);
			respuesta.setOperacion("Mensaje", "200", "Operacion Exitosa..");
		} catch (Exception e) {
			respuesta.setOperacion("Mensaje", "500", "Error al Eliminar los datos en la base de datos");
			e.getStackTrace();
			return new ResponseEntity<CategoriaRespuestaRest>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<CategoriaRespuestaRest>(respuesta, HttpStatus.OK);
	}
}
