package doo.daba.java.servicio;

import doo.daba.java.beans.TagsJsonResponse;
import doo.daba.java.persistence.TagDao;
import doo.daba.java.persistence.criteria.CriterionImpl;
import doo.daba.java.persistence.criteria.enums.TagSearchCriterionEnum;
import doo.daba.java.servicio.interfaces.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: java_daba_doo
 * Date: 8/7/13
 */
@Service
public class TagServiceImpl implements TagService {

	@Autowired
	private TagDao tagDao;

	@Override
	public List<TagsJsonResponse> findRelatedTags(String tag) {
		return this.tagDao.select(
				new CriterionImpl(TagSearchCriterionEnum.NAME),
				false,
				String.format("%%%s%%", tag));
	}
}
