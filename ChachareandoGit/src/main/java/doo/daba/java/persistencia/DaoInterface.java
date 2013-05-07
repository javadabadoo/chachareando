package doo.daba.java.persistencia;



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



	List<T> select(Object criterio, boolean mostrarDetalle);



	List<T> selectAll();



	int update(T elemento);



	int delete(T elemento);
}
