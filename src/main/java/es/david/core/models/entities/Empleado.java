package es.david.core.models.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

//Clase Entity que representa a la Tabla en la Base de Datos

@Entity
@Table(name="empleados")
public class Empleado {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String apellido;	
	@Enumerated(EnumType.STRING)	//Aquí especifico a Spring que se trata de un Enum de tipo Strings
	private PuestosEnum puesto;
	private BigDecimal salario;
	

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
	
	public PuestosEnum getPuesto() {
		return puesto;
	}

	public void setPuesto(PuestosEnum puesto) {
		this.puesto = puesto;
	}

	
	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", puesto=" + puesto
				+ ", salario=" + salario + "]";
	}

	
	
}
