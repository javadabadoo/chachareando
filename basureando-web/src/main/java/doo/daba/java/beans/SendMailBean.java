package doo.daba.java.beans;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 10/06/13
 */
public class SendMailBean {

    @NotNull
    @Size(max = 100)
    @Pattern(regexp="^([a-zA-Z0-9\\-\\.\\_]+)'+'(\\@)([a-zA-Z0-9\\-\\.]+)'+'(\\.)([a-zA-Z]{2,4})$")
    private String sentFrom;
}
