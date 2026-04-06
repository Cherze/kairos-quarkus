package br.com.kairos.timetabling.filter;
 
import br.com.kairos.jga.core.chromosome.ChromosomeIF;

public class FilterManager{
	float fitness;
	FilterChain filterChain = new FilterChain();
	
	public void addFilter(FilterIF filter){
		filterChain.addFilter(filter);
	}
	
	public void removeFilter(int index){
		filterChain.removeFilter(index);
	}
	
	public float processFilter(ChromosomeIF chromosome){
                fitness=0;
		fitness = filterChain.processFilter(chromosome);
                return fitness;
	}
	
}
