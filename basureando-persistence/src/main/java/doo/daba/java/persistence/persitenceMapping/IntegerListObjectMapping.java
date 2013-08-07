package doo.daba.java.persistence.persitenceMapping;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 11/07/13
 */
public class IntegerListObjectMapping implements RowMapper<Integer> {
    @Override
    public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Integer.parseInt(rs.getString(1));
    }
}
