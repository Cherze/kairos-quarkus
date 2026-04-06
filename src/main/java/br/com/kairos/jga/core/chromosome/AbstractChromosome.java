/*
 * AbstractChromosome.java
 *
 * Created on 30 de Abril de 2006, 15:15
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.jga.core.chromosome;

import br.com.kairos.jga.core.genes.GeneIF;


public abstract class AbstractChromosome implements ChromosomeIF{
    
    protected float fitnessValue;
    protected GeneIF[] genes;
    
    /** Creates a new instance of AbstractChromosome */
    public AbstractChromosome(int size) {
        this.genes = new GeneIF[size];
    }
    
    public void setFitnessValue(float fitnessValue){
        this.fitnessValue = fitnessValue;
    }

    public float getFitnessValue(){
        return this.fitnessValue;
    }

    public void resetFitnessValue(){
       this.fitnessValue = Float.NaN; 
    }
    
    public int size(){
      return this.genes.length;  
    }

    public GeneIF getGene(int index){
      return this.genes[index];  
    }

    public GeneIF[] getGenes(){
      return this.genes;  
    }

    public void setGene(GeneIF gene, int index){
      this.genes[index] = gene;  
    }

    public String toString(){
        String rep = "";
        for(int i = 0; i < this.size(); i++)
            rep += this.getGene(i) + " ";
        return rep.substring(0,rep.length()-1);
    }
    
    public Object clone(){
        AbstractChromosome newChromosome = this.getNewInstance(); 
        for(int i = 0; i < newChromosome.size(); i++)
            newChromosome.setGene((GeneIF)(this.getGene(i).clone()), i);
        newChromosome.setFitnessValue(this.getFitnessValue());        
        return newChromosome;
    }    
    
    
    public abstract AbstractChromosome getNewInstance();
    
    
}
