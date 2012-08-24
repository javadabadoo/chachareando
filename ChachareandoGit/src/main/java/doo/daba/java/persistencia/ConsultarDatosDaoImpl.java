package doo.daba.java.persistencia;



import doo.daba.java.persistencia.mapeo.MapeoUsuario;
import doo.daba.java.pojo.UsuarioBean;
import doo.daba.java.util.Propiedades;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ConsultarDatosDaoImpl extends JdbcDaoSupport implements ConsultarDatosDao<UsuarioBean> {

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
		
		return this.getJdbcTemplate().update(
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

		return this.getJdbcTemplate().queryForObject(
			Propiedades.obtener("sql.consulta.usuario"),
			new Object[] {
				id
			},
			new MapeoUsuario());

	}



	@Override
	public final List<UsuarioBean> select(final UsuarioBean usuario) {
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
		
		return this.getJdbcTemplate().update(
			Propiedades.obtener("sql.elimina.usuario"),
			new Object[] {
				usuario.getAlias()
			});
		
	}
}