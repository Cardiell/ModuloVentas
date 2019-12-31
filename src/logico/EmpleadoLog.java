/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logico;

import dao.EmpleadoDao;
import entidades.Empleado;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Cardiell
 */
public class EmpleadoLog {
            EmpleadoDao rol = new EmpleadoDao();
    
    public boolean OkEmpleado(int numEmpleado) throws SQLException
    {
        return rol.OkEmpleados(numEmpleado);
    }
        
            
    public Boolean AgregarEmpleado(Empleado emp)
    {
        return rol.AgregarEmpleados(emp);
        
    } 
    
         public boolean EliminarEmpleado(int id)
    {
        return rol.EliminarEmpleados(id);
    }
     
      public boolean UpdateEmpleado(Empleado emp) {
        return rol.UpdateEmpleados(emp);
    }
    
            
    public List<Empleado> ListarEmpleado() {
      return rol.ListarEmpleados();
    } 
}
