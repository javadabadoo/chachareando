package doo.daba.java.persistence;

import doo.daba.java.beans.User;

import java.util.List;

/**
 *
 * @author Gerardo Aquino
 */
public interface UserDao extends DaoInterface<User>{
	
	User select(String userAlias);
	
	List<String> selectUserRoles(int userId);

    int linkUserProfilePicture(int userId, int imageId);
	
}
