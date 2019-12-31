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
public class Articulo {
    private String nombreArticulo;
    private float precio;

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Articulo(String nombreArticulo, float precio) {
        this.nombreArticulo = nombreArticulo;
        this.precio = precio;
    }
    
    public Articulo(){}
    
}
