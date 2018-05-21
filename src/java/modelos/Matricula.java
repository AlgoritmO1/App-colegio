/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Cdbz
 */
public class Matricula implements Serializable{
    int codigo;
    float nota=0;
    Estudiante estudiante;
    Materia materia;
    Profesor profesor;
    public Mensajes msj = new Mensajes();

    public Matricula(int codigo, Estudiante estudiante, Materia materia, Profesor profesor) {
        this.codigo = codigo;
        this.estudiante = estudiante;
        this.materia = materia;
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        return "Matricula{" + "codigo=" + codigo + ", nota=" + nota + ", estudiante=" + estudiante + '}';
    }

    public Matricula(){
        
    }
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    
    //Metodos a implementar
    
    //Falta implementar
    public float mejorPromediopormateria(ArrayList<Materia> listaMaterias, 
            ArrayList<Matricula> listaMatricula){
        
            return 0;
        
    }


    public Matricula notaMasAlta (ArrayList<Matricula> listaMatricula){
        float mayorNota = 0;
        Matricula resultado = null;
        for (Matricula matricula : listaMatricula){
            if(matricula.getNota() >= mayorNota){
                mayorNota = matricula.getNota();
                resultado = matricula;
            }
        }
        
        return resultado;
    }
    
    public Matricula notaMasBaja (ArrayList<Matricula> listaMatricula){
        float menorNota = 5;
        Matricula resultado = null;
        for (Matricula matricula : listaMatricula){
            if(matricula.getNota() <= menorNota){
                menorNota = matricula.getNota();
                resultado = matricula;
            }
        }
        
        return resultado;
    }
        
}
