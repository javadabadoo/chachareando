package doo.daba.java.persistencia.mapeo;

import doo.daba.java.beans.UsuarioBean;
import doo.daba.java.beans.EntradaBean;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: java_daba_doo
 * Date: 4/6/13
 * Time: 3:03 PM
 * To change this template use File | Settings | File Templates.
 */
@AllArgsConstructor
public class MapeoEntrada implements RowMapper<EntradaBean> {

    @Getter @Setter
    private boolean mostrarDetalle;

    public EntradaBean mapRow(ResultSet rs, int i) throws SQLException {

        EntradaBean entradaBean = new EntradaBean();

        entradaBean.setId(rs.getInt("entrada"));
        entradaBean.setTitulo(rs.getString("titulo"));
        entradaBean.setEstado(rs.getString("estado"));
        entradaBean.setIdUsuario(rs.getInt("id_usuario"));

        if (mostrarDetalle) {
            entradaBean.setContenido(rs.getString("contenido"));
            entradaBean.setFechaPublicacion(rs.getDate("fecha_de_creacion"));
            entradaBean.setFechaModificacion(rs.getDate("fecha_de_modificacion"));
        }

        return entradaBean;
    }

}
