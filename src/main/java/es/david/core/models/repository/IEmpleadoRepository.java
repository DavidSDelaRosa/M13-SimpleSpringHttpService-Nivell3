package es.david.core.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.david.core.models.entities.Empleado;

@Repository
public interface IEmpleadoRepository extends JpaRepository<Empleado, Integer>{

	//public List<Empleado> buscarPorNombre(String nombre);
	
 	
}
