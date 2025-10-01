package com.donmario.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import com.donmario.dao.DaoFactory;
import com.donmario.entitys.EntityDistrito;
import com.donmario.interfaces.InterfaceDistrito;

/**
 * Servlet implementation class ServletDistrito
 */
@WebServlet("/ServletDistrito")
public class ServletDistrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
      DaoFactory fabrica = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDistrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response){
		// TODO Auto-generated method stub
		String accion = request.getParameter("accion");
		if(accion != null) {
			switch(accion) {
			case "crear" : crear(request,response);
			break;
			case "eliminar" : eliminar(request,response);
			break;
			case "editar" : editar(request,response);
			break;
			case "actualizar": actualizar(request,response);
			break;
			}
		}
		else {
			listarDistrito(request,response);
		}
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
		EntityDistrito ed = new EntityDistrito();
		ed.setDistrito(Integer.parseInt(request.getParameter("distrito_id")));
		ed.setNombre(request.getParameter("nombre"));
		InterfaceDistrito id = fabrica.getDistrito();
		id.actualizarDistrito(ed);
		listarDistrito(request, response);
		}catch(Exception e) {
			System.out.print("hubo un problema con ServletDistrito.actualizar()");
		}
	}

	private void editar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
		InterfaceDistrito id = fabrica.getDistrito();
		EntityDistrito ed =  id.editarDistrito(Integer.parseInt(request.getParameter("idEditar")));
		request.setAttribute("distrito", ed);
		request.getRequestDispatcher("Editar-Distrito.jsp").forward(request, response);
		}catch(Exception e) {
			System.out.print("Hubo un problema con ServletDistrito.editar()");
		}
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			InterfaceDistrito id = fabrica.getDistrito();
			id.eliminarDistrito(Integer.parseInt(request.getParameter("idEliminar")));
			listarDistrito(request,response);
		}
		catch(Exception e) {
			System.out.print("Hubo un problema con ServletDistrito.eliminar()");
		}
	}

	private void listarDistrito(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
		HttpSession session = request.getSession();
		InterfaceDistrito id = fabrica.getDistrito();
		ArrayList<EntityDistrito> ld = id.recuperarDistrito();
		session.setAttribute("distritos", ld);
		String pagina = (String)session.getAttribute("pagina");
		request.getRequestDispatcher(pagina).forward(request, response);
		}catch(Exception e) {
			System.out.print("Hubo un problema con ServletDistrito.listarDistrito()");
		}
		}

	private void crear(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		EntityDistrito ed = new EntityDistrito();
		ed.setNombre(request.getParameter("nombre"));
		InterfaceDistrito id = fabrica.getDistrito();
		id.crearDistrito(ed);
		listarDistrito(request,response);
	}

}
