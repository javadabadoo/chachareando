package doo.daba.java.beans;

import lombok.Getter;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 10/05/13
 * Time: 11:52 AM
 */
public class ImagenBean {

    @Getter @Setter
    int id;

    @Getter @Setter
    String
        nombre,
        comentario;

    @Getter @Setter
    byte[] imagen;
}
