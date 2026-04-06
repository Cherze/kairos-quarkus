/*
 * DefaultPopulationFactory.java
 *
 * Created on 30 de Abril de 2006, 17:10
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.jga.core;

import br.com.kairos.jga.core.chromosome.ChromosomeIF;
import br.com.kairos.jga.core.chromosome.DefaultPopulation;
import br.com.kairos.jga.core.chromosome.PopulationFactoryIF;
import br.com.kairos.jga.core.chromosome.PopulationIF;

  
public class DefaultPopulationFactory implements PopulationFactoryIF{
    private final ChromosomeIF sample;
    /** Creates a new instance of DefaultPopulationFactory */
    public DefaultPopulationFactory(ChromosomeIF sample) {
        this.sample = sample;
    }
    
    public PopulationIF makePopulation(int size){
        DefaultPopulation pop = new DefaultPopulation();
        for(int i = 0; i < size ; i++)
            pop.addChromosome(sample.getRandom());
        return pop;
    }

}
