package doo.daba.java.persistencia.mapeo;



import doo.daba.java.pojo.UsuarioBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;



/**
 *
 * @author Gerardo Aquino
 */
public class MapeoUsuario implements RowMapper<UsuarioBean> {

	public UsuarioBean mapRow(ResultSet rs, int i) throws SQLException {
		
		UsuarioBean peticionBean = new UsuarioBean();
		
		peticionBean.setId(rs.getInt("id"));
		peticionBean.setNombre(rs.getString("nombre"));
		peticionBean.setApellidos(rs.getString("apellidos"));
		peticionBean.setCorreo(rs.getString("correo"));
		peticionBean.setAlias(rs.getString("alias"));
		peticionBean.setContrasena(rs.getString("contrasena"));
		peticionBean.setFechaDeRegistro(rs.getDate("fecha_de_registro"));

		return peticionBean;
	}
}
