/*
 * NewGenerationEvent.java
 *
 * Created on 7 de Maio de 2006, 12:46
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.jga.core.events;


import br.com.kairos.jga.core.chromosome.PopulationIF;

import java.util.EventObject;


public class NewGenerationEvent extends EventObject{
    
    /** Creates a new instance of NewGenerationEvent */
    public NewGenerationEvent(Generation source) {
        super(source);
    }
    
    public PopulationIF getPopulation(){
        return ((Generation) this.source).getPopulation();
    }
    
    public int getGenNumber(){
        return ((Generation) this.source).getGenNumber();
    }    
    
}
