/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Direccion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cardiell
 */
public class DireccionDao {
        
    Conexion conexion = new Conexion();

    
      public boolean EliminarDirecciones(int id)
    {
        Connection con = null;
        Statement st= null;
        boolean exs = true;
        try {
            con = conexion.getConecion();
             String query = "DELETE FROM Direccion WHERE idDireccion="+id;
             st = con.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar4(st);
        }
        return exs;
    }
    public boolean AgregarDirecciones(Direccion dep) {
        Connection con = null;
        CallableStatement cstm = null;
        boolean resp = true;
        try {
            con = conexion.getConecion();
            con.setAutoCommit(false);
            cstm = con.prepareCall("{Call AgregarDireccion(?,?,?,?)}");
            cstm.setString(1,dep.getCiudad());
            cstm.setString(2,dep.getColonia());
            cstm.setString(3,dep.getCalle());
            cstm.setInt(4,dep.getCP());
            resp = cstm.execute();
            con.commit();
        } catch (SQLException e){
            e.printStackTrace();
        }finally{
            conexion.Cerrar1(con, cstm);
        }
        return resp;
    }
    
    
    public boolean UpdateDirecciones(Direccion dep) {
        Connection con = null;
        CallableStatement cstm = null;
        boolean resp = true;
        try {
            con = conexion.getConecion();
            con.setAutoCommit(false);
            cstm = con.prepareCall("{Call UpdateDireccion(?,?,?,?,?)}");
            cstm.setInt(1, dep.getIdDireccion());
            cstm.setString(2,dep.getCiudad());
            cstm.setString(3,dep.getColonia());
            cstm.setString(4,dep.getCalle());
            cstm.setInt(5,dep.getCP());
            resp = cstm.execute();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar1(con, cstm);
        }
        return resp;
    }
    
    
     public List<Direccion> ListarDirecciones() {
        Connection con = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        List<Direccion> lista = null;
        try {
            lista = new ArrayList<>();
            con = conexion.getConecion();
            cstm = con.prepareCall("{Call ListarDireccion}");
            rs = cstm.executeQuery();
            Direccion dep = null;
            while (rs.next()) {
                dep = new Direccion();
                dep.setIdDireccion(rs.getInt("idDireccion"));
                dep.setCiudad(rs.getString("ciudad"));
                dep.setColonia(rs.getString("colonia"));
                dep.setCalle(rs.getString("calle"));
                dep.setCP(rs.getInt("CP"));

                lista.add(dep);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar2(cstm, rs);
        }
        return lista;
    }
}
