/*
 * SwapGene.java
 *
 * Created on 18 de Maio de 2006, 10:42
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.jga.mutation;

import br.com.kairos.jga.core.chromosome.ChromosomeIF;
import br.com.kairos.jga.core.genes.GeneIF;

import java.util.Random;


public class SwapGene extends AbstractMutation{
    
    /** Creates a new instance of SwapGene */
    public SwapGene() {
    }
    
    protected void mutate(ChromosomeIF chromosome) {
        Random random = new Random();
        int lociA = random.nextInt(chromosome.size());
        int lociB = random.nextInt(chromosome.size());
        GeneIF aux = chromosome.getGene(lociA);
        chromosome.setGene(chromosome.getGene(lociB),lociA);
        chromosome.setGene(aux,lociB);
    }    
}
