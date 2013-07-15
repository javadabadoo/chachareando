package doo.daba.java.pruebas.util.io;



import doo.daba.java.beans.PersonContainer;
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

	private PersonContainer personContainerFromFile;
	private PersonContainer personContainerFromWeb;



	@Before
	public void init() throws FileNotFoundException, MalformedURLException, IOException {

		JsonReader jsonReader = new JsonReader();

        personContainerFromFile = jsonReader.jsonToObjectFromFile(
			"C:/persona.json",
			PersonContainer.class);

		personContainerFromWeb = jsonReader.
			jsonToObjectFromWeb(
			"https://raw.github.com/javadabadoo/chachareando/master/ChachareandoGit/src/test/resources/json/persona.json",
			PersonContainer.class);
	}



	@Test
	public void pruebaContenedorPersona() {

		assert personContainerFromFile != null;
		assert personContainerFromFile.getPerson() != null;
		assert personContainerFromFile.getPerson().getAge() == 99;
		assert personContainerFromFile.getPerson().getSoons().size() == 3;

		assert personContainerFromWeb != null;
		assert personContainerFromWeb.getPerson().getAge() == personContainerFromFile.getPerson().
                getAge();

		System.out.println(personContainerFromFile);
		System.out.println(personContainerFromWeb);

	}
}
