package com.donmario.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.donmario.dao.DaoFactory;
import com.donmario.entitys.EntityMenu;
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
			case "crear" : crear(request,response);
			}
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
	    System.out.print(em.getEmpleado_id()+em.getNombre()+em.getCosto());
	}
}
