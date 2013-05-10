package doo.daba.java.persistencia.mapeo;

import doo.daba.java.beans.ImagenBean;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 10/05/13
 */
public class MapeoImagen implements RowMapper <ImagenBean> {
    @Override
    public ImagenBean mapRow(ResultSet rs, int rowNum) throws SQLException {

        ImagenBean imagen = new ImagenBean();

        imagen.setId(rs.getInt("id"));
        imagen.setNombre(rs.getString("nombre"));
        imagen.setComentario(rs.getString("comentario"));
        imagen.setImagen(rs.getBytes("imagen"));

        return imagen;
    }
}
