/*
 * GeneIF.java
 *
 * Created on 30 de Abril de 2006, 15:32
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.jga.core.genes;

  
public interface GeneIF extends Cloneable{
  void setAllele(Object value);
  Object getAllele();
  GeneIF getRandom();
  Object clone();
}
