package doo.daba.java.pruebas.persistencia;

import doo.daba.java.beans.EntradaBean;
import doo.daba.java.persistencia.EntradaInterfaceDao;
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
public class EntradaRepositorioTest {

    @Autowired
    EntradaInterfaceDao entradaDao;
    EntradaBean entrada;


    @Before
    public void init() {
        this.entrada = new EntradaBean();

        this.entrada.setTitulo("Titulo de entrada de prueba");
        this.entrada.setFechaPublicacion(new Date());
        this.entrada.setContenido("Este es el contenido de la entrada de prueba. Puede contener <strong>texto en HTML</strong>");
        this.entrada.setEstado("vigente");
        this.entrada.setIdUsuario(2);
    }



    @Test
    public void registrarEntradaTest() {
        assert this.entradaDao.insert(this.entrada) > 0;
    }


    @Test
    public void consultarEntrada() {
        this.registrarEntradaTest();

        EntradaBean entrada = this.entradaDao.select(this.entrada.getId());

        assert entrada.getId() == this.entrada.getId();
        assert entrada.getFechaPublicacion().getTime() == this.entrada.getFechaPublicacion().getTime();
    }



    @Test
    public void consultarEntradasDeUsuarioTest() {
        this.registrarEntradaTest();
        List<EntradaBean> entradaLista = this.entradaDao.select(1, true);

        assert ! entradaLista.isEmpty();
    }



    @Test
    public void consultarEntradasTest() {
        this.registrarEntradaTest();

        List<EntradaBean> entradaLista = this.entradaDao.selectAll(true);

        assert ! entradaLista.isEmpty();
    }
}
