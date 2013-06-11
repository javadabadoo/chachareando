package doo.daba.java.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 11/06/13
 */
@AllArgsConstructor
public class ErrorBean {

    @Getter @Setter
    private String
        field,
        errorMessage;

}
