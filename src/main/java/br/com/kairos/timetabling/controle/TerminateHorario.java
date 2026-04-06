/*
 * TerminateHorario.java
 *
 * Created on 7 de Novembro de 2006, 16:00
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.timetabling.controle;
 
import br.com.kairos.jga.core.TerminateIF;
import br.com.kairos.jga.core.chromosome.ChromosomeIF;
import br.com.kairos.jga.core.events.Generation;

public class TerminateHorario implements TerminateIF {
    ParametrosGA parametro=new ParametrosGA();
    /** Creates a new instance of TerminateHorario */
    public boolean stop(Generation geracao){
        return geracao.getGenNumber()==parametro.getGeracaoTotal();
    }
}
