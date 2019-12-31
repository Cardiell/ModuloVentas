/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelotabla;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import entidades.Compra;

/**
 *
 * @author alberto jaquez
 */
public class ModeloTablaCompras extends AbstractTableModel {
    String[] columnas = {"Nombre","Fecha","Articulo","Cantidad","Proveedor","Correo Proveedor","Telefono Proveedor"};
    public List<Compra> con = new ArrayList<>();
    
    
    public ModeloTablaCompras(List<Compra> con) {
        this.con = con;
    }
    
    
    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public int getRowCount() {
        return con.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object resp = null;
        
        switch(columnIndex){
            case 0: 
                resp = con.get(rowIndex).getNombre();
                break;
            case 1:
                resp = con.get(rowIndex).getFechaCompra();
                break;
            case 2:
                resp = con.get(rowIndex).getNombreArticulo();
                break;
            case 3:
                resp = con.get(rowIndex).getCantidad();
                break;
            case 4:
                resp = con.get(rowIndex).getNombreCompania();
                break;

                
            case 5:
                resp = con.get(rowIndex).getCorreo();
                break;
            default:
                resp =con.get(rowIndex).getTelefono();
                break;
                
       
        }
        return resp;
    }
    
    public Compra Damecompra(int fila) {
        return con.get(fila);
    }
    
}
    
    
 
