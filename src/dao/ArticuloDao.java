package dao;


import entidades.Articulo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
/**
 *
 * @author Cardiell
 */
public class ArticuloDao {
            Conexion conexion = new Conexion();

    
      public boolean EliminarArticulos(String nombre)
    {
        Connection con = null;
        Statement st= null;
        boolean exs = true;
        try {
            con = conexion.getConecion();
             String query = "DELETE FROM Articulo WHERE nombreArticulo="+nombre;
             st = con.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar4(st);
        }
        return exs;
    }
      
       public boolean OkArticulo(String art) throws SQLException
    {
        Connection cn = null;
        int ingreso = 0;
        boolean regresa = false;

        try{
            PreparedStatement ps =null;
            ResultSet rs =null;
             cn = conexion.getConecion();

            ps = cn.prepareStatement("exec OkArticulo ?");
            ps.setString(1,art);
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
       
    public boolean AgregarArticulos(Articulo art) {
        Connection con = null;
        CallableStatement cstm = null;
        boolean resp = true;
        try {
            con = conexion.getConecion();
            con.setAutoCommit(false);
            cstm = con.prepareCall("{Call AgregarArticulo(?,?)}");
            cstm.setString(1, art.getNombreArticulo());
            cstm.setFloat(2,art.getPrecio());
            resp = cstm.execute();
            con.commit();
        } catch (SQLException e){
            e.printStackTrace();
        }finally{
            conexion.Cerrar1(con, cstm);
        }
        return resp;
    }
    
    
    public boolean UpdateArticulos(Articulo art) {
        Connection con = null;
        CallableStatement cstm = null;
        boolean resp = true;
        try {
            con = conexion.getConecion();
            con.setAutoCommit(false);
            cstm = con.prepareCall("{Call UpdateArticulo(?,?)}");
            cstm.setString(1, art.getNombreArticulo());
            cstm.setFloat(2,art.getPrecio());
            resp = cstm.execute();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar1(con, cstm);
        }
        return resp;
    }
    
    
     public List<Articulo> ListarArticulos() {
        Connection con = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        List<Articulo> lista = null;
        try {
            lista = new ArrayList<>();
            con = conexion.getConecion();
            cstm = con.prepareCall("{Call ListarArticulo}");
            rs = cstm.executeQuery();
            Articulo art = null;
            while (rs.next()) {
                art = new Articulo();
                art.setNombreArticulo(rs.getString("nombreArticulo"));
                art.setPrecio(rs.getFloat("precio"));

                lista.add(art);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar2(cstm, rs);
        }
        return lista;
    }

}
