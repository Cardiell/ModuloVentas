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
public class Rol{
    private int idRol;
    private String Descripcion;

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Rol(int idRol, String Descripcion) {
        this.idRol = idRol;
        this.Descripcion = Descripcion;
    }

    public Rol(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    public Rol(){}




}
