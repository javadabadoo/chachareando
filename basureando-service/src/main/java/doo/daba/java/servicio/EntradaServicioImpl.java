package doo.daba.java.servicio;

import doo.daba.java.beans.EntradaBean;
import doo.daba.java.persistencia.DaoInterface;
import doo.daba.java.persistencia.EntradaDao;
import doo.daba.java.servicio.interfaces.EntradaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 16/05/13
 */
@Service
@Transactional
public class EntradaServicioImpl implements EntradaServicio {


    @Autowired
    DaoInterface<EntradaBean> entradaDao;



    @Override
    public int registrarEntrada(EntradaBean entrada) {
       return this.entradaDao.insert(entrada);
    }



    @Override
    public EntradaBean consultarEntrada(int idEntrada) {
        return this.entradaDao.select(idEntrada);
    }



    @Override
    public List<EntradaBean> consultarEntradasDeUsuario(int idUsuario, boolean mostrarDetalle) {
        return this.entradaDao.select(idUsuario, mostrarDetalle);
    }



    @Override
    public List<EntradaBean> consultarEntradas(boolean mostrarDetalle) {
        return this.entradaDao.selectAll(mostrarDetalle);
    }
}
