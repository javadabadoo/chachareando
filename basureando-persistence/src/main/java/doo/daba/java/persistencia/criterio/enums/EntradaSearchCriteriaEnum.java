package doo.daba.java.persistencia.criterio.enums;

import doo.daba.java.persistencia.criterio.SearchCriteria;
import doo.daba.java.persistencia.criterio.SearchCriteria;
import doo.daba.java.util.PropertiesContainer;
import lombok.*;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 22/05/13
 */
@AllArgsConstructor
@RequiredArgsConstructor
public enum EntradaSearchCriteriaEnum implements SearchCriteria {

    USUARIO(Operator.AND, Comparator.EQUAL, PropertiesContainer.get("sql.tabla.entrada.usuario")),
    TITLE(Operator.AND, Comparator.LIKE, PropertiesContainer.get("sql.tabla.entrada.titulo"));

    @NonNull
    @Getter @Setter
    private Operator operator;

    @Getter @Setter
    private Comparator comparator;

    @NonNull
    @Getter @Setter
    private String columna;

    @Getter @Setter
    private boolean sensibleAMayusculas;



    EntradaSearchCriteriaEnum(Operator operator, Comparator comparator, String columna) {
        this.operator = operator;
        this.comparator = comparator;
        this.columna = columna;
    }


    @Override
    public String toString() {

        return  String.format(
                " %s %s %s",
                this.operator.getOperador(),
                this.getColumna(),
                this.comparator == null ? "" : this.comparator.getComparator()) + " ?";
    }

}
