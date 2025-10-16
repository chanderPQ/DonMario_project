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
import com.donmario.entitys.EntityMenuPedido;
import com.donmario.interfaces.InterfaceMenuPedido;

/**
 * Servlet implementation class ServletMenuPedido
 */
@WebServlet("/ServletMenuPedido")
public class ServletMenuPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DaoFactory fabrica = DaoFactory.getDaoFactory(DaoFactory.MYSQL);   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMenuPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			case "leer":leer(request,response);
			}
		}
		else {
			leer(request,response);
		}
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
		InterfaceMenuPedido imp = fabrica.getMenuPedido();
		HttpSession session = request.getSession();
		EntityMenuPedido empEditar = (EntityMenuPedido)session.getAttribute("menupedido");
		EntityMenuPedido emp = new EntityMenuPedido();
		emp.setMenu_id(empEditar.getMenu_id());
		emp.setPedido_id(empEditar.getPedido_id());
		emp.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
		imp.actualizarMenuPedido(emp);
		request.getRequestDispatcher("ServletPedido?accion=detalle&idDetalle="+emp.getPedido_id()).forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		}

	private void editar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
		InterfaceMenuPedido imp = fabrica.getMenuPedido();
		EntityMenuPedido emp = imp.editarMenuPedido(request.getParameter("menu_idEditar"), request.getParameter("pedido_idEditar"));
		HttpSession session = request.getSession();
		session.setAttribute("menupedido", emp);
		request.getRequestDispatcher("Editar-Menu-Pedido.jsp").forward(request, response);
		}catch(Exception e) {
			System.out.print("HUBO UN PROBLEMA CON ServletMenu.editar()");
		}
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.print("estoyllegando al eliminar");
		try {
		InterfaceMenuPedido imp = fabrica.getMenuPedido();
		imp.eliminarMenuPedido(request.getParameter("menu_idEliminar"),request.getParameter("pedido_idEliminar"));
		request.getRequestDispatcher("ServletPedido?accion=detalle&idDetalle="+request.getParameter("pedido_idEliminar")).forward(request, response);
		System.out.print("estoyllegando al eliminar");
		}catch(Exception e) {
			e.printStackTrace();
		}
		}

	private void crear(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
		InterfaceMenuPedido imp = fabrica.getMenuPedido();
		EntityMenuPedido emp = new EntityMenuPedido();
		emp.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
		emp.setMenu_id(request.getParameter("menu_id"));
		emp.setPedido_id(request.getParameter("pedido_id"));
		imp.crearMenuPedido(emp);
		request.getRequestDispatcher("ServletPedido?accion=detalle&idDetalle="+emp.getPedido_id()).forward(request, response);
	}catch(Exception e) {
		e.printStackTrace();
	}
		}

	private void leer(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	try {
	InterfaceMenuPedido imp = fabrica.getMenuPedido();
	ArrayList<EntityMenuPedido> lmp = imp.leerMenuPedido(request.getParameter("pedido_idDetalle"));
	HttpSession session = request.getSession();
	String pagina = (String)session.getAttribute("pagina");
	request.setAttribute("menupedidos", lmp);
	request.getRequestDispatcher("Menu-Pedido.jsp").forward(request, response);
		}catch(Exception e) {
			System.out.print("HUBO UN PROBLEMA CON ServletMenu.leer()");
		}
	}
}
