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
public class Factura extends Cliente{
    private int num_factura;
    private Date fecha;
    private String fechaVence;
    private int idCliente;
    private int  idCotizar;
                   
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    public int getNum_factura() {
        return num_factura;
    }

    public void setNum_factura(int num_factura) {
        this.num_factura = num_factura;
    }


    public String getFechaVence() {
        return fechaVence;
    }

    public void setFechaVence(String fechaVence) {
        this.fechaVence = fechaVence;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdCotizar() {
        return idCotizar;
    }

    public void setIdCotizar(int idCotizar) {
        this.idCotizar = idCotizar;
    }

    public Factura() {
    }

    public Factura(Date fecha, String fechaVence, int idCliente, int idCotizar) {
        this.fecha = fecha;
        this.fechaVence = fechaVence;
        this.idCliente = idCliente;
        this.idCotizar = idCotizar;
    }

    public Factura(int num_factura, Date fecha, String fechaVence, int idCliente, int idCotizar) {
        this.num_factura = num_factura;
        this.fecha = fecha;
        this.fechaVence = fechaVence;
        this.idCliente = idCliente;
        this.idCotizar = idCotizar;
    }
}
