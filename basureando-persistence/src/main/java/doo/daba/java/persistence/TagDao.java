package doo.daba.java.persistence;

import doo.daba.java.beans.TagsJsonResponse;
import doo.daba.java.persistence.criteria.Criterion;
import doo.daba.java.persistence.paginator.Page;
import doo.daba.java.persistence.persitenceMapping.TagObjectMapping;
import doo.daba.java.util.PropertiesContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: java_daba_doo
 * Date: 8/7/13
 */
@Repository
public class TagDao extends JdbcDaoSupport implements DaoInterface<TagsJsonResponse> {

	@Autowired
	private DataSource dataSource;



	@PostConstruct
	void init() {
		super.setDataSource(this.dataSource);
	}


	@Override
	public int insert(TagsJsonResponse element) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public TagsJsonResponse select(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public List<TagsJsonResponse> select(Criterion criterio, boolean showDetails, Object... params) {

		return super.getJdbcTemplate().query(
				PropertiesContainer.get("sql.tag.searchByName", criterio.toString()),
				new TagObjectMapping(),
				params);
	}

	@Override
	public Page<TagsJsonResponse> selectAll(int currentPage, boolean showDetails) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public int update(TagsJsonResponse element) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public int delete(TagsJsonResponse element) {
        throw new UnsupportedOperationException("Not supported yet.");
	}
}
