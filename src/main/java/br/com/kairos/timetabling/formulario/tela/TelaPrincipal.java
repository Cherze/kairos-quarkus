/*
 * TelaPrincipal.java
 *
 * Created on 31 de Julho de 2006, 19:01
 */


package br.com.kairos.timetabling.formulario.tela;

import javax.swing.JFileChooser;
import br.com.kairos.jga.core.genes.GeneIF;
import br.com.kairos.jga.core.chromosome.*;
import br.com.kairos.timetabling.controle.*;
import br.com.kairos.timetabling.model.*;

import java.awt.event.MouseEvent;
import java.util.*;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;


public class TelaPrincipal extends javax.swing.JFrame {
    private ControleHorario controle=new ControleHorario();
    private final DefaultTableModel modelTabelaTimetabling = new DefaultTableModel(){
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }};
    private final DefaultTableModel modelTabelaProfessores = new DefaultTableModel();
    private final DefaultListModel modelListaProfessores = new DefaultListModel();
    private final DefaultListModel modelListaSemestres = new DefaultListModel();
    private final ArrayList arrayClipBoard = new ArrayList();
    private List lista=null;
    private final BancoOO banco=new BancoOO();
    
    public TelaPrincipal() {
        initComponents();
        jMenuItemCadastrarDisciplinas.setEnabled(false);
        jMenuItemCadastrarProfessor.setEnabled(false);
        jMenuItemDisponibilidades.setEnabled(false);
        jMenuItemListarDisciplinas.setEnabled(false);
        jTableTimetabling.setCellSelectionEnabled(true);
        jMenuItemSalvarHorarioGerado.setEnabled(false);
        jMenuItemAbrirHorarioSalvo.setEnabled(false);
        jListProfessores.setEnabled(false);
        jListSemestres.setEnabled(false);
    }
    
    
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jToolBar1 = new javax.swing.JToolBar();
        jButtonNovo = new javax.swing.JButton();
        jButtonAbrir = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonImprimir = new javax.swing.JButton();
        jButtonGerarHorario = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jTabbedPaneHorarios = new javax.swing.JTabbedPane();
        jPanelSemestre = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableTimetabling = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListSemestres = new javax.swing.JList();
        jPanelProfessor = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableTimetablingProfessores = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListProfessores = new javax.swing.JList();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuArquivo = new javax.swing.JMenu();
        jMenuItemNovo = new javax.swing.JMenuItem();
        jMenuItemAbrir = new javax.swing.JMenuItem();
        jMenuItemAbrirHorarioSalvo = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuItemSalvar = new javax.swing.JMenuItem();
        jMenuItemSalvarComo = new javax.swing.JMenuItem();
        jMenuItemSalvarHorarioGerado = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JSeparator();
        jMenuItemFechar = new javax.swing.JMenuItem();
        jMenuCadastrar = new javax.swing.JMenu();
        jMenuItemCadastrarHorarios = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JSeparator();
        jMenuItemCadastrarDisciplinas = new javax.swing.JMenuItem();
        jMenuItemCadastrarProfessor = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        jMenuItemDisponibilidades = new javax.swing.JMenuItem();
        jMenuExibir = new javax.swing.JMenu();
        jMenuItemListarDisciplinas = new javax.swing.JMenuItem();
        jMenuSobre = new javax.swing.JMenu();
        jMenuItemSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("KAIR\u00d3S");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetabling/formulario/icones/novo.png")));
        jButtonNovo.setToolTipText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jToolBar1.add(jButtonNovo);
        jButtonNovo.getAccessibleContext().setAccessibleDescription("");

        jButtonAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetabling/formulario/icones/abrir.png")));
        jButtonAbrir.setToolTipText("Abrir");
        jButtonAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbrirActionPerformed(evt);
            }
        });

        jToolBar1.add(jButtonAbrir);

        jButtonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetabling/formulario/icones/salvarHorario.png")));
        jButtonSalvar.setToolTipText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jToolBar1.add(jButtonSalvar);

        jButtonImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetabling/formulario/icones/impressora.png")));
        jButtonImprimir.setToolTipText("Imprimir");
        jButtonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimirActionPerformed(evt);
            }
        });

        jToolBar1.add(jButtonImprimir);

        jButtonGerarHorario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetabling/formulario/icones/GerarHorario.png")));
        jButtonGerarHorario.setToolTipText("Gerar Horario");
        jButtonGerarHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerarHorarioActionPerformed(evt);
            }
        });

        jToolBar1.add(jButtonGerarHorario);

        jTabbedPaneHorarios.setFont(new java.awt.Font("Trebuchet MS", 0, 11));
        jTableTimetabling.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Segunda", "Terca", "Quarta", "Quinta", "Sexta"
            }
        ) {
            final boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTimetabling.setRowSelectionAllowed(false);
        jTableTimetabling.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTableTimetablingMouseMoved(evt);
            }
        });
        jTableTimetabling.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTimetablingMouseClicked(evt);
            }
        });

        jScrollPane5.setViewportView(jTableTimetabling);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Semestres"));
        jListSemestres.setBackground(new java.awt.Color(224, 220, 220));
        jListSemestres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jListSemestresKeyReleased(evt);
            }
        });
        jListSemestres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListSemestresMouseClicked(evt);
            }
        });

        jScrollPane2.setViewportView(jListSemestres);


// --- Início do bloco do jPanel1 ---
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);

        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                                .addContainerGap())
        );

