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
public class Cliente extends Persona{
    
    private int idCliente;
    private String nombrecompania;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCompania() {
        return nombrecompania;
    }

    public void setNombreCompania(String nombrecompania) {
        this.nombrecompania = nombrecompania;
    }

    public Cliente(int idCliente, String nombrecompania,int idPersona) {
        super(idPersona);
        this.idCliente = idCliente;
        this.nombrecompania = nombrecompania;
    }

    public Cliente(String nombrecompania,int idPersona) {
        super(idPersona);
        this.nombrecompania = nombrecompania;
    }
    
    public Cliente(){}
}
