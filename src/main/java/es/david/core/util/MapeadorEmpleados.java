package es.david.core.util;

import es.david.core.models.dto.EmpleadoDTO;
import es.david.core.models.entities.Empleado;
import es.david.core.models.entities.PuestosEnum;

//Clase mapeadora de objetos, tanto de Empleado a EmpleadoDTO como viceversa
public class MapeadorEmpleados {

	public EmpleadoDTO convertToDto(Empleado empleado) {
		
		EmpleadoDTO empleadoDto = new EmpleadoDTO();
		
		empleadoDto.setId(empleado.getId());
		empleadoDto.setNombre(empleado.getNombre());
		empleadoDto.setApellido(empleado.getApellido());
		empleadoDto.setNombrePuesto(empleado.getPuesto().getNombrePuesto());
		empleadoDto.setSalario(empleado.getPuesto().getSalario());
		
		return empleadoDto;
	}
	
	public Empleado convertToEntity(EmpleadoDTO empleadoDto) {
		
		Empleado empleado = new Empleado();
		
		empleado.setId(empleadoDto.getId());
		empleado.setNombre(empleadoDto.getNombre());
		empleado.setApellido(empleadoDto.getApellido());
		
		String nombrePuesto = empleadoDto.getNombrePuesto();
		
		nombrePuesto = nombrePuesto.replace(" ", "_");
		
		PuestosEnum puestoEnum = PuestosEnum.valueOf(nombrePuesto);
		
		empleado.setPuesto(puestoEnum);
		
		empleado.setSalario(puestoEnum.getSalario());
		
		return empleado;
	}
}
