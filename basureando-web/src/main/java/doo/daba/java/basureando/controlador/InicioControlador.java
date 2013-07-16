package doo.daba.java.basureando.controlador;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class InicioControlador {

    @RequestMapping(value="/inicio", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

        model.addAttribute("mensajito", "Accesando a las: " + new SimpleDateFormat("hh:mm:ss").format(new Date()));

        return "forward:/";

    }

}