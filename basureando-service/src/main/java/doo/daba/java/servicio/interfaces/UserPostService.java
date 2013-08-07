package doo.daba.java.servicio.interfaces;

import doo.daba.java.beans.UserPost;
import doo.daba.java.persistence.paginator.Page;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 16/05/13
 * Time: 04:34 PM
 */
public interface UserPostService {

    int savePost(UserPost entry);

    UserPost getUserPost(int entryId);

    List<UserPost> getUserPosts(int userId, boolean showDetails);

	List<UserPost> getUserPosts(String criterion, boolean showDetails);

    Page<UserPost> getAllUserPosts(int startPage, boolean showDetails);

    int getLastDayOfMonth(Date date);

    int getFirstDayPosition(Date date);

    List<Integer> getWhichDaysHasEntries(Date date);

    List<UserPost> getRecentEntries();

	List<UserPost> getPostComments(int idPost);

}
