/*
 * IntegerChromosome.java
 *
 * Created on 15 de Maio de 2006, 12:10
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.jga.core.chromosome.samples;

import br.com.kairos.jga.core.chromosome.AbstractChromosome;
import br.com.kairos.jga.core.chromosome.ChromosomeIF;
import br.com.kairos.jga.core.genes.IntegerGene;

  
public class IntegerChromosome extends AbstractChromosome{
    
    /** Creates a new instance of IntegerChromosome */
    private int rangeValue;
    private boolean isValid;
            
    public IntegerChromosome(int size) {
        this(size, Integer.MAX_VALUE);
        this.isValid=true;
    }

    public IntegerChromosome(int size, int rangeValue) {
        super(size);//crio o array de genes
        this.setRangeValue(rangeValue);//o valor máximo dos números que serão gerado aleatoriamente
    }


    public ChromosomeIF getRandom() {//geração aleatoria dos genes do cromossomo
        IntegerChromosome random = new IntegerChromosome(this.size(), this.getRangeValue());
        for(int i = 0; i < random.size(); i++)
            random.setGene(new IntegerGene(this.getRangeValue(),true), i);//geneIF, o indice do array de gene que o gene vai ser inserido
        return random;        
    }

    public  AbstractChromosome getNewInstance(){
        return new IntegerChromosome(this.size(), this.getRangeValue());
     }

    public int getRangeValue() {
        return rangeValue;
    }

    public void setRangeValue(int rangeValue) {
        this.rangeValue = rangeValue;
    }
    
    public void setValidation(boolean valor){
        this.isValid=valor;
    }
    
    public boolean getValidation(){
        return isValid;
    }
    
    
    
}
