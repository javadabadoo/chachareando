package doo.daba.java.persistencia;

import doo.daba.java.beans.ImagenBean;
import doo.daba.java.persistencia.mapeo.MapeoImagen;
import doo.daba.java.util.Propiedades;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 10/05/13
 */
public class ImagenDao extends JdbcDaoSupport implements ImagenInterfaceDao {

    @Override
    public int insert(ImagenBean imagen) {
        return super.getJdbcTemplate().update(
                Propiedades.obtener("sql.registro.imagen"),
                imagen.getNombre(),
                imagen.getComentario(),
                imagen.getImagen()
        );
    }

    @Override
    public ImagenBean select(int id) {
        return super.getJdbcTemplate().queryForObject(
                Propiedades.obtener("sql.consulta.imagen"),
                new MapeoImagen(),
                id
        );
    }

    @Override
    public List<ImagenBean> select(Object criterio, boolean mostrarDetalle) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ImagenBean selectImagenUsuario(int idUsuario) {
        int idImagenPerfil = super.getJdbcTemplate().queryForInt(
                Propiedades.obtener("sql.consulta.id.imagen.perfilUsuario"),
                idUsuario
        );

        return this.select(idImagenPerfil);
    }

    @Override
    public List<ImagenBean> selectAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int update(ImagenBean elemento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int delete(ImagenBean elemento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
