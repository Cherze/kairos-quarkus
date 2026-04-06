/*
 * PopulationIF.java
 *
 * Created on 30 de Abril de 2006, 12:52
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.jga.core.chromosome;

import java.util.List;


public interface PopulationIF {
    void addChromosome(ChromosomeIF chromosome);
    ChromosomeIF getChromosome(int index);
    ChromosomeIF getSomeChromosome();
    List getAllChromosomes();
    void sort();
    int size();
    ChromosomeIF getBestChromosome();
}
