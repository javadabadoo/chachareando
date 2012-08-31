package doo.daba.java.util.io;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import lombok.AccessLevel;
import lombok.Getter;



/**
 * Esta clase facilita la lectura de un recurso web. Mediante su direccion web (URL) se obtiene el
 * cofigo fuente utilizando el API nativo de java.io y java.net
 *
 * @since 23/08/1012
 * @author Gerardo Aquino
 *
 */
public class LeerContenidoHttp {

	@Getter (AccessLevel.PUBLIC)
	private int codigoDeRespuestaHttp;
	private URL direccionWeb;
	private StringBuilder contenido;
	private HttpURLConnection conexion;



	/**
	 * Metodo contructor de la clase que recibe la dirección del recurso web del cual se obtiene el
	 * contenido (codigo fuente)
	 *
	 * @param direccionWeb	Ubicacion (URL) del recurso web
	 * @throws MalformedURLException
	 * @throws IOException  
	 *
	 */
	public LeerContenidoHttp(String direccionWeb) throws MalformedURLException, IOException {
		this.setDireccionWeb(direccionWeb);
	}



	/**
	 *
	 */
	public LeerContenidoHttp() {
		super();
	}
	
	
	
	public BufferedReader obtenerReader () throws IOException {
		
		BufferedReader reader = null;
		this.codigoDeRespuestaHttp = abrirConexion();

		if ((this.codigoDeRespuestaHttp = abrirConexion()) == 200) {
			reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
		}

		return reader;
	}



	/**
	 * Obtiene el contenido de un recurso web atraves de la direccion del web que debe ser
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
	public String obtenerContenido() throws MalformedURLException, IOException {


		String inputLine = null;
		contenido  = new StringBuilder();
		
		 BufferedReader buferDeRecursoWeb = this.obtenerReader();
		
		while((inputLine = buferDeRecursoWeb.readLine()) != null) {
			contenido.append(inputLine);
		}

		buferDeRecursoWeb.close();

		return getContenidoRecursoWeb();
	}



	private int abrirConexion() throws IOException {
		this.conexion = (HttpURLConnection) this.direccionWeb.openConnection();
		return this.conexion.getResponseCode();
	}



	/**
	 * @return	Valor obtenido del recurso web consultado mediante el método {@code leerContenido}
	 *
	 * @see #leerContenido()
	 */
	public String getContenidoRecursoWeb() {
		return contenido.toString();
	}



	/**
	 * Establece la dirección del recurso web del cual se obtiene el contenido
	 *
	 * @param direccionWeb	Ubicacion web del contenido a leer
	 *
	 * @throws MalformedURLException	Posible excepcion lanzada cuando el fomrato de la url no sea
	 *                                  válido
	 * @throws IOException  Lanzada si existe un problema de I/O
	 * 
	 */
	public final void setDireccionWeb(String direccionWeb) throws MalformedURLException {
		
		this.direccionWeb = new URL(direccionWeb);
		
	}



	/**
	 * @return	URL del recurso web del cual se obtiene el contenido
	 */
	public String getDireccionWeb() {
		return (this.direccionWeb != null) ? this.direccionWeb.toString() : null;
	}
}
