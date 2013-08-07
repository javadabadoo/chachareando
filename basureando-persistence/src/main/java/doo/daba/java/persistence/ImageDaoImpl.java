package doo.daba.java.persistence;

import doo.daba.java.beans.Image;
import doo.daba.java.persistence.criterio.Criterion;
import doo.daba.java.persistence.paginator.Page;
import doo.daba.java.persistence.persitenceMapping.ImageObjectMapping;
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
                PropertiesContainer.get("sql.insert.picture"),
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
                PropertiesContainer.get("sql.select.picture"),
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
                PropertiesContainer.get("sql.select.picture.id.byUserProfile"),
                Integer.class,
                userId
        );

        return this.select(idImagenPerfil);
    }

    @Override
    public Page<Image> selectAll(int currentPage, boolean showDetails) {
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
