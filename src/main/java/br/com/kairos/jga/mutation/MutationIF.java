/*
 * MutationIF.java
 *
 * Created on 30 de Abril de 2006, 14:51
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.jga.mutation;

import br.com.kairos.jga.core.chromosome.PopulationIF;

  
public interface MutationIF {
    void mutate(PopulationIF population, float rate);
}
