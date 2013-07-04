package doo.daba.java.pruebas.persistencia;

import doo.daba.java.beans.User;
import doo.daba.java.beans.UserEntry;
import doo.daba.java.persistencia.UserEntryDao;
import doo.daba.java.persistencia.criterio.EntradaCriterio;
import doo.daba.java.persistencia.criterio.enums.EntradaSearchCriteriaEnum;
import doo.daba.java.persistencia.paginator.Page;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

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
    UserEntryDao entradaDao;
    UserEntry entrada;


    @Before
    public void init() {
        this.entrada = new UserEntry();

        this.entrada.setTitle("Titulo de entrada de prueba");
        this.entrada.setPublicationDate(new Date());
        this.entrada.setContent("Este es el contenido de la entrada de prueba. Puede contener <strong>texto en HTML</strong>");
        this.entrada.setStatus("vigente");
        this.entrada.setUser(new User(2));
    }



    @Test
    public void registrarEntradaTest() {
        assert this.entradaDao.insert(this.entrada) > 0;
    }


    @Test
    public void consultarEntrada() {
        this.registrarEntradaTest();

        UserEntry entrada = this.entradaDao.select(this.entrada.getId());

        assert entrada.getId() == this.entrada.getId();
        assert entrada.getPublicationDate().getTime() == this.entrada.getPublicationDate().getTime();
    }



    @Test
    public void consultarEntradasDeUsuarioTest() {
        this.registrarEntradaTest();
        List<UserEntry> entradaLista = this.entradaDao.select(new EntradaCriterio(EntradaSearchCriteriaEnum.USUARIO), false, 1);

        assert ! entradaLista.isEmpty();
    }



    @Test
    public void consultarEntradasPorTituloTest() {
        this.registrarEntradaTest();
        List<UserEntry> entradaLista = this.entradaDao.select(new EntradaCriterio(EntradaSearchCriteriaEnum.TITLE), false, "%itulo%");

        assert ! entradaLista.isEmpty();
    }



    @Test
    public void consultarEntradasTest() {
        this.registrarEntradaTest();

        Page<UserEntry> userEntryPage = this.entradaDao.selectAll(1, true);

        assert ! userEntryPage.getItems().isEmpty();
    }
}
