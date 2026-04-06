/*
 * AbstractGene.java
 *
 * Created on 7 de Maio de 2006, 14:15
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.jga.core.genes;


public abstract class AbstractGene {
    
    private Object allele;
    
    /** Creates a new instance of CharGene */
    public AbstractGene(Object allele) {
        this.setAllele(allele);
    }
    
    public void setAllele(Object value) {
        this.allele = value;
    }

    public Object getAllele() {
        return this.allele;
    }

    public abstract GeneIF getRandom();
    
    public abstract Object clone();
    
    public String toString(){
        return this.getAllele().toString();
    }    

    
}
