package doo.daba.java.persistencia.persitenceMapping;

import doo.daba.java.beans.TagsJsonResponse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: java_daba_doo
 * Date: 8/7/13
 * Time: 1:19 AM
 * To change this template use File | Settings | File Templates.
 */
public class TagObjectMapping implements RowMapper<TagsJsonResponse> {
	@Override
	public TagsJsonResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new TagsJsonResponse(
				rs.getInt("id"),
				rs.getString("nombre"),
				rs.getString("nombre")
		);
	}
}
