package doo.daba.java.persistencia.criterio.enums;

import doo.daba.java.persistencia.criterio.Criterio;
import doo.daba.java.util.Propiedades;
import lombok.*;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 22/05/13
 */
@AllArgsConstructor
@RequiredArgsConstructor
public enum EntradaCriterioEnum implements Criterio {

    USUARIO(Operador.AND, Propiedades.obtener("sql.tabla.entrada.usuario")),
    TITULO(Operador.AND, Comparador.LIKE, Propiedades.obtener("sql.tabla.entrada.titulo"));

    @NonNull
    @Getter @Setter
    private Operador operador;

    @Getter @Setter
    private Comparador comparador;

    @NonNull
    @Getter @Setter
    private String columna;

    @Getter @Setter
    private boolean sensibleAMayusculas;



    EntradaCriterioEnum(Operador operador, Comparador comparador, String columna) {
        this.operador = operador;
        this.comparador = comparador;
        this.columna = columna;
    }


    @Override
    public String toString() {

        return  String.format(
                " %s %s %s ?",
                this.operador,
                this.getColumna(),
                this.comparador.getComparador());
    }

}
