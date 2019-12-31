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
public class User extends Empleado{
    private String nameUser;
    private String pass;
    private String ImagenRuta;

    public User(String nameUser)
    {
        this.nameUser=nameUser;
    }
    public User(String nameUser, String pass,String ImagenRuta,int numEmpleado) {
        super(numEmpleado);//CHECAR
        this.nameUser = nameUser;
        this.pass = pass;
        this.ImagenRuta=ImagenRuta;
    }
    
    
    public User(){}

    public String getImagen() {
        return ImagenRuta;
    }

    public void setImagen(String ImagenRuta) {
        this.ImagenRuta = ImagenRuta;
    }
    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
