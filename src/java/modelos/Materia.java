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
public class Materia implements Serializable {

    int codigo;
    String nombre;
    ArrayList<Profesor> profesores = new ArrayList<>();
    ArrayList<Matricula> matriculas = new ArrayList<>();
    Mensajes msj = new Mensajes();

    public Materia(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Materia() {

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(Profesor profesor) {
        this.profesores.add(profesor);
    }

    public ArrayList<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(Matricula matriculas) {
        this.matriculas.add(matriculas);
    }

    public void editarMateria(int codigo, String nombre) {
        this.setCodigo(codigo);
        this.setNombre(nombre);
    }

    //METODOS INTERESANTES
    
    public Materia materiaConmasmatriculas(ArrayList<Materia> listaMaterias) {

        int mayor = 0;
        Materia mat=null;
        for (Materia materia : listaMaterias) {
            if (materia.getMatriculas().size() > mayor) {
                mayor = materia.getMatriculas().size();
                mat = materia;
            }
        }
            return mat;
    }

    public Materia materiaConmasprofesores(ArrayList<Materia> listaMaterias) {

        int mayor = 0;
        Materia mat = null;
        
        for (Materia materia : listaMaterias) {
            if (materia.getProfesores().size() > mayor) {
                mayor = materia.getMatriculas().size();
                mat= materia;
            }
        }
            return mat;
        
    }

    public Matricula materiaMejorNota(ArrayList<Matricula> listaMatricula) {

        float mayor = 0;
        Matricula resultado = null;

            for (Matricula matricula : listaMatricula) {
                if (matricula.getNota() > mayor) {
                    mayor = matricula.getNota();
                    resultado = matricula;
                    
            }

        }

        return resultado;
    }
}
