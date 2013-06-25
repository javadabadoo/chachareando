package doo.daba.java.beans;

import doo.daba.java.beans.util.JsonFechaSerializador;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import lombok.AccessLevel;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Created with IntelliJ IDEA.
 * User: java_daba_doo
 * Date: 4/6/13
 */
public class UserEntry {

    @Getter @Setter
    private int
		    id,
		    userId;

    @Getter @Setter(AccessLevel.PUBLIC)
    private String
            status,
            content,
		    title;

	@JsonSerialize(using=JsonFechaSerializador.class)
	@Getter @Setter
	private Date
            publicationDate,
			modificacionDate;

}
