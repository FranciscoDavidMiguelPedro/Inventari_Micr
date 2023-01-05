package com.inventario.respuesta;

import java.util.ArrayList;
import java.util.HashMap;

public class RespuestaRest {

	private ArrayList<HashMap<String, String>> operacion = new ArrayList<>();//

	public ArrayList<HashMap<String, String>> getOperacion() {//construcion de mi metodo geter y seter
		return operacion;
	}

	public void setOperacion(String mensaje, String codigo, String date) {//declaro un hasmap de manera local dentro del set
		HashMap<String, String> map = new HashMap<String, String>();//este hasmap lo seteo con string 
		
		//map.put("categoriaRespuesta", mensaje);
		map.put("codigo", codigo);
		map.put("Status", date);
		
		operacion.add(map);
	}
}
