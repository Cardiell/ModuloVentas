/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logico;

import dao.FacturaDao;
import entidades.Factura;
import java.util.List;

/**
 *
 * @author Cardiell
 */
public class FacturaLog {
    FacturaDao articulo = new FacturaDao();
    
    public List<Factura> BuscarFactura(String buscar)
    {
        return articulo.BuscarFacturas(buscar);
    }
    
    public Boolean AgregarFactura(Factura art)
    {
        return articulo.AgregarFacturas(art);
        
    } 
    public List<Factura> MostrarFactura() {
        return articulo.MostrarFacturas();
    }
         public boolean EliminarFactura(int num_fac)
    {
        return articulo.EliminarFacturas(num_fac);
    }
     
      public boolean UpdateFactura(Factura fact) {
        return articulo.UpdateFacturas(fact);
    }
    
            
    public List<Factura> ListarFactura() {
      return articulo.ListarFacturas();
    } 

}
