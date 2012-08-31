package doo.daba.java.util.io;



import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;



/**
 *
 * @author Gerardo Aquino
 */
public class JsonReader {

	private Gson gson;

	
	
	public JsonReader() {
		gson = new Gson();
	}
	
	

	public <T>T jsonToObjectFromFile(String ubicacion, Type tipo)
				throws FileNotFoundException {
		
		return this.jsonToObject(new BufferedReader(new FileReader(ubicacion)), tipo);
		
	}
	
	

	public <T>T jsonToObjectFromWeb(String direccion, Type tipo) 
				throws FileNotFoundException, MalformedURLException, IOException {
		
		LeerContenidoHttp httpReader = new LeerContenidoHttp(direccion);
		
		return this.jsonToObject(new BufferedReader(httpReader.obtenerReader()), tipo);
		
	}
	
	

	public <T>T jsonToObject(Reader reader, Type tipo) {
		
		return gson.fromJson(reader, tipo);
		
	}
	
}
