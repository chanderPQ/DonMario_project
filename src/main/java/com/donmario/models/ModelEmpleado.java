package com.donmario.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.donmario.dao.DaoDatabase;
import com.donmario.entitys.EntityEmpleado;
import com.donmario.interfaces.InterfaceEmpleado;

public class ModelEmpleado extends DaoDatabase implements InterfaceEmpleado {
   public int database;
   public ModelEmpleado(int database) {
	   this.database = database;
   }
	@Override
	public void crearEmpleado(EntityEmpleado ee) {
		// TODO Auto-generated method stub
		try {
			String sentencia = "insert into empleado(distrito_id,nombre,apellido,rol,correo,clave,empleado_id) values(?,?,?,?,?,?,?)";
			Connection connection = getDaoConnection(database);
			PreparedStatement ps = connection.prepareStatement(sentencia);
			ps.setString(1, ee.getDistrito_id());
			ps.setString(2, ee.getNombre());
			ps.setString(3,ee.getApellido());
			ps.setString(4, ee.getRol());
			ps.setString(5, ee.getCorreo());
			ps.setString(6, ee.getClave());
			ps.setString(7, ee.getEmpleado_id());
			ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.print("hubo un problema con ModelEmpleado.crearEmpleado()");
		}
	}

	@Override
	public ArrayList<EntityEmpleado> recuperarEmpleado() {
		// TODO Auto-generated method stub
		ArrayList<EntityEmpleado> le = new ArrayList<>();
		try {
			String sentencia = "select * from empleado";
			Connection connection = getDaoConnection(database);
		    PreparedStatement ps = connection.prepareStatement(sentencia);
		    ResultSet rs = ps.executeQuery();
		    while(rs.next()) {
		    	EntityEmpleado ee = new EntityEmpleado();
		    	ee.setNombre(rs.getString("nombre"));
		    	ee.setApellido(rs.getString("apellido"));
		    	ee.setRol(rs.getString("rol"));
		    	ee.setCorreo(rs.getString("correo"));
		    	ee.setClave(rs.getString("clave"));
		    	ee.setDistrito_id(rs.getString("distrito_id"));
		    	ee.setEmpleado_id(rs.getString("empleado_id"));
		    	le.add(ee);
		    }
		}
		catch(Exception e) {
			System.out.print("hubo un problema con ModelEmpleado.recuperarEmpleado()");
		}
		return le;
	}

	@Override
	public void actualizarEmpleado(EntityEmpleado ee) {
		// TODO Auto-generated method stub
		try {
			String sentencia = "update empleado set nombre=?, apellido=?, rol=?, correo=?, clave=?, distrito_id=? where empleado_id=? ";
	        Connection connection = getDaoConnection(database);
	        PreparedStatement ps = connection.prepareStatement(sentencia);
	        ps.setString(1, ee.getNombre());
	        ps.setString(2, ee.getApellido());
	        ps.setString(3, ee.getRol());
	        ps.setString(4, ee.getCorreo());
	        ps.setString(5, ee.getClave());
	        ps.setString(6, ee.getDistrito_id());
	        ps.setString(7, ee.getEmpleado_id());
	        ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.print("hubo un problema con ModelEmpleado.actualizarEmpleado()");
		}
	}

	@Override
	public void eliminarEmpleado(String empleado_id) {
		// TODO Auto-generated method stub
		try {
			String sentencia = "delete from empleado where empleado_id = ?";
			Connection connection = getDaoConnection(database);
			PreparedStatement ps = connection.prepareStatement(sentencia);
			ps.setString(1, empleado_id);
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.print("hubo un problema con ModelEmpleado.eliminarEmpleado()");
		}
	}

	@Override
	public EntityEmpleado editarEmpleado(String empleado_id) {
		// TODO Auto-generated method stub
		EntityEmpleado ee = new EntityEmpleado();
		try {
			String sentencia = "select * from empleado where empleado_id = ?";
			Connection connection = getDaoConnection(database);
			PreparedStatement ps = connection.prepareStatement(sentencia);
			ps.setString(1, empleado_id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
		    	ee.setNombre(rs.getString("nombre"));
		    	ee.setApellido(rs.getString("apellido"));
		    	ee.setRol(rs.getString("rol"));
		    	ee.setCorreo(rs.getString("correo"));
		    	ee.setClave(rs.getString("clave"));
		    	ee.setDistrito_id(rs.getString("distrito_id"));
		    	ee.setEmpleado_id(rs.getString("empleado_id"));
			}
		}
		catch(Exception e) {
			System.out.print("hubo un problema con ModelEmpleado.editarEmpleado()");
		}
		return ee;
	}
	@Override
	public EntityEmpleado accederEmpleado(String correo, String clave) {
		// TODO Auto-generated method stub
		EntityEmpleado ee = new EntityEmpleado();
		try {
			String sentencia = "select * from empleado where correo = ? and clave = ? ";
			Connection connection = getDaoConnection(database);
			PreparedStatement ps = connection.prepareStatement(sentencia);
			ps.setString(1, correo);
			ps.setString(2, clave);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				ee.setNombre(rs.getString("nombre"));
		    	ee.setApellido(rs.getString("apellido"));
		    	ee.setRol(rs.getString("rol"));
		    	ee.setCorreo(rs.getString("correo"));
		    	ee.setClave(rs.getString("clave"));
		    	ee.setDistrito_id(rs.getString("distrito_id"));
		    	ee.setEmpleado_id(rs.getString("empleado_id"));
			}
		}
		catch(Exception e) {
			System.out.print("hubo un problema con ModelEmpleado.accederEmpleado()");
		}
		return ee;
	}

}
