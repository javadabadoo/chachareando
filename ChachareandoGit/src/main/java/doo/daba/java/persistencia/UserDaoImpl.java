package doo.daba.java.persistencia;


import doo.daba.java.beans.User;
import doo.daba.java.persistencia.criterio.Criterion;
import doo.daba.java.persistencia.persitenceMapping.UserObjectMapping;
import doo.daba.java.util.PropertiesContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



/**
 * Clase DAO de Usuario. Define los metodos de lectura y escritura en base de datos acerca de la 
 * informacion relacionada del element
 *
 * @since 24/08/1012
 * @author Gerardo Aquino
 * 
 */
@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {

	@Autowired
	private DataSource dataSource;



	@PostConstruct
	void init() {
        super.setDataSource(this.dataSource);
	}



	/**
	 * Agrega un registro a la base de datos en la tabla de usuarios de la aplicación.
	 * La informacion del registro es tomada del parametro {@code element}
	 * 
	 *
     * @param element    Objeto que encapsula la informacion del element que se registra
     *					en base de datos
     *
     * @return	Numero de registros nuevos en base de datos. Actualmente se espera que
	 *			el valor de retorno cuando sea exitoso el registro sea siempre 1. Quizas
	 *			mas adelante se requiera realziar un registro en batch (que no le veo mucho
	 *			sentido pero en fin... usemos la imaginacion)
	 */
	@Override
	public final int insert(final User element) {
		
		return super.getJdbcTemplate().update(
			PropertiesContainer.get("sql.registro.usuario"),
			new Object[] {
				element.getName(),
				element.getLastName(),
				element.getEmailAddress(),
				element.getUserAlias(),
				element.getPassword(),
				element.getMemberFrom(),
			});
		
	}



	/**
	 * Consultamos a la base de datos en busca de un element que tenga como
	 * identificador el id que recibimos como parametro
	 * 
	 * @param id	Identificador del element en la base de datos
	 * 
	 * @return	Objeto que encapsula la informacion del element registrado en
	 *            base de datos
	 * 
	 */
	public User select(int id) {

		return super.getJdbcTemplate().queryForObject(
			PropertiesContainer.get("sql.consulta.usuario.id"),
			new Object[] {
				id
			},
			new UserObjectMapping(true));

	}
	
	
	
	/**
	 * Consultamos a la base de datos en busca de un element que tenga como
	 * userAlias el valor que recibimos como parametro
	 * 
	 * @param userAlias	Alias del element registrado en Base de Datos
	 * 
	 * @return	Objeto que encapsula la informacion del element registrado en
	 *            base de datos
	 */
	public User select(String userAlias) {

        User usuario;

        try {
            usuario =  super.getJdbcTemplate().queryForObject(
                PropertiesContainer.get("sql.consulta.usuario.alias"),
                new Object[] {
                        userAlias
                },
                new UserObjectMapping(true));
        } catch (EmptyResultDataAccessException e) {
            usuario = null;
        }

        return usuario;

	}
	
	
	
	/**
	 * Consulta los roles asociados al element. Estos roles pueden ser utilizados
	 * en la autenticación de la aplicación para definir el perfil de acceso.
	 * 
	 * @param userId	ID del registro en el repositorio de datos del element
	 * 
	 * @return	Roles asignados al usaurio
	 */
	public List<String> selectUserRoles(int userId) {

		return super.getJdbcTemplate().query(
				PropertiesContainer.get("sql.consulta.usuario.roles"),
				new Object[]{
                        userId
				},
				new RowMapper<String>() {
					public String mapRow(ResultSet rs, int rowNum) throws SQLException {
						return rs.getString("clave");
					}
				});

	}



	@Override
	public final List<User> select(Criterion criterio, boolean showDetails, Object ... params) {
		throw new UnsupportedOperationException("Not supported yet.");
	}



	@Override
	public final List<User> selectAll(boolean showDetails) {
		throw new UnsupportedOperationException("Not supported yet.");
	}



	@Override
	public final int update(final User element) {
		throw new UnsupportedOperationException("Not supported yet.");
	}



	/**
	 * Elimina el registro de un element en la base de datos segun su userAlias.
	 * 
	 * @param element	Encapsula la información del element a eliminar, basta
	 *					con que se defina el userAlias del element para poder realizar
	 *					el borrado del registro.
	 * 
	 * @return 
	 */
	public int delete(User element) {
		
		return super.getJdbcTemplate().update(
			PropertiesContainer.get("sql.elimina.usuario"),
			new Object[] {
				element.getUserAlias()
			});
		
	}



    @Override
    public int linkUserProfilePicture(int userId, int imageId) {
        return super.getJdbcTemplate().update(PropertiesContainer.get("sql.registro.usuario.imagen"), userId, imageId);
    }
}