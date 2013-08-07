package doo.daba.java.persistence;



import doo.daba.java.persistence.criteria.Criterion;
import doo.daba.java.persistence.paginator.Page;

import java.util.List;



/**
 * Define la el comoportamiento que deben cumplir las clases DAO de esta aplicacion.
 *
 * @since 24/08/1012
 * @author Gerardo Aquino
 */
public interface DaoInterface<T> {

	int insert(T element);



	T select(int id);



	List<T> select(Criterion criterio, boolean showDetails, Object ... params);



	Page<T> selectAll(int currentPage, boolean showDetails);



	int update(T element);



	int delete(T element);
}
