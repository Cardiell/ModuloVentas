/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logico;

import dao.PersonaDao;
import entidades.Persona;
import java.util.List;

/**
 *
 * @author Cardiell
 */
public class PersonaLog {
    PersonaDao rol = new PersonaDao();
    
    public Boolean AgregarPersona(Persona tur)
    {
        return rol.AgregarPersonas(tur);
        
    } 
    
         public boolean EliminarPersona(int id)
    {
        return rol.EliminarPersonas(id);
    }
     
      public boolean UpdatePersona(Persona tur) {
        return rol.UpdatePersonas(tur);
    }
    
            
    public List<Persona> ListarPersona() {
      return rol.ListarPersonas();
    } 
}
