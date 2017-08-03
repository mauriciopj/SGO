/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgo.apresentacao;

import br.edu.ifnmg.psc.sgo.aplicacao.Fornecedor;
import br.edu.ifnmg.psc.sgo.aplicacao.MaterialConstrucao;
import br.edu.ifnmg.psc.sgo.aplicacao.MaterialConstrucaoRepositorio;
import br.edu.ifnmg.psc.sgo.aplicacao.Pedidos;
import br.edu.ifnmg.psc.sgo.aplicacao.PedidosRepositorio;
import br.edu.ifnmg.psc.sgo.aplicacao.Repositorio;
import br.edu.ifnmg.psc.sgo.aplicacao.ViolacaoRegraNegocioException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import javax.swing.ButtonModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dougla_Castro
 */
public class PedidoEditar extends  TelaEdicao<Pedidos> {

     MaterialConstrucaoRepositorio materiais = Repositorios.getMaterialConstrucaoRepositorio();
     
     SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm");
     
     
     
      public PedidoEditar() {
       super();
        
        initComponents();
        
        List<MaterialConstrucao> lista = materiais.Buscar(null);
    
        lista.add(0, null);
        
        ComboBoxModel modelo = new DefaultComboBoxModel(lista.toArray());
        
        cbxMaterial.setModel(modelo);
        
        
        
    }
    /**
     * Creates new form PedidoEditar
     * @param MaterialConstrucao
     * @param Fornecedor
     */
   // public PedidoEditar() {
      //  super();
    //    initComponents();
        
      //  repositorio = Repositorios.getPedidosRepositorio();
       // entidade = new Pedidos();
        
        
        
        
       // ComboBoxModel model = new DefaultComboBoxModel(MaterialConstrucao.values());               
      //  cbxMaterial.setModel(model);
          
      //  ComboBoxModel model = new DefaultComboBoxModel(Fornecedor.v);               
         
       // cbxFornecedor.setModel(model);
    
   // }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbxMaterial = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtQtd = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btCancelar = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cbxFornecedor = new javax.swing.JComboBox<>();
        tblIncluir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jLabel1.setText("Material  :");

        cbxMaterial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Quantidade :");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        jLabel3.setText("Fornecedor :");

        cbxFornecedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tblIncluir.setText("Incluir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btCancelar)
                        .addGap(35, 35, 35)
                        .addComponent(btSalvar)
                        .addGap(83, 83, 83))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(tblIncluir)
                        .addGap(104, 104, 104))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1)
                        .addGap(37, 37, 37)
                        .addComponent(cbxMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(35, 35, 35)
                        .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel3)
                        .addGap(4, 4, 4)
                        .addComponent(cbxFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(tblIncluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbxFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btSalvar))
                .addGap(78, 78, 78))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        
 salvar();
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
       cancelar();
    }//GEN-LAST:event_btCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox<String> cbxFornecedor;
    private javax.swing.JComboBox<String> cbxMaterial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton tblIncluir;
    private javax.swing.JSpinner txtQtd;
    // End of variables declaration//GEN-END:variables

    @Override
    public void carregaCampos() {
       
        txtQtd.setValue(entidade.getQtd());
        cbxFornecedor.setSelectedItem( entidade.getFornecedor());
        cbxMaterial.setSelectedItem( entidade.getMaterial());
       
    }

    @Override
    public void carregaObjeto() throws ViolacaoRegraNegocioException {
        entidade.setQtd((int) txtQtd.getValue() );
     
        entidade.setFornecedor((Fornecedor) cbxFornecedor.getSelectedItem() );
        entidade.setMaterial((MaterialConstrucao) cbxMaterial.getSelectedItem() );
    
    }

    @Override
    public boolean verificarCamposObrigatorios() {
        return  txtQtd.getValue() != null || 
               
                cbxMaterial.getSelectedItem() != null || 
                cbxFornecedor.getSelectedItem() != null ;
               
    }
    
    
    public void preencheTabela(List<Pedidos> listagem) {
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("ID");
        modelo.addColumn("Material");
        modelo.addColumn("Quantidade");
        modelo.addColumn("Fornecedor");
      
        
        
         for(Pedidos f : listagem){
            Vector linha = new Vector();
            linha.add(f.getId());
            linha.add(f.getMaterial());            
            linha.add(f.getQtd());
             linha.add(f.getFornecedor());
            
            
                        
            modelo.addRow(linha);
        }
      tblIncluir.setModel((ButtonModel) modelo);
    }
    
    
   
}
