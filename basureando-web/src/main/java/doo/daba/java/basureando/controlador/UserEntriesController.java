package doo.daba.java.basureando.controlador;

import doo.daba.java.beans.DaysOfMonthEntries;
import doo.daba.java.beans.UserEntry;
import doo.daba.java.beans.json.JsonResponse;
import doo.daba.java.persistencia.criterio.Criterion;
import doo.daba.java.persistencia.paginator.Page;
import doo.daba.java.servicio.interfaces.UserEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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
    private SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");



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

        Page<UserEntry> userEntryPage = new Page<UserEntry>();
        List<UserEntry> userEntries = new ArrayList<UserEntry>();
        userEntries.add(this.userEntryService.getUserEntry(entryId));
        userEntryPage.setItems(userEntries);

        model.addAttribute("userEntryPage", userEntryPage);
        
		return "index";
	}




	@RequestMapping(value="/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		return this.displayAllEntries(0, model);

	}



    @ResponseBody
    @RequestMapping(value="/consult/calendar/{year}/{month}", method = RequestMethod.GET)
    public DaysOfMonthEntries getPostedDaysList(@PathVariable int year, @PathVariable int month) {
        DaysOfMonthEntries daysOfMonthEntries = null;
        List<Integer> activeDays = null;
        Date dateToEval = null;
        int lastDayOfMonth = 0;

        try {
            dateToEval = this.dateFormatter.parse(String.format("%04d-%02d-%02d", year, month, 1));
        } catch (ParseException e) {
            return new DaysOfMonthEntries(true, "El formato de fecha es incorrecto");
        }

        daysOfMonthEntries = new DaysOfMonthEntries();
        lastDayOfMonth = this.userEntryService.getLastDayOfMonth(dateToEval);
        activeDays = this.userEntryService.getWhichDaysHasEntries(dateToEval);

        for(int day = 1; day <= lastDayOfMonth; day++) {
            daysOfMonthEntries.addMonth(day, activeDays.contains(day));
        }

        return daysOfMonthEntries;
    }

}
