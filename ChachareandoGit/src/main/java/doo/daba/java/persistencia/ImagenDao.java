package doo.daba.java.persistencia;

import doo.daba.java.beans.ImagenBean;
import doo.daba.java.persistencia.mapeo.MapeoImagen;
import doo.daba.java.util.Propiedades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 10/05/13
 */
@Repository
public class ImagenDao extends JdbcDaoSupport implements ImagenInterfaceDao {

    @Autowired
    private DataSource dataSource;



    @PostConstruct
    void init() {
        setDataSource(dataSource);
    }

    @Override
    public int insert(ImagenBean imagen) {
        int id = super.getJdbcTemplate().queryForInt(
                Propiedades.obtener("sql.registro.imagen"),
                imagen.getNombre(),
                imagen.getComentario(),
                imagen.getImagen()
        );

        imagen.setId(id);

        return id;
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
