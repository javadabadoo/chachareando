package doo.daba.java.servicio.interfaces;

import doo.daba.java.beans.Image;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 14/05/13
 */
public interface ImageService {

    int saveImage(Image image);

    Image queryImage(int imageId);

    Image queryUserProfileImage(int userId);

}
