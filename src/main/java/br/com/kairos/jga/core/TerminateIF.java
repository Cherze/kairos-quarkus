/*
 * TerminateIF.java
 *
 * Created on 30 de Abril de 2006, 15:01
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.jga.core;

import br.com.kairos.jga.core.events.Generation;

  
public interface TerminateIF {

    boolean stop(Generation generation);
    
}
