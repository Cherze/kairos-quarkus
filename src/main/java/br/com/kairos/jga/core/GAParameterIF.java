/*
 * GAParameter.java
 *
 * Created on 30 de Abril de 2006, 13:08
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.jga.core;

  
public interface GAParameterIF {
    int getPopulationSize();
    float getSelectionPercent();
    float getMutationPercent();
}
