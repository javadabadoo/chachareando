package doo.daba.java.beans;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 10/06/13
 */
@ToString
public class SendMailBean {

    @NotNull
    @Size(max = 100, message = "La longitud del correo es muy laraga")
    @Email(message = "Dirección de correo incorrecta")
    @Getter @Setter
    private String sentFrom;

    @NotNull
    @Size(min = 5, max = 50, message = "Longitud inválida")
    @Getter @Setter
    private String title;
}
