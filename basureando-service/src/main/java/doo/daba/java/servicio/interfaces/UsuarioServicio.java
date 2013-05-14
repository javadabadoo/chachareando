package doo.daba.java.servicio.interfaces;

import doo.daba.java.beans.UsuarioBean;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 14/05/13
 */
public interface UsuarioServicio {

    int registraUsuario(UsuarioBean usuario);

    UsuarioBean consultarUsuario(int idUsuario);

    UsuarioBean consultarUsuario(String alias);

    List<String> consultarRoles(int idUsuario);

    int registrarImagenDePerfil(int idUsuario, int idImagen);

}
