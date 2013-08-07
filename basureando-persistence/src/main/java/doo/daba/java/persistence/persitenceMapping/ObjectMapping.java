package doo.daba.java.persistence.persitenceMapping;

import org.springframework.jdbc.core.RowMapper;

/**
 * Created with IntelliJ IDEA.
 * User: java_daba_doo
 * Date: 7/6/13
 */
public interface ObjectMapping <T> extends RowMapper<T> {

	void setShowDetails(boolean showDetails);

	boolean isShowDetails();

}
