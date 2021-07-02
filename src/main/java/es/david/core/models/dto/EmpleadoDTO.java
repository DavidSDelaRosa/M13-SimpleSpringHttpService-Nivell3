package es.david.core.models.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;

//Clase DTO que representa el objeto que pasará a la vista. Es la transformación de la clase Entidad Empleado.
public class EmpleadoDTO{
	
	//Campos con sus correspondientes validaciones. Nombre y Apellido no pueden ser nulos en los formularios. El ID viene predefinido
	//por el autoincrement de MySql el puesto viene controlado en el formulario por un <select><option>
	private Integer id;
	@NotEmpty
	private String nombre;
	@NotEmpty
	private String apellido;
	private String nombrePuesto;
	private BigDecimal salario;

	//Getters y Setters
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombrePuesto() {
		return nombrePuesto;
	}

	//Cuando Spring llama al set de esta clase, realizo un formateo de Strings para eliminar las barrabajas, que son el tipo de Enum
	public void setNombrePuesto(String nombrePuesto) {
		nombrePuesto = nombrePuesto.replaceAll("_", " ");
		this.nombrePuesto = nombrePuesto;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "EmpleadoDTO [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", nombrePuesto="
				+ nombrePuesto + ", salario=" + salario + "]";
	}
	
}
