/*
 * PopulationFactoryIF.java
 *
 * Created on 30 de Abril de 2006, 12:56
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.jga.core.chromosome;

  
public interface PopulationFactoryIF {
    PopulationIF makePopulation(int size);
}
