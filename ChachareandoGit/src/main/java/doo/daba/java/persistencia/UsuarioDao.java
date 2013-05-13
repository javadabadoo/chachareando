package doo.daba.java.persistencia;



import doo.daba.java.persistencia.mapeo.MapeoUsuario;
import doo.daba.java.beans.UsuarioBean;
import doo.daba.java.util.Propiedades;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;



/**
 * Clase DAO de Usuario. Define los metodos de lectura y escritura en base de datos acerca de la 
 * informacion relacionada del usuario
 *
 * @since 24/08/1012
 * @author Gerardo Aquino
 * 
 */
@Repository
public class UsuarioDao extends JdbcDaoSupport implements UsuarioInterfaceDao {

	@Autowired
	private DataSource dataSource;



	@PostConstruct
	void init() {
		setDataSource(dataSource);
	}



	/**
	 * Agrega un registro a la base de datos en la tabla de usuarios de la aplicación.
	 * La informacion del registro es tomada del parametro {@code usuario}
	 * 
	 * @param usuario	Objeto que encapsula la informacion del usuario que se registra
	 *					en base de datos
	 * 
	 * @return	Numero de registros nuevos en base de datos. Actualmente se espera que
	 *			el valor de retorno cuando sea exitoso el registro sea siempre 1. Quizas
	 *			mas adelante se requiera realziar un registro en batch (que no le veo mucho
	 *			sentido pero en fin... usemos la imaginacion)
	 */
	@Override
	public final int insert(final UsuarioBean usuario) {
		
		return super.getJdbcTemplate().update(
			Propiedades.obtener("sql.registro.usuario"),
			new Object[] {
				usuario.getNombre(),
				usuario.getApellidos(),
				usuario.getCorreo(),
				usuario.getAlias(),
				usuario.getContrasena(),
				usuario.getFechaDeRegistro(),
			});
		
	}



	/**
	 * Consultamos a la base de datos en busca de un usuario que tenga como
	 * identificador el id que recibimos como parametro
	 * 
	 * @param id	Identificador del usuario en la base de datos
	 * 
	 * @return	Objeto que encapsula la informacion del usuario registrado en
	 *            base de datos
	 * 
	 */
	public UsuarioBean select(int id) {

		return super.getJdbcTemplate().queryForObject(
			Propiedades.obtener("sql.consulta.usuario.id"),
			new Object[] {
				id
			},
			new MapeoUsuario(true));

	}
	
	
	
	/**
	 * Consultamos a la base de datos en busca de un usuario que tenga como
	 * alias el valor que recibimos como parametro
	 * 
	 * @param alias	Alias del usuario registrado en Base de Datos
	 * 
	 * @return	Objeto que encapsula la informacion del usuario registrado en
	 *            base de datos
	 */
	public UsuarioBean select(String alias) {

        UsuarioBean usuario;

        try {
            usuario =  super.getJdbcTemplate().queryForObject(
                Propiedades.obtener("sql.consulta.usuario.alias"),
                new Object[] {
                    alias
                },
                new MapeoUsuario(true));
        } catch (EmptyResultDataAccessException e) {
            usuario = null;
        }

        return usuario;

	}
	
	
	
	/**
	 * Consulta los roles asociados al usuario. Estos roles pueden ser utilizados
	 * en la autenticación de la aplicación para definir el perfil de acceso.
	 * 
	 * @param idUsuario	ID del registro en el repositorio de datos del usuario
	 * 
	 * @return	Roles asignados al usaurio
	 */
	public List<String> obtenerListaDeRoles(int idUsuario) {

		return super.getJdbcTemplate().query(
				Propiedades.obtener("sql.consulta.usuario.roles"),
				new Object[]{
					idUsuario
				},
				new RowMapper<String>() {
					public String mapRow(ResultSet rs, int rowNum) throws SQLException {
						return rs.getString("clave");
					}
				});

	}



	@Override
	public final List<UsuarioBean> select(final Object criterio, boolean mostrarDetalle) {
		throw new UnsupportedOperationException("Not supported yet.");
	}



	@Override
	public final List<UsuarioBean> selectAll() {
		throw new UnsupportedOperationException("Not supported yet.");
	}



	@Override
	public final int update(final UsuarioBean usuario) {
		throw new UnsupportedOperationException("Not supported yet.");
	}



	/**
	 * Elimina el registro de un usuario en la base de datos segun su alias.
	 * 
	 * @param usuario	Encapsula la información del usuario a eliminar, basta
	 *					con que se defina el alias del usuario para poder realizar
	 *					el borrado del registro.
	 * 
	 * @return 
	 */
	public int delete(UsuarioBean usuario) {
		
		return super.getJdbcTemplate().update(
			Propiedades.obtener("sql.elimina.usuario"),
			new Object[] {
				usuario.getAlias()
			});
		
	}



    @Override
    public int registrarImagenPerfil(int idUsuario, int idImagen) {
        return super.getJdbcTemplate().update(Propiedades.obtener("sql.registro.usuario.imagen"), idUsuario, idImagen);
    }
}