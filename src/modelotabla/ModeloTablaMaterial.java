package modelotabla;

import entidades.Material;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;


/**
 *
 * @author Cardiell
 */
public class ModeloTablaMaterial extends AbstractTableModel{

    String[] columnas = {"id", "Nombre Producto", "Precio","Existencia","imagen","Anadir al Carrito"};
    public List<Material> mat = new ArrayList<>();

    public ModeloTablaMaterial(List<Material> mat) {
        this.mat = mat;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public int getRowCount() {
        return mat.size();
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
                resp = mat.get(rowIndex).getIdMaterial();
                break;
            case 1:
                resp = mat.get(rowIndex).getNombreMaterial();
                break;
            case 2:
                resp = mat.get(rowIndex).getPrecio();
                break;
            case 3:
                resp = mat.get(rowIndex).getExistencia();
                break;
            case 4:
                resp = new JLabel(new ImageIcon(mat.get(rowIndex).getImagen()));
                break;
            default:
                resp = new JButton();
                break;

        }
        return resp;
    }

    public Material DameMaterial(int fila) {
        return mat.get(fila);
    }
    
}
