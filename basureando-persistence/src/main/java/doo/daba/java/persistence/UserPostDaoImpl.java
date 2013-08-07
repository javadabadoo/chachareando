package doo.daba.java.persistence;

import doo.daba.java.beans.TagsJsonResponse;
import doo.daba.java.beans.UserPost;
import doo.daba.java.persistence.criterio.Criterion;
import doo.daba.java.persistence.paginator.Page;
import doo.daba.java.persistence.persitenceMapping.IntegerListObjectMapping;
import doo.daba.java.persistence.persitenceMapping.RecentPostObjectMapping;
import doo.daba.java.persistence.persitenceMapping.TagObjectMapping;
import doo.daba.java.persistence.persitenceMapping.UserPostObjectMapping;
import doo.daba.java.util.PropertiesContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: java_daba_doo
 * Date: 4/6/13
 */
@Repository
public class UserPostDaoImpl extends JdbcDaoSupport implements UserPostDao {

    @Autowired
    private DataSource dataSource;

	public final static int PAGINATION_SIZE = PropertiesContainer.getInt("post.pagination.size");



    @PostConstruct
    void init() {
        super.setDataSource(this.dataSource);
    }


    /**
     * Registra una publicación al repositorio de datos
     *
     * @param element   Encapsula la información del registro de element
     *
     * @return  ID generado por el registro
     */
    @Override
    public int insert(UserPost element) {
        int id =  super.getJdbcTemplate().queryForObject(
                PropertiesContainer.get("sql.insert.post"),
                Integer.class,
                element.getTitle(),
                element.getPublicationDate(),
                element.getModificacionDate(),
                element.getStatus(),
                element.getContent(),
                element.getUser().getId()
        );

        element.setId(id);
        return id;
    }


    /**
     * Obtiene un registro de element segun el ID indicado en el parámetro
     *
     * @param id   IDentificador del registro
     *
     * @return  Registro de element encapuslado en el objeto {@code UserPost}
     */
    @Override
    public UserPost select(int id) {

        UserPost post = super.getJdbcTemplate().queryForObject(
                PropertiesContainer.get("sql.select.post"),
                new UserPostObjectMapping(true),
                id
        );

        return post;

    }


    /**
     * Obtiene todas las entradas del usuario del cual su identificador en la DB sea
     * el definido en el parametro {@code idUsuario}
     *
     * @param criterio          Define los criterios de búsqueda predefinidos para realizar la consulta
     * @param showDetails    Indica si debe mostrarse la información completa del
     *                          registro de element o solo se muestra el resumen
     *@param params         Parametros de consulta
     *
     * @return  Lista de entradas asociadas al usuario
     */
    @Override
    public List<UserPost> select(Criterion criterio, boolean showDetails, Object ... params) {

        return super.getJdbcTemplate().query(
                PropertiesContainer.get("sql.select.post.history.user", criterio.toString()),
                new UserPostObjectMapping(showDetails),
                params);

    }


	/**
     * Obtiene todas las entradas registradas de todos los usuarios
     *
     * @param showDetails    Indica si debe mostrarse la información completa del
     *                          registro de element o solo se muestra el resumen
     *
     * @return  Lista de entradas
     */
    @Override
    public Page<UserPost> selectAll(int currentPage, boolean showDetails) {

	    Page<UserPost> userEntriesPage = PersistenceHelper.resolveQueries(
			    PropertiesContainer.get("sql.select.post.history"),
			    PropertiesContainer.get("sql.select.post.history.count"),
			    super.getJdbcTemplate(),
			    new UserPostObjectMapping(showDetails),
			    new Object[] {
					    PAGINATION_SIZE,
					    currentPage
			    },
			    null
	    );

        return userEntriesPage;
    }


	/**
	 * Obtiene las publicacioones de un día utilizando la paginación
	 *
	 * @param currentPage   Número de la página actual que se está consultando
	 * @param showDetails   Indica si deben mostrarse los detalles completos de la consulta. Utilizada
	 *                      para determinar si debe mostrarse el contenido completo de la publicación
	 * @param date          Fecha de la cual se obtienen las publicaciones
	 *
	 * @return  Encapsula la información de la consulta junto con los datos informativos útiles para paginación
	 */
	@Override
	public Page<UserPost> selectDayEntries(int currentPage, boolean showDetails, Date date) {

		Page<UserPost> userEntriesPage = PersistenceHelper.resolveQueries(
				PropertiesContainer.get("sql.select.post.history.byDate"),
				PropertiesContainer.get("sql.select.post.history.byDate.count"),
				super.getJdbcTemplate(),
				new UserPostObjectMapping(showDetails),
				new Object[] {
						date,
						PAGINATION_SIZE,
						currentPage
				},
				new Object[] {
						date
				}
		);


		return userEntriesPage;
	}


    /**
     * Busca qué dias de un més tienen publicaciones
     *
     * @param date    Indica la fecha en al que se buscan publicaciones, unicamente
     *                      se considera el més y el año
     *
     * @return  Dias en los que se han realizado publicaciones
     */
    @Override
    public List<Integer> selectWhichDaysHasEntries(Date date) {

        List<Integer> days = super.getJdbcTemplate().query(
                PropertiesContainer.get("sql.select.post.history.byCalendar"),
                new IntegerListObjectMapping(),
                date);
        return days;
    }


    /**
     * @return  Lista de las entradas recientes, esta consulta retorna únicamente
     *          el id y titulo de la entrada ademas del alias del usuario.
     */
    @Override
    public List<UserPost> selectRecentEntries() {
        return super.getJdbcTemplate().query(
                PropertiesContainer.get("sql.select.post.recents"),
                new RecentPostObjectMapping(),
                PropertiesContainer.getInt("post.recent.listSize")
        );
    }



	@Override
	public List<UserPost> selectPostComments(int idPost) {
		return super.getJdbcTemplate().query(
				PropertiesContainer.get("sql.select.post.comments"),
				new UserPostObjectMapping(true),
				idPost
		);
	}

    @Override
    public List<TagsJsonResponse> selectPostTags(int idPost) {
        return super.getJdbcTemplate().query(
            PropertiesContainer.get("sql.tag.relatedToPost"),
            new TagObjectMapping(),
            idPost
        );
    }

    @Override
    public boolean isPostOwner(int idPost, int idUser) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int update(UserPost element) {
        return 0;
    }

    @Override
    public int delete(UserPost element) {
        return 0;
    }
}
