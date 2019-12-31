/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logico;

import dao.CotizarMaterialDao;
import entidades.Cotizacion;
import entidades.CotizarMaterial;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Cardiell
 */
public class CotizarMaterialLog {
     CotizarMaterialDao dep = new CotizarMaterialDao();
    
    public CotizarMaterialLog(){}
    
    public List<CotizarMaterial>  ListarCotizacion()
    {
        return dep.ListarCotizarMateriales();
    }
    public boolean EliminarCotizarMaterial(int idCotizar,int idMaterial)
    {
        return dep.EliminarCotizarMateriales(idCotizar, idMaterial);
    }
    public boolean EliminarCotizarMaterial(int idCotizar)
    {
        return dep.EliminarCotizarMateriales(idCotizar);
    }
    public CotizarMaterial BuscarCotizarMaterial(int idCotizar)
    {
        return dep.BuscarCotizarMateriales(idCotizar);
    }
    public CotizarMaterial BuscarCotizarMaterial(int idCotizar,int idMaterial)
    {
        return dep.BuscarCotizarMateriales(idCotizar,idMaterial);
    }

    public boolean AgregarCotizarMaterial(CotizarMaterial cot)
    {
        return dep.AgregarCotizarMateriales(cot);
    }
    
    public boolean UpdateCotizarMaterial(CotizarMaterial cot)
    {
        return dep.UpdateCotizarMateriales(cot);
    }
    
    public List<CotizarMaterial> ListarCotizarMaterial(int idCotizar) {
         return dep.ListarCotizarMateriales(idCotizar);
     }
    
      public List<CotizarMaterial> ListarCotizarMaterial() {
         return dep.ListarCotizarMateriales();
     }
    
    public boolean OkCotizarMaterial(int idCotizar,int idMaterial) throws SQLException
    {
        return dep.OkCotizarMateriales(idCotizar,idMaterial);
    }


}
