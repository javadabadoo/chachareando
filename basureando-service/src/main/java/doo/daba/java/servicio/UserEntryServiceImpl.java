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
}
