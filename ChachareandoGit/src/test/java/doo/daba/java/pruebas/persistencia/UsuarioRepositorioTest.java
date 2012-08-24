package doo.daba.java.pruebas.persistencia;



import doo.daba.java.persistencia.ConsultarDatosDao;
import doo.daba.java.pojo.UsuarioBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
	ConsultarDatosDao<UsuarioBean> consultarDatosDao;
	
	
	
	@Test
	public void consultaPedimentoTest() {
		UsuarioBean usuario = consultarDatosDao.select(1);
		
		Assert.notNull(usuario);
		Assert.isTrue(usuario.getNombre().equals("Gerardo"));
		Assert.isTrue(usuario.getAlias().equals("java.daba.doo"));
		
	}

}
