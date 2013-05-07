package doo.daba.java.persistencia.mapeo;



import doo.daba.java.beans.UsuarioBean;
import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.jdbc.core.RowMapper;



/**
 *
 * @author Gerardo Aquino
 */
@AllArgsConstructor
public class MapeoUsuario implements RowMapper<UsuarioBean> {

    @Getter @Setter
    private boolean mostrarDetalle;

	public UsuarioBean mapRow(ResultSet rs, int i) throws SQLException {
		
		UsuarioBean peticionBean = new UsuarioBean();
		
		peticionBean.setId(rs.getInt("id"));
		peticionBean.setNombre(rs.getString("nombre"));
		peticionBean.setApellidos(rs.getString("apellidos"));
		peticionBean.setAlias(rs.getString("alias"));

        if(mostrarDetalle) {
            peticionBean.setCorreo(rs.getString("correo"));
            peticionBean.setContrasena(rs.getString("contrasena"));
            peticionBean.setFechaDeRegistro(rs.getDate("fecha_de_registro"));
        }

		return peticionBean;
	}
}
