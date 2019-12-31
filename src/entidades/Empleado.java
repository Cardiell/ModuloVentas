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
public class Empleado extends Persona{
    private int numEmpleado;
    private int idDepartamento;
    private int idRol;
    private int idTurno;
    
    public Empleado(int numEmpleado)
    {
        this.numEmpleado = numEmpleado;
    }

    public int getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public Empleado(int idDepartamento, int idRol, int idTurno) {
        this.idDepartamento = idDepartamento;
        this.idRol = idRol;
        this.idTurno = idTurno;
    }

    public Empleado(int numEmpleado, int idDepartamento, int idRol, int idTurno) {
        this.numEmpleado = numEmpleado;
        this.idDepartamento = idDepartamento;
        this.idRol = idRol;
        this.idTurno = idTurno;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    
    public Empleado(){}
    
}
