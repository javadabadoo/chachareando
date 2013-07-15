package doo.daba.java.persistencia.persitenceMapping;

import doo.daba.java.beans.User;
import doo.daba.java.beans.UserPost;
import doo.daba.java.util.PropertiesContainer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: java_daba_doo
 * Date: 4/6/13
 */
@AllArgsConstructor
public class UserEntryObjectMapping implements ObjectMapping<UserPost> {

    @Getter @Setter
    private boolean showDetails;

    public final static int CONTENT_MAX_LENGTH = PropertiesContainer.getInt("validation.entry.contentMaxLength");



    public UserPost mapRow(ResultSet rs, int i) throws SQLException {

        UserPost userPost = new UserPost();
        User user = new User();

        userPost.setId(rs.getInt("id"));
        userPost.setTitle(rs.getString("titulo"));
        userPost.setStatus(rs.getString("estado"));
        userPost.setPublicationDate(rs.getTimestamp("fecha_de_creacion"));

        user.setId(rs.getInt("usuario_id"));
        user.setUserAlias(rs.getString("alias"));
        userPost.setUser(user);

        if (this.showDetails) {
            userPost.setContent(rs.getString("contenido"));
            userPost.setModificacionDate(rs.getTimestamp("fecha_de_modificacion"));
        } else {
            String content = rs.getString("contenido");
            int contentLength = content.length();

            if(contentLength > CONTENT_MAX_LENGTH) {
                content = content.substring(0, CONTENT_MAX_LENGTH);
                content = content.substring(0, content.lastIndexOf(' '));
            }

            userPost.setContent(content + " ...");
        }

        return userPost;
    }

}
