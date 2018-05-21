/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.HashMap;

/**
 *
 * @author Salo
 */
public class Mensajes {
    
    public HashMap<String, String> mensajes = new HashMap<String, String>();
    
    public Mensajes(){
        mensajes.put("est", "Estudiante: ");
        mensajes.put("estmayornota", "El estudiante con mayor nota es: ");
        mensajes.put("estmenornota", "El estudiante con menor nota es: ");
        mensajes.put("estudiante", "Estudiante :");
        mensajes.put("matmasmatr", "La materia con mas matriculas es: ");
        mensajes.put("matmasprof", "La materia con mas profesores es: ");
        mensajes.put("matmayornota", "La materia con mayor nota tiene la matricula: ");
        mensajes.put("matricula", " matriculas.");
        mensajes.put("profesor", " profesores.");
        mensajes.put("con", " con ");
        mensajes.put("error", "Error, no se pudo logguear correctamente, asegurese de gestionar bien los campos");
        mensajes.put("bienvenida", "Bienvenido al sistema de notas");
        mensajes.put("bien", "Bienvenido ");
        mensajes.put("crearEst", "Crear estudiante");
        mensajes.put("crearProf", "Crear profesor");
        mensajes.put("crearMat", "Crear materia");
        mensajes.put("datos", "Datos guardados");
        mensajes.put("matmm", "Materia con mas matriculas");
        mensajes.put("matmp", "Materia con mas profesores");
        mensajes.put("matmn", "Materia con mejor nota");
        mensajes.put("matms", "Materia con mas matriculas");
        mensajes.put("mejorp", "Mejor promedio");
        mensajes.put("estpm", "Estudiantes por materia");
        mensajes.put("notma", "Nota mas alta");
        mensajes.put("notmb", "Nota mas baja");
        mensajes.put("listest", "Lista de estudiantes");
        mensajes.put("listprof", "Lista de profesores");
        mensajes.put("asign", "Asignar nota");
        mensajes.put("verest", "Ver estudiantes");
        mensajes.put("verprof", "Ver profesores");
        mensajes.put("vermat", "Ver materias");
        mensajes.put("matm", "Matricular materias");
        mensajes.put("cerrc", "Cerrar sesión");
        mensajes.put("datosFic", "Agregar datos ficticios");
    }
    
}
