package doo.daba.java.persistencia.criterio;

import doo.daba.java.util.Propiedades;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 22/05/13
 * Time: 11:13 AM
 */
public interface Criterio {

    @AllArgsConstructor
    enum Operador {
        AND(Propiedades.obtener("sql.criterio.and")),
        OR(Propiedades.obtener("sql.criterio.or"));

        @Getter @Setter
        String operador;
    }

    @AllArgsConstructor
    enum Comparador {
        IGUAL(Propiedades.obtener("sql.comparador.igual")),
        MAYOR(Propiedades.obtener("sql.comparador.mayor")),
        MENOR(Propiedades.obtener("sql.comparador.menor")),
        LIKE(Propiedades.obtener("sql.criterio.like"));

        @Getter @Setter
        String comparador;
    }

}
