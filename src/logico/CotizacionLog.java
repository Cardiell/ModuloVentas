/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logico;

import dao.CotizacionDao;
import dao.CotizarMaterialDao;
import entidades.Cotizacion;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Cardiell
 */
public class CotizacionLog {
    CotizacionDao dep = new CotizacionDao();
    
    public CotizacionLog(){}
    
    public List<Cotizacion>  ListarCotizacion()
    {
        return dep.ListarCotizacions();
    }
    
    public boolean OkCotizar(int idCotizar) throws SQLException
    {
        return dep.OkCotizar(idCotizar);
    }

    public Boolean AgregarCotizacion(Cotizacion depar)
    {
        return dep.AgregarCotizaciones(depar);
        
    } 
    
     public boolean EliminarCotizacion(int idCotizar)
    {
        return dep.EliminarCotizaciones(idCotizar);
    }
     
    public boolean  EliminarCotizar(int idCotizar)
    {
        return dep.EliminarCotizar(idCotizar);
    }
 
     
      public boolean UpdateCotizacion(Cotizacion depar) {
        return dep.UpdateCotizaciones(depar);
    }
    
}
