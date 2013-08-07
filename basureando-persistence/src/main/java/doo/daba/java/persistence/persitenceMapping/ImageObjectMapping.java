package doo.daba.java.persistence.persitenceMapping;

import doo.daba.java.beans.Image;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 10/05/13
 */
public class ImageObjectMapping implements RowMapper <Image> {
    @Override
    public Image mapRow(ResultSet rs, int rowNum) throws SQLException {

        Image image = new Image();

        image.setId(rs.getInt("id"));
        image.setName(rs.getString("nombre"));
        image.setComment(rs.getString("comentario"));
        image.setByteContent(rs.getBytes("imagen"));

        return image;
    }
}
