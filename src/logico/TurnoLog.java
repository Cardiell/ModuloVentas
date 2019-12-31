/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logico;

import dao.TurnoDao;
import entidades.Turno;
import java.util.List;

/**
 *
 * @author Cardiell
 */
public class TurnoLog {
    TurnoDao rol = new TurnoDao();
    
    public Boolean AgregarTurno(Turno tur)
    {
        return rol.AgregarTurnos(tur);
        
    } 
    
         public boolean EliminarTurno(int id)
    {
        return rol.EliminarTurnos(id);
    }
     
      public boolean UpdateTurno(Turno tur) {
        return rol.UpdateTurnos(tur);
    }
    
            
    public List<Turno> ListarTurno() {
      return rol.ListarTurnos();
    } 
}
