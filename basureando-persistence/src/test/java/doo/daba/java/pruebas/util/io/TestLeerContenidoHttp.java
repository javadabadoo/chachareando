package doo.daba.java.pruebas.util.io;



import doo.daba.java.util.io.HttpContentReader;
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
	
	HttpContentReader httpContentReader;
	
	
	
	@Before
	public void init(){
		httpContentReader = new HttpContentReader();
	}

	
	
	@Test
	public void testUbicacionVerdadera() throws MalformedURLException, IOException {

        while (true) {
            httpContentReader.setUrlLocation("http://localhost:8181/basureando-web/consulta/entrada?sEcho=1&iColumns=2&sColumns=&iDisplayStart=0&iDisplayLength=-1&mDataProp_0=title&mDataProp_1=publicationDate&sSearch=&bRegex=false&sSearch_0=&bRegex_0=false&bSearchable_0=true&sSearch_1=&bRegex_1=false&bSearchable_1=true&iSortCol_0=0&sSortDir_0=asc&iSortingCols=1&bSortable_0=true&bSortable_1=true&_=1372197056070");
            httpContentReader.getTextContent();

            Assert.isTrue(httpContentReader.getResponseCode() == 200);
        }
	}

	
	
	@Test
    @Ignore
	public void testUbicacionNoExiste() throws MalformedURLException, IOException {
		httpContentReader.setUrlLocation("http://google.com.mx/javadabadoo");
		httpContentReader.getTextContent();
		
		Assert.isTrue(httpContentReader.getResponseCode() == 404);
	}

	
	
	@Test(expected=MalformedURLException.class)
	public void testUbicacionUrlMalformada() throws MalformedURLException, IOException {
		httpContentReader.setUrlLocation("javadabadoo");
	}
	
}
