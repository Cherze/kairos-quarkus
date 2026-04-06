/*
 * DefaultPopulation.java
 *
 * Created on 30 de Abril de 2006, 17:35
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.jga.core.chromosome;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Vector;


public class DefaultPopulation implements PopulationIF{
    
    private final Vector chromosomes;
    private Random random = new Random();
    
    public DefaultPopulation(){
      this.chromosomes = new Vector();
      this.random = new Random();
    }
    

    /*Retor o cromossomo da posii  çãi index do vetor de cromossomos*/
    public ChromosomeIF getChromosome(int index) {
        return (ChromosomeIF) this.chromosomes.get(index);
    }

    public List getAllChromosomes() {
        return this.chromosomes;
    }

    /*Ordena a população de acordo em ordem de fitness*/
    public void sort() {
        ChromosomeIF[] chromoArray = (ChromosomeIF[]) (this.chromosomes.toArray(new ChromosomeIF[0]));
        Arrays.sort(chromoArray, new DefaultChromosomeComparator());
        this.chromosomes.clear();
        this.chromosomes.addAll(Arrays.asList(chromoArray));
    }

    public void addChromosome(ChromosomeIF chromosome) {
        chromosomes.add(chromosome);
    }

    public int size() {
        return this.chromosomes.size();
    }

    /*Retorna o melhor cromossomo da população*/
    public ChromosomeIF getBestChromosome() {
        this.sort();
        return this.getChromosome(0);
    }

    /*Retorna um cromossomo aleatório*/
    public ChromosomeIF getSomeChromosome() {
        return this.getChromosome(this.random.nextInt(this.size()));
    }
    

    
}