// --- Início do bloco do jPanelSemestre ---
        GroupLayout jPanelSemestreLayout = new GroupLayout(jPanelSemestre);
        jPanelSemestre.setLayout(jPanelSemestreLayout);

        jPanelSemestreLayout.setHorizontalGroup(
                jPanelSemestreLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelSemestreLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jScrollPane5, GroupLayout.PREFERRED_SIZE, 706, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanelSemestreLayout.setVerticalGroup(
                jPanelSemestreLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanelSemestreLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelSemestreLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane5, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                                        .addComponent(jPanel1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        jTabbedPaneHorarios.addTab("Semestre", jPanelSemestre);

        jTableTimetablingProfessores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Segunda", "Terca", "Quarta", "Quinta", "Sexta"
            }
        ) {
            final boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTableTimetablingProfessores);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Professores"));
        jListProfessores.setBackground(new java.awt.Color(224, 220, 220));
        jListProfessores.setFont(new java.awt.Font("Trebuchet MS", 1, 12));
        jListProfessores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListProfessores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jListProfessoresKeyReleased(evt);
            }
        });
        jListProfessores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListProfessoresMouseClicked(evt);
            }
        });

        jScrollPane1.setViewportView(jListProfessores);

        // --- Bloco do jPanel2 ---
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                                .addContainerGap())
        );

