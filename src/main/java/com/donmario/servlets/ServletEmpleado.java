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
import com.donmario.entitys.EntityEmpleado;
import com.donmario.interfaces.InterfaceEmpleado;

/**
 * Servlet implementation class ServletEmpleado
 */
@WebServlet("/ServletEmpleado")
public class ServletEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DaoFactory fabrica = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEmpleado() {
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
    	 case "crear" -> crear(request,response);
    	 case "recuperar" -> recuperar(request,response);
    	 case "actualizar" -> actualizar(request,response);
    	 case "eliminar" -> eliminar(request,response);
    	 case "editar" -> editar(request,response);
    	 }
     }
     else {
    	 recuperar(request,response);
     }
	}

	private void editar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
		InterfaceEmpleado ie = fabrica.getEmpleado();
		EntityEmpleado ee = ie.editarEmpleado((request.getParameter("idEditar")));
		request.setAttribute("empleado", ee);
		request.getRequestDispatcher("Editar-Empleado.jsp").forward(request, response);
	}catch(Exception e) {
		System.out.print("hubo un problema con ServletEmpleado.editar()");
	}
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
		InterfaceEmpleado ie = fabrica.getEmpleado();
		ie.eliminarEmpleado(request.getParameter("idEliminar"));
		recuperar(request,response);
		}catch(Exception e) {
			System.out.print("hubo un problema con ServletEmpleado.eliminar()");
		}
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		EntityEmpleado ee = new EntityEmpleado();
		ee.setNombre(request.getParameter("nombre"));
		ee.setApellido(request.getParameter("apellido"));
		ee.setRol(request.getParameter("rol"));
		ee.setCorreo(request.getParameter("correo"));
		ee.setDistrito_id((request.getParameter("distrito_id")));
		ee.setClave(request.getParameter("clave"));
		ee.setEmpleado_id((request.getParameter("empleado_id")));
		InterfaceEmpleado ie = fabrica.getEmpleado();
		ie.actualizarEmpleado(ee);
		recuperar(request,response);
	}

	private void recuperar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
	 InterfaceEmpleado ie = fabrica.getEmpleado();
	 ArrayList<EntityEmpleado> le = ie.recuperarEmpleado();
	 HttpSession session = request.getSession();
	 session.setAttribute("empleados", le);
	 String pagina = (String) session.getAttribute("pagina");
	 request.getRequestDispatcher(pagina).forward(request, response);
		}
		catch(Exception e) {
			System.out.print("hubo un problema con ServletEmpleado.recuperar()");
		}
	}

	private void crear(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	InterfaceEmpleado ie = fabrica.getEmpleado();
	EntityEmpleado ee = new EntityEmpleado();
	ee.setDistrito_id((request.getParameter("distrito_id")));
	ee.setNombre(request.getParameter("nombre"));
	ee.setApellido(request.getParameter("apellido"));
	ee.setRol(request.getParameter("rol"));
	ee.setCorreo(request.getParameter("correo"));
	ee.setClave(request.getParameter("clave"));
	ee.setEmpleado_id(request.getParameter("empleado_id"));
	ie.crearEmpleado(ee);
	recuperar(request,response);
	}
} 
