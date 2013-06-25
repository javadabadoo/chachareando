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
public class Person {

	@Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
	private String name;
	
	@Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
	private int age;
	
	@Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
	List<Person> soons;
	
}
