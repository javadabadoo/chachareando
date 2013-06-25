package doo.daba.java.servicio.interfaces;

import doo.daba.java.beans.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 14/05/13
 */
public interface UserService {

    int saveUser(User user);

    User getUserInformation(int userId);

    User getUserInformation(String alias);

    List<String> getUserRoles(int userId);

    int linkUserProfilePicture(int userId, int imageId);

}
