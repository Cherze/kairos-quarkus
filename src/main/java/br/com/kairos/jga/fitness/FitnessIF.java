/*
 * FitnessIF.java
 *
 * Created on 30 de Abril de 2006, 13:13
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.jga.fitness;

import br.com.kairos.jga.core.chromosome.PopulationIF;


public interface FitnessIF {
    void evaluate(PopulationIF population);
    
}
