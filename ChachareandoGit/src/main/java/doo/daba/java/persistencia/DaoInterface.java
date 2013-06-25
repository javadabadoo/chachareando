package doo.daba.java.persistencia;



import doo.daba.java.persistencia.criterio.Criterion;

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



	List<T> selectAll(boolean showDetails);



	int update(T element);



	int delete(T element);
}
