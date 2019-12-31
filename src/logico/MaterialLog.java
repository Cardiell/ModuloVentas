/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logico;

import dao.MaterialDao;
import entidades.Material;
import java.util.List;

/**
 *
 * @author Cardiell
 */
public class MaterialLog {
    
    MaterialDao compras = new MaterialDao();
    
    public Material BuscarMaterialesId(int idMaterial)
    {
        return compras.BuscarMaterialesIds(idMaterial);
    }

    
    public Boolean AgregarMaterial(Material cont)
    {
        return compras.AgregarMateriales(cont);
        
    }      

    
     public boolean EliminarMaterial(int id)
    {
        return compras.EliminarMateriales(id);
    }
     
      public boolean UpdateMaterial(Material cont) {
        return compras.UpdateMateriales(cont);
    }
    
      
      
      public List<Material> BuscarMaterial(String buscar)
     {
         return compras.BuscarMateriales(buscar);
     }

      
      
    public List<Material> ListarMaterial() {
      return compras.ListarMateriales();
    }  
}
