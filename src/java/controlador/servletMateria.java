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
import modelos.Matricula;

/**
 *
 * @author Salo
 */
@WebServlet(name = "servletMateria", urlPatterns = {"/servletMateria"})
public class servletMateria extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        ArrayList<Materia> materia = new ArrayList<>();

        if (null != session.getAttribute("SMateria")) {

            materia = (ArrayList<Materia>) session.getAttribute("SMateria");

        }
        
        ArrayList<Matricula> matricula = new ArrayList<>();

        if (null != session.getAttribute("SMatricula")) {

            matricula = (ArrayList<Matricula>) session.getAttribute("SMatricula");

        }
        if ("Guardar".equals(request.getParameter("accion"))) {

            String nombre = request.getParameter("nombre");
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            materia.add(new Materia(codigo,nombre));

            session.setAttribute("SMateria", materia);

            request.setAttribute("SMateria", materia);
            RequestDispatcher view = request.getRequestDispatcher("crearMateria.jsp");
            view.forward(request, response);

        } else if ("VerMaterias".equals(request.getParameter("accion"))) {

            request.setAttribute("materia", materia);
            RequestDispatcher view = request.getRequestDispatcher("datosMateria.jsp");
            view.forward(request, response);

        } else if ("VerDetalles".equals(request.getParameter("accion"))) {
            int codigo = Integer.parseInt(request.getParameter("codigo"));

            Materia resultado = new Materia();
            for (Materia materia1 : materia) {
                if (materia1.getCodigo() == (codigo)) {
                    resultado = materia1;
                    break;
                }
            }
            List<Materia> listaResultado = new ArrayList<>();
            listaResultado.add(resultado);
            request.setAttribute("materia", listaResultado);
            RequestDispatcher view = request.getRequestDispatcher("datosMateria.jsp");
            view.forward(request, response);
        } else if ("Eliminar".equals(request.getParameter("accion"))) {
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            for (Materia materia1 : materia) {
                if (materia1.getCodigo()==(codigo)) {
                    materia.remove(materia1);
                    break;
                }
            }
            session.setAttribute("SMateria", materia);

            request.setAttribute("SMateria", materia);
            RequestDispatcher view = request.getRequestDispatcher("datosMateria.jsp");
            view.forward(request, response);
        } else if ("RutaCrearMateria".equals(request.getParameter("accion"))) {
            RequestDispatcher view = request.getRequestDispatcher("crearMateria.jsp");
            view.forward(request, response);
        }else if ("Modificar".equals(request.getParameter("accion"))){
            int codigo = Integer.parseInt(request.getParameter("codigo"));

            Materia resultado = new Materia();
            for (Materia materia1 : materia) {
                if (materia1.getCodigo() == codigo) {
                    resultado = materia1;
                    break;
                }
            }
            List<Materia> listaResultado = new ArrayList<>();
            listaResultado.add(resultado);
            request.setAttribute("materia", listaResultado);
            RequestDispatcher view = request.getRequestDispatcher("editarMateria.jsp");
            view.forward(request, response);
            
        }else if("Guardar edicion".equals(request.getParameter("accion"))){
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            String nombre = request.getParameter("nombre");
            
            for(Materia materia1 : materia){
                if(materia1.getCodigo() == codigo){
                    materia1.editarMateria(codigo, nombre);
                    break;
                }
            }

            session.setAttribute("SMateria", materia);

            request.setAttribute("SMateria", materia);
            RequestDispatcher view = request.getRequestDispatcher("datosMateria.jsp");
            view.forward(request, response);
        }else if("MateriaMasMatriculas".equals(request.getParameter("accion"))){
            Materia mat = new Materia();
            Materia materiaMasMatriculas=mat.materiaConmasmatriculas(materia);
            String opcion = "masMatriculas";
            request.setAttribute("opcion",opcion);
            request.setAttribute("resultado", materiaMasMatriculas);
            RequestDispatcher view = request.getRequestDispatcher("metodosInteresantesMateria.jsp");
            view.forward(request, response);
        }else if("MateriaMasProfesores".equals(request.getParameter("accion"))){
            Materia mat = new Materia();
            Materia materiaMasMatriculas=mat.materiaConmasprofesores(materia);
            String opcion = "masProfesores";
            request.setAttribute("opcion",opcion);
            request.setAttribute("resultado", materiaMasMatriculas);
            RequestDispatcher view = request.getRequestDispatcher("metodosInteresantesMateria.jsp");
            view.forward(request, response);
        }else if("MateriaMejorNota".equals(request.getParameter("accion"))){
            Materia mat = new Materia();
            Matricula materiaMasMatriculas=mat.materiaMejorNota(matricula);
            String opcion = "mejorNota";
            request.setAttribute("opcion",opcion);
            request.setAttribute("resultado", materiaMasMatriculas);
            RequestDispatcher view = request.getRequestDispatcher("metodosInteresantesMateria.jsp");
            view.forward(request, response);
        }
    }

}
