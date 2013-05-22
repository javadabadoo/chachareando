package doo.daba.java.persistencia.criterio;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 22/05/13
 * Time: 04:01 PM
 */
public class EntradaCriterio implements CriterioConsulta {

    @Getter
    private List<Criterio> criterios;


    public EntradaCriterio(Criterio ... criterios) {
        this.init();
        if(criterios != null) {
            for(Criterio criterio : criterios) this.agregaCriterio(criterio);
        }
    }


    private void init() {
        this.criterios = new ArrayList<Criterio>();
    }

    @Override
    public void agregaCriterio(Criterio criterio) {
        this.criterios.add(criterio);
    }

    @Override
    public void quitaCriterio(Criterio criterio) {
        this.criterios.remove(criterio);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Criterio criterio : this.criterios) {
            sb.append(criterio);
        }

        return sb.toString();
    }
}
