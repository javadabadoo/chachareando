package doo.daba.java.servicio.interfaces;

import doo.daba.java.beans.TagsJsonResponse;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: java_daba_doo
 * Date: 8/7/13
 */
public interface TagService {

	List<TagsJsonResponse> findRelatedTags(String tag);
}
