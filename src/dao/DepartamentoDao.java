/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Departamento;
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
public class DepartamentoDao {
      Conexion conexion = new Conexion();

        public Departamento BuscarDepartamentos(int buscar)
        {
        Connection con = null;
        PreparedStatement st= null;
        ResultSet rs = null;
        Departamento cont = new Departamento();
        try {
            con = conexion.getConecion();
             String query = "exec BuscarDepartamento '"+buscar+"'";
             st = con.prepareStatement(query);
             rs = st.executeQuery();
           
            
            while (rs.next()) {
                cont.setIdDepartamento(rs.getInt("idDepartamento"));
                cont.setDescripcion(rs.getString("descripcion"));
                cont.setPresupuesto(rs.getFloat("presupuesto"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar3(st, rs);
        }
        return cont;
        
        
    }
    
      public boolean EliminarDepartamentos(int id)
    {
        Connection con = null;
        Statement st= null;
        boolean exs = true;
        try {
            con = conexion.getConecion();
             String query = "DELETE FROM Departamento WHERE idDepartamento="+id;
             st = con.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar4(st);
        }
        return exs;
    }
    public boolean AgregarDepartamentos(Departamento dep) {
        Connection con = null;
        CallableStatement cstm = null;
        boolean resp = true;
        try {
            con = conexion.getConecion();
            con.setAutoCommit(false);
            cstm = con.prepareCall("{Call AgregarDepartamento(?,?)}");
            cstm.setString(1,dep.getDescripcion());
            cstm.setFloat(2,dep.getPresupuesto());
            resp = cstm.execute();
            con.commit();
        } catch (SQLException e){
            e.printStackTrace();
        }finally{
            conexion.Cerrar1(con, cstm);
        }
        return resp;
    }
    
    
    public boolean UpdateDepartamentos(Departamento dep) {
        Connection con = null;
        CallableStatement cstm = null;
        boolean resp = true;
        try {
            con = conexion.getConecion();
            con.setAutoCommit(false);
            cstm = con.prepareCall("{Call UpdateDepartamento(?,?,?)}");
            cstm.setInt(1, dep.getIdDepartamento());
            cstm.setString(2,dep.getDescripcion());
            cstm.setFloat(3,dep.getPresupuesto());
            resp = cstm.execute();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar1(con, cstm);
        }
        return resp;
    }
    
    
     public List<Departamento> ListarDepartamentos() {
        Connection con = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        List<Departamento> lista = null;
        try {
            lista = new ArrayList<>();
            con = conexion.getConecion();
            cstm = con.prepareCall("{Call ListarDepartamento}");
            rs = cstm.executeQuery();
            Departamento dep = null;
            while (rs.next()) {
                dep = new Departamento();
                dep.setIdDepartamento(rs.getInt("idDepartamento"));
                dep.setDescripcion(rs.getString("Descripcion"));
                dep.setPresupuesto(rs.getFloat("presupuesto"));
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
