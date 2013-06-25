package doo.daba.java.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 10/05/13
 */
@AllArgsConstructor
@NoArgsConstructor
public class Image {

    @Getter @Setter
    int id;

    @Getter @Setter
    String
            name,
            comment;

    @Getter @Setter
    byte[] byteContent;
}
