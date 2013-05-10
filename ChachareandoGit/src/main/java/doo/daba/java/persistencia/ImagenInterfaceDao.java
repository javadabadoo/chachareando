package doo.daba.java.persistencia;

import doo.daba.java.beans.ImagenBean;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 10/05/13
 */
public interface ImagenInterfaceDao extends DaoInterface<ImagenBean> {

    ImagenBean selectImagenUsuario(int idUsuario);

}
