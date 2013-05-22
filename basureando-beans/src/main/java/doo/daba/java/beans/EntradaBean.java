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
 * Time: 2:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class EntradaBean {

    @Getter @Setter
    private int
		    id,
		    idUsuario;

    @Getter @Setter(AccessLevel.PUBLIC)
    private String
		    estado,
		    contenido,
		    titulo;

	@JsonSerialize(using=JsonFechaSerializador.class)
	@Getter @Setter
	private Date
			fechaPublicacion,
			fechaModificacion;

}
