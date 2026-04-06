package br.com.kairos.timetabling.filter;
 
import java.util.ArrayList;
import java.util.Iterator;
import br.com.kairos.jga.core.chromosome.ChromosomeIF;

public class FilterChain {
    int count=0;
	private final ArrayList myFilters = new ArrayList();
	
	protected float processFilter(ChromosomeIF chromosome){
                count=0;
                float fitness=0;
		FilterIF filter;
		Iterator filters = myFilters.iterator();
		while(filters.hasNext()){
                        count++;
                        filter = (FilterIF)filters.next();
                        fitness += filter.execute(chromosome);
		}
                return fitness;
	}
	
	//@SuppressWarnings("unchecked")
	protected void addFilter(FilterIF filter){
		this.myFilters.add(filter);
	}
	
	protected void removeFilter(int index){
		this.myFilters.remove(index);
	}
}
