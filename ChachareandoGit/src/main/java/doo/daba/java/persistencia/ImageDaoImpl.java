package doo.daba.java.persistencia;

import doo.daba.java.beans.Image;
import doo.daba.java.persistencia.criterio.Criterion;
import doo.daba.java.persistencia.persitenceMapping.ImageObjectMapping;
import doo.daba.java.util.PropertiesContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
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
public class ImageDaoImpl extends JdbcDaoSupport implements ImageDao {

    @Autowired
    private DataSource dataSource;



    @PostConstruct
    void init() {
        super.setDataSource(this.dataSource);
    }

    @Override
    public int insert(Image element) {
        int id = super.getJdbcTemplate().queryForObject(
                PropertiesContainer.get("sql.registro.imagen"),
                Integer.class,
                element.getName(),
                element.getComment(),
                element.getByteContent()
        );

        element.setId(id);

        return id;
    }

    @Override
    public Image select(int id) {
        return super.getJdbcTemplate().queryForObject(
                PropertiesContainer.get("sql.consulta.imagen"),
                new ImageObjectMapping(),
                id
        );
    }

    @Override
    public List<Image> select(Criterion criterion, boolean showDetails, Object ... params) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Image selectImagenUsuario(int userId) {
        int idImagenPerfil = super.getJdbcTemplate().queryForObject(
                PropertiesContainer.get("sql.consulta.id.imagen.perfilUsuario"),
                Integer.class,
                userId
        );

        return this.select(idImagenPerfil);
    }

    @Override
    public List<Image> selectAll(boolean showDetails) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int update(Image element) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int delete(Image element) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
