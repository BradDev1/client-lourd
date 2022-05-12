/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package javacrud.view;

import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javacrud.model.Commune;
import javacrud.control.VilleDAOImp;

/**
 *
 * @author b.chesneau
 */
public class SelectionVille extends javax.swing.JDialog {
    
    Commune selectedVille = new Commune();
    VilleDAOImp dao = new VilleDAOImp();
    HashMap<Integer, Commune> ville = new HashMap<>();
    Boolean selected;

    public SelectionVille(java.awt.Frame parent, boolean modal, Integer codePostal, String numVille) {
        super(parent, modal);
        Commune c = new Commune();
        VilleDAOImp daoVille = new VilleDAOImp();
        initComponents();
        jScrollPane1.getViewport().setOpaque(false);
        HashMap<Integer, Commune> lesVilles = daoVille.lesVille(codePostal);
        DefaultTableModel uiTable = (DefaultTableModel)Ville.getModel();
        selectedVille.setCode_Postal(codePostal.toString());
        selectedVille.setNum_Postal(numVille);
        int i = 0, selNumRow = 0;
        
        for(Integer numV : lesVilles.keySet()){
            
            c = lesVilles.get(numV);
            Object[] row = new Object[2];
            row[0] = numV;
            row[1] = c.getNom_Commune();
            uiTable.addRow(row);
            
            
            if(numV.toString().equals(numVille)){
                Ville.setRowSelectionInterval(i, i);
                this.selectedVille.setNom_Commune(row[1].toString());
            }
            i++;
        }
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Ville = new javax.swing.JTable();
        Valider = new javax.swing.JButton();
        Abandonner = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);

        Ville.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num", "Selectionner une commune"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Ville.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VilleMouseClicked(evt);
            }
        });
        Ville.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                VilleKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(Ville);

        Valider.setText("Valider");
        Valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValiderActionPerformed(evt);
            }
        });

        Abandonner.setText("Abandonner");
        Abandonner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbandonnerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(Valider)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Abandonner)
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Valider)
                    .addComponent(Abandonner))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AbandonnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbandonnerActionPerformed
        // TODO add your handling code here:
        selected  = false;
        this.dispose();
    }//GEN-LAST:event_AbandonnerActionPerformed

    private void ValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValiderActionPerformed
        selected = true;
        this.dispose();
    }//GEN-LAST:event_ValiderActionPerformed

    private void VilleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VilleMouseClicked
        chargeSelectVille();
    }//GEN-LAST:event_VilleMouseClicked

    private void VilleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_VilleKeyReleased
        chargeSelectVille();
    }//GEN-LAST:event_VilleKeyReleased

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
            java.util.logging.Logger.getLogger(SelectionVille.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectionVille.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectionVille.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectionVille.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SelectionVille dialog = new SelectionVille(new javax.swing.JFrame(), true,82300,"0");
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
     public void chargeSelectVille(){
        int i  = Ville.getSelectedRow();
        TableModel model = Ville.getModel();
        this.selectedVille.setNum_Postal(model.getValueAt(i, 0).toString());
        this.selectedVille.setNom_Commune(model.getValueAt(i, 1).toString());
        
    }
    public Commune getSelectedVille(){
        
        return selectedVille; 
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Abandonner;
    private javax.swing.JButton Valider;
    private javax.swing.JTable Ville;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
