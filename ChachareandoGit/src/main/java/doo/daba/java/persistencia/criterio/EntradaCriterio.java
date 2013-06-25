package doo.daba.java.persistencia.criterio;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 22/05/13
 * Time: 04:01 PM
 */
public class EntradaCriterio implements Criterion {

    @Getter
    private List<SearchCriteria> searchCriterias;


    public EntradaCriterio(SearchCriteria... searchCriterias) {
        this.init();
        if(searchCriterias != null) {
            for(SearchCriteria searchCriteria : searchCriterias) this.addCriterion(searchCriteria);
        }
    }


    private void init() {
        this.searchCriterias = new ArrayList<SearchCriteria>();
    }

    @Override
    public void addCriterion(SearchCriteria searchCriteria) {
        this.searchCriterias.add(searchCriteria);
    }

    @Override
    public void deleteCriterio(SearchCriteria searchCriteria) {
        this.searchCriterias.remove(searchCriteria);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (SearchCriteria searchCriteria : this.searchCriterias) {
            sb.append(searchCriteria);
        }

        return sb.toString();
    }
}
