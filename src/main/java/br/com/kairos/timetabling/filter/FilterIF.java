/*
 * FilterIF.java
 *
 * Created on 30 de Outubro de 2006, 17:28
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.timetabling.filter;
 
import br.com.kairos.jga.core.chromosome.ChromosomeIF;

public interface FilterIF {
	float execute(ChromosomeIF chromosome);
}
