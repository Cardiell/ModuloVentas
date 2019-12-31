/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelotabla;

import entidades.Factura;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Cardiell
 */
public class ModeloTablaVentas extends AbstractTableModel {
    String[] columnas = {"num_factura","Fecha","Nombre Compania","Telefono","Correo","Colonia","Calle","Nombre","Apellido P"};
    public List<Factura> fac = new ArrayList<>();
    
    
    public ModeloTablaVentas(List<Factura> fac) {
        this.fac = fac;
    }
    
    
    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public int getRowCount() {
        return fac.size();
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
                resp = fac.get(rowIndex).getNum_factura();
                break;
            case 1:
                resp = fac.get(rowIndex).getFecha();
                break;
            case 2:
                resp = fac.get(rowIndex).getNombreCompania();
                break;
            case 3:
                resp = fac.get(rowIndex).getTelefono();
                break;
            case 4:
                resp = fac.get(rowIndex).getCorreo();
                break;                
            case 5:
                resp = fac.get(rowIndex).getColonia();
                break;
            case 6:
                resp = fac.get(rowIndex).getCalle();
            break;
            case 7:
                resp = fac.get(rowIndex).getNombre();
            default:
                resp =fac.get(rowIndex).getApellidoP();
                break;
                
       
        }
        return resp;
    }
    
    public Factura Damecompra(int fila) {
        return fac.get(fila);
    }
    
}
    