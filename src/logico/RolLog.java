/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logico;

import dao.RolDao;
import entidades.Rol;
import java.util.List;

/**
 *
 * @author Cardiell
 */
public class RolLog {
        RolDao rol = new RolDao();
    
    
    
    public Boolean AgregarRol(Rol prov)
    {
        return rol.AgregarRols(prov);
        
    } 
    
         public boolean EliminarRol(int id)
    {
        return rol.EliminarRols(id);
    }
     
      public boolean UpdateRol(Rol prov) {
        return rol.UpdateRols(prov);
    }
    
            
    public List<Rol> ListarRol() {
      return rol.ListarRols();
    } 
}
