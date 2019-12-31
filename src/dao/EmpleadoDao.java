package dao;

import entidades.Empleado;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Cardiell
 */
public class EmpleadoDao {
  
    Conexion conexion = new Conexion();

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
    
      public boolean EliminarEmpleados(int num)
    {
        Connection con = null;
        Statement st= null;
        boolean exs = true;
        try {
            con = conexion.getConecion();
             String query = "DELETE FROM Empleado WHERE numEmpleado="+num;
             st = con.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar4(st);
        }
        return exs;
    }
    public boolean AgregarEmpleados(Empleado emp) {
        Connection con = null;
        CallableStatement cstm = null;
        boolean resp = true;
        try {
            con = conexion.getConecion();
            con.setAutoCommit(false);
            cstm = con.prepareCall("{Call AgregarEmpleado(?,?,?,?)}");
            cstm.setInt(1,emp.getIdPersona());
            cstm.setInt(2,emp.getIdDepartamento());
            cstm.setInt(3,emp.getIdRol());
            cstm.setInt(4,emp.getIdTurno());
            resp = cstm.execute();
            con.commit();
        } catch (SQLException e){
            e.printStackTrace();
        }finally{
            conexion.Cerrar1(con, cstm);
        }
        return resp;
    }
    
    
    public boolean UpdateEmpleados(Empleado emp) {
        Connection con = null;
        CallableStatement cstm = null;
        boolean resp = true;
        try {
            con = conexion.getConecion();
            con.setAutoCommit(false);
            cstm = con.prepareCall("{Call UpdateEmpleado(?,?,?,?,?)}");
            cstm.setInt(1, emp.getNumEmpleado());
            cstm.setInt(2,emp.getIdPersona());
            cstm.setInt(3,emp.getIdDepartamento());
            cstm.setInt(4,emp.getIdRol());
            cstm.setInt(5,emp.getIdTurno());
            resp = cstm.execute();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar1(con, cstm);
        }
        return resp;
    }
    
    
     public List<Empleado> ListarEmpleados() {
        Connection con = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        List<Empleado> lista = null;
        try {
            lista = new ArrayList<>();
            con = conexion.getConecion();
            cstm = con.prepareCall("{Call ListarEmpleado}");
            rs = cstm.executeQuery();
            Empleado emp = null;
            while (rs.next()) {
                emp = new Empleado();
                emp.setNumEmpleado(rs.getInt("numEmpleado"));
                emp.setIdPersona(rs.getInt("idPersona"));
                emp.setIdDepartamento(rs.getInt("idDepartamento"));
                emp.setIdRol(rs.getInt("idRol"));
                emp.setIdTurno(rs.getInt("idTurno"));

                lista.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar2(cstm, rs);
        }
        return lista;
    }
}
