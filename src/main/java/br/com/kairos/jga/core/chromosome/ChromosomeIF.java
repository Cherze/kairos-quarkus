/*
 * ChromosomeIF.java
 *
 * Created on 30 de Abril de 2006, 12:55
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.jga.core.chromosome;

import br.com.kairos.jga.core.genes.GeneIF;


/*Estrutura de um cromossomo*/
public interface ChromosomeIF extends Cloneable{
    void setFitnessValue(float fitnessValue);
    float getFitnessValue();
    void resetFitnessValue();
    int size();
    GeneIF getGene(int index);
    GeneIF[] getGenes();
    void setGene(GeneIF gene, int index);
    void setValidation(boolean valor);
    boolean getValidation();
    ChromosomeIF getRandom();
    Object clone();
}
