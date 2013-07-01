package doo.daba.java.persistencia;

import doo.daba.java.beans.UserEntry;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 16/05/13
 * Time: 04:53 PM
 */
public interface UserEntryDao extends DaoInterface<UserEntry> {

	public List<UserEntry> selectAll(int startPage, boolean showDetails);
}
