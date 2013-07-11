package doo.daba.java.servicio.interfaces;

import doo.daba.java.beans.UserEntry;
import doo.daba.java.persistencia.paginator.Page;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 16/05/13
 * Time: 04:34 PM
 */
public interface UserEntryService {

    int saveEntry(UserEntry entry);

    UserEntry getUserEntry(int entryId);

    List<UserEntry> getUserEntries(int userId, boolean showDetails);

	List<UserEntry> getUserEntries(String criterion, boolean showDetails);

    Page<UserEntry> getAllUserEntries(int startPage, boolean showDetails);

    int getLastDayOfMonth(Date date);

    List<Integer> getWhichDaysHasEntries(Date date);

}
