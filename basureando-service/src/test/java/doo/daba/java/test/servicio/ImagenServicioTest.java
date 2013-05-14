package doo.daba.java.test.servicio;

import doo.daba.java.beans.ImagenBean;
import doo.daba.java.beans.UsuarioBean;
import doo.daba.java.persistencia.ImagenInterfaceDao;
import doo.daba.java.persistencia.UsuarioInterfaceDao;
import doo.daba.java.servicio.interfaces.ImagenServicio;
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

    private ImagenBean imagen;
    private UsuarioBean usuario;

    @Autowired
    private ImagenInterfaceDao imagenDao;

    @Autowired
    private UsuarioInterfaceDao usuarioDao;

    private final File archivoImagenRegistro =  new File("C:/imagen.png");
    private final File archivoImagenConsulta =  new File("C:/imagen.png");


    @Before
    public void init() throws IOException {

        this.imagen = new ImagenBean();
        this.usuario = new UsuarioBean();

        this.imagen.setNombre("prueba.png");
        this.imagen.setComentario("Esta es la imagen de la prueba generada en: " + new Date());
        this.imagen.setImagen(this.cargaImagen());

        this.usuario = this.usuarioDao.select("javadabadoo");

    }


    @Test
    public void registrarImagen() {
        assert this.imagenDao.insert(this.imagen) > 0;
        assert this.usuarioDao.registrarImagenPerfil(this.usuario.getId(), this.imagen.getId()) == 1;
    }


    @Test(expected = EmptyResultDataAccessException.class)
    public void consultaImagenNoVinculada() {
        this.imagenDao.selectImagenUsuario(0);
    }


    @Test
    public void consultaImagen() {
        this.registrarImagen();
        ImagenBean imagen = this.imagenDao.selectImagenUsuario(this.usuario.getId());
        assert Arrays.equals(this.imagen.getImagen(), imagen.getImagen());
    }


    private byte[] cargaImagen() throws IOException {
        return FileIO.readBytes(this.archivoImagenRegistro);
    }

}
