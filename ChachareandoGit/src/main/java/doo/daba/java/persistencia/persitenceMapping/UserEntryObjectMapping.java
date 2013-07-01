package doo.daba.java.persistencia.persitenceMapping;

import doo.daba.java.beans.User;
import doo.daba.java.beans.UserEntry;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: java_daba_doo
 * Date: 4/6/13
 */
@AllArgsConstructor
public class UserEntryObjectMapping implements RowMapper<UserEntry> {

    @Getter @Setter
    private boolean showDetails;

    public UserEntry mapRow(ResultSet rs, int i) throws SQLException {

        UserEntry userEntry = new UserEntry();
        User user = new User();

        userEntry.setId(rs.getInt("id"));
        userEntry.setTitle(rs.getString("titulo"));
        userEntry.setStatus(rs.getString("estado"));

        user.setId(rs.getInt("usuario_id"));
        user.setName(rs.getString("nombre"));
        userEntry.setUser(user);

        if (this.showDetails) {
            userEntry.setContent(rs.getString("contenido"));
            userEntry.setPublicationDate(rs.getTimestamp("fecha_de_creacion"));
            userEntry.setModificacionDate(rs.getTimestamp("fecha_de_modificacion"));
        }

        return userEntry;
    }

}
