package doo.daba.java.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 12/06/13
 */
@AllArgsConstructor
@NoArgsConstructor
public class FormResponse {

    @Getter @Setter
    private boolean hasError;

    @Getter @Setter
    private String responseMessage;

    @Getter @Setter
    private List<ValidationError> validationErrors;

}
