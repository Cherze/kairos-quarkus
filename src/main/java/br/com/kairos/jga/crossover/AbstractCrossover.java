/*
 * AbstractCrossover.java
 *
 * Created on 30 de Abril de 2006, 22:39
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.jga.crossover;

import br.com.kairos.jga.core.chromosome.ChromosomeIF;
import br.com.kairos.jga.core.chromosome.DefaultPopulation;
import br.com.kairos.jga.core.chromosome.PopulationIF;
import br.com.kairos.timetabling.controle.ParametrosGA;

import java.util.Random;


public abstract class AbstractCrossover implements CrossoverIF{
    ParametrosGA parametro=new ParametrosGA();
    /** Creates a new instance of AbstractCrossover */
    public AbstractCrossover() {
    }

    public PopulationIF makeOffspring(PopulationIF population, int size) {
        DefaultPopulation newPop = new DefaultPopulation();
        Random parents = new Random();
        
        int x = 0;
        population.sort();
        while(x < (population.size()*parametro.getNumeroElitismo())){
            newPop.addChromosome(population.getChromosome(x));
            x++;
        }    
        while(newPop.size() < parametro.getPopulationSize()){
            ChromosomeIF parentA = (ChromosomeIF) population.getSomeChromosome().clone();
            ChromosomeIF parentB = (ChromosomeIF) population.getSomeChromosome().clone();
            this.crossover(parentA, parentB);
            newPop.addChromosome(parentA);
            if(newPop.size() > parametro.getPopulationSize()) 
                continue;
            newPop.addChromosome(parentB);
        }
        return newPop;
    }

    protected abstract void crossover(ChromosomeIF parentA, ChromosomeIF parentB);
    
    
}
