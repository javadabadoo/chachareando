package doo.daba.java.pruebas.persistencia;



import doo.daba.java.beans.User;
import doo.daba.java.persistencia.UserDao;
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
 * Este test prueba que se obtengan datos de la DB de un usuario que sabemos que ya está registrado
 *
 * @since 24/08/1012
 * @author Gerardo Aquino
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:chachareando-context.xml"
})
public class UsuarioRepositorioTest {
	
	@Autowired
	private UserDao usuarioDao;
	
	private User usuario;
	
	
	@Before
	public void init() {
		this.usuario = new User(
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
	public void consultarUsuarioTest() {
		
		User otroUsuario = this.usuarioDao.select(1);
		
		Assert.notNull(otroUsuario);
		Assert.isTrue(otroUsuario.getName().equals("Gerardo"));
		Assert.isTrue(otroUsuario.getUserAlias().equals("java.daba.doo"));
		
	}
	
	
	@Test
	public void eliminarUsuarioTest() {
		
		int registroEliminado = this.usuarioDao.delete(this.usuario);
		
		Assert.isTrue(registroEliminado == 1);
	}
	
	
	@Test
	public void registrarUsuarioTest() {
		int registro = this.usuarioDao.insert(this.usuario);
		
		Assert.isTrue(registro == 1);
		
	}
	
	
	@Test (expected=DuplicateKeyException.class)
	public void registrarUsuarioFallidoTest() {
		this.usuarioDao.insert(this.usuario);
	}

}
