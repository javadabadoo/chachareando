package doo.daba.java.persistencia;

import doo.daba.java.beans.EntradaBean;
import doo.daba.java.persistencia.mapeo.MapeoEntrada;
import doo.daba.java.util.Propiedades;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: java_daba_doo
 * Date: 4/6/13
 * Time: 3:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class EntradaDao extends JdbcDaoSupport implements DaoInterface<EntradaBean> {
	
    @Override
    public int insert(EntradaBean imagen) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public EntradaBean select(int id) {

        return super.getJdbcTemplate().queryForObject(
                Propiedades.obtener("sql.consulta.entrada"),
                new Object[]{
                        id
                },
                new MapeoEntrada(false));

    }

    @Override
    public List<EntradaBean> select(Object elemento, boolean mostrarDetalle) {

        return super.getJdbcTemplate().query(
                Propiedades.obtener("sql.consulta.entrada.detalle"),
                new Object[]{
                        elemento
                },
                new MapeoEntrada(true));

    }

    @Override
    public List<EntradaBean> selectAll() {
        return null;
    }

    @Override
    public int update(EntradaBean elemento) {
        return 0;
    }

    @Override
    public int delete(EntradaBean elemento) {
        return 0;
    }
}
