package doo.daba.java.basureando.controlador;

import doo.daba.java.beans.EntradaBean;
import doo.daba.java.beans.json.RespuestaJson;
import doo.daba.java.servicio.interfaces.EntradaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 16/05/13
 */
@Controller
public class EntradaControlador {


	@Autowired
	private EntradaServicio entradaServicio;

	private Random r = new Random();



	@ResponseBody
	@RequestMapping(
			value="/consulta/entrada/{idEntrada}/{alias}",
			method = RequestMethod.GET
	)
	public EntradaBean consultaEntrada(@PathVariable int idEntrada, @PathVariable String alias) {

		return this.entradaServicio.consultarEntrada(idEntrada);

	}



	@ResponseBody
	@RequestMapping(
			value="/consulta/entrada",
			method = RequestMethod.GET
	)
	public RespuestaJson<List<EntradaBean>> consultaEntradas(@RequestParam String sSearch) {
		RespuestaJson<List<EntradaBean>> respuesta = new RespuestaJson<List<EntradaBean>>();

		respuesta.setAaData(this.entradaServicio.consultarEntradas(String.format("%%%s%%", sSearch), false));
		respuesta.setITotalDisplayRecords(r.nextInt(100));
		respuesta.setITotalRecords(r.nextInt(100));

		return respuesta;
	}

}
