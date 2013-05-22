package doo.daba.java.beans.json;

import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 20/05/13
 */
public class RespuestaJson <T> implements Serializable {


    @Getter @Setter
    private int
            iTotalRecords,
            iTotalDisplayRecords;

    @Getter @Setter
    private T aaData;

}
