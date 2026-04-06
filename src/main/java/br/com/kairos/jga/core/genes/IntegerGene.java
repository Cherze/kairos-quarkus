/*
 * IntegerGene.java
 *
 * Created on 15 de Maio de 2006, 12:11
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.jga.core.genes;

import java.util.Random;

  
public class IntegerGene extends AbstractGene implements GeneIF{
    
    private int maxValue;
    
    /** Creates a new instance of IntegerGene */
    public IntegerGene(int value) {//Inicia um gene com um valor pre-estipulado
        super(Integer.valueOf(value));
        this.setMaxValue(Integer.MAX_VALUE);
    }
    
    public IntegerGene() {//Inicia um gene aleatoriamente
        this(Integer.valueOf(((new Random()).nextInt())));
    }
    
    public IntegerGene(int rangeValue, boolean withRangeValue) {
        super(Integer.valueOf(((new Random()).nextInt(rangeValue))));
        this.setMaxValue(rangeValue);
    }
    

    public GeneIF getRandom() {
        return new IntegerGene(this.getMaxValue(), true);
    }
    
    public String toString(){
        return this.getAllele().toString();
    }
    
    public Object clone(){
        return new IntegerGene(((Integer)this.getAllele()).intValue());
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }
    
}
