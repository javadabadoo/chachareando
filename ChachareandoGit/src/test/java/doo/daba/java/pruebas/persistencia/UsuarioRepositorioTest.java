package doo.daba.java.pruebas.persistencia;



import doo.daba.java.persistencia.ConsultarDatosDao;
import doo.daba.java.pojo.UsuarioBean;
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
    "classpath:applicationContext.xml"
})
public class UsuarioRepositorioTest {
	
	@Autowired
	private ConsultarDatosDao<UsuarioBean> consultarDatosDao;
	
	private UsuarioBean usuario;
	
	
	@Before
	public void init() {
		usuario = new UsuarioBean(
			0,
			"Pedro",
			"Picapiedra",
			"pedro.picapiedra@bufalosmojados",
			"pedro.picapiedra",
			"rocadura",
			new Date());
	}
	
	
	
	@Test
	public void consultarUsuarioTest() {
		
		UsuarioBean otroUsuario = consultarDatosDao.select(1);
		
		Assert.notNull(otroUsuario);
		Assert.isTrue(otroUsuario.getNombre().equals("Gerardo"));
		Assert.isTrue(otroUsuario.getAlias().equals("java.daba.doo"));
		
	}
	
	
	@Test
	public void eliminarUsuarioTest() {
		
		int registroEliminado = consultarDatosDao.delete(usuario);
		
		Assert.isTrue(registroEliminado == 1);
	}
	
	
	@Test
	public void registrarUsuarioTest() {
		int registro = consultarDatosDao.insert(usuario);
		
		Assert.isTrue(registro == 1);
		
	}
	
	
	@Test (expected=DuplicateKeyException.class)
	public void registrarUsuarioFallidoTest() {
		consultarDatosDao.insert(usuario);
	}

}
