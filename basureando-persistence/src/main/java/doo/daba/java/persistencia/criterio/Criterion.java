package doo.daba.java.persistencia.criterio;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 22/05/13
 * Time: 04:03 PM
 */
public interface Criterion {

    void addCriterion(SearchCriteria searchCriteria);

    void deleteCriterio(SearchCriteria searchCriteria);

}
