/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Salo
 */
public class DatosFicticios {
    
    public ArrayList<Estudiante> estudiante = new ArrayList<>();
    public ArrayList<Profesor> profesor = new ArrayList<>();
    public ArrayList<Materia> materia = new ArrayList<>();
    public ArrayList<Matricula> matricula = new ArrayList<>();
    
    Materia m1 = new Materia(1,"Matematicas");
    Materia m2 = new Materia(2,"Fisica");
    Estudiante e1 = new Estudiante("3909291", "1", "Daniel", "Perez", "dp@mail.com", "dp", "dp123");
    Estudiante e2 = new Estudiante("3244522", "2", "Fabio", "Yepes", "fy@mail.com", "fy", "fy123");
    Profesor p1 = new Profesor(124432, "M1-201", m1, "1", "Javier", "Caldas", "jc@mail.com", "jc", 
            "jc123");
    Profesor p2 = new Profesor(232241, "M2-101", m2, "2", "Francisco", "Gonzales", "fg@mail.com", "fg", 
            "fg123");
    Matricula mt1 = new Matricula(1, e1, m1, p1);
    Matricula mt2 = new Matricula(2, e2, m2, p2);
    

    public void datos(){
        
        m1.setMatriculas(mt1);
        m2.setMatriculas(mt2);
        m1.setProfesores(p1);
        m2.setProfesores(p2);
        
        estudiante.add(e1);
        estudiante.add(e2);
        profesor.add(p1);
        profesor.add(p2);
        materia.add(m1);
        materia.add(m2);
        matricula.add(mt1);
        matricula.add(mt2);        
        
    }
}
