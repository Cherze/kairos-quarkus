/*
 * Generation.java
 *
 * Created on 7 de Maio de 2006, 13:11
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.jga.core.events;

import br.com.kairos.jga.core.chromosome.PopulationIF;

  
public class Generation {
    
    private int genNumber;
    private PopulationIF population;
    
    /** Creates a new instance of Generation */
    public Generation(int genNumber, PopulationIF population) {
        this.setGenNumber(genNumber);
        this.setPopulation(population);
    }

    public int getGenNumber() {
        return genNumber;
    }

    private void setGenNumber(int genNumber) {
        this.genNumber = genNumber;
    }

    public PopulationIF getPopulation() {
        return population;
    }

    private void setPopulation(PopulationIF population) {
        this.population = population;
    }
    
}
