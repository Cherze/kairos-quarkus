/*
 * CadastroHorario.java
 *
 * Created on 15 de Agosto de 2006, 16:01
 */

package br.com.kairos.timetabling.formulario.tela;
 
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.table.TableColumn;
import br.com.kairos.timetabling.objetos.*;
import br.com.kairos.timetabling.controle.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

public class CadastroHorario extends javax.swing.JDialog {
    private final DefaultTableModel modelTabelaHorario=new DefaultTableModel();
    private final String[] diasPossiveis= {" ","Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado", "Domingo"};
    private final Horario horario;
    String[] dias;
    String[] diasSalvos;
    
    
    public CadastroHorario(ControleHorario controle) {
        initComponents();
        this.setTitle("Horário Semanal");
        this.setBounds(150,150,650,370);
        this.setModal(true);
        this.horario=controle.getHorario();
        jTableHorario.setModel(modelTabelaHorario);
        jTextFieldPeriodos.setEnabled(false);
        if(horario.getDias()!=null){
            jSliderQtdDias.setValue(horario.getDias().length);
            int qtdDias=jSliderQtdDias.getValue();
            modelTabelaHorario.setColumnCount(qtdDias+1);
            dias=new String[qtdDias+1];
            diasSalvos=new String[qtdDias];
            for(int i=0;i<qtdDias+1;i++){
                dias[i]=diasPossiveis[i];
                if(i!=0){
                    diasSalvos[i-1]=diasPossiveis[i];
                }
            }
            modelTabelaHorario.setColumnIdentifiers(dias);
            jTextFieldPeriodos.setText(horario.getPeriodos()+"");
            modelTabelaHorario.setNumRows(horario.getPeriodos());
            for(int i=0;i<modelTabelaHorario.getRowCount();i++){
                modelTabelaHorario.setValueAt(i+1,i,0);
            }
        }else{
            jSliderQtdDias.setValue(0);
            int qtdDias=0;
            modelTabelaHorario.setColumnCount(1);
            dias=new String[1];
            dias[0]=" ";
            modelTabelaHorario.setColumnIdentifiers(dias);
            jTextFieldPeriodos.setText(0+"");
            for(int i=0;i<modelTabelaHorario.getRowCount();i++){
                modelTabelaHorario.setValueAt(i+1,i,0);
            }
        }
    }
    
    
    
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jButtonOK = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableHorario = new javax.swing.JTable();
        jSliderQtdDias = new javax.swing.JSlider();
        jLabelMaisPeriodos = new javax.swing.JLabel();
        jTextFieldPeriodos = new javax.swing.JTextField();
        jLabelMenosPeriodos = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);
        jButtonOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetabling/formulario/icones/salvar.png")));
        jButtonOK.setMaximumSize(new java.awt.Dimension(64, 41));
        jButtonOK.setMinimumSize(new java.awt.Dimension(64, 41));
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetabling/formulario/icones/cancelar.png")));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Hor\u00e1rio"), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 10)));
        jScrollPane2.setFont(new java.awt.Font("Trebuchet MS", 0, 11));
        jTableHorario.setFont(new java.awt.Font("Trebuchet MS", 0, 11));
        jTableHorario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                ""
            }
        ) {
            final Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableHorario.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTableHorario.setCellSelectionEnabled(true);
        jScrollPane2.setViewportView(jTableHorario);

        jSliderQtdDias.setFont(new java.awt.Font("Tahoma", 0, 10));
        jSliderQtdDias.setMajorTickSpacing(1);
        jSliderQtdDias.setMaximum(7);
        jSliderQtdDias.setPaintLabels(true);
        jSliderQtdDias.setSnapToTicks(true);
        jSliderQtdDias.setValue(0);
        jSliderQtdDias.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jSliderQtdDiasMouseDragged(evt);
            }
        });
        jSliderQtdDias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSliderQtdDiasMouseClicked(evt);
            }
        });

        jLabelMaisPeriodos.setFont(new java.awt.Font("Trebuchet MS", 0, 11));
        jLabelMaisPeriodos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMaisPeriodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetabling/formulario/icones/addPeriodo.png")));
        jLabelMaisPeriodos.setToolTipText("Adicionar Per\u00edodo");
        jLabelMaisPeriodos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMaisPeriodosMouseClicked(evt);
            }
        });

        jTextFieldPeriodos.setFont(new java.awt.Font("Tahoma", 0, 10));
        jTextFieldPeriodos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldPeriodos.setText("0");

        jLabelMenosPeriodos.setFont(new java.awt.Font("Trebuchet MS", 0, 11));
        jLabelMenosPeriodos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMenosPeriodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetabling/formulario/icones/remPeriodo.png")));
        jLabelMenosPeriodos.setToolTipText("Remover Per\u00edodo");
        jLabelMenosPeriodos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMenosPeriodosMouseClicked(evt);
            }
        });

        jLabel1.setText("Per\u00edodos");

        jLabel2.setText("Dias");

        // --- Configuração do jPanel1 ---
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(63, 63, 63)
                                                .addComponent(jSliderQtdDias, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addComponent(jLabel2)))
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(38, 38, 38)
                                                .addComponent(jLabel1)
                                                .addContainerGap(122, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabelMenosPeriodos)
                                                                .addGap(19, 19, 19)
                                                                .addComponent(jLabelMaisPeriodos, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 13, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jTextFieldPeriodos, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(14, 14, 14)))
                                                .addGap(67, 67, 67))))
                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 587, GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jSliderQtdDias, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jTextFieldPeriodos, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabelMenosPeriodos, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabelMaisPeriodos))))
                                .addContainerGap())
        );

