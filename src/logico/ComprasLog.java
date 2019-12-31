/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logico;




import dao.ComprasDao;
import entidades.Compra;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author alberto jaquez
 */
public class ComprasLog {
    ComprasDao compras = new ComprasDao();
    
    
    
    public Boolean AgregarCompra(Compra cont)
    {
        return compras.AgregarCompra(cont);
        
    }      
    
        public boolean OkArticulo(String Articulo) throws SQLException
        {
            return compras.OkArticulos(Articulo);
        }
        
        public boolean OkProveedores(String Provedor) throws SQLException
        {
            
            return compras.OkProveedor(Provedor);
        }
        public boolean OkUser(String user) throws SQLException
        {
            return compras.OkUser(user);
            
        }

    
     public boolean EliminarCcompra(int id)
    {
        return compras.EliminarCompra(id);
    }
     
      public boolean UpdateCompras(Compra cont,int id) {
        return compras.UpdateCompra(cont,id);
    }
    
    public Compra SelectPresupuesto(String nombreArticulo) {
        return compras.SelectPresupuestos(nombreArticulo);
    }
      
      public List<Compra> BuscarPedimento(String buscar)
     {
         return compras.BuscarPedimentos(buscar);
     }

      
      
    public List<Compra> ListarPedimento() {
      return compras.ListarPedimentos();
    }  
    
}
