package doo.daba.java.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 4/08/13
 */
@AllArgsConstructor
@NoArgsConstructor
public class TagsJsonResponse {

    @Getter @Setter
    private int id;

    @Getter @Setter
    private String
            label,
            value;


}
