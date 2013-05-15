package doo.daba.java.basureando.controlador;

import doo.daba.java.beans.ImagenBean;
import doo.daba.java.servicio.interfaces.ImagenServicio;
import doo.daba.java.util.Propiedades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.support.AbstractMultipartHttpServletRequest;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 15/05/13
 */
@Controller
public class ImagenControlador {

    @Autowired
    private ImagenServicio imagenServicio;


    @ResponseBody
    @RequestMapping(
            value="/consulta/imagen/usuario/perfil/{idUsuario}",
            method = RequestMethod.GET,
            produces = "image/png"
    )
    public byte[] consultarImagenDePerfil(@PathVariable int idUsuario) throws IOException {

        byte[] imagenUsuario = null;
        ImagenBean imagen = null;

        try {
            imagen = this.imagenServicio.consultarImagenPerfilUsuario(idUsuario);
            imagenUsuario = imagen.getImagen();
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            URL url = new URL(Propiedades.obtener("usaurio.imagen.default"));
            BufferedImage image = ImageIO.read(url);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write( image, "png", baos );
            baos.flush();
            imagenUsuario = baos.toByteArray();
            baos.close();
        }

        return imagenUsuario;

    }
}
