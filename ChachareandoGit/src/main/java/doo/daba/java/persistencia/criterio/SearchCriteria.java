package doo.daba.java.persistencia.criterio;

import doo.daba.java.util.PropertiesContainer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 22/05/13
 */
public interface SearchCriteria {

    @AllArgsConstructor
    enum Operator {
        AND(PropertiesContainer.get("sql.criterion.and")),
        OR(PropertiesContainer.get("sql.criterion.or"));

        @Getter @Setter
        String operador;
    }

    @AllArgsConstructor
    enum Comparator {
        EQUAL(PropertiesContainer.get("sql.comparator.igual")),
        LIKE(PropertiesContainer.get("sql.comparator.like")),
        MORE_THAN(PropertiesContainer.get("sql.comparator.mayor")),
        LESS_THAN(PropertiesContainer.get("sql.comparator.menor"));

        @Getter @Setter
        String comparator;
    }

}
