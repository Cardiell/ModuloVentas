/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CotizarMaterial;
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
public class CotizarMaterialDao {
    
    Conexion conexion = new Conexion();

    
    public boolean EliminarCotizarMateriales(int idCotizar,int idMaterial)
    {
        Connection con = null;
        Statement st= null;
        boolean exs = true;
        try {
            con = conexion.getConecion();
             String query = "DELETE FROM CotizarMaterial WHERE idCotizar="+idCotizar+" and idMaterial="+idMaterial ;
             st = con.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar4(st);
        }
        return exs;
    }
    public CotizarMaterial BuscarCotizarMateriales(int idCotizar)
    {
        Connection con = null;
        PreparedStatement st= null;
        ResultSet rs = null;
        CotizarMaterial cont = new CotizarMaterial();
        try {
            con = conexion.getConecion();
             String query = "exec BuscarCotizarMaterial "+idCotizar;
             st = con.prepareStatement(query);
             rs = st.executeQuery();
            while (rs.next()) {
                cont.setIdCotizar(rs.getInt("idCotizar"));
                cont.setIdMaterial(rs.getInt("idMaterial"));               
                cont.setCantidad(rs.getInt("cantidad"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar3(st, rs);
        }
        return cont;
    }
     
    public CotizarMaterial BuscarCotizarMateriales(int idCotizar,int idMaterial)
    {
        Connection con = null;
        PreparedStatement st= null;
        ResultSet rs = null;
        CotizarMaterial cont = new CotizarMaterial();
        try {
            con = conexion.getConecion();
             String query = "exec BuscarCotizarMaterial "+idCotizar+","+idMaterial;
             st = con.prepareStatement(query);
             rs = st.executeQuery();
            while (rs.next()) {
                cont.setIdCotizar(rs.getInt("idCotizar"));
                cont.setIdMaterial(rs.getInt("idMaterial"));               
                cont.setCantidad(rs.getInt("cantidad"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar3(st, rs);
        }
        return cont;
    }
    
    public boolean EliminarCotizarMateriales(int idCotizar)
    {
        Connection con = null;
        Statement st= null;
        boolean exs = true;
        try {
            con = conexion.getConecion();
             String query = "DELETE FROM CotizarMaterial WHERE idCotizar="+idCotizar;
             st = con.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar4(st);
        }
        return exs;
    }
    public boolean AgregarCotizarMateriales(CotizarMaterial cot) {
        Connection con = null;
        CallableStatement cstm = null;
        boolean resp = true;
        try {
            con = conexion.getConecion();
            con.setAutoCommit(false);
            cstm = con.prepareCall("{Call AgregarCotizarMaterial(?,?,?)}");
            cstm.setInt(1, cot.getIdCotizar());
            cstm.setInt(2,cot.getIdMaterial());
            cstm.setInt(3,cot.getCantidad());
            resp = cstm.execute();
            con.commit();
        } catch (SQLException e){
            e.printStackTrace();
        }finally{
            conexion.Cerrar1(con, cstm);
        }
        return resp;
    }
    
    
    public boolean UpdateCotizarMateriales(CotizarMaterial cot) {
        Connection con = null;
        CallableStatement cstm = null;
        boolean resp = true;
        try {
            con = conexion.getConecion();
            con.setAutoCommit(false);
            cstm = con.prepareCall("{Call UpdateCotizarMaterial(?,?,?)}");
            cstm.setInt(1, cot.getIdCotizar());
            cstm.setInt(2,cot.getIdMaterial());
            cstm.setInt(3,cot.getCantidad());
            resp = cstm.execute();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar1(con, cstm);
        }
        return resp;
    }
    
    
     public List<CotizarMaterial> ListarCotizarMateriales(int idCotizar) {
         Connection con = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        List<CotizarMaterial> lista = null;
        try {
            lista = new ArrayList<>();
            con = conexion.getConecion();
            cstm = con.prepareCall("exec ListarCotizarMaterial "+idCotizar);
            rs = cstm.executeQuery();
            CotizarMaterial cot = null;
            while (rs.next()) {
                cot = new CotizarMaterial();
                cot.setIdCotizar(rs.getInt("idCotizar"));
                cot.setIdMaterial(rs.getInt("idMaterial"));
                cot.setCantidad(rs.getInt("cantidad"));
                lista.add(cot);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar2(cstm, rs);
        }
        return lista;
    }
     
     
     
     public List<CotizarMaterial> ListarCotizarMateriales() {
         Connection con = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        List<CotizarMaterial> lista = null;
        try {
            lista = new ArrayList<>();
            con = conexion.getConecion();
            cstm = con.prepareCall("exec ListarCotizarMaterialMaterial");
            rs = cstm.executeQuery();
            CotizarMaterial cot = null;
            while (rs.next()) {
                cot = new CotizarMaterial();
                cot.setIdCotizar(rs.getInt("idCotizar"));
                cot.setIdMaterial(rs.getInt("idMaterial"));
                cot.setCantidad(rs.getInt("cantidad"));
                lista.add(cot);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar2(cstm, rs);
        }
        return lista;
    }
     
       public boolean OkCotizarMateriales(int idCotizar,int idMaterial) throws SQLException
    {
        Connection cn = null;
        int ingreso = 0;
        boolean regresa = false;

        try{
            PreparedStatement ps =null;
            ResultSet rs =null;
             cn = conexion.getConecion();
            ps = cn.prepareStatement("exec OkCotizarMaterial ?,?");
            ps.setInt(1,idCotizar);
            ps.setInt(2, idMaterial);
            rs=ps.executeQuery();
            if(rs.next())
            {
                ingreso = Integer.parseInt(rs.getString(1));
            }
            }catch(Exception e)
            {
                        
            }
        if(ingreso>0)
            regresa=true;
        return regresa;
    }
}
