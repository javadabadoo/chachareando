package doo.daba.java.persistencia;



import java.util.List;





/**
 * Define la el comoportamiento que deben cumplir las clases DAO de esta aplicacion.
 *
 * @since 24/08/1012
 * @author Gerardo Aquino
 */
public interface ConsultarDatosDao<T> {
	
	int insert (T elemento);
	
	T select(int id);
	
	List<T> select(T elemento);
	
	List<T> selectAll();
	
	int update (T elemento);
	
}
