package com.donmario.models;
import java.util.ArrayList;
import com.donmario.dao.DaoDatabase;
import com.donmario.entitys.EntityMesa;
import com.donmario.interfaces.InterfaceMesa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class ModelMesa extends DaoDatabase implements InterfaceMesa {
	private int database;
	public ModelMesa(int db) {
	this.database = db;
	}
	@Override
	public void crearMesa(EntityMesa em) {
		// TODO Auto-generated method stub
	try {
		String sentencia = "insert into mesa (empleado_id,capacidad,estado,mesa_id) values(?,?,?,?) ";
		Connection connection = getDaoConnection(database);
		PreparedStatement ps = connection.prepareStatement(sentencia);
		ps.setString(1,em.getEmpleado_id());
		ps.setInt(2, em.getCapacidad());
		ps.setString(3, em.getEstado());
		ps.setString(4, em.getMesa_id());
		ps.executeUpdate();
	}
	catch(Exception e) {
		System.out.print("HUBO UN PROBLEMA CON ModelMesa.crearMesa()");
	}
	}

	@Override
	public ArrayList<EntityMesa> leerMesa() {
		// TODO Auto-generated method stub
		ArrayList<EntityMesa> mesas = new ArrayList<>();
		try {
			String sentencia = "select * from mesa";
			Connection connection = getDaoConnection(database);
			PreparedStatement ps = connection.prepareStatement(sentencia);
			ResultSet rs = ps.executeQuery(); 
			while(rs.next()) {
				EntityMesa em = new EntityMesa();
				em.setMesa_id(rs.getString("mesa_id"));
				em.setEmpleado_id(rs.getString("empleado_id"));
				em.setEstado(rs.getString("estado"));
				em.setCapacidad(rs.getInt("capacidad"));
				mesas.add(em);
			}
		}
		catch(Exception e) {
			System.out.print("HUBO UN PROBLEMA CON ModelMesa.leerMesa()");

		}
		return mesas;
	}

	@Override
	public void actualizarMesa(EntityMesa em) {
		// TODO Auto-generated method stub
		try {
			String sentencia = "update mesa set empleado_id=?, capacidad=?, estado=? where mesa_id=? ";
			Connection connection = getDaoConnection(database);
			PreparedStatement ps = connection.prepareStatement(sentencia);
			ps.setString(1, em.getEmpleado_id());
			ps.setInt(2, em.getCapacidad());
			ps.setString(3, em.getEstado());
			ps.setString(4, em.getMesa_id());
			ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.print("HUBO UN PROBLEMA CON ModelMesa.actualizarMesa()");
		}
	}

	@Override
	public void eliminarMesa(String mesa_id) {
		// TODO Auto-generated method stub
		try {
		String sentencia = "delete from mesa where mesa_id=?";
		Connection connection = getDaoConnection(database);
		PreparedStatement ps = connection.prepareStatement(sentencia);
		ps.setString(1, mesa_id);
		ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.print("HUBO UN PROBLEMA CON ModelMesa.eliminarMesa()");
		}
	}

	@Override
	public EntityMesa editarMesa(String mesa_id) {
		// TODO Auto-generated method stub
		EntityMesa em = new EntityMesa();
		try {
			String sentencia = "select * from mesa where mesa_id=?";
			Connection connection = getDaoConnection(database);
			PreparedStatement ps = connection.prepareStatement(sentencia);
			ps.setString(1, mesa_id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				em.setMesa_id(rs.getString("mesa_id"));
				em.setEmpleado_id(rs.getString("empleado_id"));
				em.setEstado(rs.getString("estado"));
				em.setCapacidad(rs.getInt("capacidad"));
			}
		}
		catch(Exception e) {
			System.out.print("HUBO UN PROBLEMA CON ModelMesa.editarMesa()");

		}
		return em;
	}

}
