package doo.daba.java.basureando.controlador;

import doo.daba.java.beans.EntradaBean;
import doo.daba.java.persistencia.EntradaInterfaceDao;
import doo.daba.java.servicio.interfaces.EntradaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 16/05/13
 */
@Controller
public class EntradaControlador {


    @Autowired
    private EntradaServicio entradaServicio;



    @ResponseBody
    @RequestMapping(
            value="/consulta/entrada/{idEntrada}/{alias}",
            method = RequestMethod.GET
    )
    public EntradaBean consultaEntrada(@PathVariable int idEntrada, @PathVariable String alias) {

        return this.entradaServicio.consultarEntrada(idEntrada);

    }

}
