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
import com.donmario.entitys.EntityMenu;
import com.donmario.interfaces.InterfaceDistrito;
import com.donmario.interfaces.InterfaceMenu;


/**
 * Servlet implementation class ServletMenu
 */
@WebServlet("/ServletMenu")
public class ServletMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DaoFactory fabrica = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMenu() {
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
			case "crear" : crear(request,response);break;
			case "actualizar": actualizar(request,response);break;
			case "eliminar": eliminar(request,response);break;
			case "editar" : editar(request,response);break;
			}
		}
		else {
			recuperar(request,response);
		}
	}

	private void editar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			InterfaceMenu im = fabrica.getMenu();
			EntityMenu em = im.editarMenu(Integer.parseInt(request.getParameter("idEditar")));
			request.setAttribute("menu", em);
		    request.getRequestDispatcher("Editar-Menu.jsp").forward(request, response);
		}catch(Exception e) {
			System.out.print("hubo un problema con ServletMenu.editar()");
		}
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			InterfaceMenu im = fabrica.getMenu();
			im.eliminarMenu(Integer.parseInt(request.getParameter("idEliminar")));
	        recuperar(request,response);	
		}
		catch(Exception e) {
			System.out.print("hubo un problema ServletMenu.eliminar()");
		}
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			EntityMenu em = new EntityMenu();
			em.setEmpleado_id(Integer.parseInt(request.getParameter("empleado_id")));
			em.setMenu_id(Integer.parseInt(request.getParameter("menu_id")));
			em.setNombre(request.getParameter("nombre"));
			em.setCosto(Double.parseDouble(request.getParameter("costo")));
			InterfaceMenu im = fabrica.getMenu();
			im.actualizarMenu(em);
			recuperar(request,response);
		}
		catch(Exception e) {
			System.out.print("hubo un problema con ServletMenu.actualizar()");
		}
	}

	private void recuperar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			InterfaceMenu im = fabrica.getMenu();
			ArrayList<EntityMenu> listaMenu = im.recuperarMenu();
			HttpSession session = request.getSession();
			session.setAttribute("menus", listaMenu);
			String pagina = (String)session.getAttribute("pagina");
			request.getRequestDispatcher(pagina).forward(request, response);
		}
		
		catch(Exception e) {
			System.out.print("hubo un problema con ServletMenu.recuperar()");
		}
	}

	private void crear(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		EntityMenu em = new EntityMenu();
	    em.setEmpleado_id(Integer.parseInt(request.getParameter("empleado_id")));
	    em.setNombre(request.getParameter("nombre"));
	    em.setCosto(Double.parseDouble(request.getParameter("costo")));
	    InterfaceMenu im = fabrica.getMenu();
	    im.crearMenu(em);
	    recuperar(request,response);
	}
}
