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
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 15/05/13
 */
@Controller
public class ImageControlador {

    @Autowired
    private ImageService imageService;


    @ResponseBody
    @RequestMapping(
            value="/consulta/imagen/usuario/perfil/{width}/{height}/{idUsuario}",
            method = RequestMethod.GET,
            produces = "image/png"
    )
    public byte[] consultarImagenDePerfil(@PathVariable int idUsuario,
                                          @PathVariable int width,
                                          @PathVariable int height,
                                          HttpServletRequest request,
                                          HttpServletResponse response) {

        byte[] imagenUsuario = null;
        BufferedImage image = null;

        try {
            Image imagen = this.imageService.queryUserProfileImage(idUsuario);
            imagenUsuario = imagen.getByteContent();
            image = this.resizeImage(ImageIO.read(new ByteArrayInputStream(imagen.getByteContent())), width, height);
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
                image = this.resizeImage(ImageIO.read(url), width, height);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            imagenUsuario = this.createByteImage(image);
        } catch (IOException ioe){
            ioe.printStackTrace();
        }


        return imagenUsuario;

    }


    private byte[] createByteImage(BufferedImage image) throws IOException {
        byte[] byteImage = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        baos.flush();
        byteImage = baos.toByteArray();
        baos.close();

        return byteImage;
    }


    private BufferedImage resizeImage(BufferedImage image, int width, int height){
        BufferedImage resizedImage = new BufferedImage(width, height, image.getType());
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(image, 0, 0, width, height, null);
        g.setComposite(AlphaComposite.Src);

        g.setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        g.setRenderingHint(
                RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g.dispose();

        return resizedImage;
    }
}
