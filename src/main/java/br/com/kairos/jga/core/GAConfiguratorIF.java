/*
 * GAConfIF.java
 *
 * Created on 30 de Abril de 2006, 13:06
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.jga.core;

import br.com.kairos.jga.core.chromosome.PopulationFactoryIF;
import br.com.kairos.jga.crossover.CrossoverIF;
import br.com.kairos.jga.fitness.FitnessIF;
import br.com.kairos.jga.mutation.MutationIF;
import br.com.kairos.jga.selection.SelectionIF;


public interface GAConfiguratorIF {
    PopulationFactoryIF getPopulationFactory();
    FitnessIF getFitness();
    SelectionIF getSelection();
    CrossoverIF getCrossover();
    MutationIF getMutation();
    TerminateIF getTerminate();
}
