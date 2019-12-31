/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logico;

import dao.DepartamentoDao;
import entidades.Departamento;
import java.util.List;

/**
 *
 * @author Cardiell
 */
public class DepartamentoLog {
    DepartamentoDao dep = new DepartamentoDao();
    
    public DepartamentoLog(){}
    
    public Departamento BuscarDepartamento(int buscar)
    {
        return dep.BuscarDepartamentos(buscar);
    }
    
    public Boolean AgregarDepartamento(Departamento depar)
    {
        return dep.AgregarDepartamentos(depar);
        
    } 
    
         public boolean EliminarDepartamento(int id)
    {
        return dep.EliminarDepartamentos(id);
    }
     
      public boolean UpdateDepartamento(Departamento depar) {
        return dep.UpdateDepartamentos(depar);
    }
    
            
    public List<Departamento> ListarDepartamento() {
      return dep.ListarDepartamentos();
    } 
}
