package doo.daba.java.persistencia;

import doo.daba.java.beans.UsuarioBean;
import java.util.List;

/**
 *
 * @author Gerardo Aquino
 */
public interface UsuarioInterfaceDao extends DaoInterface<UsuarioBean>{
	
	UsuarioBean select(String alias);
	
	List<String> obtenerListaDeRoles(int idUsuario);

    int registrarImagenPerfil(int idUsuario, int idImagen);
	
}
