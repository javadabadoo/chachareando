package doo.daba.java.beans;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import lombok.AccessLevel;

/**
 * Created with IntelliJ IDEA.
 * User: java_daba_doo
 * Date: 4/6/13
 * Time: 2:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class EntradaBean {

    @Getter @Setter
    private int id;

    @Getter @Setter
    private String titulo;

    @Getter @Setter
    private Date fechaPublicacion;

    @Getter @Setter
    private Date fechaModificacion;

    @Getter @Setter(AccessLevel.PUBLIC)
    private String estado;

    @Getter @Setter
    private String contenido;

    @Getter @Setter
    private int idUsuario;

}
