/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.ArrayList;

/**
 *
 * @author Cdbz
 */
public class Profesor extends Persona{
    long telefono;
    String oficina;
    Materia materia;
    
    public Profesor(long telefono, String oficina,Materia materia, String cedula, String nombre, 
            String apellido, String email, String usuario, String clave) {
        super(cedula, nombre, apellido, email, usuario, clave);
        this.telefono = telefono;
        this.oficina = oficina;
        this.materia = materia;
    }
    
    public Profesor(){
        
    }
    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public void editarProfesor(long telefono, String oficina, Materia materia, String cedula, 
            String nombre, String apellido, String email, String usuario, String clave) {
        this.setTelefono(telefono);
        this.setOficina(oficina);
        this.setMateria(materia);
        this.setCedula(cedula);
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setEmail(email);
        this.setUsuario(usuario);
        this.setClave(clave);
    }
    
}
