package doo.daba.java.test.servicio;

import doo.daba.java.beans.UserEntry;
import doo.daba.java.persistencia.UserEntryDaoImpl;
import doo.daba.java.persistencia.criterio.EntradaCriterio;
import doo.daba.java.persistencia.criterio.enums.EntradaSearchCriteriaEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 22/05/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:chachareando-context.xml"
})
@Transactional
public class EntradaServicioTest {

    @Autowired
    UserEntryDaoImpl userEntryDaoImpl;


    @Test
    public void consultaEntradasDeUsuarioTest() {
        List<UserEntry> entradas = this.userEntryDaoImpl.select(
                new EntradaCriterio(EntradaSearchCriteriaEnum.USUARIO),
                false,
                1);

        assert ! entradas.isEmpty();
    }
}
