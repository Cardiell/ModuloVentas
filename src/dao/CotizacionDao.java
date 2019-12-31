package dao;

import entidades.Cotizacion;
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
public class CotizacionDao {
    
    Conexion conexion = new Conexion();
 
    
    public boolean EliminarCotizaciones(int idCotizar)
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
    public boolean EliminarCotizar(int idCotizar)
    {
        Connection con = null;
        Statement st= null;
        boolean exs = true;
        try {
            con = conexion.getConecion();
             String query = "DELETE FROM Cotizar WHERE idCotizar="+idCotizar;
             st = con.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar4(st);
        }
        return exs;
    }
    
    public boolean AgregarCotizaciones(Cotizacion cot) {
        Connection con = null;
        CallableStatement cstm = null;
        boolean resp = true;
        try {
            con = conexion.getConecion();
            con.setAutoCommit(false);
            cstm = con.prepareCall("{Call AgregarCotizar(?)}");
            cstm.setInt(1, cot.getIdCotizar());
            resp = cstm.execute();
            con.commit();
        } catch (SQLException e){
            e.printStackTrace();
        }finally{
            conexion.Cerrar1(con, cstm);
        }
        return resp;
    }
    
    
    public boolean UpdateCotizaciones(Cotizacion cot) {
        Connection con = null;
        CallableStatement cstm = null;
        boolean resp = true;
        try {
            con = conexion.getConecion();
            con.setAutoCommit(false);
            cstm = con.prepareCall("{Call UpdateCotizar(?)}");
            cstm.setInt(1, cot.getIdCotizar());
            resp = cstm.execute();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar1(con, cstm);
        }
        return resp;
    }
    
      
     public List<Cotizacion> ListarCotizacions() {
         Connection con = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        List<Cotizacion> lista = null;
        try {
            lista = new ArrayList<>();
            con = conexion.getConecion();
            cstm = con.prepareCall("exec ListarCotizacion");
            rs = cstm.executeQuery();
            Cotizacion cot = null;
            while (rs.next()) {
                cot = new Cotizacion();
                cot.setIdCotizar(rs.getInt("idCotizar"));
                lista.add(cot);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar2(cstm, rs);
        }
        return lista;
    }
     
       public boolean OkCotizar(int idCotizar) throws SQLException
    {
        Connection cn = null;
        int ingreso = 0;
        boolean regresa = false;

        try{
            PreparedStatement ps =null;
            ResultSet rs =null;
             cn = conexion.getConecion();
            ps = cn.prepareStatement("exec OkCotizar ?");
            ps.setInt(1,idCotizar);
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
