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
import modelos.Materia;
import modelos.Profesor;

/**
 *
 * @author Salo
 */
@WebServlet(name = "servletProfesor", urlPatterns = {"/servletProfesor"})
public class servletProfesor extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        ArrayList<Profesor> profesor = new ArrayList<>();

        if (null != session.getAttribute("SProfesor")) {

            profesor = (ArrayList<Profesor>) session.getAttribute("SProfesor");

        }

        List<Materia> materia = new ArrayList<>();
        if (null != session.getAttribute("SMateria")) {
            materia = (ArrayList<Materia>) session.getAttribute("SMateria");
        }

 

        if ("Guardar".equals(request.getParameter("accion"))) {

            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String email = request.getParameter("email");
            String cedula = request.getParameter("cedula");
            Long telefono = Long.parseLong(request.getParameter("telefono"));
            String oficina = request.getParameter("oficina");
            String usuario = request.getParameter("usuario");
            String clave = request.getParameter("clave");
            int codMateria = Integer.parseInt(request.getParameter("materia"));
            for (Materia materia1 : materia) {
                if (codMateria == materia1.getCodigo()) {
                    Profesor p = new Profesor(telefono, oficina, materia1, cedula, nombre, apellido, email, 
                            usuario, clave);
                    profesor.add(p);
                    materia1.setProfesores(p);
                    break;
                }

            }

            session.setAttribute("SProfesor", profesor);
            request.setAttribute("SProfesor", profesor);
            request.setAttribute("materias", materia);
            RequestDispatcher view = request.getRequestDispatcher("crearProfesor.jsp");
            view.forward(request, response);

        } else if ("VerProfesores".equals(request.getParameter("accion"))) {

            request.setAttribute("profesor", profesor);
            RequestDispatcher view = request.getRequestDispatcher("datosProfesor.jsp");
            view.forward(request, response);

        } else if ("VerDetalles".equals(request.getParameter("accion"))) {
            String cedula = request.getParameter("cedula");

            Profesor resultado = new Profesor();
            for (Profesor profesor1 : profesor) {
                if (profesor1.getCedula().equals(cedula)) {
                    resultado = profesor1;
                    break;
                }
            }
            List<Profesor> listaResultado = new ArrayList<>();
            listaResultado.add(resultado);
            request.setAttribute("profesor", listaResultado);
            RequestDispatcher view = request.getRequestDispatcher("datosProfesor.jsp");
            view.forward(request, response);
        } else if ("Eliminar".equals(request.getParameter("accion"))) {
            String cedula = request.getParameter("cedula");
            for (Profesor profesor1 : profesor) {
                if (profesor1.getCedula().equals(cedula)) {
                    profesor.remove(profesor1);
                    break;
                }
            }
            session.setAttribute("SProfesor", profesor);

            request.setAttribute("SProfesor", profesor);
            RequestDispatcher view = request.getRequestDispatcher("datosProfesor.jsp");
            view.forward(request, response);
        } else if ("RutaCrearProfesor".equals(request.getParameter("accion"))) {

            request.setAttribute("materias", materia);

            RequestDispatcher view = request.getRequestDispatcher("crearProfesor.jsp");
            view.forward(request, response);

        } else if ("Modificar".equals(request.getParameter("accion"))) {
            String cedula = request.getParameter("cedula");

            Profesor resultado = new Profesor();
            for (Profesor profesor1 : profesor) {
                if (profesor1.getCedula().equals(cedula)) {
                    resultado = profesor1;
                    break;
                }
            }
            List<Profesor> listaResultado = new ArrayList<>();
            listaResultado.add(resultado);
            request.setAttribute("profesor", listaResultado);
            request.setAttribute("materias", materia);
            RequestDispatcher view = request.getRequestDispatcher("editarProfesor.jsp");
            view.forward(request, response);

        } else if ("Guardar edicion".equals(request.getParameter("accion"))) {
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String email = request.getParameter("email");
            String cedula = request.getParameter("cedula");
            Long telefono = Long.parseLong(request.getParameter("telefono"));
            String oficina = request.getParameter("oficina");
            String usuario = request.getParameter("usuario");
            String clave = request.getParameter("clave");
            for (Profesor profesor1 : profesor) {
                if (profesor1.getCedula().equals(cedula)) {
                    int codMateria = Integer.parseInt(request.getParameter("materia"));
                    for (Materia materia1 : materia) {
                        if (codMateria == materia1.getCodigo()) {
                            profesor1.editarProfesor(telefono, oficina, materia1, cedula, nombre, 
                                    apellido, email, usuario, clave);
                            materia1.setProfesores(profesor1);
                            break;
                        }

                    }
                }
            }

            session.setAttribute("SProfesor", profesor);
            request.setAttribute("SProfesor", profesor);
            request.setAttribute("materias", materia);
            RequestDispatcher view = request.getRequestDispatcher("datosProfesor.jsp");
            view.forward(request, response);
        }
    }

}
