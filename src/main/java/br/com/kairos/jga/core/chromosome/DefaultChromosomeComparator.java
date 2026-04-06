/*
 * DefaultChromosomeComparator.java
 *
 * Created on 30 de Abril de 2006, 15:25
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.jga.core.chromosome;

import java.util.Comparator;

  
public class DefaultChromosomeComparator implements Comparator{
    
    public int compare(Object o1, Object o2) {
        return (int) (((ChromosomeIF) o2).getFitnessValue() - ((ChromosomeIF) o1).getFitnessValue());
    }
    
    
    
}
