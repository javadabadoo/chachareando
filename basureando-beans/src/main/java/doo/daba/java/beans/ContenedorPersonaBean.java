package doo.daba.java.beans;



import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



/**
 *
 * @author Gerardo Aquino
 */
@ToString
public class ContenedorPersonaBean {
	
	@Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
	PersonaBean persona;

}
