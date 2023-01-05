package com.inventario.respuesta;

import java.util.List;
import com.inventario.dto.CategiraDto;

public class CategoriaRespuesta {

	private List<CategiraDto>inventarioCategorias;

	public List<CategiraDto> getInventarioCategorias() {
		return inventarioCategorias;
	}

	public void setCategiraDtos(List<CategiraDto> inventarioCategorias) {
		this.inventarioCategorias = inventarioCategorias;
	}
}
