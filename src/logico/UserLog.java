/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logico;

import dao.UserDao;
import entidades.User;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Cardiell
 */
public class UserLog{
    
    UserDao articulo = new UserDao();
    
    public int Logeo(String UserName,String pass) throws SQLException
    {
        return articulo.Logeos(UserName, pass);
    }
       
    public boolean OkUser(String user) throws SQLException
    {
        return articulo.OkUser(user);
    }
        
    public boolean OkEmpleado(int numEmpleado) throws SQLException
    {
        return articulo.OkEmpleados(numEmpleado);
    }
            
    public User ListarLogin(String nameUser) 
    {
        return articulo.ListarLogins(nameUser);
    }
    
    public Boolean AgregarUser(User art)
    {
        return articulo.AgregarUsers(art);
        
    } 
    
         public boolean EliminarUser(String nombre)
    {
        return articulo.EliminarUsers(nombre);
    }
     
      public boolean UpdateUser(User art) {
        return articulo.UpdateUsers(art);
    }
    
            
    public List<User> ListarUser() {
      return articulo.ListarUsers();
    }
}
