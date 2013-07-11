package doo.daba.java.persistencia;

import doo.daba.java.beans.UserEntry;
import doo.daba.java.persistencia.criterio.Criterion;
import doo.daba.java.persistencia.criterio.EntradaCriterio;
import doo.daba.java.persistencia.criterio.enums.EntradaSearchCriteriaEnum;
import doo.daba.java.persistencia.paginator.Page;
import doo.daba.java.persistencia.persitenceMapping.IntegerListObjectMapping;
import doo.daba.java.persistencia.persitenceMapping.UserEntryObjectMapping;
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
public class UserEntryDaoImpl extends JdbcDaoSupport implements UserEntryDao {

    @Autowired
    private DataSource dataSource;

	public final static int PAGINATION_SIZE = PropertiesContainer.getInt("entries.pagination.size");



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
    public int insert(UserEntry element) {
        int id =  super.getJdbcTemplate().queryForObject(
                PropertiesContainer.get("sql.registro.entrada"),
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
     * @return  Registro de element encapuslado en el objeto {@code UserEntry}
     */
    @Override
    public UserEntry select(int id) {

        return super.getJdbcTemplate().queryForObject(
                PropertiesContainer.get("sql.consulta.entrada"),
                new UserEntryObjectMapping(true),
                id
        );

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
    public List<UserEntry> select(Criterion criterio, boolean showDetails, Object ... params) {

        Criterion cirterio = new EntradaCriterio(EntradaSearchCriteriaEnum.USUARIO);

        return super.getJdbcTemplate().query(
                PropertiesContainer.get("sql.consulta.entrada.historial.usuario", criterio.toString()),
                new UserEntryObjectMapping(showDetails),
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
    public Page<UserEntry> selectAll(int currentPage, boolean showDetails) {

	    Page<UserEntry> userEntriesPage = PersistenceHelper.resolveQueries(
			    PropertiesContainer.get("sql.consulta.entrada.historial"),
			    PropertiesContainer.get("sql.consulta.entrada.historial.count"),
			    super.getJdbcTemplate(),
			    new UserEntryObjectMapping(showDetails),
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
	public Page<UserEntry> selectDayEntries(int currentPage, boolean showDetails, Date date) {

		Page<UserEntry> userEntriesPage = PersistenceHelper.resolveQueries(
				PropertiesContainer.get("sql.consulta.entrada.historial.porDia"),
				PropertiesContainer.get("sql.consulta.entrada.historial.porDia.count"),
				super.getJdbcTemplate(),
				new UserEntryObjectMapping(showDetails),
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

        List<Integer> days = super.getJdbcTemplate().query(PropertiesContainer.get(
                "sql.consulta.entrada.historial.calendario"),
                new IntegerListObjectMapping(),
                date);
        return days;
    }

    @Override
    public int update(UserEntry element) {
        return 0;
    }

    @Override
    public int delete(UserEntry element) {
        return 0;
    }
}
