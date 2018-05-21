/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.Estudiante;
import modelos.Materia;
import modelos.Matricula;
import modelos.Profesor;
import modelos.Usuario;

/**
 *
 * @author Salo
 */
@WebServlet(name = "servletMatricula", urlPatterns = {"/servletMatricula"})
public class servletMatricula extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        ArrayList<Matricula> matricula = new ArrayList<>();

        if (null != session.getAttribute("SMatricula")) {

            matricula = (ArrayList<Matricula>) session.getAttribute("SMatricula");

        }
        
        ArrayList<Materia> materia = new ArrayList<>();

        if (null != session.getAttribute("SMateria")) {

            materia = (ArrayList<Materia>) session.getAttribute("SMateria");

        }

        List<Estudiante> estudiante = new ArrayList<>();

        if (null != session.getAttribute("SEstudiante")) {

            estudiante = (ArrayList<Estudiante>) session.getAttribute("SEstudiante");

        }

        List<Usuario> usuario = new ArrayList<>();

        if (null != session.getAttribute("SUsuario")) {

            usuario = (ArrayList<Usuario>) session.getAttribute("SUsuario");

        }

        if ("Inscribir".equals(request.getParameter("accion"))) {
            int codigo = 0;
            if (matricula.isEmpty()) {
                codigo = 0;
            } else {
                codigo = matricula.get(matricula.size() - 1).getCodigo() + 1;
            }

            String cedEstudiante = usuario.get(0).getIndentificacion();
            String cedProfesor = request.getParameter("profesor");
            int codMateria = Integer.parseInt(request.getParameter("materia"));

            boolean matricular = true;

            for (Matricula matricula1 : matricula) {
                if (matricula1.getEstudiante().getCedula().equals(cedEstudiante)
                        && matricula1.getMateria().getCodigo() == codMateria) {
                    matricular = false;
                }
            }
            if (matricular) {
                for (Estudiante estudiante1 : estudiante) {
                    if (cedEstudiante.equals(estudiante1.getCedula())) {
                        for (Materia materia1 : materia) {
                            if (codMateria == materia1.getCodigo()) {
                                for (Profesor profesor : materia1.getProfesores()) {
                                    if (profesor.getCedula().equals(cedProfesor)) {
                                        Matricula matr= new Matricula(codigo, estudiante1, materia1, profesor);
                                        matricula.add(matr);
                                        materia1.setMatriculas(matr);
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        break;
                    }
                }
            }

            session.setAttribute("SMatricula", matricula);

            request.setAttribute("SMatricula", matricula);
            RequestDispatcher view = request.getRequestDispatcher("crearMatricula.jsp");
            view.forward(request, response);

        } else if ("VerMatriculas".equals(request.getParameter("accion"))) {

            request.setAttribute("matricula", matricula);
            RequestDispatcher view = request.getRequestDispatcher("datosMatricula.jsp");
            view.forward(request, response);

        } else if ("VerDetalles".equals(request.getParameter("accion"))) {
            int codigo = Integer.parseInt(request.getParameter("codigo"));

            Matricula resultado = new Matricula();
            for (Matricula matricula1 : matricula) {
                if (matricula1.getCodigo() == codigo) {
                    resultado = matricula1;
                    break;
                }
            }
            List<Matricula> listaResultado = new ArrayList<>();
            listaResultado.add(resultado);
            request.setAttribute("maticula", listaResultado);
            RequestDispatcher view = request.getRequestDispatcher("datosMatricula.jsp");
            view.forward(request, response);
        } else if ("Eliminar".equals(request.getParameter("accion"))) {
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            for (Matricula matricula1 : matricula) {
                if (matricula1.getCodigo() == codigo) {
                    matricula.remove(matricula1);
                    break;
                }
            }
            session.setAttribute("SMatricula", matricula);

            request.setAttribute("SMatricula", matricula);
            RequestDispatcher view = request.getRequestDispatcher("datosMatricula.jsp");
            view.forward(request, response);
        } else if ("RutaCrearMatricula".equals(request.getParameter("accion"))) {

            request.setAttribute("materias", materia);

            RequestDispatcher view = request.getRequestDispatcher("crearMatricula.jsp");
            view.forward(request, response);
        } else if ("asignarNota".equals(request.getParameter("accion"))) {

            String profesor = usuario.get(0).getIndentificacion();

            ArrayList<Matricula> matriculaConProfe = new ArrayList<>();

            for (Matricula matricula1 : matricula) {
                if (profesor.equals(matricula1.getProfesor().getCedula())) {
                    matriculaConProfe.add(matricula1);
                }
            }

            request.setAttribute("matriculaConProfe", matriculaConProfe);
            RequestDispatcher view = request.getRequestDispatcher("asignarNota.jsp");
            view.forward(request, response);
        } else if ("Editar nota".equals(request.getParameter("accion"))) {
            try {
                float nota = Float.parseFloat(request.getParameter("nota"));
                int codigoMatricula = Integer.parseInt(request.getParameter("codigo"));
                if (nota >= 0 && nota <= 5) {
                    for (Matricula matricula1 : matricula) {
                        if (codigoMatricula == matricula1.getCodigo()) {
                            matricula1.setNota(nota);
                            break;
                        }
                    }
                }
            } catch (Exception e) {

            } finally {
                request.setAttribute("SMatricula", matricula);
                RequestDispatcher view = request.getRequestDispatcher("asignarNota.jsp");
                view.forward(request, response);
            }
        }else if("mejorPromediopormateria".equals(request.getParameter("accion"))){
            Matricula matr = new Matricula();
            float mejorPromediopormateria=matr.mejorPromediopormateria(materia, matricula);
            String opcion = "mejorPromediopormateria";
            request.setAttribute("opcion",opcion);
            request.setAttribute("resultado", mejorPromediopormateria);
            RequestDispatcher view = request.getRequestDispatcher("metodosInteresantesMatricula.jsp");
            view.forward(request, response);
        }else if("estudiantePormateria".equals(request.getParameter("accion"))){
            
            
            String opcion = "estudiantePormateria";
            request.setAttribute("opcion",opcion);
            request.setAttribute("resultado", materia);
            RequestDispatcher view = request.getRequestDispatcher("metodosInteresantesMatricula.jsp");
            view.forward(request, response);
        }else if("notaMasAlta".equals(request.getParameter("accion"))){
            Matricula matr = new Matricula();
            Matricula notaMasAlta=matr.notaMasAlta(matricula);
            String opcion = "notaMasAlta";
            request.setAttribute("opcion",opcion);
            request.setAttribute("resultado", notaMasAlta);
            RequestDispatcher view = request.getRequestDispatcher("metodosInteresantesMatricula.jsp");
            view.forward(request, response);
        }else if("notaMasBaja".equals(request.getParameter("accion"))){
            Matricula matr = new Matricula();
            Matricula notaMasBaja=matr.notaMasBaja(matricula);
            String opcion = "notaMasBaja";
            request.setAttribute("opcion",opcion);
            request.setAttribute("resultado", notaMasBaja);
            RequestDispatcher view = request.getRequestDispatcher("metodosInteresantesMatricula.jsp");
            view.forward(request, response);
        }

    }

}
