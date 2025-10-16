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
import com.donmario.entitys.EntityMesa;
import com.donmario.interfaces.InterfaceMesa;

/**
 * Servlet implementation class ServletMesa
 */
@WebServlet("/ServletMesa")
public class ServletMesa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       DaoFactory fabrica = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMesa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accion = request.getParameter("accion");
		if(accion != null) {
			switch(accion) {
			case "crear" : crear(request,response); break;
			case "actualizar" : actualizar(request,response); break;
			case "eliminar" : eliminar(request,response); break;
			case "editar" : editar(request,response); break;
		}
	}
		else {
		 listar(request,response);
		}
		
	}

	private void editar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
		InterfaceMesa im = fabrica.getMesa();
		EntityMesa em =  im.editarMesa((request.getParameter("idEditar")));
		request.setAttribute("mesa", em);
		request.getRequestDispatcher("Editar-Mesa.jsp").forward(request, response);
		}catch(Exception e) {
			System.out.print("HUBO UN PROBLEMA CON ModelMesa.editar()");
		}
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	try {
	InterfaceMesa im = fabrica.getMesa();
	ArrayList<EntityMesa> lm = im.leerMesa();
	HttpSession session = request.getSession();
	session.setAttribute("mesas", lm);
	String pagina = (String)session.getAttribute("pagina");
	request.getRequestDispatcher(pagina).forward(request, response);
		}catch(Exception e) {
			System.out.print("HUBO UN PROBLEMA CON ModelMesa.listar()");
		}
	} 

	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		InterfaceMesa im = fabrica.getMesa();
		im.eliminarMesa((request.getParameter("idEliminar")));
		listar(request,response);
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		InterfaceMesa im = fabrica.getMesa();
		EntityMesa em = new EntityMesa();
		em.setMesa_id((request.getParameter("mesa_id")));
		em.setEmpleado_id((request.getParameter("empleado_id")));
		em.setCapacidad(Integer.parseInt(request.getParameter("capacidad")));
		em.setEstado(request.getParameter("estado"));
		im.actualizarMesa(em);
		listar(request,response);
	}

	private void crear(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	EntityMesa em = new EntityMesa();
	em.setEmpleado_id((request.getParameter("empleado_id")));
	em.setEstado(request.getParameter("estado"));
	em.setCapacidad(Integer.parseInt(request.getParameter("capacidad")));
	em.setMesa_id(request.getParameter("mesa_id"));
	InterfaceMesa im = fabrica.getMesa();
	im.crearMesa(em);
	listar(request,response);
	}
}
