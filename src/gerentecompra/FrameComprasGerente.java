/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerentecompra;


import compras.*;
import modelotabla.ModeloTablaCompras;
import entidades.Compra;
import logico.ComprasLog;
import static compras.InicioCompras.idDepartamento;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

//Que pedo por que no marca error con los imports?
//a la madre si es cierto
/**
 *
 * @author alberto jaquez
 */
public class FrameComprasGerente extends javax.swing.JFrame {
ComprasLog inv;
Compra compras;
ModeloTablaCompras modeloTabla;
boolean presionado = false;
    /**
     * Creates new form FrameCompras
     */
    public FrameComprasGerente() {
        initComponents();
        setLocationRelativeTo(null);
        inv = new ComprasLog();
        ListarPedimento();
    }
       
    public void ListarPedimento()
    {

            List<Compra> listas = inv.ListarPedimento();
            tblPedimento.setModel(new ModeloTablaCompras(listas));
            tblPedimento.getRowSorter();
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
        tblPedimento = new javax.swing.JTable();
        btnAtras = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1230, 850));
        getContentPane().setLayout(null);

        tblPedimento.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblPedimento);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(60, 30, 1129, 675);

        btnAtras.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAtras.setText("Regresar");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtras);
        btnAtras.setBounds(940, 730, 110, 34);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ingresa Articulo: ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(430, 736, 160, 22);

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        getContentPane().add(txtBuscar);
        txtBuscar.setBounds(590, 736, 150, 28);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/orig_506983.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setMaximumSize(new java.awt.Dimension(1450, 1000));
        jLabel2.setMinimumSize(new java.awt.Dimension(1450, 1000));
        jLabel2.setPreferredSize(new java.awt.Dimension(1450, 1000));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1220, 810);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
                if(txtBuscar.getText().isEmpty()){
            List<Compra> listas = inv.ListarPedimento();
            tblPedimento.setModel(new ModeloTablaCompras(listas));
            tblPedimento.getRowSorter();
        }else
        {
            List<Compra> listas = inv.BuscarPedimento(txtBuscar.getText());
            tblPedimento.setModel(new ModeloTablaCompras(listas));
            tblPedimento.getRowSorter();
        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
                if(txtBuscar.getText().isEmpty()){
            List<Compra> listas = inv.ListarPedimento();
            
            
            tblPedimento.setModel(new ModeloTablaCompras(listas));
            tblPedimento.getRowSorter();
        }else
        {
            
            List<Compra> listas = inv.BuscarPedimento(txtBuscar.getText());
            modeloTabla = new ModeloTablaCompras(listas);
            tblPedimento.setModel(modeloTabla);
            tblPedimento.getRowSorter();
        } 
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        dispose();
        new inicio(idDepartamento).setVisible(true);
    }//GEN-LAST:event_btnAtrasActionPerformed

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
            java.util.logging.Logger.getLogger(FrameComprasGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameComprasGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameComprasGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameComprasGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameComprasGerente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPedimento;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
