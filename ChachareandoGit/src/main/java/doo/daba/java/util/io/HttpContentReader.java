package doo.daba.java.util.io;


import lombok.AccessLevel;
import lombok.Getter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;



/**
 * Esta clase facilita la lectura de un recurso web. Mediante su direccion web (URL) se obtiene el
 * cofigo fuente utilizando el API nativo de java.io y java.net
 *
 * @since 23/08/1012
 * @author Gerardo Aquino
 *
 */
public class HttpContentReader {

	@Getter (AccessLevel.PUBLIC)
	private int responseCode;
	private URL urlLocation;
	private StringBuilder content;
	private HttpURLConnection connection;



	/**
	 * Metodo contructor de la clase que recibe la dirección del recurso web del cual se obtiene el
	 * content (codigo fuente)
	 *
	 * @param urlLocation	Ubicacion (URL) del recurso web
	 * @throws MalformedURLException
	 * @throws IOException  
	 *
	 */
	public HttpContentReader(String urlLocation) throws MalformedURLException, IOException {
		this.setUrlLocation(urlLocation);
	}



	/**
	 *
	 */
	public HttpContentReader() {
		super();
	}
	
	


	public BufferedReader getReader() throws IOException {
		
		BufferedReader reader = null;
		this.responseCode = openConnection();

		if ((this.responseCode = openConnection()) == 200) {
			reader = new BufferedReader(new InputStreamReader(this.getInputStream()));
		}

		return reader;
	}



    public InputStream getInputStream() throws IOException {
        return connection.getInputStream();
    }



	/**
	 * Obtiene el content de un recurso web atraves de la direccion del web que debe ser
	 * establecida anteriormente.
	 *
	 * @returnC	Ontenido del recurso web.
	 * 
	 * @throws MalformedURLException	Posible excepcion lanzada cuando el fomrato de la url no sea
	 *                                  válido
	 * 
	 * @throws IOException  Lanzada si existe un problema de I/O
	 * 
	 */
	public String getTextContent() throws MalformedURLException, IOException {


		String inputLine = null;
		content = new StringBuilder();
		
		 BufferedReader buferDeRecursoWeb = this.getReader();
		
		while((inputLine = buferDeRecursoWeb.readLine()) != null) {
			content.append(inputLine);
		}

		buferDeRecursoWeb.close();

		return content.toString();
	}



	private int openConnection() throws IOException {
        if (this.connection != null) {
            this.connection.disconnect();
        }
		this.connection = (HttpURLConnection) this.urlLocation.openConnection();
		return this.connection.getResponseCode();
	}



	/**
	 * Establece la dirección del recurso web del cual se obtiene el content
	 *
	 * @param urlLocation	Ubicacion web del content a leer
	 *
	 * @throws MalformedURLException	Posible excepcion lanzada cuando el fomrato de la url no sea
	 *                                  válido
	 * @throws IOException  Lanzada si existe un problema de I/O
	 * 
	 */
	public final void setUrlLocation(String urlLocation) throws MalformedURLException {
		
		this.urlLocation = new URL(urlLocation);
		
	}



	/**
	 * @return	URL del recurso web del cual se obtiene el content
	 */
	public String getUrlLocation() {
		return (this.urlLocation != null) ? this.urlLocation.toString() : null;
	}
}
