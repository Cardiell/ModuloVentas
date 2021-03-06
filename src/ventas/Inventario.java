package ventas;

import entidades.Cotizacion;
import entidades.User;
import logico.UserLog;
import logico.CotizacionLog;

import login.Login;
import static login.Login.UserName;
import java.awt.Image;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

/**
 *
 * @author Cardiell
 */
public class Inventario extends javax.swing.JFrame {
String ruta =null;
public static int idCotizar;
Icon img;
User Datos;
UserLog usrlog;
CotizacionLog cotizacion;
JLabel jLblTitulo = new JLabel();

    /**
     * Creates new form Inventario
     */
    public Inventario() {

        initComponents();
        usrlog= new UserLog();
        cotizacion= new CotizacionLog();
        List<Cotizacion> tmp= cotizacion.ListarCotizacion();
        idCotizar=  tmp.size()+1;
        Cotizacion cot= new Cotizacion(idCotizar);
        cotizacion.AgregarCotizacion(cot);
        ImgFondo();
        label();
    }
    
    private void label(){
        lblUserName.setText((UserName).toUpperCase());
    }
    public void ImgFondo()
    {
        ruta = usrlog.ListarLogin(UserName).getImagen();
            if(ruta != null){
                ImageIcon btnPerfil= new ImageIcon(ruta);
                Icon icono = new ImageIcon(btnPerfil.getImage().getScaledInstance(btnImagen.getWidth()-3,btnImagen.getHeight()-3,Image.SCALE_DEFAULT));
                btnImagen.setIcon(icono);
            }
            else
            {
                ImageIcon btnPerfil= new ImageIcon("src/imagenes/ImgdFondo.jpg");
                Icon icono = new ImageIcon(btnPerfil.getImage().getScaledInstance(btnImagen.getWidth()-5,btnImagen.getHeight()-5,Image.SCALE_DEFAULT));
                btnImagen.setIcon(icono);
            }
            this.repaint();
    }
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoModulos = new javax.swing.ButtonGroup();
        panel1 = new java.awt.Panel();
        btnAtras = new javax.swing.JButton();
        lblUserName = new javax.swing.JLabel();
        btnMaterial = new javax.swing.JToggleButton();
        btnCotizar = new javax.swing.JToggleButton();
        btnReporteVentas = new javax.swing.JToggleButton();
        lblImagen = new javax.swing.JLabel();
        btnImagen = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        contenedorModulos = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventas");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1366, 770));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        panel1.setLayout(null);

        btnAtras.setBackground(new java.awt.Color(204, 0, 0));
        btnAtras.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAtras.setForeground(new java.awt.Color(255, 255, 255));
        btnAtras.setText("Cerrar Sesion");
        btnAtras.setBorder(null);
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        panel1.add(btnAtras);
        btnAtras.setBounds(0, 680, 200, 50);

        lblUserName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUserName.setText("Cardiell");
        panel1.add(lblUserName);
        lblUserName.setBounds(60, 190, 120, 30);

