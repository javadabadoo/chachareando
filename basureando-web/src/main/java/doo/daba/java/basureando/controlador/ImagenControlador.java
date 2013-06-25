package doo.daba.java.basureando.controlador;

import doo.daba.java.beans.Image;
import doo.daba.java.servicio.interfaces.ImageService;
import doo.daba.java.util.PropertiesContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    private ImageService imageService;


    @ResponseBody
    @RequestMapping(
            value="/consulta/imagen/usuario/perfil/{idUsuario}",
            method = RequestMethod.GET,
            produces = "image/png"
    )
    public byte[] consultarImagenDePerfil(@PathVariable int idUsuario,
                                          HttpServletRequest request,
                                          HttpServletResponse response) {

        byte[] imagenUsuario = null;
        Image imagen = null;

        //TODO Mejorar la carga de imagenes, no me gusta como se obtiene
        try {
            imagen = this.imageService.queryUserProfileImage(idUsuario);
            imagenUsuario = imagen.getByteContent();
        } catch (EmptyResultDataAccessException e) {
            try {
                URL url = new URL(
                        String.format(
                                "%s://%s:%s/%s/%s",
                                request.getScheme(),
                                request.getServerName(),
                                request.getServerPort(),
                                request.getContextPath(),
                                PropertiesContainer.get("usaurio.imagen.default")));
                BufferedImage image = ImageIO.read(url);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write( image, "png", baos );
                baos.flush();
                imagenUsuario = baos.toByteArray();
                baos.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

        return imagenUsuario;

    }
}
