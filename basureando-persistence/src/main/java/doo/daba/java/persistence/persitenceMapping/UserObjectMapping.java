package doo.daba.java.persistence.persitenceMapping;



import doo.daba.java.beans.User;
import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.jdbc.core.RowMapper;



/**
 *
 * @author Gerardo Aquino
 */
@AllArgsConstructor
public class UserObjectMapping implements RowMapper<User> {

    @Getter @Setter
    private boolean showDetails;

	public User mapRow(ResultSet rs, int i) throws SQLException {
		
		User user = new User();
		
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("nombre"));
		user.setLastName(rs.getString("apellidos"));
		user.setUserAlias(rs.getString("alias"));

        if(this.showDetails) {
            user.setEmailAddress(rs.getString("correo"));
            user.setPassword(rs.getString("contrasena"));
            user.setMemberFrom(rs.getDate("fecha_de_registro"));
        }

		return user;
	}
}
