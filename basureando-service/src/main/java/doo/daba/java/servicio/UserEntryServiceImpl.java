package doo.daba.java.servicio;

import doo.daba.java.beans.UserEntry;
import doo.daba.java.persistencia.UserEntryDao;
import doo.daba.java.persistencia.criterio.Criterion;
import doo.daba.java.persistencia.criterio.EntradaCriterio;
import doo.daba.java.persistencia.criterio.enums.EntradaSearchCriteriaEnum;
import doo.daba.java.persistencia.paginator.Page;
import doo.daba.java.servicio.interfaces.UserEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 16/05/13
 */
@Service
@Transactional
public class UserEntryServiceImpl implements UserEntryService {


    @Autowired
    private UserEntryDao userEntryDao;


    /**
     * Invoca al objeto de persistencia para guardar la información de la entrada.
     *
     * @param entry Encapsula la información de la entrada que se debe de persistir.
     *
     * @return  ID del registro de la entrada
     */
    @Override
    public int saveEntry(UserEntry entry) {
       return this.userEntryDao.insert(entry);
    }



    @Override
    public UserEntry getUserEntry(int entryId) {
        return this.userEntryDao.select(entryId);
    }



    @Override
    public List<UserEntry> getUserEntries(int userId, boolean showDetails) {
        Criterion criterio = new EntradaCriterio(EntradaSearchCriteriaEnum.USUARIO);
        return this.userEntryDao.select(criterio, showDetails, userId);
    }



    @Override
    public List<UserEntry> getUserEntries(String criterion, boolean showDetails) {
        return this.userEntryDao.select(new EntradaCriterio(EntradaSearchCriteriaEnum.TITLE), showDetails, criterion);
    }


    /**
     * Consulta las entradas de todos los usuarios. Para poder controlar la paginación
     * se define el objeto {@link Page} el cual tiene las propiedades adecuadas para
     * realizar el recorrido entre bloques de registros.
     *
     * @param startPage     Indica la página actual de consulta
     * @param showDetails   Indica si los registros deben mostrarse con los detalles,
     *                      en este caso muestra la entrada completa cuando el valor
     *                      de éste parametro es {@code true}
     *
     * @return  Página de las entradas consultadas
     */
    @Override
    @Cacheable("getAllUserEntries")
	public Page<UserEntry> getAllUserEntries(int startPage, boolean showDetails) {
		return this.userEntryDao.selectAll(startPage, showDetails);
	}


    /**
     * @param date  Fecha de la cual se obtiene el mes para calcular su último dia
     *
     * @return  Número de dias en el mes que viene representando el ultimo dia
     */
    @Override
    public int getLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);

        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);

        return calendar.get(Calendar.DATE);
    }


    /**
     * @param date  Fecha de la que se obtiene el primer dia de la semana
     *
     * @return  Posision en la semana del primer dia. Por default la posision 1
     *          Corresponde a Domingo, siendo 7 el valor del Sábado
     */
    public int getFirstDayPosition(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        return calendar.get(Calendar.DAY_OF_WEEK);
    }


    /**
     * Invoca al repositorio de datos en busca de los dias en los que se haya realizado una publicación
     *
     * @param date  Fecha de la cual se consultan los dias en los que se ha publicado alguna entrada
     *
     * @return  Dias en los cuales se encontró al menos una publicación
     */
    @Override
    public List<Integer> getWhichDaysHasEntries(Date date) {
        return this.userEntryDao.selectWhichDaysHasEntries(date);
    }
}
