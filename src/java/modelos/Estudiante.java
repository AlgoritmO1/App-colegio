/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;

/**
 *
 * @author Cdbz
 */
public class Estudiante extends Persona implements Serializable{
    private String celular;

    public Estudiante(String celular, String cedula, String nombre, String apellido, String email, String usuario, String contraseña) {
        super(cedula, nombre, apellido, email, usuario, contraseña);
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "Celular: " + this.getCelular() + ", Cedula: " + this.getCedula() + ", Nombre: " + this.getNombre() 
                + ", Apellido: " + this.getApellido() + ", Email: " + this.getEmail() +'}';
    }

    public Estudiante() {
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    public void editarEstudiante(String celular, String cedula, String nombre, String apellido, String email, String usuario, String clave){
        this.setCelular(celular);
        this.setCedula(cedula);
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setEmail(email);
        this.setUsuario(usuario);
        this.setClave(clave);
    }
    
}
