package doo.daba.java.basureando.controlador;

import doo.daba.java.beans.UsuarioBean;
import doo.daba.java.persistencia.UsuarioInterfaceDao;
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
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class UsuarioControlador {

    @Autowired
    UsuarioInterfaceDao usuarioDao;




    @RequestMapping(value="/consulta/json/usuario/{alias}", method = RequestMethod.GET)
    public @ResponseBody
    UsuarioBean consultaInformacionDeUsuario(@PathVariable String alias) {

        UsuarioBean usuario = this.usuarioDao.select(alias);

        return usuario;

    }



    @RequestMapping(value="/actualizacion/json/usuario/{alias}", method = RequestMethod.GET)
    public @ResponseBody
    UsuarioBean ActualizaInformacionDeUsuario(@PathVariable String alias) {

        UsuarioBean usuario = this.usuarioDao.select(alias);

        return usuario;

    }


}
