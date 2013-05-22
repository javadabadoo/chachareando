package doo.daba.java.servicio.interfaces;

import doo.daba.java.beans.EntradaBean;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 16/05/13
 * Time: 04:34 PM
 */
public interface EntradaServicio {

    int registrarEntrada(EntradaBean entrada);

    EntradaBean consultarEntrada(int idEntrada);

    List<EntradaBean> consultarEntradasDeUsuario(int idUsuario, boolean mostrarDetalle);

    List<EntradaBean> consultarEntradas(String criterio, boolean mostrarDetalle);


}
