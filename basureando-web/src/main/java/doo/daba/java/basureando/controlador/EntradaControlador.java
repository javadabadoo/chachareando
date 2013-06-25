package doo.daba.java.basureando.controlador;

import doo.daba.java.beans.UserEntry;
import doo.daba.java.beans.json.JsonResponse;
import doo.daba.java.servicio.interfaces.UserEntryService;
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
	private UserEntryService userEntryService;

	private Random r = new Random();



	@ResponseBody
	@RequestMapping(
			value="/consulta/entrada/{idEntrada}/{alias}",
			method = RequestMethod.GET
	)
	public UserEntry consultaEntrada(@PathVariable int idEntrada, @PathVariable String alias) {

		return this.userEntryService.getUserEntry(idEntrada);

	}



	@ResponseBody
	@RequestMapping(
			value="/consulta/entrada",
			method = RequestMethod.GET
	)
	public JsonResponse<List<UserEntry>> consultaEntradas(@RequestParam String sSearch) {
		JsonResponse<List<UserEntry>> respuesta = new JsonResponse<List<UserEntry>>();

		respuesta.setAaData(this.userEntryService.getUserEntries(String.format("%%%s%%", sSearch), false));
		respuesta.setITotalDisplayRecords(r.nextInt(100));
		respuesta.setITotalRecords(r.nextInt(100));

		return respuesta;
	}

}
