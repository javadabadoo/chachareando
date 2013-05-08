package doo.daba.java.basureando.controlador;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import doo.daba.java.beans.UsuarioBean;
import doo.daba.java.persistencia.UsuarioInterfaceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class InicioControlador {

    @Autowired
    UsuarioInterfaceDao usuarioDao;

    @RequestMapping(value="/inicio", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

        model.addAttribute("mensajito", "Accesando a las: " + new SimpleDateFormat("hh:mm:ss").format(new Date()));

        return "inicio";

    }



    @RequestMapping(value="/consulta/json/usuario/{alias}", method = RequestMethod.GET)
    public @ResponseBody
    UsuarioBean consultaInformacionDeUsuario(@PathVariable String alias) {

        UsuarioBean usuario = this.usuarioDao.select(alias);

        return usuario;

    }

}