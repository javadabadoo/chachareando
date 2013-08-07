package doo.daba.java.persistence;

import doo.daba.java.beans.Image;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 10/05/13
 */
public interface ImageDao extends DaoInterface<Image> {

    Image selectImagenUsuario(int userId);

}
