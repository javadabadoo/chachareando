package doo.daba.java.beans;


import lombok.*;

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
@RequiredArgsConstructor
public class User {

    @NonNull
	@Getter @Setter 
	private int id;
	
	@Getter @Setter 
	private String
            name,
            lastName,
            emailAddress,
            userAlias,
            password;
	
	@Getter @Setter 
	Date memberFrom;
	
	
    @Getter @Setter
    private  List<String> rolesList;

    @Getter @Setter
    private boolean accesValid;
	

    public void addRol(String rol) {
        this.rolesList.add(rol);
    }

}