// --- Configuração do Layout do ContentPane ---
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButtonOK, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonOK, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jSliderQtdDiasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSliderQtdDiasMouseClicked
        this.jSliderQtdDiasMouseDragged(evt);
    }//GEN-LAST:event_jSliderQtdDiasMouseClicked
    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed
    
    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        if(modelTabelaHorario.getColumnCount()==1){
            JOptionPane.showMessageDialog(null,"Selecione os dias e os períodos do horário.", "Atenção",2);
        }else{
            horario.setPeriodos(modelTabelaHorario.getRowCount());
            horario.setDias(diasSalvos);
            this.setVisible(false);
        }
    }//GEN-LAST:event_jButtonOKActionPerformed
    
    private void jSliderQtdDiasMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSliderQtdDiasMouseDragged
        jLabelMaisPeriodos.setVisible(true);
        jLabelMenosPeriodos.setVisible(true);
        
        int qtdDias=jSliderQtdDias.getValue();
        modelTabelaHorario.setColumnCount(qtdDias+1);
        dias=new String[qtdDias+1];
        diasSalvos=new String[qtdDias];
        for(int i=0;i<qtdDias+1;i++){
            dias[i]=diasPossiveis[i];
            if(i!=0){
                diasSalvos[i-1]=diasPossiveis[i];
            }
        }
        modelTabelaHorario.setColumnIdentifiers(dias);
        
    }//GEN-LAST:event_jSliderQtdDiasMouseDragged
    
    
    
    private void jLabelMenosPeriodosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMenosPeriodosMouseClicked
        if(modelTabelaHorario.getColumnCount()==1){
            JOptionPane.showMessageDialog(null,"Escolha os dias primeiro.", "Atenção",2);
        }else{
            int periodos=Integer.valueOf(jTextFieldPeriodos.getText()).intValue();
            if(periodos!=0){
                jTextFieldPeriodos.setText(periodos-1+"");
            }else{
                JOptionPane.showMessageDialog(null,"Não é aceito números abaixo de 0.", "Atenção",2);
            }
            modelTabelaHorario.setNumRows(periodos-1);
        }
    }//GEN-LAST:event_jLabelMenosPeriodosMouseClicked
    
    
    private void jLabelMaisPeriodosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMaisPeriodosMouseClicked
        if(modelTabelaHorario.getColumnCount()==1){
            JOptionPane.showMessageDialog(null,"Escolha os dias primeiro.", "Atenção",2);
        }else{
            int periodos=Integer.valueOf(jTextFieldPeriodos.getText()).intValue();
            jTextFieldPeriodos.setText(periodos+1+"");
            modelTabelaHorario.setNumRows(periodos+1);
            modelTabelaHorario.setValueAt(periodos+1,periodos,0);// tem que ser mudado, tem q aparecer o periodo do horario
        }
    }//GEN-LAST:event_jLabelMaisPeriodosMouseClicked
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelMaisPeriodos;
    private javax.swing.JLabel jLabelMenosPeriodos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSlider jSliderQtdDias;
    private javax.swing.JTable jTableHorario;
    private javax.swing.JTextField jTextFieldPeriodos;
    // End of variables declaration//GEN-END:variables
    
}
