/*
 * CrossoverIF.java
 *
 * Created on 30 de Abril de 2006, 14:43
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.jga.crossover;

import br.com.kairos.jga.core.chromosome.PopulationIF;

  
public interface CrossoverIF {
    PopulationIF makeOffspring(PopulationIF population, int size);
}
