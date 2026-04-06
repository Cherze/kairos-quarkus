/*
 * JlabelRendererDisponibilidades.java
 *
 * Created on 22 de Novembro de 2006, 21:29
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.timetabling.formulario.tela;

 
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class JlabelRendererDisponibilidades extends JLabel implements TableCellRenderer{
    
    /**
     * Creates a new instance of JlabelRendererDisponibilidades
     */
    public JlabelRendererDisponibilidades() {
    }
    
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int rowIndex, int vColIndex) {
        
        int codigo=Integer.valueOf(value.toString()).intValue();
        if (codigo==0) {
            this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetabling/formulario/icones/NaoPode.png")));
        } else if(codigo==1) {
            this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetabling/formulario/icones/Pode.png")));
        } else if (codigo==2) {
            this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetabling/formulario/icones/Quer.png")));
        }
        setHorizontalAlignment(CENTER);
        return this;
    }
    
    
}
