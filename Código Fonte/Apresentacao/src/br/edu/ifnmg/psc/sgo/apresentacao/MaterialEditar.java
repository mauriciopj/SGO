/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.psc.sgo.apresentacao;
import br.edu.ifnmg.psc.sgo.aplicacao.MaterialConstrucao;
import br.edu.ifnmg.psc.sgo.aplicacao.ViolacaoRegraNegocioException;
/**
 *
 * @author Dougla_Castro
 */
public class MaterialEditar extends TelaEdicao<MaterialConstrucao> {

    /** Creates new form MaterialEditar */
    public MaterialEditar() {
        super();
        initComponents();       
        
        entidade = new MaterialConstrucao() ; 
    }
    
    @Override
    public void carregaCampos() {
        txtNome.setText( entidade.getNome() );
        txtDescricao.setText( entidade.getDescricao());
        jSpQuantidade.setValue(entidade.getQtd());
       jTValor.setText(entidade.getValor());
       
    }
    
    @Override
    public void carregaObjeto() throws ViolacaoRegraNegocioException {
        entidade.setNome( txtNome.getText() );
        entidade.setDescricao(txtDescricao.getText() );
        entidade.setQtd((int) jSpQuantidade.getValue());
        entidade.setValor( jTValor.getText());
    }
    
    @Override
    public boolean verificarCamposObrigatorios() {
        return !txtNome.getText().isEmpty() || 
               !txtDescricao.getText().isEmpty() ||
               jSpQuantidade.getValue()!= null||
               !jTValor.getText().isEmpty() ;
    }
                                              
    private void txtNomeKeyPressed(java.awt.event.KeyEvent evt) {                                   
        // TODO add your handling code here:
             if(evt.getKeyCode() == evt.VK_ENTER)  {
             txtDescricao.requestFocus();
    }
    }
    
    
     private void txtDescricaoKeyPressed(java.awt.event.KeyEvent evt) {                                     
        // TODO add your handling code here:
        if(evt.getKeyCode() == evt.VK_ENTER)  {
             btnSalvar.requestFocus();
           
          }
    }
     
      private void btnSalvarKeyPressed(java.awt.event.KeyEvent evt) {                                     
        // TODO add your handling code here:
        if(evt.getKeyCode() == evt.VK_ENTER)  {
        salvar();
          }
    }     
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        choice1 = new java.awt.Choice();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtDescricao = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSpQuantidade = new javax.swing.JSpinner();
        jTValor = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setTitle("Editar Material");

        jLabel1.setText("Nome :");

        jLabel2.setText("Descrição:");

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Save_37110.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jLabel3.setText("Quantidade : ");

        jLabel4.setText("Valor :");

        jSpQuantidade.setModel(new javax.swing.SpinnerNumberModel(1, null, null, 1));

        jTValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTValorActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Cancel_icon-icons.com_73703.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                    .addComponent(txtNome))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(50, 50, 50)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTValor)
                            .addComponent(jSpQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(btnCancelar)
                        .addGap(28, 28, 28)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jSpQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar))
                .addGap(20, 20, 20))
        );

        setBounds(410, 100, 473, 304);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
         salvar();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jTValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTValorActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private java.awt.Choice choice1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSpinner jSpQuantidade;
    private javax.swing.JTextField jTValor;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables

   
} 
