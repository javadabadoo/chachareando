package doo.daba.java.persistencia;

import doo.daba.java.beans.UserPost;
import doo.daba.java.persistencia.paginator.Page;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 16/05/13
 * Time: 04:53 PM
 */
public interface UserPostDao extends DaoInterface<UserPost> {

	Page<UserPost> selectAll(int currentPage, boolean showDetails);

	Page<UserPost> selectDayEntries(int currentPage, boolean showDetails, Date date);

    List<Integer> selectWhichDaysHasEntries(Date mounthDate);

    List<UserPost> selectRecentEntries();

	List<UserPost> selectPostComments(int idPost);

}
