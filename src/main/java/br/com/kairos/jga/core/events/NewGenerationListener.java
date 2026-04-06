/*
 * NewGenerationListener.java
 *
 * Created on 7 de Maio de 2006, 12:51
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.jga.core.events;

import java.util.EventListener;

  
public interface NewGenerationListener extends EventListener{

    void notifyNewGeneration(NewGenerationEvent event);

    
}
