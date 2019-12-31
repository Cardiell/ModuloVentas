/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.User;
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
public class UserDao {
        
    Conexion conexion = new Conexion();

          public boolean OkUser(String user) throws SQLException
    {
        Connection cn = null;
        int ingreso = 0;
        boolean regresa = false;

        try{
            PreparedStatement ps =null;
            ResultSet rs =null;
             cn = conexion.getConecion();

            ps = cn.prepareStatement("exec OkUser ?");
            ps.setString(1,user);
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

    public boolean OkEmpleados(int numEmpleado) throws SQLException
    {
        Connection cn = null;
        int ingreso = 0;
        boolean regresa = false;

        try{
            PreparedStatement ps =null;
            ResultSet rs =null;
             cn = conexion.getConecion();

            ps = cn.prepareStatement("exec OkEmpleado ?");
            ps.setInt(1,numEmpleado);
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
    public int Logeos(String UserName,String pass) throws SQLException
    {
        Connection cn = null;
        int ingreso = 0;

        try{
            PreparedStatement ps =null;
            ResultSet rs =null;
             cn = conexion.getConecion();

            ps = cn.prepareStatement("exec UserRegistrado ?,?");
            ps.setString(1,UserName);
            ps.setString(2, pass);
            rs=ps.executeQuery();
            if(rs.next())
            {
                ingreso = Integer.parseInt(rs.getString(1));
            }
            }catch(Exception e)
            {
                        
            }
        return ingreso;
    }

    
    public User ListarLogins(String nameUser) {
        Connection con = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        User usr = null;
        try {
            con = conexion.getConecion();
            cstm = con.prepareCall("exec ListarLogin "+nameUser);
            rs = cstm.executeQuery();
            while (rs.next()) {
                usr = new User();
                usr.setNameUser(rs.getString("nameUser"));
                usr.setPass(rs.getString("pass"));
                usr.setImagen(rs.getString("imagen"));
                usr.setNumEmpleado(rs.getInt("numEmpleado"));
                usr.setIdRol(rs.getInt("idRol"));
                usr.setIdDepartamento(rs.getInt("idDepartamento"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar2(cstm, rs);
        }
        return usr;
    }
      public boolean EliminarUsers(String nombre)
    {
        Connection con = null;
        Statement st= null;
        boolean exs = true;
        try {
            con = conexion.getConecion();
             String query = "DELETE FROM Users WHERE nameUser="+nombre;
             st = con.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar4(st);
        }
        return exs;
    }
    public boolean AgregarUsers(User usr) {
        Connection con = null;
        CallableStatement cstm = null;
        boolean resp = true;
        try {
            con = conexion.getConecion();
            con.setAutoCommit(false);
            cstm = con.prepareCall("{Call AgregarUser(?,?,?,?)}");
            cstm.setString(1, usr.getNameUser());
            cstm.setString(2, usr.getPass());
            cstm.setString(3,usr.getImagen());
            cstm.setInt(4,usr.getNumEmpleado());//numEmpleado
            resp = cstm.execute();
            con.commit();
        } catch (SQLException e){
            e.printStackTrace();
        }finally{
            conexion.Cerrar1(con, cstm);
        }
        return resp;
    }
    
    
    public boolean UpdateUsers(User usr) {
        Connection con = null;
        CallableStatement cstm = null;
        boolean resp = true;
        try {
            con = conexion.getConecion();
            con.setAutoCommit(false);
            cstm = con.prepareCall("{Call UpdateUser(?,?,?,?)}");
            cstm.setString(1, usr.getNameUser());
            cstm.setString(2,usr.getPass());
            cstm.setString(3,usr.getImagen());
            cstm.setInt(4,usr.getNumEmpleado());
            resp = cstm.execute();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar1(con, cstm);
        }
        return resp;
    }
    
    
     public List<User> ListarUsers() {
        Connection con = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        List<User> lista = null;
        try {
            lista = new ArrayList<>();
            con = conexion.getConecion();
            cstm = con.prepareCall("{Call ListarUser}");
            rs = cstm.executeQuery();
            User usr = null;
            while (rs.next()) {
                usr = new User();
                usr.setNameUser(rs.getString("nameUser"));
                usr.setPass(rs.getString("pass"));
                usr.setImagen(rs.getString("imagen"));
                usr.setNumEmpleado(rs.getInt("numEmpleado"));

                lista.add(usr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar2(cstm, rs);
        }
        return lista;
    }
}
