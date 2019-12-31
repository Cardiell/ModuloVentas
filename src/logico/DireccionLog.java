/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logico;

import dao.DireccionDao;
import entidades.Direccion;
import java.util.List;


/**
 *
 * @author Cardiell
 */
public class DireccionLog {
    DireccionDao dep = new DireccionDao();
    
    
    
    public Boolean AgregarDireccion(Direccion direc)
    {
        return dep.AgregarDirecciones(direc);
        
    } 
    
         public boolean EliminarDireccion(int id)
    {
        return dep.EliminarDirecciones(id);
    }
     
      public boolean UpdateDireccion(Direccion direc) {
        return dep.UpdateDirecciones(direc);
    }
    
            
    public List<Direccion> ListarDireccion() {
      return dep.ListarDirecciones();
    } 
}
