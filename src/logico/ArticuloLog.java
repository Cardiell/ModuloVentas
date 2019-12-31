/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logico;

import dao.ArticuloDao;
import entidades.Articulo;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Cardiell
 */
public class ArticuloLog {
        ArticuloDao articulo = new ArticuloDao();
    
    
    
    public Boolean AgregarArticulo(Articulo art)
    {
        return articulo.AgregarArticulos(art);
        
    } 
    
         public boolean EliminarArticulo(String nombre)
    {
        return articulo.EliminarArticulos(nombre);
    }
     
      public boolean UpdateArticulo(Articulo cont) {
        return articulo.UpdateArticulos(cont);
    }
    
            
    public List<Articulo> ListarArticulo() {
      return articulo.ListarArticulos();
    } 
     public Boolean okarticulo(String art) throws SQLException
    {
           return articulo.OkArticulo(art);
        
    }
}
