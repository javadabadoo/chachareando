package doo.daba.java.persistencia;

import doo.daba.java.beans.UserEntry;
import doo.daba.java.persistencia.paginator.Page;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 16/05/13
 * Time: 04:53 PM
 */
public interface UserEntryDao extends DaoInterface<UserEntry> {

	Page<UserEntry> selectAll(int currentPage, boolean showDetails);

	Page<UserEntry> selectDayEntries(int currentPage, boolean showDetails, Date date);

}
