/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerentecompra;

import dao.ProveedoresDao;
import entidades.Direccion;
import entidades.Persona;
import entidades.Proveedor;
import logico.DireccionLog;
import logico.PersonaLog;
import logico.ProveedorLog;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author alberto jaquez
 */
public class AgregarProveedor extends javax.swing.JFrame {
    //Proveedores
    ProveedoresDao proveedoresdao;
    Proveedor proveedor;
    ProveedorLog proveedorlog;
    String NombreCompania;
    //Direccion
    Direccion direc;
    DireccionLog direccion;
    String cuidad;
    String colonia;
    String calle;
    int CP;
    //Persona
    Persona per;
    PersonaLog persona;
    String nombre;
    String ApellidoP;
    String ApellidoM;
    String Fecha;
    String Correo;
    String telefono;
    
    
    

    /**
     * Creates new form AgregarProveedor
     */
    public AgregarProveedor() {
        initComponents();
        this.setLocationRelativeTo(null);
        proveedorlog = new ProveedorLog();
        direccion = new DireccionLog();
        persona = new PersonaLog();
    }
    
    
    public void ingresarProveedor() throws SQLException
    {
        //Proveedor
        NombreCompania = txtcompania.getText();
        //Direccion
        cuidad = txtciudad.getText();
        colonia= txtcolonia.getText();
        calle = txtcalle.getText();

        //Persona
        nombre = txtnombre.getText();
        ApellidoP = txtapellidoP.getText();
        ApellidoM = txtapellidoM.getText();
        Fecha = FechaSql(txtfecha.getDate().toString());
        Correo = txtcorreo.getText();
        telefono = txttelefono.getText();
        if(Validar(Fecha)){
                if(txtcodigopostal.getText().isEmpty() == false){
            CP = Integer.parseInt(txtcodigopostal.getText());
            direc = new Direccion(cuidad,colonia,calle,CP);
            direccion.AgregarDireccion(direc);
            List<Direccion> aux = direccion.ListarDireccion();
            per = new Persona(nombre,ApellidoP,ApellidoM,Fecha,telefono,Correo,aux.size());
            persona.AgregarPersona(per);
            List<Persona> aux2 = persona.ListarPersona();
            proveedor = new Proveedor(aux2.size(),NombreCompania);
             if(proveedorlog.okProveedor(NombreCompania))
            JOptionPane.showMessageDialog(null,"El usuario ya se encuentra registrado");
        else{
             
             if(!proveedorlog.AgregarProveedor(proveedor)){
            JOptionPane.showMessageDialog(null, "Información Agregada.");
            dispose();
           
            }
             else {
            JOptionPane.showMessageDialog(null, "Error al agregar la Información.");
            System.exit(0);
                 }
        }
            
     }    else
        JOptionPane.showMessageDialog(null, "Favor de ingresa un CP");
    }

 }
    
    
    private boolean Validar(String fecha)
    {
        int cont=0;
        int anyo=Integer.valueOf(fecha.substring(6,10));
        System.out.println(anyo);
        if(txtciudad.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Favor de introducir la Ciudad");
            return false;
        }else if(txtcolonia.getText().isEmpty()){
             JOptionPane.showMessageDialog(null,"Favor de introducir la Colonia");
             return false;
        }else if(txtcalle.getText().isEmpty()){
             JOptionPane.showMessageDialog(null,"Favor de introducir la Calle");
             return false;
        }else if(txtcodigopostal.getText().isEmpty()){
             JOptionPane.showMessageDialog(null,"Favor de introducir el Codigo Postal");
             return false;
        }else if(txtnombre.getText().isEmpty()){
             JOptionPane.showMessageDialog(null,"Favor de introducir el Nombre");
             return false;
        }else if( txtapellidoP.getText().isEmpty()){
             JOptionPane.showMessageDialog(null,"Favor de introducir Apellido Paterno");
             return false;
        }else if(txttelefono.getText().isEmpty()){
             JOptionPane.showMessageDialog(null,"Favor de introducir Telefono");
             return false;
        }else if(txtcorreo.getText().isEmpty()){
             JOptionPane.showMessageDialog(null,"Favor de introducir su Correo");
             return false;
        }else if(txtcompania.getText().isEmpty()){
             JOptionPane.showMessageDialog(null,"Favor de introducir el Nombre de la Compania");
             return false;
        }
        else if(anyo <1938 || anyo>2000)
        {
             JOptionPane.showMessageDialog(null,"Favor de introducir Fecha de Nacimiento Correcta");
            return false;
        }
        return true;
    }
    
