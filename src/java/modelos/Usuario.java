/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Cdbz
 */
public class Usuario {
    private String nombre;
    private String clave;
    private String indentificacion;
    private String tipo;

    public Usuario(String nombre, String clave,String identificacion,String tipo) {
        this.nombre = nombre;
        this.clave = clave;
        this.tipo = tipo;
        this.indentificacion=identificacion;
                
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIndentificacion() {
        return indentificacion;
    }

    public void setIndentificacion(String indentificacion) {
        this.indentificacion = indentificacion;
    }
    
    
}
