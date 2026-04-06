/*
 * cromossomo.java
 *
 * Created on 2 de Setembro de 2006, 13:52
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.timetabling.cromossomo;
 
import br.com.kairos.jga.core.chromosome.samples.IntegerChromosome;
import br.com.kairos.jga.core.genes.IntegerGene;
import br.com.kairos.jga.core.chromosome.ChromosomeIF;
import br.com.kairos.timetabling.flyweight.*;


public class CromossomoHorario extends IntegerChromosome{
    
    
    public CromossomoHorario(int size, int qtdDisciplina) {
        super(size,qtdDisciplina);
        
    }
    
    public ChromosomeIF getRandom() {
        CromossomoHorario cromossomoRandom = new CromossomoHorario(this.size(), this.getRangeValue());
        for(int i = 0; i < cromossomoRandom.size(); i++)
            cromossomoRandom.setGene(FlyIntFactory.getFlyIntFactory().getFlyIntegerWithRange(this.getRangeValue()), i);
        return cromossomoRandom;
    }
    
    
}
