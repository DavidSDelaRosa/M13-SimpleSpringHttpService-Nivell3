package es.david.core.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.david.core.models.dto.EmpleadoDTO;
import es.david.core.models.services.IEmpleadoService;
import es.david.core.util.MapeadorEmpleados;

@Controller
@RequestMapping("views/empleados")
public class EmpleadoController {

	@Autowired
	private IEmpleadoService emplService;
	
	MapeadorEmpleados mapper = new MapeadorEmpleados();

	@GetMapping("/")
	public String listarEmpleados(Model model) {
		
		List<EmpleadoDTO> listadoEmpleadosDto = emplService.listarEmpleados();
		
		for(EmpleadoDTO emp: listadoEmpleadosDto) {
			emp.toString();
		}
		
		model.addAttribute("titulo", "Lista de Empleados de la Tierra Media");
		model.addAttribute("empleados", listadoEmpleadosDto);
		
		return "/views/empleados/listar";
	}
	
	@GetMapping("/create")
	public String crear(Model model) {
		
		EmpleadoDTO empleadoDto = new EmpleadoDTO();
		
		model.addAttribute("titulo","Formulario: Nuevo empleado de la Tierra Media");
		
		model.addAttribute("empleado", empleadoDto);
		
		return "/views/empleados/formCrear";
	}
	
	@PostMapping("/save")
	public String guardar(@Valid @ModelAttribute EmpleadoDTO empleadoDto, BindingResult result, Model model, RedirectAttributes attribute) {
		
		if(result.hasErrors()) {
			
			model.addAttribute("titulo","Formulario: Nuevo empleado de la Tierra Media");
			
			model.addAttribute("empleado", empleadoDto);
			
			System.out.println("Hubo errores en el formulario");
			
			return "/views/empleados/formCrear";
		}
		
		emplService.guardarEmpleado(empleadoDto);
		System.out.println("CONTROLLER: Empleado con ID " + empleadoDto.getId() +" guardado con exito!");
		
		return "redirect:/views/empleados/";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") Integer id, Model model, RedirectAttributes attribute) {
		
		EmpleadoDTO empleadoDto = null;
		
		if(id>0) {
			empleadoDto = emplService.buscarEmpleadoPorId(id);
			
			if(empleadoDto == null) {
				
				System.err.println("ERROR: El empleado no existe!");
				attribute.addFlashAttribute("error", "ATENCION: El ID del empleado no existe!");//'error' es la palabra que recogerá Thymeleaf en el HTML
				
				return"redirect:/views/empleados/";
			}
		}else {
			System.err.println("ERROR: Error con el ID del empleado");
			attribute.addFlashAttribute("error", "ATENCION: Error con el ID del empleado");

			return"redirect:/views/empleados/";
		}
		
		model.addAttribute("titulo", "Formulario: Editar Empleado");
		model.addAttribute("empleado", empleadoDto);
		
		return "/views/empleados/formCrear";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes attribute) {
		
	EmpleadoDTO empleadoDto = null;
		
		if(id>0) {
			empleadoDto = emplService.buscarEmpleadoPorId(id);
			
			if(empleadoDto == null) {
				
				System.err.println("ERROR: El empleado no existe!");
				attribute.addFlashAttribute("error", "ATENCION: El ID del empleado no existe!");

				return"redirect:/views/empleados/";
			}
		}else {
			System.err.println("ERROR: Error con el ID del empleado");
			attribute.addFlashAttribute("error", "ATENCION: Error con el ID del empleado");

			return"redirect:/views/empleados/";
		}
		
		emplService.eliminarEmpleadoPorId(id);
		System.out.println("Registro eliminado con exito!");
		attribute.addFlashAttribute("warning", "Registro eliminado con exito!");

		
		return "redirect:/views/empleados/";
	}
	
	@GetMapping("/buscar/{id}")
	public String buscarPorId(Model model, Integer id, RedirectAttributes attribute) {
		
		model.addAttribute("empleados", emplService.buscarEmpleadoPorId(id));
		
		if(emplService.buscarEmpleadoPorId(id) == null) { 
			List<EmpleadoDTO> listadoEmpleadosDto = emplService.listarEmpleados();
			model.addAttribute("titulo", "Lista de Empleados de la Tierra Media");
			model.addAttribute("empleados", listadoEmpleadosDto);
			attribute.addFlashAttribute("warning", "ATENCION: Empleado no encontrado");
			return "/views/empleados/listar";
		}
		
		return "/views/empleados/listar";
	}
	
	@GetMapping("/buscar_por_sueldo/{sueldo}")
	public String buscarPorSueldo(Model model, String sueldo) {
		
		System.out.println("Filtrando por sueldo...");
		
		if((sueldo.isEmpty() || sueldo.isBlank()) || Double.valueOf(sueldo)==null || Double.valueOf(sueldo)<0)  {
			System.err.println("El sueldo introducido es inválido...");

			return"redirect:/views/empleados/";
		}
		
		BigDecimal sueldoBD = BigDecimal.valueOf(Double.valueOf(sueldo));
		System.out.println("Filtrar por sueldo: " + sueldoBD);
		
		model.addAttribute("empleados", emplService.filtrarPorSueldo(sueldoBD));
		
		return "/views/empleados/listar";
	}
	
	@GetMapping("/buscar_por_puesto")
	public String buscarPorPuesto(Model model, String puesto) {
		
		System.err.println("Buscando por puesto: " + puesto);
		
		List<EmpleadoDTO> resultBusqueda = null;
		
		if(puesto==null) {
			System.err.println("AQUI");
			resultBusqueda = emplService.listarEmpleados();
			model.addAttribute("titulo", "Lista de Empleados de la Tierra Media");
			model.addAttribute("empleados", resultBusqueda);
			
			return "/views/empleados/listar";
		}
		
		List<EmpleadoDTO> resulBusqueda = emplService.buscarEmpleadosPorPuesto(puesto);
		System.err.println("Buscando por: " + puesto);
		model.addAttribute("titulo", "Lista FILTRADA de Empleados de la Tierra Media");
		model.addAttribute("empleados", resulBusqueda);
		
		
		
		return "/views/empleados/listar";
	}
}
