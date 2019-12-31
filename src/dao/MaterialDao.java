/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Material;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cardiell
 */
public class MaterialDao {
  Conexion conexion = new Conexion();

      public Material BuscarMaterialesIds(int idMaterial)
    {
        Connection con = null;
        PreparedStatement st= null;
        ResultSet rs = null;
        Material mat = new Material();

        try {
            con = conexion.getConecion();
             String query = "exec buscarMaterialId '"+idMaterial+"'";
             st = con.prepareStatement(query);
             rs = st.executeQuery();
            while (rs.next()) {
            mat.setIdMaterial(rs.getInt("idMaterial"));
            mat.setNombreMaterial(rs.getString("nombreMaterial"));
            mat.setExistencia(rs.getInt("existencia"));
            mat.setPrecio(rs.getFloat("precio"));
            mat.setImagen(rs.getString("imagen"));
            mat.setIdIncorrecto(rs.getInt("idIncorrecto"));
            mat.setIdCorrecto(rs.getInt("idCorrecto"));
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar3(st, rs);
        }
        return mat;
        
        
    }
      
    
    public List<Material> BuscarMateriales(String nombreMaterial)
    {
        Connection con = null;
        PreparedStatement st= null;
        ResultSet rs = null;
        List<Material> lista = null;
        try {
            lista = new ArrayList<>();
            con = conexion.getConecion();
             String query = "exec buscarMaterial '"+nombreMaterial+"'";
             st = con.prepareStatement(query);
             rs = st.executeQuery();
           
            Material mat;
            
            while (rs.next()) {
                mat = new Material();
            mat.setIdMaterial(rs.getInt("idMaterial"));
            mat.setNombreMaterial(rs.getString("nombreMaterial"));
            mat.setExistencia(rs.getInt("existencia"));
            mat.setPrecio(rs.getFloat("precio"));
            mat.setImagen(rs.getString("imagen"));
            mat.setIdIncorrecto(rs.getInt("idIncorrecto"));
            mat.setIdCorrecto(rs.getInt("idCorrecto"));
                lista.add(mat);
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar3(st, rs);
        }
        return lista;
        
        
    }
    
      public boolean EliminarMateriales(int idMaterial)
    {
        Connection con = null;
        Statement st= null;
        boolean exs = true;
        try {
            con = conexion.getConecion();
             String query = "DELETE FROM Material WHERE idMaterial="+idMaterial;
             st = con.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar4(st);
        }
        return exs;
    }
    public boolean AgregarMateriales(Material mat) {
        Connection con = null;
        CallableStatement cstm = null;
        boolean resp = true;
        try {
            con = conexion.getConecion();
            con.setAutoCommit(false);
            cstm = con.prepareCall("{Call AgregarMaterial(?,?,?,?,?,?,)}");
            cstm.setString(1, mat.getNombreMaterial());
            cstm.setInt(2,mat.getExistencia());
            cstm.setFloat(3,mat.getPrecio());
            cstm.setString(4,mat.getImagen());
            cstm.setInt(5,mat.getIdIncorrecto());
            cstm.setInt(6,mat.getIdCorrecto());
            resp = cstm.execute();
            con.commit();
        } catch (SQLException e){
            e.printStackTrace();
        }finally{
            conexion.Cerrar1(con, cstm);
        }
        return resp;
    }
    
    
    public boolean UpdateMateriales(Material mat) {
        Connection con = null;
        CallableStatement cstm = null;
        boolean resp = true;
        try {
            con = conexion.getConecion();
            con.setAutoCommit(false);
            cstm = con.prepareCall("{Call UpdateMaterial(?,?,?,?,?,?,?)}");
            cstm.setInt(1,mat.getIdMaterial());
            cstm.setString(2, mat.getNombreMaterial());
            cstm.setInt(3,mat.getExistencia());
            cstm.setFloat(4,mat.getPrecio());
            cstm.setString(5,mat.getImagen());
            cstm.setInt(6,mat.getIdIncorrecto());
            cstm.setInt(7,mat.getIdCorrecto());
            resp = cstm.execute();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar1(con, cstm);
        }
        return resp;
    }
    
    
     public List<Material> ListarMateriales() {
        Connection con = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        List<Material> lista = null;
        try {
            lista = new ArrayList<>();
            con = conexion.getConecion();
            cstm = con.prepareCall("{Call ListarMaterial}");
            rs = cstm.executeQuery();
            Material mat = null;
            while (rs.next()) {
                
            mat = new Material();
            mat.setIdMaterial(rs.getInt("idMaterial"));
            mat.setNombreMaterial(rs.getString("nombreMaterial"));
            mat.setExistencia(rs.getInt("existencia"));
            mat.setPrecio(rs.getFloat("precio"));
            mat.setImagen(rs.getString("imagen"));
            mat.setIdIncorrecto(rs.getInt("idIncorrecto"));
            mat.setIdCorrecto(rs.getInt("idCorrecto"));
            lista.add(mat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar2(cstm, rs);
        }
        return lista;
    }
}
