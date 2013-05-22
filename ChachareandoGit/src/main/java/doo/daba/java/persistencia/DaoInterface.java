package doo.daba.java.persistencia;



import doo.daba.java.beans.ImagenBean;
import doo.daba.java.persistencia.criterio.CriterioConsulta;

import java.util.List;



/**
 * Define la el comoportamiento que deben cumplir las clases DAO de esta aplicacion.
 *
 * @since 24/08/1012
 * @author Gerardo Aquino
 */
public interface DaoInterface<T> {

	int insert(T elemento);



	T select(int id);



	List<T> select(CriterioConsulta criterio, boolean mostrarDetalle, Object ... parametros);



	List<T> selectAll(boolean mostrarDetalle);



	int update(T elemento);



	int delete(T elemento);
}
