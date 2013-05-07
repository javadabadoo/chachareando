package doo.daba.java.basureando.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/consulta")
public class ConsultaControlador {

	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String consultarUsuarios(ModelMap model) {

		model.addAttribute("mensajito", "Aqui va el resoultado de la consulta");
		
		return "inicio";

	}
}
