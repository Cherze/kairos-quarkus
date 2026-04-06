/*
 * BestSelection.java
 *
 * Created on 30 de Abril de 2006, 22:52
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.jga.selection;

import br.com.kairos.jga.core.chromosome.DefaultPopulation;
import br.com.kairos.jga.core.chromosome.PopulationIF;

  
public class BestSelection implements SelectionIF{
    
    /** Creates a new instance of BestSelection */
    public BestSelection() {
    }

    public PopulationIF select(PopulationIF population, float rate) {
        int qtdeSelections = (int) (population.size() * rate);
        PopulationIF newPopulation = new DefaultPopulation();
        population.sort();
        for(int i = 0; i < qtdeSelections; i++)
            newPopulation.addChromosome(population.getChromosome(i));
        return newPopulation;
    }
    
}
