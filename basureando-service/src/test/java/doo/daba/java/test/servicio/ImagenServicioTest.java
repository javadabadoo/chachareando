package doo.daba.java.test.servicio;

import doo.daba.java.beans.Image;
import doo.daba.java.beans.User;
import doo.daba.java.persistence.ImageDao;
import doo.daba.java.persistence.UserDao;
import doo.daba.java.util.io.FileIO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 14/05/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:chachareando-context.xml"
})
@Transactional
public class ImagenServicioTest {

    private Image imagen;
    private User usuario;

    @Autowired
    private ImageDao imagenDao;

    @Autowired
    private UserDao usuarioDao;

    private final File registryPicture =  new File("C:/imagen.png");
    private final File queryPicture =  new File("C:/imagen.png");


    @Before
    public void init() throws IOException {

        this.imagen = new Image();
        this.usuario = new User();

        this.imagen.setName("prueba.png");
        this.imagen.setComment("Esta es la imagen de la prueba generada en: " + new Date());
        this.imagen.setByteContent(this.loadPictureFile());

        this.usuario = this.usuarioDao.select("javadabadoo");

    }


    @Test
    public void registrarImagen() {
        assert this.imagenDao.insert(this.imagen) > 0;
        assert this.usuarioDao.linkUserProfilePicture(this.usuario.getId(), this.imagen.getId()) == 1;
    }


    @Test(expected = EmptyResultDataAccessException.class)
    public void consultaImagenNoVinculada() {
        this.imagenDao.selectImagenUsuario(0);
    }


    @Test
    public void consultaImagen() {
        this.registrarImagen();
        Image imagen = this.imagenDao.selectImagenUsuario(this.usuario.getId());
        assert Arrays.equals(this.imagen.getByteContent(), imagen.getByteContent());
    }


    private byte[] loadPictureFile() throws IOException {
        return FileIO.readBytes(this.registryPicture);
    }

}
