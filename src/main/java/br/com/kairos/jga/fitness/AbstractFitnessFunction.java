/*
 * AbstractFitnessFunction.java
 *
 * Created on 30 de Abril de 2006, 13:15
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.jga.fitness;

import br.com.kairos.jga.core.chromosome.ChromosomeIF;
import br.com.kairos.jga.core.chromosome.PopulationIF;

import java.util.List;


public abstract class AbstractFitnessFunction implements FitnessIF{
    
    /** Creates a new instance of AbstractFitnessFunction */
    public AbstractFitnessFunction() {
    }

    public void evaluate(PopulationIF population) {
        List chromosomes = population.getAllChromosomes();
        for(int i = 0; i < chromosomes.size(); i++){
            ChromosomeIF chromosome = (ChromosomeIF) chromosomes.get(i);
            this.evaluate(chromosome);        
        }
    }

    private void evaluate(ChromosomeIF chromosome) {
        float fitness = this.getFitnessValue(chromosome);
        chromosome.setFitnessValue(fitness);
    }

    protected abstract float getFitnessValue(ChromosomeIF chromosome);
    
}
