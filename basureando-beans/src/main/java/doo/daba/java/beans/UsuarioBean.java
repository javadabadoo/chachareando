package doo.daba.java.beans;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;



/**
 * Objeto que encapsula la informacion almacenada en la base de datos que
 * representa a un registro de usuario.
 *
 * @since 24/08/2012
 * @author Gerardo Aquino
 */
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioBean {
	
	@Getter @Setter 
	private int id;
	
	@Getter @Setter 
	private String
		nombre,
		apellidos,
		correo,
		alias,
		contrasena;
	
	@Getter @Setter 
	Date fechaDeRegistro;
	
	
    @Getter @Setter
    private  List<String> listaDeRoles;

    @Getter @Setter
    private boolean accesoValido;
	

    public void agregaRol(String rol) {
        this.listaDeRoles.add(rol);
    }

}
