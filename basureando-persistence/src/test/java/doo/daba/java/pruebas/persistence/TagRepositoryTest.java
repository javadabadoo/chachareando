package doo.daba.java.pruebas.persistence;

import doo.daba.java.beans.TagsJsonResponse;
import doo.daba.java.persistence.TagDao;
import doo.daba.java.persistence.criteria.CriterionImpl;
import doo.daba.java.persistence.criteria.enums.TagSearchCriterionEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: java_daba_doo
 * Date: 8/7/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:chachareando-context.xml"
})
public class TagRepositoryTest {

	@Autowired
	private TagDao tagDao;


	@Test
	public void selectTest(){
		List<TagsJsonResponse> tags = this.tagDao.select(new CriterionImpl(TagSearchCriterionEnum.NAME), false, "%spri%");
		assert tags != null;
        assert ! tags.isEmpty();

        assert ! tags.contains(null);
	}
}
