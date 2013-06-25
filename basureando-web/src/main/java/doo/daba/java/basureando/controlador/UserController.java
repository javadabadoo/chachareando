package doo.daba.java.basureando.controlador;

import doo.daba.java.beans.User;
import doo.daba.java.servicio.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 10/05/13
 */
@Controller
public class UserController {

    @Autowired
    UserService usuarioService;




    @ResponseBody
    @RequestMapping(value="/consulta/json/usuario/{alias}", method = RequestMethod.GET)
    public User obtainUserInformation(@PathVariable String alias) {

        User usuario = this.usuarioService.getUserInformation(alias);

        return usuario;

    }



    @ResponseBody
    @RequestMapping(value="/actualizacion/json/usuario/{alias}", method = RequestMethod.GET)
    public User updateUserInformation(@PathVariable String alias) {

        User usuario = this.usuarioService.getUserInformation(alias);

        return usuario;

    }


}
