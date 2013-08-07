package doo.daba.java.test.servicio;

import doo.daba.java.beans.UserPost;
import doo.daba.java.persistence.paginator.Page;
import doo.daba.java.servicio.interfaces.UserPostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    UserPostService userPostService;


    @Test
    public void consultaEntradasDeUsuarioTest() {
        List<UserPost> entradas = this.userPostService.getUserPosts(1, false);

        assert ! entradas.isEmpty();
    }

    @Test
    public void selectAllTest() {
        Page<UserPost> userEntryPage = null;

        this.userPostService.getAllUserPosts(1, false);
        userEntryPage = this.userPostService.getAllUserPosts(1, false);

        assert userEntryPage != null;
    }


    @Test
    public void testDayOfWeek() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-ddd");
        assert 2 == this.userPostService.getFirstDayPosition(df.parse("2013-07-01"));
    }
}
