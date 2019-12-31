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
public class Material {
    private int idMaterial;
    private String nombreMaterial;
    private int existencia;
    private float precio;
    private String imagen;
    private int idIncorrecto;
    private int idCorrecto;
    
    public Material(){}

    public Material(String nombreMaterial, int existencia, float precio, String imagen, int idIncorrecto, int idCorrecto) {
        this.nombreMaterial = nombreMaterial;
        this.existencia = existencia;
        this.precio = precio;
        this.imagen = imagen;
        this.idIncorrecto = idIncorrecto;
        this.idCorrecto = idCorrecto;
    }

    public Material(String nombreMaterial,int existencia, float precio, String imagen) {
        this.nombreMaterial = nombreMaterial;
        this.existencia = existencia;
        this.precio = precio;
        this.imagen = imagen;
    }

    
    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public Material(int idMaterial, String nombreMaterial, int existencia, float precio, String imagen, int idIncorrecto, int idCorrecto) {
        this.idMaterial = idMaterial;
        this.nombreMaterial = nombreMaterial;
        this.existencia = existencia;
        this.precio = precio;
        this.imagen = imagen;
        this.idIncorrecto = idIncorrecto;
        this.idCorrecto = idCorrecto;
    }

    public Material(int idMaterial, String nombreMaterial,  int existencia, float precio, String imagen) {
        this.idMaterial = idMaterial;
        this.nombreMaterial = nombreMaterial;
        this.existencia = existencia;
        this.precio = precio;
        this.imagen = imagen;
    }
    
    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }


    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getIdIncorrecto() {
        return idIncorrecto;
    }

    public void setIdIncorrecto(int idIncorrecto) {
        this.idIncorrecto = idIncorrecto;
    }

    public int getIdCorrecto() {
        return idCorrecto;
    }

    public void setIdCorrecto(int idCorrecto) {
        this.idCorrecto = idCorrecto;
    }
                
}
