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
public class Turno {
    private int idTurno;
    private String Descripcion;

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Turno(int idTurno, String Descripcion) {
        this.idTurno = idTurno;
        this.Descripcion = Descripcion;
    }

    public Turno(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    public Turno(){}
}
