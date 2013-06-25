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

import java.io.IOException;
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
@Ignore
public class ImagenRepositorioTest {


    private Image imagen;

    @Autowired
    private ImageDao imagenDao;

    @Autowired
    private UserDao usuarioDao;

    private final File archivoImagenRegistro =  new File("C:/imagen.png");
    private final File archivoImagenConsulta =  new File("C:/imagen.png");


    @Before
    public void init() throws IOException {

        this.imagen = new Image();

        this.imagen.setName("prueba.png");
        this.imagen.setComment("Esta es la imagen de la prueba generada en: " + new Date());
        this.imagen.setByteContent(this.cargaImagen());

    }


    @Test
    public void registrarImagen() {
        User usuario = this.usuarioDao.select("javadabadoo");
        assert this.imagenDao.insert(this.imagen) > 0;
        assert this.usuarioDao.linkUserProfilePicture(usuario.getId(), this.imagen.getId()) == 1;
    }


    @Test (expected = DataIntegrityViolationException.class)
    public void registroDeImagenPerfilInvalido() {
        this.usuarioDao.linkUserProfilePicture(0, 0);
    }


    @Test
    public void consultaImagen() {
        Image imagenConsulta = this.imagenDao.selectImagenUsuario(imagen.getId());
        assert this.imagen.getByteContent().equals(imagenConsulta.getByteContent());
    }


    private byte[] cargaImagen() throws IOException {
        return FileIO.readBytes(this.archivoImagenRegistro);
    }

}