// --- Bloco do jPanelProfessor ---
        javax.swing.GroupLayout jPanelProfessorLayout = new javax.swing.GroupLayout(jPanelProfessor);
        jPanelProfessor.setLayout(jPanelProfessorLayout);
        jPanelProfessorLayout.setHorizontalGroup(
                jPanelProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelProfessorLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanelProfessorLayout.setVerticalGroup(
                jPanelProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProfessorLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        jTabbedPaneHorarios.addTab("Professor", jPanelProfessor);

        jTabbedPaneHorarios.getAccessibleContext().setAccessibleName("");

        jMenuBar1.setFont(new java.awt.Font("Trebuchet MS", 0, 8));
        jMenuArquivo.setText("Arquivo");
        jMenuItemNovo.setText("Novo");
        jMenuItemNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNovoActionPerformed(evt);
            }
        });

        jMenuArquivo.add(jMenuItemNovo);

        jMenuItemAbrir.setText("Abrir");
        jMenuItemAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAbrirActionPerformed(evt);
            }
        });

        jMenuArquivo.add(jMenuItemAbrir);

        jMenuItemAbrirHorarioSalvo.setText("Abrir Horario");
        jMenuItemAbrirHorarioSalvo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAbrirHorarioSalvoActionPerformed(evt);
            }
        });

        jMenuArquivo.add(jMenuItemAbrirHorarioSalvo);

        jMenuArquivo.add(jSeparator1);

        jMenuItemSalvar.setText("Salvar");
        jMenuItemSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalvarActionPerformed(evt);
            }
        });

        jMenuArquivo.add(jMenuItemSalvar);

        jMenuItemSalvarComo.setText("Salvar como...");
        jMenuItemSalvarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalvarComoActionPerformed(evt);
            }
        });

        jMenuArquivo.add(jMenuItemSalvarComo);

        jMenuItemSalvarHorarioGerado.setText("Salvar Horario");
        jMenuItemSalvarHorarioGerado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalvarHorarioGeradoActionPerformed(evt);
            }
        });

        jMenuArquivo.add(jMenuItemSalvarHorarioGerado);

        jMenuArquivo.add(jSeparator5);

        jMenuItemFechar.setText("Fechar");
        jMenuItemFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFecharActionPerformed(evt);
            }
        });

        jMenuArquivo.add(jMenuItemFechar);

        jMenuBar1.add(jMenuArquivo);

        jMenuCadastrar.setText("Cadastrar");
        jMenuItemCadastrarHorarios.setText("Cadastrar horários de aulas na semana");
        jMenuItemCadastrarHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastrarHorariosActionPerformed(evt);
            }
        });

        jMenuCadastrar.add(jMenuItemCadastrarHorarios);

        jMenuCadastrar.add(jSeparator4);

        jMenuItemCadastrarDisciplinas.setText("Cadastrar Disciplinas");
        jMenuItemCadastrarDisciplinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastrarDisciplinasActionPerformed(evt);
            }
        });

        jMenuCadastrar.add(jMenuItemCadastrarDisciplinas);

        jMenuItemCadastrarProfessor.setText("Cadastrar Professor");
        jMenuItemCadastrarProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastrarProfessorActionPerformed(evt);
            }
        });

        jMenuCadastrar.add(jMenuItemCadastrarProfessor);

        jMenuCadastrar.add(jSeparator2);

        jMenuItemDisponibilidades.setText("Cadastrar Disponibilidades do Professor");
        jMenuItemDisponibilidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDisponibilidadesActionPerformed(evt);
            }
        });

        jMenuCadastrar.add(jMenuItemDisponibilidades);

        jMenuBar1.add(jMenuCadastrar);

        jMenuExibir.setText("Exibir");
        jMenuItemListarDisciplinas.setText("Disciplinas Cadastradas");
        jMenuItemListarDisciplinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListarDisciplinasActionPerformed(evt);
            }
        });

        jMenuExibir.add(jMenuItemListarDisciplinas);

        jMenuBar1.add(jMenuExibir);

        jMenuSobre.setText("Sobre");
        jMenuItemSobre.setText("Sobre Kairós");
        jMenuItemSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSobreActionPerformed(evt);
            }
        });

        jMenuSobre.add(jMenuItemSobre);

        jMenuBar1.add(jMenuSobre);

        setJMenuBar(jMenuBar1);

        // --- Configuração do Layout do ContentPane ---
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jTabbedPaneHorarios, GroupLayout.PREFERRED_SIZE, 946, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())
                                        .addComponent(jSeparator3, GroupLayout.DEFAULT_SIZE, 966, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jToolBar1, GroupLayout.DEFAULT_SIZE, 966, Short.MAX_VALUE)
                                .addContainerGap())
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jToolBar1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator3, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTabbedPaneHorarios, GroupLayout.PREFERRED_SIZE, 449, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jListProfessoresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jListProfessoresKeyReleased
        this.montaTabelaProfessores();
    }//GEN-LAST:event_jListProfessoresKeyReleased

    private void jListSemestresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jListSemestresKeyReleased
        this.montaTabelaSemestres();
    }//GEN-LAST:event_jListSemestresKeyReleased
    
    private void jTableTimetablingMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTimetablingMouseMoved
        int linhaSelecionada=jTableTimetabling.getSelectedRow();
        int colunaSelecionada=jTableTimetabling.getSelectedColumn();
        int linha=jTableTimetabling.rowAtPoint(evt.getPoint());
        int coluna=jTableTimetabling.columnAtPoint(evt.getPoint());
        if(jTableTimetabling.isCellSelected(linhaSelecionada,colunaSelecionada)){
            jTableTimetabling.setColumnSelectionInterval(coluna,coluna);
            jTableTimetabling.setRowSelectionInterval(linha,linha);
        }
    }//GEN-LAST:event_jTableTimetablingMouseMoved
    
    private void jMenuItemAbrirHorarioSalvoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAbrirHorarioSalvoActionPerformed
        String nomeArquivoHorario=null;
        try{
            JFileChooser abrirArquivoHorario=new JFileChooser();
            abrirArquivoHorario.showOpenDialog(this);
            nomeArquivoHorario=abrirArquivoHorario.getSelectedFile().getName();
            banco.setNomeArquivoHorario(nomeArquivoHorario);
            lista=new ArrayList();
            lista.add(0,banco.restaurarHorario());
            ChromosomeIF cromossomoBest = (ChromosomeIF)lista.get(0);
            System.out.println("FITNESS: "+cromossomoBest.getFitnessValue()+" ----> "+ cromossomoBest);
            this.construirTabela();
        }catch(Exception e){
            if(nomeArquivoHorario!=null)
            JOptionPane.showMessageDialog(this, "Não foi possível restaurar um horário do arquivo "+banco.getNomeArquivoHorario()+".", "Mensagem", 1, new ImageIcon(getClass().getResource("/timetabling/formulario/icones/pare.png")));
        }
    }//GEN-LAST:event_jMenuItemAbrirHorarioSalvoActionPerformed
    
    private void jMenuItemSalvarHorarioGeradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalvarHorarioGeradoActionPerformed
        try{
            ChromosomeIF cromossomoBest = (ChromosomeIF)lista.get(0);
            JFileChooser salvarArquivoHorario=new JFileChooser();
            salvarArquivoHorario.showSaveDialog(this);
            String nomeArquivoHorario=salvarArquivoHorario.getName(salvarArquivoHorario.getSelectedFile());
            banco.setNomeArquivoHorario(nomeArquivoHorario);
            banco.salvarHorario(cromossomoBest);
            JOptionPane.showMessageDialog(this, "Horário gerado foi salvo no atual arquivo "+banco.getNomeArquivoHorario()+".", "Mensagem", 1, new ImageIcon(getClass().getResource("/timetabling/formulario/icones/atencao.png")));
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Não foi possível salvar o horário no arquivo "+banco.getNomeArquivoHorario()+".", "Mensagem", 1, new ImageIcon(getClass().getResource("/timetabling/formulario/icones/pare.png")));
        }
    }//GEN-LAST:event_jMenuItemSalvarHorarioGeradoActionPerformed
    
    private void jListSemestresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListSemestresMouseClicked
        this.montaTabelaSemestres();
    }//GEN-LAST:event_jListSemestresMouseClicked
    
    private void jButtonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimirActionPerformed
        Imprimir imprime=new Imprimir();
        imprime.imprime(controle,jTableTimetabling);
    }//GEN-LAST:event_jButtonImprimirActionPerformed
    
    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        controle=null;
        banco.setNomeArquivoBanco("");
        System.gc();
        controle=new ControleHorario();
        jMenuItemCadastrarDisciplinas.setEnabled(false);
        jMenuItemCadastrarProfessor.setEnabled(false);
        jMenuItemDisponibilidades.setEnabled(false);
        jMenuItemListarDisciplinas.setEnabled(false);
        jMenuItemSalvarHorarioGerado.setEnabled(false);
        jMenuItemAbrirHorarioSalvo.setEnabled(false);
        modelTabelaTimetabling.setColumnCount(0);
        modelTabelaTimetabling.setNumRows(0);
        modelTabelaTimetabling.setColumnIdentifiers(controle.getHorario().getDias());
        modelListaSemestres.removeAllElements();
        modelListaProfessores.removeAllElements();
        modelTabelaProfessores.setColumnCount(0);
        modelTabelaProfessores.setNumRows(0);
        modelTabelaProfessores.setColumnIdentifiers(controle.getHorario().getDias());
        this.setTitle("Kairós - Geração Automática de Horários Acadêmicos");
        
    }//GEN-LAST:event_jButtonNovoActionPerformed
    
    private void jMenuItemSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSobreActionPerformed
        JOptionPane.showMessageDialog(this,"Kairós - Geração Automática de Horários Acadêmicos.\nImplementado por: Cherze C. Freitas \nTrabalho de conclusão do curso de Bacharelado em Ciências da Computação.\n\nFaculdade Ruy Barbosa. 2006-2007\nCopyright 2007 \n\n* Kairós, em grego, significa 'momento oportuno'","Sobre Kairós",1,new javax.swing.ImageIcon(getClass().getResource("/timetabling/formulario/icones/info.png")));
    }//GEN-LAST:event_jMenuItemSobreActionPerformed
    
    private void jMenuItemAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAbrirActionPerformed
        this.jButtonAbrirActionPerformed(evt);
    }//GEN-LAST:event_jMenuItemAbrirActionPerformed
    
    private void jMenuItemSalvarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalvarComoActionPerformed
        try{
            JFileChooser salvarArquivo=new JFileChooser();
            salvarArquivo.showSaveDialog(this);
            String nomeArquivo=salvarArquivo.getName(salvarArquivo.getSelectedFile());
            banco.setNomeArquivoBanco(nomeArquivo);
            banco.salvarDados(controle);
            this.setTitle("Kairós - Geração Automática de Horários Acadêmicos"+" .::. "+nomeArquivo);
        }catch(Exception e){}
    }//GEN-LAST:event_jMenuItemSalvarComoActionPerformed
    
    private void jMenuItemSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalvarActionPerformed
        this.jButtonSalvarActionPerformed(evt);
    }//GEN-LAST:event_jMenuItemSalvarActionPerformed
    
    private void jMenuItemListarDisciplinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListarDisciplinasActionPerformed
        ListarDisciplinas listaDisciplinas= new ListarDisciplinas(controle);
        listaDisciplinas.setVisible(true);
    }//GEN-LAST:event_jMenuItemListarDisciplinasActionPerformed
    
    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        try{
            if(banco.getNomeArquivoBanco()!=""){
                banco.salvarDados(controle);
            }else{
                JFileChooser salvarArquivo=new JFileChooser();
                salvarArquivo.showSaveDialog(this);
                String nomeArquivo=salvarArquivo.getName(salvarArquivo.getSelectedFile());
                banco.setNomeArquivoBanco(nomeArquivo);
                banco.salvarDados(controle);
                this.setTitle("Kairós - Geração Automática de Horários Acadêmicos"+" .::. "+nomeArquivo);
            }
        }catch(Exception e){}
    }//GEN-LAST:event_jButtonSalvarActionPerformed
    
    private void jTableTimetablingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTimetablingMouseClicked
        if(jTableTimetabling.isEnabled()){
            int linha = jTableTimetabling.rowAtPoint(evt.getPoint());
            int coluna = jTableTimetabling.columnAtPoint(evt.getPoint());
            
            ArrayList arrayChoqueDisciplinas = (ArrayList)jTableTimetabling.getValueAt(linha, coluna);
            if(arrayChoqueDisciplinas.size() <= 1) {
                if(arrayChoqueDisciplinas.isEmpty() && arrayClipBoard.isEmpty() ){
                    ArrayList disciplinas=new ArrayList();
                    for(int i=0;i<controle.getTodasDisciplinas().size();i++){
                        Disciplina disciplina=(Disciplina)controle.getTodasDisciplinas().get(i);
                        if(disciplina.getSemestre().equals(jListSemestres.getSelectedValue())){
                            disciplinas.add(disciplina.getNome());
                        }
                    }
                    try{
                        String incluirDisciplina = JOptionPane.showInputDialog(this,"Selecione a disciplina a ser incluída:","Disciplinas",JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("/timetabling/formulario/icones/atencao.png")),disciplinas.toArray(),disciplinas.get(0)).toString();
                        this.incluirDisciplinaEmHorarioVazio(controle.getDisciplina(incluirDisciplina).getCodigoGA(),linha,coluna);
                    }catch(Exception e){
                        jTableTimetabling.clearSelection();
                    }
                } else{
                    if(evt.getButton()== MouseEvent.BUTTON3){
                        if(0==JOptionPane.showConfirmDialog(this,"Deseja excluir a disciplina selecionada do horário gerado?","Excluir Disciplina",0,2,new javax.swing.ImageIcon(getClass().getResource("/timetabling/formulario/icones/atencao.png")))){
                            int codigoGAExcluirDisciplina = Integer.valueOf(arrayChoqueDisciplinas.get(0).toString()).intValue();
                            this.excluirDisciplinaDoHorario(codigoGAExcluirDisciplina,linha,coluna);
                        }else{
                            jTableTimetabling.clearSelection();
                        }
                    }else{
                        this.trocaPosicaoDisciplinas(arrayChoqueDisciplinas,linha,coluna,0);
                    }
                }
            } else {
                if(arrayClipBoard.isEmpty()){
                    ArrayList disciplinasEmChoque=new ArrayList();
                    for(int i=0;i<arrayChoqueDisciplinas.size();i++){
                        int codigoGA = Integer.valueOf(arrayChoqueDisciplinas.get(i).toString()).intValue();
                        disciplinasEmChoque.add(controle.getDisciplina(codigoGA).getNome());
                    }
                    try{
                        String disciplinaEmChoqueEscolhida = JOptionPane.showInputDialog(this,"Selecione a disciplina a ser deslocada:","Disciplinas em Conflito de Horario",JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("/timetabling/formulario/icones/atencao.png")),disciplinasEmChoque.toArray(),disciplinasEmChoque.get(0)).toString();
                        int posicaoArrayChoqueDisciplinas=disciplinasEmChoque.indexOf(disciplinaEmChoqueEscolhida);
                        this.trocaPosicaoDisciplinas(arrayChoqueDisciplinas,linha,coluna,posicaoArrayChoqueDisciplinas);
                    }catch(Exception e){
                        jTableTimetabling.clearSelection();
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Escolha um horario sem conflitos.", "Mensagem", 1, new ImageIcon(getClass().getResource("/timetabling/formulario/icones/pare.png")));
                }
            }
        }
    }//GEN-LAST:event_jTableTimetablingMouseClicked
    
    private void jListProfessoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListProfessoresMouseClicked
        this.montaTabelaProfessores();       
    }//GEN-LAST:event_jListProfessoresMouseClicked
    
    private void jButtonAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbrirActionPerformed
        String nomeArquivo=null;
        try{
            JFileChooser abrirArquivo=new JFileChooser();
            abrirArquivo.showOpenDialog(this);
            nomeArquivo=abrirArquivo.getSelectedFile().getName();
            banco.setNomeArquivoBanco(nomeArquivo);
            controle=banco.restaurarBaseDados();
            jMenuItemCadastrarDisciplinas.setEnabled(true);
            jMenuItemCadastrarProfessor.setEnabled(true);
            jMenuItemDisponibilidades.setEnabled(true);
            jMenuItemListarDisciplinas.setEnabled(true);
            jMenuItemAbrirHorarioSalvo.setEnabled(true);
            this.setTitle("Kairos - Geracao Automatica de Horarios Academicos"+" .::. "+nomeArquivo);
        }catch(Exception e){
            if (nomeArquivo!=null)
                JOptionPane.showMessageDialog(this,"Arquivo inexistente.","Mensagem",1,new javax.swing.ImageIcon(getClass().getResource("/timetabling/formulario/icones/pare.png")));
        }
    }//GEN-LAST:event_jButtonAbrirActionPerformed
    
    private void jButtonGerarHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerarHorarioActionPerformed
        try{
            final RunAG run=new RunAG(controle);
            final BarraDeProgresso progresso=new BarraDeProgresso();
            Thread t = new Thread( new Runnable() {
                public void run() {
                    Date tempo=new Date();
                    int horaInicial=tempo.getHours();
                    int minutoInicial=tempo.getMinutes();
                    int segundoInicial=tempo.getSeconds();
                    progresso.setTempoInicial(horaInicial+":"+minutoInicial+":"+segundoInicial);
                    lista=run.iniciarAG(progresso);
                    Date tempo2=new Date();
                    int hora=tempo2.getHours();
                    int minuto=tempo2.getMinutes();
                    int segundo=tempo2.getSeconds();
                    progresso.setTempoFinal(hora+":"+minuto+":"+segundo);
                    try {
                        Thread.sleep(300);
                    } catch( Exception e ) {
                    }finally{
                        progresso.setProgressBarValue(100);
                        construirTabela();
                    }
                }
            });
            t.start();
            progresso.setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"Algum passo do cadastro dos dados nao foi cumprido.\n Favor conferir e tentar outra vez.","Mensagem",1,new javax.swing.ImageIcon(getClass().getResource("/timetabling/formulario/icones/pare.png")));
        }
    }//GEN-LAST:event_jButtonGerarHorarioActionPerformed
    
    private void jMenuItemDisponibilidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDisponibilidadesActionPerformed
        CadastroDisponibilidadesProfessor cadDisProf=new CadastroDisponibilidadesProfessor(controle);
        cadDisProf.setVisible(true);
    }//GEN-LAST:event_jMenuItemDisponibilidadesActionPerformed
    
    private void jMenuItemCadastrarProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastrarProfessorActionPerformed
        try{
            controle.cadastrarProfessor(JOptionPane.showInputDialog(this,"Informe o nome do professor.","Cadastrar Professor",1,new javax.swing.ImageIcon(getClass().getResource("/timetabling/formulario/icones/atencao.png")),null,null).toString());
        }catch(Exception e){}
    }//GEN-LAST:event_jMenuItemCadastrarProfessorActionPerformed
    
    private void jMenuItemCadastrarDisciplinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastrarDisciplinasActionPerformed
        CadastroDisciplinas cadDis=new CadastroDisciplinas(controle);
        cadDis.setVisible(true);
        jMenuItemDisponibilidades.setEnabled(true);
        jMenuItemListarDisciplinas.setEnabled(true);
    }//GEN-LAST:event_jMenuItemCadastrarDisciplinasActionPerformed
    
    private void jMenuItemCadastrarHorariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastrarHorariosActionPerformed
        CadastroHorario cadHor= new CadastroHorario(controle);
        cadHor.setVisible(true);
        if(controle.getHorario()!=null){
            jMenuItemCadastrarDisciplinas.setEnabled(true);
            jMenuItemCadastrarProfessor.setEnabled(true);
        }
    }//GEN-LAST:event_jMenuItemCadastrarHorariosActionPerformed
    
    private void jMenuItemFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFecharActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItemFecharActionPerformed
    
    private void jMenuItemNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNovoActionPerformed
        this.jButtonNovoActionPerformed(evt);
    }//GEN-LAST:event_jMenuItemNovoActionPerformed
    
    public void incluirDisciplinaEmHorarioVazio(int codigoGA, int linha, int coluna){
        GeneIF gene1;
        ChromosomeIF cromossomoBest = (ChromosomeIF)lista.get(0);
        Disciplina disciplinaPrimeiroClick = controle.getDisciplina(codigoGA);
        Professor professorDisciplinaPrimeiroClick = controle.getProfessor(disciplinaPrimeiroClick.getNomeProfessor());
        if(professorDisciplinaPrimeiroClick.getDisponibilidade(coluna * jTableTimetabling.getRowCount() + linha) != 0) {
            ArrayList arrayChoqueDisciplinas=new ArrayList();
            arrayChoqueDisciplinas.add(codigoGA);
            jTableTimetabling.setValueAt(arrayChoqueDisciplinas, linha, coluna);
            int posicaoPrimeiroProfessorNoCromossomo=controle.getOrdemProfessorNoCromossomo(professorDisciplinaPrimeiroClick.getNome());
            gene1=cromossomoBest.getGene((coluna*jTableTimetabling.getRowCount()+linha)+posicaoPrimeiroProfessorNoCromossomo*controle.getQtdHorario());
            gene1.setAllele(codigoGA);
            cromossomoBest.setGene(gene1,(coluna*jTableTimetabling.getRowCount()+linha)+posicaoPrimeiroProfessorNoCromossomo*controle.getQtdHorario());
            jTableTimetabling.clearSelection();
        }else{
            JOptionPane.showMessageDialog(this, "Horario indisponivel ao professor da disciplina escolhida", "Mensagem", 1, new ImageIcon(getClass().getResource("/timetabling/formulario/icones/pare.png")));
            jTableTimetabling.clearSelection();
        }
    }
    public void excluirDisciplinaDoHorario(int codigoGA, int linha, int coluna){
        GeneIF gene1;
        ChromosomeIF cromossomoBest = (ChromosomeIF)lista.get(0);
        Disciplina disciplinaPrimeiroClick = controle.getDisciplina(codigoGA);
        Professor professorDisciplinaPrimeiroClick = controle.getProfessor(disciplinaPrimeiroClick.getNomeProfessor());
        ArrayList arrayChoqueDisciplinas=new ArrayList();
        jTableTimetabling.setValueAt(arrayChoqueDisciplinas, linha, coluna);
        int posicaoPrimeiroProfessorNoCromossomo=controle.getOrdemProfessorNoCromossomo(professorDisciplinaPrimeiroClick.getNome());
        gene1=cromossomoBest.getGene((coluna*jTableTimetabling.getRowCount()+linha)+posicaoPrimeiroProfessorNoCromossomo*controle.getQtdHorario());
        gene1.setAllele(0);
        cromossomoBest.setGene(gene1,(coluna*jTableTimetabling.getRowCount()+linha)+posicaoPrimeiroProfessorNoCromossomo*controle.getQtdHorario());
        jTableTimetabling.clearSelection();
        
    }
    
    public void trocaPosicaoDisciplinas(ArrayList arrayChoqueDisciplinas, int linha, int coluna,int posicaoArrayChoqueDisciplinas){
        GeneIF gene1,gene2;
        int disciplina = 0;
        ChromosomeIF cromossomoBest = (ChromosomeIF)lista.get(0);
        if(!arrayChoqueDisciplinas.isEmpty() && arrayClipBoard.isEmpty()) {
            disciplina = Integer.valueOf(arrayChoqueDisciplinas.get(posicaoArrayChoqueDisciplinas).toString()).intValue();
            arrayClipBoard.add(Integer.valueOf(disciplina));
            arrayClipBoard.add(Integer.valueOf(linha));
            arrayClipBoard.add(Integer.valueOf(coluna));
            arrayChoqueDisciplinas.remove(posicaoArrayChoqueDisciplinas);
            jTableTimetabling.setValueAt(arrayChoqueDisciplinas, linha, coluna);
        } else {
            int genePrimeiroClick = Integer.valueOf(arrayClipBoard.get(0).toString()).intValue();
            int linhaPrimeiroGene = Integer.valueOf(arrayClipBoard.get(1).toString()).intValue();
            int colunaPrimeiroGene = Integer.valueOf(arrayClipBoard.get(2).toString()).intValue();
            Disciplina disciplinaPrimeiroClick = controle.getDisciplina(genePrimeiroClick);
            Professor professorDisciplinaPrimeiroClick = controle.getProfessor(disciplinaPrimeiroClick.getNomeProfessor());
            if(!arrayChoqueDisciplinas.isEmpty() && !arrayClipBoard.isEmpty()) {
                disciplina = Integer.valueOf(arrayChoqueDisciplinas.get(0).toString()).intValue();
                int geneSegundoClick = disciplina;
                Disciplina disciplinaSegundoClick = controle.getDisciplina(geneSegundoClick);
                Professor professorDisciplinaSegundoClick = controle.getProfessor(disciplinaSegundoClick.getNomeProfessor());
                if(professorDisciplinaPrimeiroClick.getDisponibilidade(coluna * jTableTimetabling.getRowCount() + linha) != 0 && professorDisciplinaSegundoClick.getDisponibilidade(colunaPrimeiroGene * jTableTimetabling.getRowCount() + linhaPrimeiroGene) != 0) {
                    arrayChoqueDisciplinas = (ArrayList)jTableTimetabling.getValueAt(linha, coluna);
                    arrayChoqueDisciplinas.set(0, arrayClipBoard.get(0));
                    jTableTimetabling.setValueAt(arrayChoqueDisciplinas, linha, coluna);
                    if(linha != linhaPrimeiroGene || coluna != colunaPrimeiroGene) {
                        arrayChoqueDisciplinas = (ArrayList)jTableTimetabling.getValueAt(linhaPrimeiroGene, colunaPrimeiroGene);
                        arrayChoqueDisciplinas.add(0, Integer.valueOf(disciplina));
                        jTableTimetabling.setValueAt(arrayChoqueDisciplinas, linhaPrimeiroGene, colunaPrimeiroGene);
                        int posicaoPrimeiroProfessorNoCromossomo=controle.getOrdemProfessorNoCromossomo(professorDisciplinaPrimeiroClick.getNome());
                        int posicaoSegundoProfessorNoCromossomo=controle.getOrdemProfessorNoCromossomo(professorDisciplinaSegundoClick.getNome());
                        int a=(posicaoPrimeiroProfessorNoCromossomo*controle.getQtdHorario())+((colunaPrimeiroGene*jTableTimetabling.getRowCount())+linhaPrimeiroGene);
                        int b=(posicaoPrimeiroProfessorNoCromossomo*controle.getQtdHorario())+((coluna*jTableTimetabling.getRowCount())+linha);
                        gene1=cromossomoBest.getGene(a);
                        gene2=cromossomoBest.getGene(b);
                        cromossomoBest.setGene(gene1,b);
                        cromossomoBest.setGene(gene2,a);
                        if(posicaoPrimeiroProfessorNoCromossomo!=posicaoSegundoProfessorNoCromossomo){
                            int c=(posicaoSegundoProfessorNoCromossomo*controle.getQtdHorario())+((coluna*jTableTimetabling.getRowCount())+linha);
                            int d=(posicaoSegundoProfessorNoCromossomo*controle.getQtdHorario())+((colunaPrimeiroGene*jTableTimetabling.getRowCount())+linhaPrimeiroGene);
                            gene1=cromossomoBest.getGene(c);
                            gene2=cromossomoBest.getGene(d);
                            cromossomoBest.setGene(gene1,d);
                            cromossomoBest.setGene(gene2,c);
                        }
                    }
                    arrayClipBoard.clear();
                    jTableTimetabling.clearSelection();
                } else {
                    JOptionPane.showMessageDialog(this, "Horário indisponível a um dos professores envolvidos na alteração", "Mensagem", 1, new ImageIcon(getClass().getResource("/timetabling/formulario/icones/pare.png")));
                    arrayChoqueDisciplinas = (ArrayList)jTableTimetabling.getValueAt(linhaPrimeiroGene, colunaPrimeiroGene);
                    arrayChoqueDisciplinas.add(arrayClipBoard.get(0));
                    jTableTimetabling.setValueAt(arrayChoqueDisciplinas, linhaPrimeiroGene, colunaPrimeiroGene);
                    arrayClipBoard.clear();
                    jTableTimetabling.clearSelection();
                }
            } else if(arrayChoqueDisciplinas.isEmpty() && !arrayClipBoard.isEmpty()) {
                if(professorDisciplinaPrimeiroClick.getDisponibilidade(coluna * jTableTimetabling.getRowCount() + linha) != 0) {
                    arrayChoqueDisciplinas = (ArrayList)jTableTimetabling.getValueAt(linha, coluna);
                    arrayChoqueDisciplinas.add(arrayClipBoard.get(0));
                    jTableTimetabling.setValueAt(arrayChoqueDisciplinas, linha, coluna);
                    if(linha != linhaPrimeiroGene || coluna != colunaPrimeiroGene) {
                        int posicaoPrimeiroProfessorNoCromossomo=controle.getOrdemProfessorNoCromossomo(professorDisciplinaPrimeiroClick.getNome());
                        gene1=cromossomoBest.getGene((colunaPrimeiroGene*jTableTimetabling.getRowCount()+linhaPrimeiroGene)+posicaoPrimeiroProfessorNoCromossomo*controle.getQtdHorario());
                        gene2=cromossomoBest.getGene((coluna*jTableTimetabling.getRowCount()+linha)+posicaoPrimeiroProfessorNoCromossomo*controle.getQtdHorario());
                        cromossomoBest.setGene(gene1,(coluna*jTableTimetabling.getRowCount()+linha)+posicaoPrimeiroProfessorNoCromossomo*controle.getQtdHorario());
                        cromossomoBest.setGene(gene2,(colunaPrimeiroGene*jTableTimetabling.getRowCount()+linhaPrimeiroGene)+posicaoPrimeiroProfessorNoCromossomo*controle.getQtdHorario());
                        
                    }
                    arrayClipBoard.clear();
                    jTableTimetabling.clearSelection();
                }else{
                    JOptionPane.showMessageDialog(this, "Horário indisponível ao professor da disciplina escolhida", "Mensagem", 1, new ImageIcon(getClass().getResource("/timetabling/formulario/icones/pare.png")));
                    arrayChoqueDisciplinas = (ArrayList)jTableTimetabling.getValueAt(linhaPrimeiroGene, colunaPrimeiroGene);
                    arrayChoqueDisciplinas.add(posicaoArrayChoqueDisciplinas, arrayClipBoard.get(0));
                    jTableTimetabling.setValueAt(arrayChoqueDisciplinas, linhaPrimeiroGene, colunaPrimeiroGene);
                    arrayClipBoard.clear();
                    jTableTimetabling.clearSelection();
                }
            }
        }
    }
    
    public void carregarListProfessores(){
        jListProfessores.setModel(modelListaProfessores);
        modelTabelaProfessores.setColumnCount(0);
        modelTabelaProfessores.setNumRows(0);
        modelTabelaProfessores.setColumnIdentifiers(controle.getHorario().getDias());
        modelListaProfessores.removeAllElements();
        Professor professor;
        Iterator professores=controle.getTodosProfessores().keySet().iterator();
        while(professores.hasNext()){
            professor = (Professor)controle.getTodosProfessores().get(professores.next());
            modelListaProfessores.addElement(professor.getNome());
        }
        jTableTimetablingProfessores.setModel(modelTabelaProfessores);
        modelTabelaProfessores.setColumnCount(controle.getHorario().getDias().length);
        modelTabelaProfessores.setNumRows(controle.getHorario().getPeriodos());
        modelTabelaProfessores.setColumnIdentifiers(controle.getHorario().getDias());
    }
    
    public void construirTabela(){
        jTableTimetabling.setModel(modelTabelaTimetabling);
        modelTabelaTimetabling.setColumnCount(controle.getHorario().getDias().length);
        modelTabelaTimetabling.setNumRows(controle.getHorario().getPeriodos());
        modelTabelaTimetabling.setColumnIdentifiers(controle.getHorario().getDias());
        jTableTimetabling.setRowHeight(50);
        jTableTimetablingProfessores.setRowHeight(50);
        jTableTimetabling.setEnabled(false);
        jListSemestres.setModel(modelListaSemestres);
        modelTabelaTimetabling.setColumnCount(0);
        modelTabelaTimetabling.setNumRows(0);
        modelTabelaTimetabling.setColumnIdentifiers(controle.getHorario().getDias());
        ArrayList semestres=controle.getSemestres();
        modelListaSemestres.removeAllElements();
        for(int i=0;i<semestres.size();i++){
            String nomeSemestre=(String)semestres.get(i);
            modelListaSemestres.addElement(nomeSemestre);
        }
        this.carregarListProfessores();
        jMenuItemSalvarHorarioGerado.setEnabled(true);
        jListProfessores.setEnabled(true);
        jListSemestres.setEnabled(true);
    }
    
    public void montaTabelaProfessores(){
        int qtdHorario=controle.getQtdHorario();
        int countHorario=0;
        Iterator professores=controle.getTodosProfessores().keySet().iterator();
        Professor professor = (Professor)controle.getTodosProfessores().get(professores.next());
        while((professores.hasNext())&&(!professor.getNome().equals(jListProfessores.getSelectedValue()))){
            professor = (Professor)controle.getTodosProfessores().get(professores.next());
            countHorario+=qtdHorario;
        }
        ChromosomeIF cromossomoBest=(ChromosomeIF)lista.get(0);
        
        if(professor.getNome().equals(jListProfessores.getSelectedValue())){
            for(int j=0;j<jTableTimetablingProfessores.getColumnCount();j++){
                jTableTimetablingProfessores.getColumn(jTableTimetablingProfessores.getColumnName(j)).setCellRenderer(
                        new JLabelRendererDisciplinasProfessor(controle,professor));
                for(int k=0;k<jTableTimetablingProfessores.getRowCount();k++){
                    int codigoGaDisciplina=Integer.valueOf(cromossomoBest.getGene(countHorario).toString()).intValue();
                    if(codigoGaDisciplina!=0){
                        Disciplina disciplina= controle.getDisciplina(codigoGaDisciplina);
                        if(professor.getDisponibilidade(j*jTableTimetablingProfessores.getRowCount()+k)!=0&&disciplina.getNomeProfessor().equals(professor.getNome())){
                            jTableTimetablingProfessores.setValueAt(codigoGaDisciplina,k,j);
                        }else{
                            jTableTimetablingProfessores.setValueAt(0,k,j);
                        }
                    }else{
                        jTableTimetablingProfessores.setValueAt(0,k,j);
                    }
                    countHorario++;
                }
            }
        }
        jTableTimetablingProfessores.setRowHeight(50);
        jTableTimetablingProfessores.setEnabled(false);
    }
    
    public void montaTabelaSemestres(){
        jTableTimetabling.setEnabled(true);
        modelTabelaTimetabling.setColumnCount(0);
        modelTabelaTimetabling.setNumRows(0);
        modelTabelaTimetabling.setColumnCount(controle.getHorario().getDias().length);
        modelTabelaTimetabling.setNumRows(controle.getHorario().getPeriodos());
        modelTabelaTimetabling.setColumnIdentifiers(controle.getHorario().getDias());
        jTableTimetabling.setRowHeight(50);
        Iterator professores = controle.getTodosProfessores().keySet().iterator();
        int indiceCromossomo = 0;
        for(ChromosomeIF cromossomoBest = (ChromosomeIF)lista.get(0); indiceCromossomo < cromossomoBest.size() && professores.hasNext();) {
            Professor professor = (Professor)controle.getTodosProfessores().get(professores.next());
            int indice = 0;
            int j = 0;
            while(j < jTableTimetabling.getColumnCount()) {
                jTableTimetabling.getColumn(jTableTimetabling.getColumnName(j)).setCellRenderer(new JLabelRendererDisciplinas(controle));
                for(int k = 0; k < jTableTimetabling.getRowCount(); k++) {
                    int codigoGaDisciplina = Integer.valueOf(cromossomoBest.getGene(indiceCromossomo).toString()).intValue();
                    if(codigoGaDisciplina != 0) {
                        Disciplina disciplina = controle.getDisciplina(codigoGaDisciplina);
                        Professor professorTeste = controle.getProfessor(disciplina.getNomeProfessor());
                        if(disciplina.getSemestre().equals(jListSemestres.getSelectedValue())){
                            if(professorTeste.getDisponibilidade(j * jTableTimetabling.getRowCount() + k) != 0 && disciplina.getNomeProfessor().equals(professor.getNome())) {
                                if(jTableTimetabling.getValueAt(k, j) == null) {
                                    ArrayList arrayChoqueDisciplinas = new ArrayList();
                                    arrayChoqueDisciplinas.add(Integer.valueOf(codigoGaDisciplina));
                                    jTableTimetabling.setValueAt(arrayChoqueDisciplinas, k, j);
                                } else {
                                    ArrayList arrayChoqueDisciplinas = (ArrayList)jTableTimetabling.getValueAt(k, j);
                                    if(!arrayChoqueDisciplinas.contains(codigoGaDisciplina)){
                                        arrayChoqueDisciplinas.add(Integer.valueOf(codigoGaDisciplina));
                                        jTableTimetabling.setValueAt(arrayChoqueDisciplinas, k, j);
                                    }
                                }
                            } else
                                if(indiceCromossomo == indice && jTableTimetabling.getValueAt(k, j) == null) {
                                jTableTimetabling.setValueAt(new ArrayList(), k, j);
                                }
                        } else
                            if(indiceCromossomo == indice && jTableTimetabling.getValueAt(k, j) == null) {
                            jTableTimetabling.setValueAt(new ArrayList(), k, j);
                            }
                    } else
                        if(indiceCromossomo == indice && jTableTimetabling.getValueAt(k, j) == null) {
                        jTableTimetabling.setValueAt(new ArrayList(), k, j);
                        }
                    indice++;
                    indiceCromossomo++;
                }
                
                j++;
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
            TelaPrincipal telaP= new TelaPrincipal();
            telaP.setTitle("Kairós - Geração de Horários Acadêmicos");
            telaP.setBounds(7,7,1000,600);
            telaP.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAbrir;
    private javax.swing.JButton jButtonGerarHorario;
    private javax.swing.JButton jButtonImprimir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JList<String> jListProfessores;
    private javax.swing.JList<String> jListSemestres;
    private javax.swing.JMenu jMenuArquivo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastrar;
    private javax.swing.JMenu jMenuExibir;
    private javax.swing.JMenuItem jMenuItemAbrir;
    private javax.swing.JMenuItem jMenuItemAbrirHorarioSalvo;
    private javax.swing.JMenuItem jMenuItemCadastrarDisciplinas;
    private javax.swing.JMenuItem jMenuItemCadastrarHorarios;
    private javax.swing.JMenuItem jMenuItemCadastrarProfessor;
    private javax.swing.JMenuItem jMenuItemDisponibilidades;
    private javax.swing.JMenuItem jMenuItemFechar;
    private javax.swing.JMenuItem jMenuItemListarDisciplinas;
    private javax.swing.JMenuItem jMenuItemNovo;
    private javax.swing.JMenuItem jMenuItemSalvar;
    private javax.swing.JMenuItem jMenuItemSalvarComo;
    private javax.swing.JMenuItem jMenuItemSalvarHorarioGerado;
    private javax.swing.JMenuItem jMenuItemSobre;
    private javax.swing.JMenu jMenuSobre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelProfessor;
    private javax.swing.JPanel jPanelSemestre;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTabbedPane jTabbedPaneHorarios;
    private javax.swing.JTable jTableTimetabling;
    private javax.swing.JTable jTableTimetablingProfessores;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
    
}
