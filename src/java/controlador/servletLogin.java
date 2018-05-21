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
import modelos.Profesor;
import modelos.Usuario;
import modelos.Materia;
import modelos.Matricula;
import modelos.DatosFicticios;

/**
 *
 * @author Salo
 */
@WebServlet(name = "servletLogin", urlPatterns = {"/servletLogin"})
public class servletLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if ("RutaLogin".equals(request.getParameter("accion"))) {
            RequestDispatcher view = request.getRequestDispatcher("login.jsp");
            view.forward(request, response);

        } else if ("DatosFicticios".equals(request.getParameter("accion"))) {
            DatosFicticios d = new DatosFicticios();
            d.datos();
            ArrayList<Profesor> profesor = d.profesor;
            ArrayList<Estudiante> estudiante = d.estudiante;
            ArrayList<Materia> materia = d.materia;
            ArrayList<Matricula> matricula = d.matricula;
            HttpSession session = request.getSession();
            session.setAttribute("SEstudiante", estudiante);
            session.setAttribute("SProfesor", profesor);
            session.setAttribute("SMateria", materia);
            session.setAttribute("SMatricula", matricula);
            request.setAttribute("SEstudiante", estudiante);
            request.setAttribute("SProfesor", profesor);
            request.setAttribute("SMateria", materia);
            request.setAttribute("SMatricula", matricula);
            RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
            view.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        List<Profesor> profesor = new ArrayList<>();

        if (null != session.getAttribute("SProfesor")) {
            profesor = (ArrayList<Profesor>) session.getAttribute("SProfesor");
        }

        List<Usuario> usuarioConSesion = new ArrayList<>();

        List<Estudiante> estudiante = new ArrayList<>();

        if (null != session.getAttribute("SEstudiante")) {
            estudiante = (ArrayList<Estudiante>) session.getAttribute("SEstudiante");
        }

        if ("Ingresar".equals(request.getParameter("accion"))) {

            String usuario = request.getParameter("usuario");
            String clave = request.getParameter("clave");

            for (Profesor profesores : profesor) {

                if (usuario.equals(profesores.getUsuario()) && clave.equals(profesores.getClave())) {
                    usuarioConSesion.add(new Usuario(usuario, clave, profesores.getCedula(), "profesor"));
                    session.setAttribute("SUsuario", usuarioConSesion);
                    request.setAttribute("SUsuario", usuarioConSesion);
                    RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
                    view.forward(request, response);
                }
            }

            for (Estudiante estudiantes : estudiante) {
                if (usuario.equals(estudiantes.getUsuario()) && clave.equals(estudiantes.getClave())) {
                    usuarioConSesion.add(new Usuario(usuario, clave, estudiantes.getCedula(), "estudiante"));
                    session.setAttribute("SUsuario", usuarioConSesion);
                    request.setAttribute("SUsuario", usuarioConSesion);
                    RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
                    view.forward(request, response);
                }
            }

            if (usuario.equals("Admin") && clave.equals("12345")) {
                usuarioConSesion.add(new Usuario(usuario, clave, "", "admin"));
                session.setAttribute("SUsuario", usuarioConSesion);
                request.setAttribute("SUsuario", usuarioConSesion);
                RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
                view.forward(request, response);
            } else {
                RequestDispatcher view = request.getRequestDispatcher("/Error.jsp");
                view.forward(request, response);
            }
        }

    }

}
