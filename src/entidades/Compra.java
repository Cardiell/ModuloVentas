/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Date;

/**
 *
 * @author Cardiell
 */
public class Compra extends User{
    private int idPendiente; 
    private Date fechaCompra;
    private int cantidad;
    private String nombreArticulo;
    private String nombreCompania;
    private float precio;

    public Compra(){}

    public Compra(int idPendiente, Date fechaCompra, int cantidad, String nombreArticulo, String nombreCompania, float precio) {
        this.idPendiente = idPendiente;
        this.fechaCompra = fechaCompra;
        this.cantidad = cantidad;
        this.nombreArticulo = nombreArticulo;
        this.nombreCompania = nombreCompania;
        this.precio = precio;
    }
    
     public Compra(String User,Date fechaCompra, int cantidad, String nombreArticulo, String nombreCompania) {
        super(User);
        this.fechaCompra = fechaCompra;
        this.cantidad = cantidad;
        this.nombreArticulo = nombreArticulo;
        this.nombreCompania = nombreCompania;
    }
     
     public Compra(int idPendiente, Date fechaCompra, int cantidad, String nombreArticulo, String nombreCompania) {
        this.idPendiente = idPendiente;
        this.fechaCompra = fechaCompra;
        this.cantidad = cantidad;
        this.nombreArticulo = nombreArticulo;
        this.nombreCompania = nombreCompania;
    }

     
     
    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    


    public int getIdPendiente() {
        return idPendiente;
    }

    public void setIdPendiente(int idPendiente) {
        this.idPendiente = idPendiente;
    }

    public Date getFechaCompra() {
        return (fechaCompra);
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public String getNombreCompania() {
        return nombreCompania;
    }

    public void setNombreCompania(String nombreCompania) {
        this.nombreCompania = nombreCompania;
    }
    
}
