package doo.daba.java.pruebas.util.io;



import doo.daba.java.beans.ContenedorPersonaBean;
import doo.daba.java.util.io.JsonReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;



/**
 *
 * @author Gerardo Aquino
 */
@Ignore
public class JsonReaderTest {

	private ContenedorPersonaBean contenedorPersonaArchivo;
	private ContenedorPersonaBean contenedorPersonaWeb;



	@Before
	public void init() throws FileNotFoundException, MalformedURLException, IOException {

		JsonReader jsonReader = new JsonReader();

		contenedorPersonaArchivo = jsonReader.jsonToObjectFromFile(
			"C:/persona.json",
			ContenedorPersonaBean.class);

		contenedorPersonaWeb = jsonReader.
			jsonToObjectFromWeb(
			"https://raw.github.com/javadabadoo/chachareando/master/ChachareandoGit/src/test/resources/json/persona.json",
			ContenedorPersonaBean.class);
	}



	@Test
	public void pruebaContenedorPersona() {

		assert contenedorPersonaArchivo != null;
		assert contenedorPersonaArchivo.getPersona() != null;
		assert contenedorPersonaArchivo.getPersona().getEdad() == 99;
		assert contenedorPersonaArchivo.getPersona().getHijos().size() == 3;

		assert contenedorPersonaWeb != null;
		assert contenedorPersonaWeb.getPersona().getEdad() == contenedorPersonaArchivo.getPersona().
			getEdad();

		System.out.println(contenedorPersonaArchivo);
		System.out.println(contenedorPersonaArchivo);

	}
}
