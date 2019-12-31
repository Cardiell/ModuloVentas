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
public class Direccion {
        private int idDireccion;
        private String ciudad;

    public Direccion(){}
    
    public Direccion(String ciudad, String colonia, String calle, int CP) {
        this.ciudad = ciudad;
        this.colonia = colonia;
        this.calle = calle;
        this.CP = CP;
    }
    
    public Direccion(int idDireccion)
    {
        this.idDireccion=idDireccion;
    }

    public Direccion(int idDireccion, String ciudad, String colonia, String calle, int CP) {
        this.idDireccion = idDireccion;
        this.ciudad = ciudad;
        this.colonia = colonia;
        this.calle = calle;
        this.CP = CP;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getCP() {
        return CP;
    }

    public void setCP(int CP) {
        this.CP = CP;
    }
        private String colonia;
        private String calle;
        private int CP;
}
