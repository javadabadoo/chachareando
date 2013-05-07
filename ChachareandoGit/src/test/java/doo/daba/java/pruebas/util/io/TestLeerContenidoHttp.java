package doo.daba.java.pruebas.util.io;



import doo.daba.java.util.io.LeerContenidoHttp;
import java.io.IOException;
import java.net.MalformedURLException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.util.Assert;



/**
 *
 * @author Gerardo Aquino
 */
@Ignore
public class TestLeerContenidoHttp {
	
	LeerContenidoHttp leerContenidoHttp;
	
	
	
	@Before
	public void init(){
		leerContenidoHttp = new LeerContenidoHttp();
	}

	
	
	@Test
	public void testUbicacionVerdadera() throws MalformedURLException, IOException {
		leerContenidoHttp.setDireccionWeb("http://google.com.mx");
		leerContenidoHttp.obtenerContenido();
		
		Assert.isTrue(leerContenidoHttp.getCodigoDeRespuestaHttp() == 200);
	}

	
	
	@Test
	public void testUbicacionNoExiste() throws MalformedURLException, IOException {
		leerContenidoHttp.setDireccionWeb("http://google.com.mx/javadabadoo");
		leerContenidoHttp.obtenerContenido();
		
		Assert.isTrue(leerContenidoHttp.getCodigoDeRespuestaHttp() == 404);
	}

	
	
	@Test(expected=MalformedURLException.class)
	public void testUbicacionUrlMalformada() throws MalformedURLException, IOException {
		leerContenidoHttp.setDireccionWeb("javadabadoo");
	}
	
}
