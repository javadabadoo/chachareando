package doo.daba.java.pruebas.persistence;



import doo.daba.java.beans.User;
import doo.daba.java.persistence.UserDao;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;



/**
 * Realizamos una prueba para verificar que nuestra configuracion de Spring esté bien realizada.
 * Este test prueba que se obtengan datos de la DB de un user que sabemos que ya está registrado
 *
 * @since 24/08/1012
 * @author Gerardo Aquino
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:chachareando-context.xml"
})
public class UserRepositoryTest {
	
	@Autowired
	private UserDao userDao;
	
	private User user;
	
	
	@Before
	public void init() {
		this.user = new User(
			0,
			"Pedro",
			"Picapiedra",
			"pedro.picapiedra@bufalosmojados.rock",
			"pedro.picapiedra",
			"rocadura",
			new Date(),
			null,
			true);
	}
	
	
	
	@Test
	public void selectUserTest() {
		
		User anotherUser = this.userDao.select(1);
		
		Assert.notNull(anotherUser);
		Assert.isTrue(anotherUser.getName().equals("Gerardo"));
		Assert.isTrue(anotherUser.getUserAlias().equals("java.daba.doo"));
		
	}
	
	
	@Test
	public void deleteUserTest() {
		
		int registroEliminado = this.userDao.delete(this.user);
		
		Assert.isTrue(registroEliminado == 1);
	}
	
	
	@Test
	public void insertUserTest() {
		int affectedRows = this.userDao.insert(this.user);
		
		Assert.isTrue(affectedRows == 1);
		
	}
	
	
	@Test (expected=DuplicateKeyException.class)
	public void registrarUsuarioFallidoTest() {
		this.userDao.insert(this.user);
	}

}
