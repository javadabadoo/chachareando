package doo.daba.java.pruebas.persistencia;

import doo.daba.java.beans.ImagenBean;
import doo.daba.java.beans.UsuarioBean;
import doo.daba.java.persistencia.ImagenInterfaceDao;
import doo.daba.java.persistencia.UsuarioInterfaceDao;
import doo.daba.java.util.io.FileIO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ImagenRepositorioTest {


    private ImagenBean imagen;

    @Autowired
    private ImagenInterfaceDao imagenDao;

    @Autowired
    private UsuarioInterfaceDao usuarioDao;

    private final File archivoImagenRegistro =  new File("C:/imagen.png");
    private final File archivoImagenConsulta =  new File("C:/imagen.png");


    @Before
    public void init() throws IOException {

        this.imagen = new ImagenBean();

        this.imagen.setNombre("prueba.png");
        this.imagen.setComentario("Esta es la imagen de la prueba generada en: " + new Date());
        this.imagen.setImagen(this.cargaImagen());

    }


    @Test
    public void registrarImagen() {
        UsuarioBean usuario = this.usuarioDao.select("javadabadoo");
        assert this.imagenDao.insert(this.imagen) == 1;
        assert this.usuarioDao.registrarImagenPerfil(usuario.getId(), this.imagen.getId()) == 1;

    }


    @Test
    public void consultaImagen() {
        this.imagenDao.selectImagenUsuario(imagen.getId());
    }


    private byte[] cargaImagen() throws IOException {
        return FileIO.readBytes(this.archivoImagenRegistro);
    }

}
