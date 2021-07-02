package es.david.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	//Metodo para acceder a nuestro HTML "home" por la rutas "/, /index o /home"
	
	@GetMapping({"/index", "/home", "/"})
	public String index() {
		return "home";
	}

}
