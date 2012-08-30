package doo.daba.java.util.io;



import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;



/**
 *
 * @author Gerardo Aquino
 */
public class JsonReader {

	private Gson gson;
	
	@Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
	private String jsonFile;



	public <T>T jsonToObject(String ubicacion, Type objeto) throws FileNotFoundException {

		gson = new Gson();
		
		BufferedReader archivoJsonBufferedReader = new BufferedReader(new FileReader(ubicacion));
		return gson.fromJson(archivoJsonBufferedReader, objeto);
		

	}
	
}