     private String FechaSql(String fecha_a_filtrar)
    {
        String dia="";
        String mes="";
        String anyo="";
        String fecha="";
        String temp;
        temp = fecha_a_filtrar.substring(4, 7).trim();
        switch(temp)
        {
            case "Jan":
                    mes="01";
            break;
            case "Feb":
                    mes="02";
            break;
            case "Mar":
                    mes="03";
            break;
            case "Apr":
                    mes="04";
            break;
            case "May":
                    mes="05";
            break;
            case "Jun":
                    mes="06";
            break;
           case "Jul":
                    mes="07";
            break;
            case "Aug":
                    mes="08";
            break;
            case "Sep":
                    mes="09";
            break;
            case "Oct":
                    mes="10";
            break;
            case "Nov":
                    mes="11";
            break;
            case "Dec":
                    mes="12";
            break;
            
        }
        dia = fecha_a_filtrar.substring(8, 10);
        anyo = fecha_a_filtrar.substring(24,28);
        fecha = dia+"-"+mes+"-"+anyo;
        return fecha;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtcompania = new javax.swing.JTextField();
        btnContinuar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtciudad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtcolonia = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtcalle = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtcodigopostal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtapellidoP = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtapellidoM = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtcorreo = new javax.swing.JTextField();
        txtfecha = new com.toedter.calendar.JDateChooser();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(950, 780));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Correo:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(320, 620, 100, 22);
        getContentPane().add(txtcompania);
        txtcompania.setBounds(390, 120, 310, 28);

        btnContinuar.setBackground(new java.awt.Color(51, 51, 51));
        btnContinuar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnContinuar.setForeground(new java.awt.Color(255, 255, 255));
        btnContinuar.setText("Contiunuar");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });
        getContentPane().add(btnContinuar);
        btnContinuar.setBounds(370, 690, 160, 34);

        btnRegresar.setBackground(new java.awt.Color(51, 51, 51));
        btnRegresar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresar);
        btnRegresar.setBounds(590, 690, 100, 34);

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Persona");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(470, 370, 110, 30);

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Agregar Proveedor");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(410, 20, 250, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nombre de la compañia:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(150, 120, 230, 22);
        getContentPane().add(txtciudad);
        txtciudad.setBounds(390, 220, 310, 28);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Ciudad:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(310, 220, 100, 22);
        getContentPane().add(txtcolonia);
        txtcolonia.setBounds(390, 260, 310, 28);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Colonia:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(310, 260, 100, 22);
        getContentPane().add(txtcalle);
        txtcalle.setBounds(390, 300, 310, 28);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Calle:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(330, 300, 90, 22);

        txtcodigopostal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodigopostalKeyTyped(evt);
            }
        });
        getContentPane().add(txtcodigopostal);
        txtcodigopostal.setBounds(390, 340, 310, 28);

        jLabel9.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Direccion");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(460, 170, 130, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Codigo Postal:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(260, 340, 140, 22);
        getContentPane().add(txtnombre);
        txtnombre.setBounds(390, 420, 310, 28);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Nombre:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(310, 420, 110, 22);
        getContentPane().add(txtapellidoP);
        txtapellidoP.setBounds(390, 460, 310, 28);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Apellido Paterno:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(230, 460, 160, 22);
        getContentPane().add(txtapellidoM);
        txtapellidoM.setBounds(390, 500, 310, 28);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Apellido Materno:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(230, 500, 170, 22);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Fecha de Nacimiento:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(190, 540, 200, 22);

        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefonoKeyTyped(evt);
            }
        });
        getContentPane().add(txttelefono);
        txttelefono.setBounds(390, 580, 310, 28);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Telefono:");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(300, 580, 110, 22);
        getContentPane().add(txtcorreo);
        txtcorreo.setBounds(390, 620, 310, 28);
        getContentPane().add(txtfecha);
        txtfecha.setBounds(390, 540, 110, 28);

        Fondo.setBackground(new java.awt.Color(51, 51, 51));
        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/orig_506983.jpg"))); // NOI18N
        Fondo.setText("jLabel3");
        getContentPane().add(Fondo);
        Fondo.setBounds(0, -10, 1060, 760);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        try {
            ingresarProveedor();
        } catch (SQLException ex) {
            Logger.getLogger(AgregarProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnContinuarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        dispose();
        new Agregar().setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void txtcodigopostalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigopostalKeyTyped
             char caracter = evt.getKeyChar();

      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '\b' /*corresponde a BACK_SPACE*/))
      {
         evt.consume();  // ignorar el evento de teclado
      }    }//GEN-LAST:event_txtcodigopostalKeyTyped

    private void txttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyTyped
                char caracter = evt.getKeyChar();

      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '\b' /*corresponde a BACK_SPACE*/))
      {
         evt.consume();  // ignorar el evento de teclado
      }                                         
    }//GEN-LAST:event_txttelefonoKeyTyped

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
            java.util.logging.Logger.getLogger(AgregarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarProveedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtapellidoM;
    private javax.swing.JTextField txtapellidoP;
    private javax.swing.JTextField txtcalle;
    private javax.swing.JTextField txtciudad;
    private javax.swing.JTextField txtcodigopostal;
    private javax.swing.JTextField txtcolonia;
    private javax.swing.JTextField txtcompania;
    private javax.swing.JTextField txtcorreo;
    private com.toedter.calendar.JDateChooser txtfecha;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
