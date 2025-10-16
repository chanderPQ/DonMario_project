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
import com.donmario.entitys.EntityPedido;
import com.donmario.interfaces.InterfacePedido;

/**
 * Servlet implementation class ServletPedido
 */
@WebServlet("/ServletPedido")
public class ServletPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DaoFactory fabrica = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accion = request.getParameter("accion");
		if(accion!=null) {
			switch(accion) {
			case "crear":crear(request,response);
			break;
			case "actualizar":actualizar(request,response);
			break;
			case "eliminar":eliminar(request,response);
			break;
			case "editar": editar(request,response);
			break;
			case "detalle":detalle(request,response);
			}
		}
		else {
			leer(request,response);
		}
	}

   private void detalle(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	   try {
		   InterfacePedido ip = fabrica.getPedido();
		EntityPedido ep =  ip.editarPedido(request.getParameter("idDetalle"));
		request.setAttribute("pedido", ep);
		request.getRequestDispatcher("Menu-Pedido.jsp").forward(request, response);
		   }catch(Exception e) {
				System.out.print("HUBO UN PROBLEMA CON ServletPedido.detalle()");
		   }
	}


   private void editar(HttpServletRequest request, HttpServletResponse response) {
	   try {
	   InterfacePedido ip = fabrica.getPedido();
	EntityPedido ep =  ip.editarPedido(request.getParameter("idEditar"));
	request.setAttribute("pedido", ep);
	request.getRequestDispatcher("Editar-Pedido.jsp").forward(request, response);
	   }catch(Exception e) {
			System.out.print("HUBO UN PROBLEMA CON ServletPedido.editar()");
	   }
   }
	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		InterfacePedido ip = fabrica.getPedido();
		ip.eliminarPedido(request.getParameter("idEliminar"));
		leer(request,response);
	}


	private void leer(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			InterfacePedido ip = fabrica.getPedido();
		ArrayList<EntityPedido> lp = ip.leerPedido();
		HttpSession session = request.getSession();
		String pagina = (String)session.getAttribute("pagina");
		session.setAttribute("pedidos", lp);
		request.getRequestDispatcher(pagina).forward(request, response);
		}catch(Exception e) {
			System.out.print("HUBO UN PROBLEMA CON ServletPedido.leer()");
		}
		
	}


	private void actualizar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		EntityPedido ep = new EntityPedido();
		ep.setEmpleado_id(request.getParameter("empleado_id"));
		ep.setMesa_id(request.getParameter("mesa_id"));
		ep.setEstado(request.getParameter("estado"));
		ep.setPedido_id(request.getParameter("pedido_id"));
		InterfacePedido ip = fabrica.getPedido();
		ip.actualizarPedido(ep);
		leer(request,response);
	}


	private void crear(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		EntityPedido ep = new EntityPedido();
		ep.setEmpleado_id(request.getParameter("empleado_id"));
		ep.setMesa_id(request.getParameter("mesa_id"));
		ep.setEstado(request.getParameter("estado"));
		ep.setPedido_id(request.getParameter("pedido_id"));
		InterfacePedido ip = fabrica.getPedido();
		ip.crearPedido(ep);
		leer(request,response);
	}
}
