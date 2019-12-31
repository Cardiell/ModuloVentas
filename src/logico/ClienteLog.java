/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logico;

import dao.ClienteDao;
import entidades.Cliente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Cardiell
 */
public class ClienteLog {
     ClienteDao cliente = new ClienteDao();
    
    public boolean OkCliente(String nombreCompania) throws SQLException
    {
        return cliente.OkClientes(nombreCompania);
    }
 
     
    public Cliente BuscarCliente(String nombreCompania) 
    {
        return cliente.BuscarClientes(nombreCompania);
    }
    
    public Boolean AgregarCliente(Cliente prov)
    {
        return cliente.AgregarClientees(prov);
        
    } 
    
         public boolean EliminarCliente(String nombre)
    {
        return cliente.EliminarClientes(nombre);
    }
     
      public boolean UpdateCliente(Cliente prov) {
        return cliente.UpdateClientes(prov);
    }
    
            
    public List<Cliente> ListarCliente() {
      return cliente.ListarClientes();
    } 
}
