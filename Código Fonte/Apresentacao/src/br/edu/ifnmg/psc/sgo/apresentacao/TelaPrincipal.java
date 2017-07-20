/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgo.apresentacao;

import br.edu.ifnmg.psc.sgo.aplicacao.EmpresaRepositorio;

/**
 *
 * @author mauricio
 */
public class TelaPrincipal extends javax.swing.JFrame {    
    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        planoFundo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuForn = new javax.swing.JMenuItem();
        mnuEmpresa = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SGO - Sistema de Gestão de Obras");
        setAlwaysOnTop(true);

        planoFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/telaLogin_1.jpg"))); // NOI18N

        jMenuBar1.setBackground(new java.awt.Color(208, 208, 208));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SGO - Sistema de Gestão de Obras", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Loma", 1, 14), new java.awt.Color(74, 74, 74))); // NOI18N
        jMenuBar1.setMargin(new java.awt.Insets(10, 0, 0, 0));
        jMenuBar1.setName(""); // NOI18N

        jMenu1.setForeground(new java.awt.Color(1, 1, 1));
        jMenu1.setText("Novo");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu1.setFocusCycleRoot(true);
        jMenu1.setNextFocusableComponent(jMenu1);

        mnuForn.setText("Fornecedor");
        mnuForn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuFornActionPerformed(evt);
            }
        });
        jMenu1.add(mnuForn);

        jMenuBar1.add(jMenu1);
        jMenu1.getAccessibleContext().setAccessibleDescription("");

        mnuEmpresa.setForeground(new java.awt.Color(1, 1, 1));
        mnuEmpresa.setText("Configurações");
        mnuEmpresa.setToolTipText("");
        mnuEmpresa.setFocusable(false);

        jMenuItem2.setText("Minha Empresa");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mnuEmpresa.add(jMenuItem2);

        jMenuBar1.add(mnuEmpresa);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(planoFundo, javax.swing.GroupLayout.PREFERRED_SIZE, 1338, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(planoFundo)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuFornActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuFornActionPerformed
        FornecedorBuscar tela = new FornecedorBuscar(Repositorios.getFornecedorRepositorio(), FornecedorEditar.class);
        
      planoFundo.add(tela);
        tela.setVisible(true);
    }//GEN-LAST:event_mnuFornActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if (Repositorios.getEmpresaRepositorio().Abrir(1) != null){                        
            EmpresaBuscaDados tela = new EmpresaBuscaDados(Repositorios.getEmpresaRepositorio(), EmpresaEditar.class);       
            planoFundo.add(tela);
            tela.setVisible(true);
        } else {                        
            EmpresaEditar tela = new EmpresaEditar();     
            planoFundo.add(tela);
            tela.setVisible(true);            
        }                 
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * @param args the command line arguments
     */
  
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenu mnuEmpresa;
    private javax.swing.JMenuItem mnuForn;
    private javax.swing.JLabel planoFundo;
    // End of variables declaration//GEN-END:variables

}
