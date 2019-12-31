/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Persona;
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
public class PersonaDao {
        
    Conexion conexion = new Conexion();

    
      public boolean EliminarPersonas(int id)
    {
        Connection con = null;
        Statement st= null;
        boolean exs = true;
        try {
            con = conexion.getConecion();
             String query = "DELETE FROM Persona WHERE idPersona="+id;
             st = con.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar4(st);
        }
        return exs;
    }
    public boolean AgregarPersonas(Persona per) {
        Connection con = null;
        CallableStatement cstm = null;
        boolean resp = true;
        try {
            con = conexion.getConecion();
            con.setAutoCommit(false);
            cstm = con.prepareCall("{Call AgregarPersona(?,?,?,?,?,?,?)}");
            cstm.setString(1, per.getNombre());
            cstm.setString(2, per.getApellidoP());
            cstm.setString(3, per.getApellidoM());
            cstm.setString(4, per.getFechaNacimiento());
            cstm.setString(5, per.getTelefono());
            cstm.setString(6, per.getCorreo());
            cstm.setInt(7,per.getIdDireccion());
            resp = cstm.execute();
            con.commit();
        } catch (SQLException e){
            e.printStackTrace();
        }finally{
            conexion.Cerrar1(con, cstm);
        }
        return resp;
    }
    
    
    public boolean UpdatePersonas(Persona per) {
        Connection con = null;
        CallableStatement cstm = null;
        boolean resp = true;
        try {
            con = conexion.getConecion();
            con.setAutoCommit(false);
            cstm = con.prepareCall("{Call UpdatePersona(?,?,?,?,?,?,?,?)}");
            cstm.setInt(1, per.getIdPersona());
            cstm.setString(2, per.getNombre());
            cstm.setString(3, per.getApellidoP());
            cstm.setString(4, per.getApellidoM());
            cstm.setString(5, String.valueOf(per.getFechaNacimiento()));
            cstm.setString(6, per.getTelefono());
            cstm.setString(7, per.getCorreo());
            cstm.setInt(8,per.getIdDireccion());
            resp = cstm.execute();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar1(con, cstm);
        }
        return resp;
    }
    
    
     public List<Persona> ListarPersonas() {
        Connection con = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        List<Persona> lista = null;
        try {
            lista = new ArrayList<>();
            con = conexion.getConecion();
            cstm = con.prepareCall("{Call ListarPersona}");
            rs = cstm.executeQuery();
            Persona per = null;
            while (rs.next()) {
                per = new Persona();
                per.setIdPersona(rs.getInt("idPersona"));
                per.setNombre(rs.getString("nombre"));
                per.setApellidoP(rs.getString("apellidoP"));
                per.setApellidoM(rs.getString("apellidoM"));
                per.setFechaNacimiento(rs.getString("fechaNacimiento"));
                per.setTelefono(rs.getString("telefono"));
                per.setCorreo(rs.getString("correo"));
                per.setIdDireccion(rs.getInt("idDireccion"));

                lista.add(per);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar2(cstm, rs);
        }
        return lista;
    }
}
