package dao;

import entidades.Proveedor;
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
public class ProveedoresDao {
    
    Conexion conexion = new Conexion();

    
      public boolean EliminarProveedores(String nombre)
    {
        Connection con = null;
        Statement st= null;
        boolean exs = true;
        try {
            con = conexion.getConecion();
             String query = "DELETE FROM Proveedor WHERE idPendiente="+nombre;
             st = con.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar4(st);
        }
        return exs;
    }
    public boolean AgregarProveedores(Proveedor prov) {
        Connection con = null;
        CallableStatement cstm = null;
        boolean resp = true;
        try {
            con = conexion.getConecion();
            con.setAutoCommit(false);
            cstm = con.prepareCall("{Call AgregarProveedor(?,?)}");
            cstm.setString(1, prov.getNombreCompania());
            cstm.setInt(2,prov.getIdPersona());
            resp = cstm.execute();
            con.commit();
        } catch (SQLException e){
            e.printStackTrace();
        }finally{
            conexion.Cerrar1(con, cstm);
        }
        return resp;
    }
    
    
    public boolean UpdateProveedores(Proveedor prov) {
        Connection con = null;
        CallableStatement cstm = null;
        boolean resp = true;
        try {
            con = conexion.getConecion();
            con.setAutoCommit(false);
            cstm = con.prepareCall("{Call UpdateProveedor(?,?)}");
            cstm.setString(1, prov.getNombreCompania());
            cstm.setInt(2,prov.getIdPersona());
            resp = cstm.execute();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexion.Cerrar1(con, cstm);
        }
        return resp;
    }
    
    
     public List<Proveedor> ListarProveedores() {
         Connection con = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        List<Proveedor> lista = null;
        try {
            lista = new ArrayList<>();
            con = conexion.getConecion();
            cstm = con.prepareCall("{Call ListarProveedor}");
            rs = cstm.executeQuery();
            Proveedor cli = null;
            while (rs.next()) {
                cli = new Proveedor();
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
     
       public boolean OkProveedor(String proveedor) throws SQLException
    {
        Connection cn = null;
        int ingreso = 0;
        boolean regresa = false;

        try{
            PreparedStatement ps =null;
            ResultSet rs =null;
             cn = conexion.getConecion();

            ps = cn.prepareStatement("exec OkProveedor ?");
            ps.setString(1,proveedor);
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
