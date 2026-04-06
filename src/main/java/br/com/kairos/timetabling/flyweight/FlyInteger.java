package br.com.kairos.timetabling.flyweight;

 
import br.com.kairos.jga.core.genes.GeneIF;
import br.com.kairos.jga.core.genes.IntegerGene;
public class FlyInteger extends IntegerGene implements GeneIF{

    public Object clone(){
        return this;
    }

    public FlyInteger() {
    	super();
    }
    
    public FlyInteger(int value) {
    	super(value);
    }    
    
    
    public FlyInteger(int rangeValue, boolean withRangeValue) {
        super(rangeValue, withRangeValue);
    }    
    
    public GeneIF getRandom() {
        return FlyIntFactory.getFlyIntFactory().getFlyIntegerWithRange(this.getMaxValue());
    }
    
    
    
}