        btnMaterial.setBackground(new java.awt.Color(204, 0, 0));
        grupoModulos.add(btnMaterial);
        btnMaterial.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnMaterial.setForeground(new java.awt.Color(255, 255, 255));
        btnMaterial.setText("Articulos");
        btnMaterial.setBorder(null);
        btnMaterial.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaterialActionPerformed(evt);
            }
        });
        panel1.add(btnMaterial);
        btnMaterial.setBounds(0, 270, 200, 50);

        btnCotizar.setBackground(new java.awt.Color(204, 0, 0));
        grupoModulos.add(btnCotizar);
        btnCotizar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCotizar.setForeground(new java.awt.Color(255, 255, 255));
        btnCotizar.setText("Cotizar");
        btnCotizar.setBorder(null);
        btnCotizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCotizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCotizarActionPerformed(evt);
            }
        });
        panel1.add(btnCotizar);
        btnCotizar.setBounds(0, 350, 200, 50);

        btnReporteVentas.setBackground(new java.awt.Color(204, 0, 0));
        grupoModulos.add(btnReporteVentas);
        btnReporteVentas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnReporteVentas.setForeground(new java.awt.Color(255, 255, 255));
        btnReporteVentas.setText("Reporte de Ventas");
        btnReporteVentas.setToolTipText("");
        btnReporteVentas.setBorder(null);
        btnReporteVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnReporteVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteVentasActionPerformed(evt);
            }
        });
        panel1.add(btnReporteVentas);
        btnReporteVentas.setBounds(0, 430, 200, 50);

        lblImagen.setToolTipText("");
        lblImagen.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblImagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblImagenMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblImagenMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblImagenMousePressed(evt);
            }
        });
        panel1.add(lblImagen);
        lblImagen.setBounds(0, 140, 200, 40);

        btnImagen.setBorderPainted(false);
        btnImagen.setContentAreaFilled(false);
        btnImagen.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnImagen.setFocusPainted(false);
        btnImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagenActionPerformed(evt);
            }
        });
        panel1.add(btnImagen);
        btnImagen.setBounds(0, 0, 200, 180);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoInv.png"))); // NOI18N
        panel1.add(jLabel1);
        jLabel1.setBounds(0, 10, 200, 768);

        getContentPane().add(panel1);
        panel1.setBounds(0, 0, 200, 850);
        getContentPane().add(contenedorModulos);
        contenedorModulos.setBounds(200, 0, 1170, 770);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
       cotizacion.EliminarCotizacion(idCotizar);
        cotizacion.EliminarCotizar(idCotizar);
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaterialActionPerformed
        if(mat==null){
                    mat= new MaterialesFrame();
                    contenedorModulos.add(mat);
                    contenedorModulos.getDesktopManager().maximizeFrame(mat);
                    mat.setVisible(true);  
                }
                else
                    contenedorModulos.getDesktopManager().maximizeFrame(mat);
        if(cot!=null){
            cot.dispose();
            cot=null;
        }else if(rep!=null)
        {
            rep.dispose();
            rep=null;
        }
    }//GEN-LAST:event_btnMaterialActionPerformed

    private void btnCotizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCotizarActionPerformed
                if(cot==null){
                    cot= new CotizacionFrame();
                    contenedorModulos.add(cot);
                    contenedorModulos.getDesktopManager().maximizeFrame(cot);
                    cot.setVisible(true);  
                }
                else
                    contenedorModulos.getDesktopManager().maximizeFrame(cot);
                if(rep!=null)
                {
                    rep.dispose();
                    rep=null;
                }
    }//GEN-LAST:event_btnCotizarActionPerformed

    private void btnReporteVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteVentasActionPerformed
        if(rep==null)  {         
        rep= new ReportedVentasFrame();
                    contenedorModulos.add(rep);
                    contenedorModulos.getDesktopManager().maximizeFrame(rep);
                    rep.setVisible(true);  
    }
    }//GEN-LAST:event_btnReporteVentasActionPerformed

    private void btnImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagenActionPerformed
                JFileChooser j = new JFileChooser();
           Datos = usrlog.ListarLogin(UserName);
            ruta = Datos.getImagen();
        int ap = j.showOpenDialog(this);
        if(ap == JFileChooser.APPROVE_OPTION)
        {
         ruta = j.getSelectedFile().getAbsolutePath();
          User usr = new User(Datos.getNameUser(),Datos.getPass(),ruta,Datos.getNumEmpleado());
          usrlog.UpdateUser(usr);
        ImageIcon btnPerfil= new ImageIcon(ruta);
        
         Icon icono = new ImageIcon(btnPerfil.getImage().getScaledInstance(btnImagen.getWidth()-5,btnImagen.getHeight()-5,Image.SCALE_DEFAULT));
        btnImagen.setIcon(icono);
        this.repaint();
        }
    }//GEN-LAST:event_btnImagenActionPerformed

    private void lblImagenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagenMouseEntered
        img=new javax.swing.ImageIcon(getClass().getResource("/imagenes/foto1.png"));
        lblImagen.setIcon(img);  
    }//GEN-LAST:event_lblImagenMouseEntered

    private void lblImagenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagenMouseExited
       lblImagen.setIcon(null);
       repaint();
    }//GEN-LAST:event_lblImagenMouseExited

    private void lblImagenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagenMousePressed
        JFileChooser j = new JFileChooser();
           Datos = usrlog.ListarLogin(UserName);
            ruta = Datos.getImagen();
        int ap = j.showOpenDialog(this);
        if(ap == JFileChooser.APPROVE_OPTION)
        {
         ruta = j.getSelectedFile().getAbsolutePath();
          User usr = new User(Datos.getNameUser(),Datos.getPass(),ruta,Datos.getNumEmpleado());
          usrlog.UpdateUser(usr);
        ImageIcon btnPerfil= new ImageIcon(ruta);
        
         Icon icono = new ImageIcon(btnPerfil.getImage().getScaledInstance(btnImagen.getWidth()-5,btnImagen.getHeight()-5,Image.SCALE_DEFAULT));
        btnImagen.setIcon(icono);
        this.repaint();
        }
    }//GEN-LAST:event_lblImagenMousePressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        cotizacion.EliminarCotizacion(idCotizar);
        cotizacion.EliminarCotizar(idCotizar);
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventario().setVisible(true);
                                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    public static javax.swing.JToggleButton btnCotizar;
    private javax.swing.JButton btnImagen;
    public static javax.swing.JToggleButton btnMaterial;
    public static javax.swing.JToggleButton btnReporteVentas;
    public static javax.swing.JDesktopPane contenedorModulos;
    private javax.swing.ButtonGroup grupoModulos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblUserName;
    private java.awt.Panel panel1;
    // End of variables declaration//GEN-END:variables
    MaterialesFrame mat;
    FacturaFrame fact;
    ReportedVentasFrame rep;
    public static CotizacionFrame cot;
}
