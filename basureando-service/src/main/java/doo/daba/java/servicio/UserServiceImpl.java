package doo.daba.java.servicio;

import doo.daba.java.beans.User;
import doo.daba.java.persistence.UserDao;
import doo.daba.java.servicio.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 14/05/13
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;



    @Override
    public int saveUser(User user) {
        return this.userDao.insert(user);
    }



    @Override
    public User getUserInformation(int userId) {
        return this.userDao.select(userId);
    }



    @Override
    public User getUserInformation(String alias) {
        return this.userDao.select(alias);
    }



    @Override
    public List<String> getUserRoles(int userId) {
        return this.userDao.selectUserRoles(userId);
    }



    @Override
    public int linkUserProfilePicture(int userId, int imageId) {
        return this.linkUserProfilePicture(userId, imageId);
    }

}
