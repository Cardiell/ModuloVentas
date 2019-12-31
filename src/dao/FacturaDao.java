package dao;

import entidades.Factura;
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
public class FacturaDao {
          Conexion conexion = new Conexion();

    
      public boolean EliminarFacturas(int num_factura)
    {
        Connection con = null;
        Statement st= null;
        boolean exs = true;
        try {
            con = conexion.getConecion();
             String query = "DELETE FROM Factura WHERE nombreFactura="+num_factura;
             st = con.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar4(st);
        }
        return exs;
    }
       
    public boolean AgregarFacturas(Factura fac) {
        Connection con = null;
        CallableStatement cstm = null;
        boolean resp = true;
        try {
            con = conexion.getConecion();
            con.setAutoCommit(false);
            cstm = con.prepareCall("{Call AgregarFactura(?,?,?,?)}");
            cstm.setString(1,fac.getFecha().toString());
            cstm.setString(2,fac.getFechaVence());
            cstm.setInt(3, fac.getIdCliente());
            cstm.setInt(4, fac.getIdCotizar());
            resp = cstm.execute();
            con.commit();
        } catch (SQLException e){
            e.printStackTrace();
        }finally{
            conexion.Cerrar1(con, cstm);
        }
        return resp;
    }
    
    
    public boolean UpdateFacturas(Factura fac) {
        Connection con = null;
        CallableStatement cstm = null;
        boolean resp = true;
        try {
            con = conexion.getConecion();
            con.setAutoCommit(false);
            cstm = con.prepareCall("{Call UpdateFactura(?,?,?,?,?)}");
            cstm.setInt(1, fac.getNum_factura());
            cstm.setString(2,fac.getFecha().toString());
            cstm.setString(3,fac.getFechaVence());
            cstm.setInt(4, fac.getIdCliente());
            cstm.setInt(5, fac.getIdCotizar());
            resp = cstm.execute();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar1(con, cstm);
        }
        return resp;
    }

public List<Factura> BuscarFacturas(String buscar)
    {
        Connection con = null;
        PreparedStatement st= null;
        ResultSet rs = null;
        List<Factura> lista = null;
        try {
            lista = new ArrayList<>();
            con = conexion.getConecion();
             String query = "exec buscarFactura '"+buscar+"'";
             st = con.prepareStatement(query);
             rs = st.executeQuery();
           
            Factura fac;
            
            while (rs.next()) {
                fac = new Factura();
                fac.setNum_factura(rs.getInt("num_factura"));
                fac.setFecha(rs.getDate("fecha"));
                fac.setNombreCompania(rs.getString("nombreCompania"));
                fac.setTelefono(rs.getString("telefono"));
                fac.setCorreo(rs.getString("correo"));
                fac.setColonia(rs.getString("colonia"));
                fac.setCalle(rs.getString("calle"));
                fac.setNombre(rs.getString("nombre"));
                fac.setApellidoP(rs.getString("apellidoP"));
                lista.add(fac);
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar3(st, rs);
        }
        return lista;
        
        
    }                   
    public List<Factura> MostrarFacturas() {
        Connection con = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        List<Factura> lista = null;
        try {
            lista = new ArrayList<>();
            con = conexion.getConecion();
            cstm = con.prepareCall("{Call MostrarFactura}");
            rs = cstm.executeQuery();
            Factura fac = null;
            while (rs.next()) {
                fac = new Factura();
                fac.setNum_factura(rs.getInt("num_factura"));
                fac.setFecha(rs.getDate("fecha"));
                fac.setNombreCompania(rs.getString("nombreCompania"));
                fac.setTelefono(rs.getString("telefono"));
                fac.setCorreo(rs.getString("correo"));
                fac.setColonia(rs.getString("colonia"));
                fac.setCalle(rs.getString("calle"));
                fac.setNombre(rs.getString("nombre"));
                fac.setApellidoP(rs.getString("apellidoP"));
                lista.add(fac);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar2(cstm, rs);
        }
        return lista;
    }
    
     public List<Factura> ListarFacturas() {
        Connection con = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        List<Factura> lista = null;
        try {
            lista = new ArrayList<>();
            con = conexion.getConecion();
            cstm = con.prepareCall("{Call ListarFactura}");
            rs = cstm.executeQuery();
            Factura fac = null;
            while (rs.next()) {
                fac = new Factura();
                fac.setNum_factura(rs.getInt("num_factura"));
                fac.setFecha(rs.getDate("fecha"));
                fac.setFechaVence(rs.getString("fechaVence"));
                fac.setIdCliente(rs.getInt("idCliente"));
                fac.setIdCotizar(rs.getInt("idCotizar"));
                lista.add(fac);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar2(cstm, rs);
        }
        return lista;
    }

}
