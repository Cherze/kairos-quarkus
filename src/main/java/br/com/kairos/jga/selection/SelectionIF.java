/*
 * SelectionIF.java
 *
 * Created on 30 de Abril de 2006, 13:58
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.jga.selection;

import br.com.kairos.jga.core.chromosome.PopulationIF;

  
public interface SelectionIF {
    PopulationIF select(PopulationIF population, float percent);
    
}
