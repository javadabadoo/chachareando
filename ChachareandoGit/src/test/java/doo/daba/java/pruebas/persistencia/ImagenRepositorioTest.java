package doo.daba.java.pruebas.persistencia;

import doo.daba.java.beans.Image;
import doo.daba.java.beans.User;
import doo.daba.java.persistencia.ImageDao;
import doo.daba.java.persistencia.UserDao;
import doo.daba.java.util.io.FileIO;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 13/05/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:chachareando-context.xml"
})
public class ImagenRepositorioTest {


    private Image imagen;

    private User usuario;

    @Autowired
    private ImageDao imageDao;

    @Autowired
    private UserDao userDao;

    private final File archivoImagenRegistro =  new File("C:/imagen.png");
    private final File archivoImagenConsulta =  new File("C:/imagen.png");


    @Before
    public void init() throws IOException {

        this.imagen = new Image();

        this.imagen.setName("prueba.png");
        this.imagen.setComment("Esta es la imagen de la prueba generada en: " + new Date());
        this.imagen.setByteContent(this.cargaImagen());

        this.usuario = this.userDao.select("javadabadoo");

    }


    @Test
    public void registrarImagen() {
        assert this.imageDao.insert(this.imagen) > 0;
        assert this.userDao.linkUserProfilePicture(this.usuario.getId(), this.imagen.getId()) == 1;
    }


    @Test (expected = DataIntegrityViolationException.class)
    public void registroDeImagenPerfilInvalido() {
        this.userDao.linkUserProfilePicture(0, 0);
    }


    @Test
    public void consultaImagen() {
        Image imagenConsulta = this.imageDao.selectImagenUsuario(this.usuario.getId());
        assert Arrays.equals(this.imagen.getByteContent(), imagenConsulta.getByteContent());
    }


    private byte[] cargaImagen() throws IOException {
        return FileIO.readBytes(this.archivoImagenRegistro);
    }

}
