package doo.daba.java.servicio;

import doo.daba.java.beans.Image;
import doo.daba.java.persistence.ImageDao;
import doo.daba.java.servicio.interfaces.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 14/05/13
 */
@Service
@Transactional
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageDao imageDao;



    @Override
    public int saveImage(Image image) {
        return this.imageDao.insert(image);
    }



    @Override
    public Image queryImage(int imageId) {
        return this.imageDao.select(imageId);
    }



    @Override
    public Image queryUserProfileImage(int userId) {
        return this.imageDao.selectImagenUsuario(userId);
    }
}
