package es.david.core.models.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.david.core.models.dto.EmpleadoDTO;
import es.david.core.models.entities.Empleado;
import es.david.core.models.entities.PuestosEnum;
import es.david.core.models.repository.IEmpleadoRepository;
import es.david.core.util.MapeadorEmpleados;
import es.david.core.util.NombrePuestoConverter;

//Logica del programa. Se trata de un Service que implementa la interfaz IEmpleadoService, que contiene todos los métodos firmados pero sin implementar.
@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

	@Autowired
	IEmpleadoRepository empleadoRepository;
	
	MapeadorEmpleados mapEmpl = new MapeadorEmpleados();

	@Override
	public void guardarEmpleado(EmpleadoDTO empleadoDto) {
		
		System.err.println(empleadoDto.toString());
		
		if(empleadoDto.getId()==null) {
			
			System.out.println("Aquí");
			int size = empleadoRepository.findAll().size();
			
			Integer id = empleadoRepository.findAll().get(size-1).getId();
			
			empleadoDto.setId(id+1);
			
			empleadoRepository.save(mapEmpl.convertToEntity(empleadoDto));
		}else {
			System.out.println("Aca");

			empleadoRepository.save(mapEmpl.convertToEntity(empleadoDto));
		}
		
	}
	
	@Override
	public List<EmpleadoDTO> listarEmpleados() {
		
		List<EmpleadoDTO> empleadosDto = null;
		
		List<Empleado> empleados = empleadoRepository.findAll();
		
		
		if(empleados!=null && empleados.size()>0) {
			empleadosDto = new ArrayList<EmpleadoDTO>();
			
			for(Empleado emp: empleados) {
				empleadosDto.add(mapEmpl.convertToDto(emp));
			}
		}
		return empleadosDto;
	}


	@Override
	public EmpleadoDTO buscarEmpleadoPorId(Integer id) {
		
		Optional<Empleado> emp = empleadoRepository.findById(id);
		
		if(emp.isPresent()) {
			return mapEmpl.convertToDto(emp.get());
		}else {
			//return new EmpleadoDTO();
			return null;
		}
	}


	@Override
	public void eliminarEmpleadoPorId(Integer id) {
		empleadoRepository.deleteById(id);

	}
	
	//TODO
	@Override
	public List<EmpleadoDTO> buscarEmpleadosPorPuesto(String nombrePuesto){
		
		List<EmpleadoDTO> empleadosPorPuesto = new ArrayList<>();
	
		for(Empleado emp: empleadoRepository.findAll()) {
			
			if(emp.getPuesto().getNombrePuesto().toLowerCase().contains(nombrePuesto.toLowerCase())) {
				empleadosPorPuesto.add(mapEmpl.convertToDto(emp)); 
			}
		}
		
		return empleadosPorPuesto;
	}
	
	@Override
	public List<EmpleadoDTO> filtrarPorSueldo(BigDecimal sueldo){
		
		System.out.println("Filtrando por sueldo...");
		
		List<EmpleadoDTO> empleadosPorSueldo = new ArrayList<>();
		
		for(Empleado emp: empleadoRepository.findAll()) {
			
			if(emp.getSalario().compareTo(sueldo) >= 1) {
				System.err.println("Por sueldo:" + emp.toString());
				empleadosPorSueldo.add(mapEmpl.convertToDto(emp));
			}
		}
		
		return empleadosPorSueldo;
	}

}
