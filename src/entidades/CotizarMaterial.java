/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Cardiell
 */
public class CotizarMaterial {
        public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdCotizar() {
        return idCotizar;
    }

    public void setIdCotizar(int idCotizar) {
        this.idCotizar = idCotizar;
    }

    
    private int idCotizar;
    private int idMaterial;
    private int cantidad;

    public CotizarMaterial() {
    }

    public CotizarMaterial(int idCotizar,int idMaterial, int cantidad) {
        this.idCotizar = idCotizar;
        this.idMaterial = idMaterial;
        this.cantidad = cantidad;
    }
}
