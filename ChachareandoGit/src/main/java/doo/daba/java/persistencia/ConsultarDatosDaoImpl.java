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



	@Override
	public final int insert(final UsuarioBean peticionBean) {
		throw new UnsupportedOperationException("Not supported yet.");
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
	public final List<UsuarioBean> select(final UsuarioBean peticionBean) {
		throw new UnsupportedOperationException("Not supported yet.");
	}



	@Override
	public final List<UsuarioBean> selectAll() {
		throw new UnsupportedOperationException("Not supported yet.");
	}



	@Override
	public final int update(final UsuarioBean elemento) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}