package doo.daba.java.exceptionAspect.basura;

import doo.daba.java.annotation.ExceptionAnotation;
import lombok.ToString;
import org.springframework.stereotype.Component;


/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 19/06/13
 */
@Component
public class Cosa {


    @ExceptionAnotation
    public void imprimeValor(String mensaje) {
        System.out.println("\n\n\tTERMINAMOS" + Integer.parseInt(mensaje));
        new Cosa().toString();
    }


    @Override
    public String toString() {
        return null;
    }
}
