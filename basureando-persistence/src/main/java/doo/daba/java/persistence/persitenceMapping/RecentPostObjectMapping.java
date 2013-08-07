package doo.daba.java.persistence.persitenceMapping;

import doo.daba.java.beans.User;
import doo.daba.java.beans.UserPost;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 15/07/13
 */
public class RecentPostObjectMapping implements RowMapper<UserPost> {

    @Override
    public UserPost mapRow(ResultSet rs, int rowNum) throws SQLException {


        UserPost userPost = new UserPost();
        userPost.setId(rs.getInt("entry_id"));
        userPost.setTitle(rs.getString("entry_title"));

        User user = new User();
        user.setUserAlias(rs.getString("user_alias"));

        userPost.setUser(user);

        return userPost;
    }
}
