/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logico;

import dao.ProveedoresDao;
import entidades.Proveedor;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Cardiell
 */
public class ProveedorLog {
    ProveedoresDao compras = new ProveedoresDao();
    
    
    
    public Boolean AgregarProveedor(Proveedor prov)
    {
        return compras.AgregarProveedores(prov);
        
    } 
    
         public boolean EliminarProveedor(String nombre)
    {
        return compras.EliminarProveedores(nombre);
    }
     
      public boolean UpdateProveedor(Proveedor prov) {
        return compras.UpdateProveedores(prov);
    }
    
            
    public List<Proveedor> ListarProveedor() {
      return compras.ListarProveedores();
    } 
    
     public Boolean okProveedor(String Proveedor) throws SQLException
    {
        return compras.OkProveedor(Proveedor);
        
    }
}
