/*
 * JLabelRendererDisciplinasProfessor.java
 *
 * Created on 8 de Maráço de 2007, 14:45
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.timetabling.formulario.tela;

 
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;
import javax.swing.BorderFactory;
import java.awt.Color;
import br.com.kairos.timetabling.controle.ControleHorario;
import br.com.kairos.timetabling.objetos.*;

public class JLabelRendererDisciplinasProfessor extends JLabel implements TableCellRenderer{
    ControleHorario controle;
    Professor professor;
    /** Creates a new instance of JLabelRendererDisciplinasProfessor */
    public JLabelRendererDisciplinasProfessor(ControleHorario controle,Professor professor) {
        this.controle=controle;
        this.professor=professor;
        this.setOpaque(true);
    }
    
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int rowIndex, int vColIndex) {
        JLabel jlabel;
        int codigoGA=Integer.valueOf(value.toString()).intValue();
        if(codigoGA!=0){
            this.setText(controle.getDisciplina(codigoGA).getSigla());
            setToolTipText(controle.getDisciplina(codigoGA).getNome());
            this.setBorder(BorderFactory.createEtchedBorder());
            this.setBackground(controle.getDisciplina(codigoGA).getCor());
        }else{
            this.setText("");
            this.setBorder(BorderFactory.createEtchedBorder());
            this.setBackground(new Color(255,255,255));
                if(professor.getDisponibilidade(vColIndex*table.getRowCount()+rowIndex)==0){
                    this.setBackground(new Color(255,220,220));
                }else{
                    if(professor.getDisponibilidade(vColIndex*table.getRowCount()+rowIndex)==1){
                        this.setBackground(new Color(255,255,220));
                    }else{
                        if(professor.getDisponibilidade(vColIndex*table.getRowCount()+rowIndex)==2){
                            this.setBackground(new Color(220,255,225));
                        }
                    }
                }
        }
        setHorizontalAlignment(CENTER);
        return this;
    }
}
