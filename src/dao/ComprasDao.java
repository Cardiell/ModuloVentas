package dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alberto jaquez
 */


import dao.Conexion;
import entidades.Compra;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;


public class ComprasDao {
    Conexion conexion = new Conexion();
    
    public ComprasDao(){}
    
    public boolean OkArticulos(String Articulo) throws SQLException
    {
        Connection cn = null;
        int ingreso = 0;
        boolean regresa = false;

        try{
            PreparedStatement ps =null;
            ResultSet rs =null;
             cn = conexion.getConecion();

            ps = cn.prepareStatement("exec OkArticulo ?");
            ps.setString(1,Articulo);
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
    
     public boolean OkProveedor(String Provedor) throws SQLException
    {
        Connection cn = null;
        int ingreso = 0;
        boolean regresa = false;

        try{
            PreparedStatement ps =null;
            ResultSet rs =null;
             cn = conexion.getConecion();

            ps = cn.prepareStatement("exec OkProveedor ?");
            ps.setString(1,Provedor);
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
    
    
    
    
    
    public List<Compra> BuscarPedimentos(String buscar)
    {
        Connection con = null;
        PreparedStatement st= null;
        ResultSet rs = null;
        List<Compra> lista = null;
        try {
            lista = new ArrayList<>();
            con = conexion.getConecion();
             String query = "exec buscarPedimento '"+buscar+"'";
             st = con.prepareStatement(query);
             rs = st.executeQuery();
           
            Compra cont;
            
            while (rs.next()) {
                cont = new Compra();
                cont.setNombreArticulo(rs.getString("nombreArticulo"));
                cont.setIdPendiente(rs.getInt("idPendiente"));
                cont.setNombre(rs.getString("nameUser"));
                cont.setFechaCompra(rs.getDate("fechaCompra"));
                cont.setNombreArticulo(rs.getString("nombreArticulo"));
                cont.setCantidad(rs.getInt("cantidad"));  
                cont.setNombreCompania(rs.getString("nombreCompania"));
                cont.setCorreo(rs.getString("correo"));
                cont.setTelefono(rs.getString("telefono"));
                lista.add(cont);
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar3(st, rs);
        }
        return lista;
        
        
    }
    
    
      public boolean EliminarCompra(int id)
    {
        Connection con = null;
        Statement st= null;
        boolean exs = true;
        try {
            con = conexion.getConecion();
             String query = "DELETE FROM compras WHERE idPendiente="+id;
             st = con.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar4(st);
        }
        return exs;
    }
    public boolean AgregarCompra(Compra cont) {
        Connection con = null;
        CallableStatement cstm = null;
        boolean resp = true;
        try {
            con = conexion.getConecion();
            con.setAutoCommit(false);
            cstm = con.prepareCall("{Call AgregarCompra(?,?,?,?,?)}");
            cstm.setString(1, cont.getNameUser());
            cstm.setString(2, cont.getFechaCompra().toString());
            cstm.setInt(3,cont.getCantidad());
            cstm.setString(4, cont.getNombreCompania());
            cstm.setString(5, cont.getNombreArticulo());
            resp = cstm.execute();
            con.commit();
        } catch (SQLException e){
            e.printStackTrace();
        }finally{
            conexion.Cerrar1(con, cstm);
        }
        return resp;
    }
    
    
    public boolean UpdateCompra(Compra cont, int id) {
        Connection con = null;
        CallableStatement cstm = null;
        boolean resp = true;
        try {
            con = conexion.getConecion();
            con.setAutoCommit(false);
            cstm = con.prepareCall("{Call UpdateCompra(?,?,?,?,?)}");
            cstm.setInt(1, id);
            cstm.setString(2, cont.getNombre());
            cstm.setDate(3,cont.getFechaCompra());
            cstm.setString(4, cont.getNombreArticulo());
            cstm.setInt(4, cont.getCantidad());
            cstm.setString(5, cont.getNombreCompania());
            resp = cstm.execute();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar1(con, cstm);
        }
        return resp;
    }
    
        public Compra SelectPresupuestos(String nombreArticulo) {
        Connection con = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        Compra cont= new Compra();
        String consulta="exec SelectPresupuesto '"+nombreArticulo+"'";
        try {
            con = conexion.getConecion();
            
            cstm = con.prepareCall(consulta );
            rs = cstm.executeQuery();
            while (rs.next()) {
                cont.setIdPendiente(rs.getInt("idPendiente"));
                cont.setNombre(rs.getString("nameUser"));
                cont.setFechaCompra(rs.getDate("fechaCompra"));
                cont.setNombreArticulo(rs.getString("nombreArticulo"));
                cont.setCantidad(rs.getInt("cantidad"));  
                cont.setNombreCompania(rs.getString("nombreCompania"));
                cont.setCorreo(rs.getString("correo"));
                cont.setTelefono(rs.getString("telefono"));
                cont.setPrecio(rs.getFloat("precio"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar2(cstm, rs);
        }
        return cont;
    }
    
     public List<Compra> ListarPedimentos() {
        Connection con = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        List<Compra> lista = null;
        try {
            lista = new ArrayList<>();
            con = conexion.getConecion();
            cstm = con.prepareCall("{Call ListarPedimento}");
            rs = cstm.executeQuery();
            Compra cont = null;
            while (rs.next()) {
                cont = new Compra();
                cont.setIdPendiente(rs.getInt("idPendiente"));
                cont.setNombre(rs.getString("nameUser"));
                cont.setFechaCompra(rs.getDate("fechaCompra"));
                cont.setNombreArticulo(rs.getString("nombreArticulo"));
                cont.setCantidad(rs.getInt("cantidad"));  
                cont.setNombreCompania(rs.getString("nombreCompania"));
                cont.setCorreo(rs.getString("correo"));
                cont.setTelefono(rs.getString("telefono"));
                lista.add(cont);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar2(cstm, rs);
        }
        return lista;
    }

    boolean UpdateCompra(ComprasDao cont, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
    
    
    
    
    
    
    

