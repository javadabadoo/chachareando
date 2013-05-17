package doo.daba.java.persistencia;

import doo.daba.java.beans.EntradaBean;
import doo.daba.java.persistencia.mapeo.MapeoEntrada;
import doo.daba.java.util.Propiedades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: java_daba_doo
 * Date: 4/6/13
 * Time: 3:15 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class EntradaDao extends JdbcDaoSupport implements EntradaInterfaceDao {

    @Autowired
    private DataSource dataSource;



    @PostConstruct
    void init() {
        setDataSource(dataSource);
    }


    /**
     * Registra una publicación al repositorio de datos
     *
     * @param entrada   Encapsula la información del registro de entrada
     *
     * @return  ID generado por el registro
     */
    @Override
    public int insert(EntradaBean entrada) {
        int id =  super.getJdbcTemplate().queryForObject(
                Propiedades.obtener("sql.registro.entrada"),
                Integer.class,
                entrada.getTitulo(),
                entrada.getFechaPublicacion(),
                entrada.getFechaModificacion(),
                entrada.getEstado(),
                entrada.getContenido(),
                entrada.getIdUsuario()
        );

        entrada.setId(id);
        return id;
    }


    /**
     * Obtiene un registro de entrada segun el ID indicado en el parámetro
     *
     * @param id   IDentificador del registro
     *
     * @return  Registro de entrada encapuslado en el objeto {@code EntradaBean}
     */
    @Override
    public EntradaBean select(int id) {

        return super.getJdbcTemplate().queryForObject(
                Propiedades.obtener("sql.consulta.entrada"),
                new MapeoEntrada(true),
                id
        );

    }


    /**
     * Obtiene todas las entradas del usuario del cual su identificador en la DB sea
     * el definido en el parametro {@code idUsuario}
     *
     * @param idUsuario         Identificador del usuario del cual se obtienen las entradas
     * @param mostrarDetalle    Indica si debe mostrarse la información completa del
     *                          registro de entrada o solo se muestra el resumen
     *
     * @return  Lista de entradas asociadas al usuario
     */
    @Override
    public List<EntradaBean> select(Object idUsuario, boolean mostrarDetalle) {

        return super.getJdbcTemplate().query(
                Propiedades.obtener("sql.consulta.entrada.historial.usuario"),
                new MapeoEntrada(true),
                idUsuario);

    }


    /**
     * Obtiene todas las entradas registradas de todos los usuarios
     *
     * @param mostrarDetalle    Indica si debe mostrarse la información completa del
     *                          registro de entrada o solo se muestra el resumen
     *
     * @return  Lista de entradas
     */
    @Override
    public List<EntradaBean> selectAll(boolean mostrarDetalle) {

        return super.getJdbcTemplate().query(
                Propiedades.obtener("sql.consulta.entrada.historial"),
                new MapeoEntrada(true));
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
