package doo.daba.java.beans;



import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



/**
 *
 * @author Gerardo Aquino
 */
@ToString
public class PersonaBean {

	@Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
	private String nombre;
	
	@Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
	private int edad;
	
	@Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
	List<PersonaBean> hijos;
	
}
