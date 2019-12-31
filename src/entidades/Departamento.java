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
public class Departamento {
    private int idDepartamento;
    private String Descripcion;
    private float presupuesto;

    public Departamento(int idDepartamento, String Descripcion, float presupuesto) {
        this.idDepartamento = idDepartamento;
        this.Descripcion = Descripcion;
        this.presupuesto = presupuesto;
    }

    public float getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(float presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Departamento(){}
    
    public Departamento(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Departamento(int idDepartamento, String Descripcion) {
        this.idDepartamento = idDepartamento;
        this.Descripcion = Descripcion;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
}
