package doo.daba.java.servicio;

import doo.daba.java.beans.UserEntry;
import doo.daba.java.persistencia.UserEntryDao;
import doo.daba.java.persistencia.criterio.Criterion;
import doo.daba.java.persistencia.criterio.EntradaCriterio;
import doo.daba.java.persistencia.criterio.enums.EntradaSearchCriteriaEnum;
import doo.daba.java.servicio.interfaces.UserEntryService;
import org.springframework.beans.factory.annotation.Autowired;
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
    UserEntryDao userEntryDao;



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
}
