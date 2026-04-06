/*
 * AbstractMutation.java
 *
 * Created on 30 de Abril de 2006, 22:42
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.jga.mutation;

import br.com.kairos.jga.core.chromosome.ChromosomeIF;
import br.com.kairos.jga.core.chromosome.PopulationIF;

  
public abstract class AbstractMutation implements MutationIF{
    
    /** Creates a new instance of AbstractMutation */
    public AbstractMutation() {
    }
    
    public void mutate(PopulationIF population, float rate) {
        int qtdeMutations = (int) (population.size() * rate);
        for(int i = 0; i < qtdeMutations; i++){
            ChromosomeIF chromosome = population.getSomeChromosome();
            this.mutate(chromosome);
        }
    }

    protected abstract void mutate(ChromosomeIF chromosome);
    
    
}
