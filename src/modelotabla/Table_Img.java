/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelotabla;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Cardiell
 */
public class Table_Img extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o,
            boolean bln, boolean bln1, int i, int i1){
            if(o instanceof JLabel)
            {
                JLabel lbl =(JLabel)o;
                lbl.setBounds(0,0,90,90);
                Icon temp=lbl.getIcon();                
                ImageIcon lblDisp= new ImageIcon(temp.toString());
                 Icon icono = new ImageIcon(lblDisp.getImage().getScaledInstance(lbl.getWidth()-1,lbl.getHeight()-1,Image.SCALE_DEFAULT));    
                 lbl.setIcon(icono);
                return lbl;
            }
            else if(o instanceof JButton)
            {
                JButton btn =(JButton)o;
                btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                btn.setText("Anadir");
                btn.setBackground(Color.red); 
                 return btn;
            }
        return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
