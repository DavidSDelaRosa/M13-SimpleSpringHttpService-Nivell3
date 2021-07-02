package es.david.core.models.entities;

import java.math.BigDecimal;

//Clase Enum con todos los valores posibles, a los cuales viene atribuido un salario específico
public enum PuestosEnum {

	Portador_del_Anillo("Portador_del_Anillo", BigDecimal.valueOf(100000.5)),
	Administrador_de_la_llama_de_Anor("Administrador_de_la_llama_de_Anor", BigDecimal.valueOf(80000.75)),
	Posadero_en_Hobbiton("Posadero_en_Hobbiton",BigDecimal.valueOf(10000.5)),
	Istari_Junior("Istari_Junior", BigDecimal.valueOf(18000)),
	Istari_Senior("Istari_Senior", BigDecimal.valueOf(35000)),
	Senescal_de_Gondor("Senescal_de_Gondor", BigDecimal.valueOf(75000.5)),
	Jinete_de_Rohan("Jinete_de_Rohan", BigDecimal.valueOf(25000.5)),
	Lider_de_los_Nueve("Lider_de_los_Nueve", BigDecimal.valueOf(90000.3)),
	Lugarteniente_de_Mordor("Lugarteniente_de_Mordor", BigDecimal.valueOf(65000)),
	Lider_de_los_Istari("Lider_de_los_Istari", BigDecimal.valueOf(80000)),
	Señor_de_Rivendel("Señor_de_Rivendel", BigDecimal.valueOf(57500)),
	Montaraz_a_sueldo("Montaraz_a_sueldo", BigDecimal.valueOf(0));
	
	private String nombrePuesto;
	private BigDecimal salario;
	
	//Constructor
	PuestosEnum(String nombrePuesto, BigDecimal salario){
		this.nombrePuesto = nombrePuesto;
		this.salario = salario;
		
	}

	//Getters y setters
	public String getNombrePuesto() {
		return nombrePuesto;
	}

	public void setNombrePuesto(String nombrePuesto) {
		this.nombrePuesto = nombrePuesto;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	

	
}
