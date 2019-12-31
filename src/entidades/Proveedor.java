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
public class Proveedor extends Persona{
    private String nombreCompania;

    public Proveedor(){}
    
    public Proveedor(int idPersona,String nombreCompania)
    {
        super(idPersona); 
        this.nombreCompania=nombreCompania;
        
    }
    
    public Proveedor(String nombreCompania) {
       
        this.nombreCompania = nombreCompania;
    }

    public String getNombreCompania() {
        return nombreCompania;
    }

    public void setNombreCompania(String nombreCompania) {
        this.nombreCompania = nombreCompania;
    }
    
}
