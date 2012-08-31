package doo.daba.java.pruebas.util.io;



import doo.daba.java.beans.ContenedorPersonaBean;
import doo.daba.java.util.io.JsonReader;
import java.io.FileNotFoundException;
import org.junit.Before;
import org.junit.Test;



/**
 *
 * @author Gerardo Aquino
 */
public class JsonReaderTest {
	
	private ContenedorPersonaBean contenedorPersona;
	
	
	
	@Before
	public void init() throws FileNotFoundException {
		contenedorPersona = new JsonReader().jsonToObjectFromFile(
			"C:/persona.json",
			ContenedorPersonaBean.class
			);
	}
	
	
	@Test
	public void pruebaContenedorPersona() {
		
		assert contenedorPersona != null;
		assert contenedorPersona.getPersona() != null;
		assert contenedorPersona.getPersona().getEdad() == 99;
		assert contenedorPersona.getPersona().getHijos().size() == 3;
		
		System.out.println(contenedorPersona);
		
	}
	
	
}
