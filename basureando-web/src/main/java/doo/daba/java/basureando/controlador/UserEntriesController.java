package doo.daba.java.basureando.controlador;

import doo.daba.java.beans.UserEntry;
import doo.daba.java.beans.json.JsonResponse;
import doo.daba.java.persistencia.criterio.Criterion;
import doo.daba.java.persistencia.paginator.Page;
import doo.daba.java.servicio.interfaces.UserEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

		page = page < 0 ? 0 : page;

		Page<UserEntry> userEntryPage = this.userEntryService.getAllUserEntries(page, false);

		model.addAttribute("userEntryPage" , userEntryPage);
		model.addAttribute("page", page);

		return "index";

	}



	@RequestMapping(
			value="/consulta/entrada/{userAlias}/{entryName}/{entryId}",
			method = RequestMethod.GET
	)
	public String displayUserEntry(
			@PathVariable String userAlias,
			@PathVariable String entryName,
			@PathVariable int entryId,
			ModelMap model) {

        List<UserEntry> userEntries = new ArrayList<UserEntry>();
        userEntries.add(this.userEntryService.getUserEntry(entryId));
        model.addAttribute("userEntries", userEntries);

		return "index";
	}




	@RequestMapping(value="/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		return this.displayAllEntries(0, model);

	}

}
