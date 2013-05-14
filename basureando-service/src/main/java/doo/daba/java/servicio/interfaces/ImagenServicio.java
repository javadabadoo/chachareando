package doo.daba.java.servicio.interfaces;

import doo.daba.java.beans.ImagenBean;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 14/05/13
 */
public interface ImagenServicio {

    int registrarImagen(ImagenBean imagen);

    ImagenBean consultarImagen(int idImagen);

    ImagenBean consultarImagenPerfilUsuario(int idUsuario);

}
