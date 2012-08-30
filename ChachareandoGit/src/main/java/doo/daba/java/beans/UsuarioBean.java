package doo.daba.java.beans;



import java.util.Date;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



/**
 * Objeto que encapsula la informacion almacenada en la base de datos que representa a un registro
 * de usuario.
 *
 * @since 24/08/1012
 * @author Gerardo Aquino
 */
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioBean {
	
	@Getter(AccessLevel.PUBLIC) 
	@Setter(AccessLevel.PUBLIC) 
	private int id;
	
	@Getter(AccessLevel.PUBLIC) 
	@Setter(AccessLevel.PUBLIC) 
	private String
		nombre,
		apellidos,
		correo,
		alias,
		contrasena;
	
	@Getter(AccessLevel.PUBLIC) 
	@Setter(AccessLevel.PUBLIC) 
	Date fechaDeRegistro;

}
