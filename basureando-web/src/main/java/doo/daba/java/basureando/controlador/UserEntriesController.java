package doo.daba.java.basureando.controlador;

import doo.daba.java.beans.UserEntry;
import doo.daba.java.beans.json.JsonResponse;
import doo.daba.java.persistencia.criterio.Criterion;
import doo.daba.java.servicio.interfaces.UserEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 16/05/13
 */
@Controller
public class UserEntriesController {


	@Autowired
	private UserEntryService userEntryService;



	@RequestMapping(
			value="/consulta/entrada/{page}",
			method = RequestMethod.GET
	)
	public String displayAllEntries(@PathVariable int page, ModelMap model) {

		List<UserEntry> userEntries = this.userEntryService.getAllUserEntries(page, false);

		model.addAttribute("userEntries" , userEntries);

		return "/entries/displayUserEntries";

	}



	@ResponseBody
	@RequestMapping(
			value="/consulta/entrada/{userAlias}/{entryName}/{entryId}",
			method = RequestMethod.GET
	)
	public String displayUserEntry(
			@PathVariable String userAlias,
			@PathVariable String entryName,
			@PathVariable int entryId,
			ModelMap model) {

		model.addAttribute("userEntry", this.userEntryService.getUserEntry(entryId));

		return "";
	}




	@RequestMapping(value="/entries", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		model.addAttribute("mensajito", "Accesando a las: " + new SimpleDateFormat("hh:mm:ss").format(new Date()));

		return "inicio";

	}

}
