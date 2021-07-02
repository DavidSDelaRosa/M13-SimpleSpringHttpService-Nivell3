package es.david.core.util;

import es.david.core.models.entities.PuestosEnum;

//Formateador de Strings a PuestosEnum
public class NombrePuestoConverter {

	public static PuestosEnum stringToPuestosEnum(String nombrePuesto) {
		
		nombrePuesto = nombrePuesto.replace(" ", "_");
		
		PuestosEnum puestoEnum = PuestosEnum.valueOf(nombrePuesto);
		
		return puestoEnum;
	}
}
