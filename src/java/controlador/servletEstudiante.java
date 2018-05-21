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
import modelos.Mensajes;

/**
 *
 * @author Cdbz
 */
@WebServlet(name = "servletEstudiante", urlPatterns = {"/servletEstudiante"})
public class servletEstudiante extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();

        List<Estudiante> estudiante = new ArrayList<>();

        if (null != session.getAttribute("SEstudiante")) {

            estudiante = (ArrayList<Estudiante>) session.getAttribute("SEstudiante");

        }
        if ("Guardar".equals(request.getParameter("accion"))) {

            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String email = request.getParameter("email");
            String cedula = request.getParameter("cedula");
            String celular = request.getParameter("celular");
            String usuario = request.getParameter("usuario");
            String clave = request.getParameter("clave");
            estudiante.add(new Estudiante(celular, cedula, nombre, apellido, email, usuario, clave));

            session.setAttribute("SEstudiante", estudiante);

            request.setAttribute("SEstudiante", estudiante);
            RequestDispatcher view = request.getRequestDispatcher("crearEstudiante.jsp");
            view.forward(request, response);

        } else if ("Ver todos los estudiantes".equals(request.getParameter("accion"))) {

            request.setAttribute("estudiante", estudiante);
            RequestDispatcher view = request.getRequestDispatcher("datosEstudiantes.jsp");
            view.forward(request, response);

        } else if ("Ver detalles".equals(request.getParameter("accion"))) {
            String cedula = request.getParameter("cedula");

            Estudiante resultado = new Estudiante();
            for (Estudiante estudiante1 : estudiante) {
                if (estudiante1.getCedula().equals(cedula)) {
                    resultado = estudiante1;
                    break;
                }
            }
            List<Estudiante> listaResultado = new ArrayList<>();
            listaResultado.add(resultado);
            request.setAttribute("estudiante", listaResultado);
            RequestDispatcher view = request.getRequestDispatcher("datosEstudiantes.jsp");
            view.forward(request, response);
            
        } else if ("Eliminar".equals(request.getParameter("accion"))) {
            String cedula = request.getParameter("cedula");
            for (Estudiante estudiante1 : estudiante) {
                if (estudiante1.getCedula().equals(cedula)) {
                    estudiante.remove(estudiante1);
                    break;
                }
            }
            session.setAttribute("SEstudiante", estudiante);

            request.setAttribute("SEstudiante", estudiante);
            RequestDispatcher view = request.getRequestDispatcher("datosEstudiantes.jsp");
            view.forward(request, response);
            
        }else if ("RutaCrearEstudiante".equals(request.getParameter("accion"))){
            RequestDispatcher view = request.getRequestDispatcher("crearEstudiante.jsp");
            view.forward(request, response);
            
        }else if ("Modificar".equals(request.getParameter("accion"))){
            String cedula = request.getParameter("cedula");

            Estudiante resultado = new Estudiante();
            for (Estudiante estudiante1 : estudiante) {
                if (estudiante1.getCedula().equals(cedula)) {
                    resultado = estudiante1;
                    break;
                }
            }
            List<Estudiante> listaResultado = new ArrayList<>();
            listaResultado.add(resultado);
            request.setAttribute("estudiante", listaResultado);
            RequestDispatcher view = request.getRequestDispatcher("editarEstudiante.jsp");
            view.forward(request, response);
            
        }else if("Guardar edicion".equals(request.getParameter("accion"))){
            String cedula = request.getParameter("cedula");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String email = request.getParameter("email");
            String celular = request.getParameter("celular");
            String usuario = request.getParameter("usuario");
            String clave = request.getParameter("clave");
            for(Estudiante estudiante1 : estudiante){
                if(estudiante1.getCedula().equals(cedula)){
                    estudiante1.editarEstudiante(celular, cedula, nombre, apellido, email, usuario, 
                            clave);
                    break;
                }
            }

            session.setAttribute("SEstudiante", estudiante);
            request.setAttribute("SEstudiante", estudiante);
            RequestDispatcher view = request.getRequestDispatcher("datosEstudiantes.jsp");
            view.forward(request, response);
        }

    }

}
