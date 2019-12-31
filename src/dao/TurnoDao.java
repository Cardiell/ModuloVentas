/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Turno;
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
public class TurnoDao {
       Conexion conexion = new Conexion();

    
      public boolean EliminarTurnos(int id)
    {
        Connection con = null;
        Statement st= null;
        boolean exs = true;
        try {
            con = conexion.getConecion();
             String query = "DELETE FROM Turno WHERE idTurno="+id;
             st = con.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar4(st);
        }
        return exs;
    }
    public boolean AgregarTurnos(Turno tur) {
        Connection con = null;
        CallableStatement cstm = null;
        boolean resp = true;
        try {
            con = conexion.getConecion();
            con.setAutoCommit(false);
            cstm = con.prepareCall("{Call AgregarTurno(?)}");
            cstm.setString(1,tur.getDescripcion());
            resp = cstm.execute();
            con.commit();
        } catch (SQLException e){
            e.printStackTrace();
        }finally{
            conexion.Cerrar1(con, cstm);
        }
        return resp;
    }
    
    
    public boolean UpdateTurnos(Turno tur) {
        Connection con = null;
        CallableStatement cstm = null;
        boolean resp = true;
        try {
            con = conexion.getConecion();
            con.setAutoCommit(false);
            cstm = con.prepareCall("{Call UpdateTurno(?,?)}");
            cstm.setInt(1, tur.getIdTurno());
            cstm.setString(2,tur.getDescripcion());
            resp = cstm.execute();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar1(con, cstm);
        }
        return resp;
    }
    
    
     public List<Turno> ListarTurnos() {
        Connection con = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        List<Turno> lista = null;
        try {
            lista = new ArrayList<>();
            con = conexion.getConecion();
            cstm = con.prepareCall("{Call ListarTurno}");
            rs = cstm.executeQuery();
            Turno tur = null;
            while (rs.next()) {
                tur = new Turno();
                tur.setIdTurno(rs.getInt("idTurno"));
                tur.setDescripcion(rs.getString("Descripcion"));

                lista.add(tur);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar2(cstm, rs);
        }
        return lista;
    }
}
