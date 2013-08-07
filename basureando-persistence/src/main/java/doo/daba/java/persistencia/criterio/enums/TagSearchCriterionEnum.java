package doo.daba.java.persistencia.criterio.enums;

import doo.daba.java.persistencia.criterio.SearchCriteria;
import doo.daba.java.util.PropertiesContainer;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA.
 * User: java_daba_doo
 * Date: 8/7/13
 * Time: 1:10 AM
 * To change this template use File | Settings | File Templates.
 */
public enum TagSearchCriterionEnum implements SearchCriteria {

	NAME(SearchCriteria.Operator.AND, Comparator.LIKE, PropertiesContainer.get("sql.table.tag.name"));

	@NonNull
	@Getter
	@Setter
	private SearchCriteria.Operator operator;

	@Getter @Setter
	private SearchCriteria.Comparator comparator;

	@NonNull
	@Getter @Setter
	private String columna;

	@Getter @Setter
	private boolean sensibleAMayusculas;



	TagSearchCriterionEnum(SearchCriteria.Operator operator, SearchCriteria.Comparator comparator, String columna) {
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
