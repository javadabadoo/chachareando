package doo.daba.java.ejb;

import doo.daba.java.beans.UsuarioBean;
import doo.daba.java.persistencia.UsuarioInterfaceDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ejb.Local;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 14/05/13
 */
@Local
public interface UsuarioServicioInterface {

    int registraUsuario (UsuarioBean usuario);

}
