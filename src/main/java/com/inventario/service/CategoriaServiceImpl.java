package com.inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventario.dao.ICategoriaDao;
import com.inventario.dto.CategiraDto;
import com.inventario.respuesta.CategoriaRespuestaRest;

//con la anotacion @service les estoy indicando que se comportara como un servicio
@Service
public class CategoriaServiceImpl implements ICategoriaService {

	@Autowired
	private ICategoriaDao categoriaDao;

	@Override
	@Transactional(readOnly = true) // este metodo funcionara como metodo transacional
	public ResponseEntity<CategoriaRespuestaRest> entity() {

		CategoriaRespuestaRest respuesta = new CategoriaRespuestaRest();
		try {
			List<CategiraDto> categiraDto = (List<CategiraDto>) categoriaDao.findAll();// cateo del retonro de este
																						// metodo
			respuesta.getRespuestaCategoria().setCategiraDtos(categiraDto);// este setea la lista de categoria el cual
																			// se otubo las categorias
			respuesta.setOperacion("Mensaje", "200", "Operacion Exitosa..");
		} catch (Exception e) {
			respuesta.setOperacion("Mensaje", "500", "Error al Consumir Los datos");
			e.getStackTrace();
			return new ResponseEntity<CategoriaRespuestaRest>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<CategoriaRespuestaRest>(respuesta,HttpStatus.OK);
	}

}
