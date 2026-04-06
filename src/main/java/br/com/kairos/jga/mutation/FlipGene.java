/*
 * FlipGene.java
 *
 * Created on 30 de Abril de 2006, 22:20
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.jga.mutation;

import br.com.kairos.jga.core.chromosome.ChromosomeIF;

import java.util.Random;


public class FlipGene extends AbstractMutation{
    
    protected void mutate(ChromosomeIF chromosome) {
        Random random = new Random();
        int loci = random.nextInt(chromosome.size());
        chromosome.setGene(chromosome.getGene(loci).getRandom(),loci);
    }

    
}
