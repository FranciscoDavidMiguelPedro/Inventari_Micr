package com.inventario.respuesta;

import java.util.List;
import com.inventario.dto.CategoriaDto;

public class CategoriaRespuesta {

	private List<CategoriaDto>inventarioCategorias;

	public List<CategoriaDto> getInventarioCategorias() {
		return inventarioCategorias;
	}

	public void setCategiraDtos(List<CategoriaDto> inventarioCategorias) {
		this.inventarioCategorias = inventarioCategorias;
	}
}
