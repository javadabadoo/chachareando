package doo.daba.java.test.servicio;

import doo.daba.java.beans.UserEntry;
import doo.daba.java.persistencia.UserEntryDao;
import doo.daba.java.persistencia.UserEntryDaoImpl;
import doo.daba.java.persistencia.criterio.EntradaCriterio;
import doo.daba.java.persistencia.criterio.enums.EntradaSearchCriteriaEnum;
import doo.daba.java.persistencia.paginator.Page;
import doo.daba.java.servicio.interfaces.UserEntryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 22/05/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:chachareando-context.xml",
        "classpath:services-applicationContext.xml"
})
@Transactional
public class EntradaServicioTest {
    @Autowired
    private CacheManager cacheManager;

    @Autowired
    UserEntryService userEntryService;


    @Test
    public void consultaEntradasDeUsuarioTest() {
        List<UserEntry> entradas = this.userEntryService.getUserEntries(1, false);

        assert ! entradas.isEmpty();
    }

    @Test
    public void selectAllTest() {
        Page<UserEntry> userEntryPage = null;

        this.userEntryService.getAllUserEntries(1, false);
        userEntryPage = this.userEntryService.getAllUserEntries(1, false);

        assert userEntryPage != null;
    }


    @Test
    public void testDayOfWeek() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-ddd");
        assert 2 == this.userEntryService.getFirstDayPosition(df.parse("2013-07-01"));
    }
}
