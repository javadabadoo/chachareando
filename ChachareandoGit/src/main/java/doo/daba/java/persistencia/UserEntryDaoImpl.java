package doo.daba.java.persistencia;

import doo.daba.java.beans.UserEntry;
import doo.daba.java.persistencia.criterio.Criterion;
import doo.daba.java.persistencia.criterio.EntradaCriterio;
import doo.daba.java.persistencia.criterio.enums.EntradaSearchCriteriaEnum;
import doo.daba.java.persistencia.persitenceMapping.UserEntryObjectMapping;
import doo.daba.java.util.PropertiesContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
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

	@Override
	public List<UserEntry> selectAll(boolean showDetails) {
		return this.selectAll(1, showDetails);
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
    public List<UserEntry> selectAll(int startPage, boolean showDetails) {

        return super.getJdbcTemplate().query(
                PropertiesContainer.get("sql.consulta.entrada.historial"),
                new UserEntryObjectMapping(showDetails));
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
