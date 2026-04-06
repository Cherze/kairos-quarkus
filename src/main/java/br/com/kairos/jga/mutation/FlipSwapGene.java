/*
 * FlipSwapGene.java
 *
 * Created on 18 de Maio de 2006, 10:47
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.jga.mutation;

import br.com.kairos.jga.core.chromosome.ChromosomeIF;

import java.util.Random;


public class FlipSwapGene extends AbstractMutation{
    
    private final AbstractMutation[] mutations;
    
    /** Creates a new instance of FlipSwapGene */
    public FlipSwapGene() {
        mutations = new AbstractMutation[2];
        this.mutations[0] = new FlipGene();
        this.mutations[1] = new SwapGene();
    }
    
    protected void mutate(ChromosomeIF chromosome) {
        Random random = new Random();
        this.mutations[random.nextInt(2)].mutate(chromosome);//random.nextInt(2)
    }    
    
}
