/*
 * TwoPointCrossover.java
 *
 * Created on 18 de Maio de 2006, 10:30
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.jga.crossover;

import br.com.kairos.jga.core.chromosome.ChromosomeIF;
import br.com.kairos.jga.core.genes.GeneIF;

import java.util.Random;


public class TwoPointCrossover extends AbstractCrossover{
    
    /** Creates a new instance of TwoPointCrossover */
    public TwoPointCrossover() {
    }
    
    protected void crossover(ChromosomeIF parentA, ChromosomeIF parentB){
        int pointA = (new Random()).nextInt(parentA.size());
        int pointB = (new Random()).nextInt(parentA.size() - pointA) + pointA;
        for(int i = pointA; i < pointB; i++){
            GeneIF aux = parentA.getGene(i);
            parentA.setGene(parentB.getGene(i),i);
            parentB.setGene(aux,i);
        }
    }
    
    
}
