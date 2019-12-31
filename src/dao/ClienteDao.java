/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Cliente;
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
public class ClienteDao {
    
    Conexion conexion = new Conexion();

    
      public boolean EliminarClientes(String nombre)
    {
        Connection con = null;
        Statement st= null;
        boolean exs = true;
        try {
            con = conexion.getConecion();
             String query = "DELETE FROM Cliente WHERE nombreCompania="+nombre;
             st = con.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar4(st);
        }
        return exs;
    }
      
    public boolean AgregarClientees(Cliente cli) {
        Connection con = null;
        CallableStatement cstm = null;
        boolean resp = true;
        try {
            con = conexion.getConecion();
            con.setAutoCommit(false);
            cstm = con.prepareCall("{Call AgregarCliente(?,?)}");
            cstm.setString(1, cli.getNombreCompania());
            cstm.setInt(2,cli.getIdPersona());
            resp = cstm.execute();
            con.commit();
        } catch (SQLException e){
            e.printStackTrace();
        }finally{
            conexion.Cerrar1(con, cstm);
        }
        return resp;
    }
    
    
    public boolean UpdateClientes(Cliente cli) {
        Connection con = null;
        CallableStatement cstm = null;
        boolean resp = true;
        try {
            con = conexion.getConecion();
            con.setAutoCommit(false);
            cstm = con.prepareCall("{Call UpdateCliente(?,?)}");
            cstm.setString(1, cli.getNombreCompania());
            cstm.setInt(2,cli.getIdPersona());
            resp = cstm.execute();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar1(con, cstm);
        }
        return resp;
    }
    
    
     public List<Cliente> ListarClientes() {
        Connection con = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        List<Cliente> lista = null;
        try {
            lista = new ArrayList<>();
            con = conexion.getConecion();
            cstm = con.prepareCall("{Call ListarCliente}");
            rs = cstm.executeQuery();
            Cliente cli = null;
            while (rs.next()) {
                cli = new Cliente();
                cli.setNombreCompania(rs.getString("nombreCompania"));
                cli.setIdPersona(rs.getInt("idPersona"));

                lista.add(cli);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar2(cstm, rs);
        }
        return lista;
    }

    public boolean OkClientes(String nombreCompania) throws SQLException
    {
        Connection cn = null;
        int ingreso = 0;
        boolean regresa = false;

        try{
            PreparedStatement ps =null;
            ResultSet rs =null;
             cn = conexion.getConecion();

            ps = cn.prepareStatement("exec OkCliente ?");
            ps.setString(1,nombreCompania);
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



     
     public Cliente BuscarClientes(String nombreCompania) {
        Connection con = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        Cliente cli = new Cliente();
        try {
            con = conexion.getConecion();
            cstm = con.prepareCall("exec BuscarCliente "+nombreCompania);
            rs = cstm.executeQuery();
            while (rs.next()) {
                cli.setIdCliente(rs.getInt("idCliente"));
                cli.setNombreCompania(rs.getString("nombreCompania"));
                cli.setIdPersona(rs.getInt("idPersona"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar2(cstm, rs);
        }
        return cli;
    }
}
