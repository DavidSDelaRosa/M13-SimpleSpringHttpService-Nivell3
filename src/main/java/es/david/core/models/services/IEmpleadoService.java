package es.david.core.models.services;

import java.math.BigDecimal;
import java.util.List;

import es.david.core.models.dto.EmpleadoDTO;

public interface IEmpleadoService {

	List<EmpleadoDTO> listarEmpleados();
	
	void guardarEmpleado(EmpleadoDTO empleado);
	
	EmpleadoDTO buscarEmpleadoPorId(Integer id);
	
	void eliminarEmpleadoPorId(Integer id);
	
	List<EmpleadoDTO> buscarEmpleadosPorPuesto(String nombrePuesto);
	
	List<EmpleadoDTO> filtrarPorSueldo(BigDecimal sueldo);
	
	//List<EmpleadoDTO> buscarEmpleadosPorFiltro(String nombre, String apellido);
}
