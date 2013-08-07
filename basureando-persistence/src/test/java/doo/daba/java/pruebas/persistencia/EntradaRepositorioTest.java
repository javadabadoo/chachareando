package doo.daba.java.pruebas.persistencia;

import doo.daba.java.beans.User;
import doo.daba.java.beans.UserPost;
import doo.daba.java.persistencia.UserPostDao;
import doo.daba.java.persistencia.criterio.CriterionImpl;
import doo.daba.java.persistencia.criterio.enums.EntradaSearchCriteriaEnum;
import doo.daba.java.persistencia.paginator.Page;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
 * Date: 16/05/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:chachareando-context.xml"
})
@Transactional
public class EntradaRepositorioTest {

    @Autowired
    UserPostDao entradaDao;
    UserPost entrada;
	private SimpleDateFormat dateFormat;


    @Before
    public void init() {
        this.entrada = new UserPost();

        this.entrada.setTitle("Titulo de entrada de prueba");
        this.entrada.setPublicationDate(new Date());
        this.entrada.setContent("Este es el contenido de la entrada de prueba. Puede contener <strong>texto en HTML</strong>");
        this.entrada.setStatus("vigente");
        this.entrada.setUser(new User(2));

	    this.dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }



    @Test
    public void registrarEntradaTest() {
        assert this.entradaDao.insert(this.entrada) > 0;
    }


    @Test
    public void consultarEntrada() {
        this.registrarEntradaTest();

        UserPost entrada = this.entradaDao.select(this.entrada.getId());

        assert entrada.getId() == this.entrada.getId();
        assert entrada.getPublicationDate().getTime() == this.entrada.getPublicationDate().getTime();
    }



    @Test
    public void consultarEntradasDeUsuarioTest() {
        this.registrarEntradaTest();
        List<UserPost> entradaLista = this.entradaDao.select(new CriterionImpl(EntradaSearchCriteriaEnum.USUARIO), false, 1);

        assert ! entradaLista.isEmpty();
    }



    @Test
    public void consultarEntradasPorTituloTest() {
        this.registrarEntradaTest();
        List<UserPost> entradaLista = this.entradaDao.select(new CriterionImpl(EntradaSearchCriteriaEnum.TITLE), false, "%itulo%");

        assert ! entradaLista.isEmpty();
    }



    @Test
    public void consultarEntradasTest() {
        this.registrarEntradaTest();

        Page<UserPost> userEntryPage = this.entradaDao.selectAll(1, true);

        assert ! userEntryPage.getItems().isEmpty();
    }


	@Test
	public void testByDate() throws ParseException {

		Page<UserPost> userEntryPage = this.entradaDao.selectDayEntries(1, false, this.dateFormat.parse("2013-03-12"));

		assert userEntryPage != null;
		assert ! userEntryPage.isEmpty();

	}



    @Test
    public void testWhichDaysHasEntries() throws ParseException {
        Date date = this.dateFormat.parse("2013-05-12");
        List<Integer> days = this.entradaDao.selectWhichDaysHasEntries(date);

        for (int i = 0; i <= 31; i++){
            System.out.println(String.format("%02d", i));
        }

        assert days != null;
        assert ! days.isEmpty();
    }
}
