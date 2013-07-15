package doo.daba.java.pruebas.aspect;

import doo.daba.java.exceptionAspect.basura.Cosa;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 19/06/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:chachareando-context.xml"
})
public class ExceptionAspectTest {

    @Autowired
    Cosa cosa;


    @Test(expected = NumberFormatException.class)
    public void testCosa() {
        cosa.imprimeValor("Este es el mensaje");
    }
}
